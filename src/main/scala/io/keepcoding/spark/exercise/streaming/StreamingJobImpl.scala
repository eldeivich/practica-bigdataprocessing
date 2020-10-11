package io.keepcoding.spark.exercise.streaming
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.{DateType, StringType, StructType, TimestampType}
import org.apache.spark.sql.functions.unix_timestamp
import org.joda.time._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object StreamingJobImpl extends StreamingJob {


  override val spark: SparkSession = SparkSession
    .builder()
    .master("local[*]")
    .appName("Proyecto David")
    .getOrCreate()

  import spark.implicits._

  override def readFromKafka(kafkaServer: String, topic: String): DataFrame = {
    spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", kafkaServer)
      .option("subscribe", topic)
      .load()
  }

  override def parserJsonData(dataFrame: DataFrame): DataFrame = {
    val schema = ScalaReflection.schemaFor[UsersMessage].dataType.asInstanceOf[StructType]

    dataFrame
      .select(from_json(col("value").cast(StringType), schema).as("json"))
      .select("json.*")
  }

  override def readUsers(jdbcURI: String, jdbcTable: String, user: String, password: String): DataFrame = {
    spark
      .read
      .format("jdbc")
      .option("driver", "org.postgresql.Driver")
      .option("url", jdbcURI)
      .option("dbtable", jdbcTable)
      .option("user", user)
      .option("password", password)
      .load()
  }

  override def enrichUsersWithMetadata(usersDF: DataFrame, user_metadataDF: DataFrame): DataFrame = {
    usersDF.as("users")
      .join(
        user_metadataDF.as("user_metadata"),
        $"users.id" === $"user_metadata.id"
      ).drop($"user_metadata.id")


  }

  override def computeUsersCountByBytes(dataFrame: DataFrame): DataFrame = {
    dataFrame
      .select($"timestamp", $"bytes", $"antenna_id")
      .withWatermark("timestamp", "30 seconds")
      //.groupBy($"bytes", window($"timestamp", "1 minutes"))
      //.agg(sum($"bytes").as())

  }

  override def writeToJdbc(dataFrame: DataFrame, jdbcURI: String, jdbcTable: String, user: String, password: String): Future[Unit] = ???

  override def writeToStorage(dataFrame: DataFrame, storageRootPath: String): Future[Unit] = Future {
    dataFrame
      .withColumn("year", year($"timestamp"))
      .withColumn("month", month($"timestamp"))
      .withColumn("day", dayofmonth($"timestamp"))
      .withColumn("hour", hour($"timestamp"))
      .writeStream
      .partitionBy("year", "month", "day", "hour")
      .format("parquet")
      .option("path", s"$storageRootPath/data")
      .option("checkpointLocation", s"$storageRootPath/checkpoint")
      .start()
      .awaitTermination()
  }

  def main(args: Array[String]): Unit = run(args)

}
