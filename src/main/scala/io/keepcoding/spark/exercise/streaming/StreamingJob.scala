package io.keepcoding.spark.exercise.streaming

import java.sql.Timestamp
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

import org.apache.spark.sql.{DataFrame, SparkSession}

// case class AntennaMessage(timestamp: Timestamp, id: String, metric: String, value: Long)
case class UsersMessage(bytes: Long, timestamp: String, app: String, id: String, antenna_id: String)

trait StreamingJob {

  val spark: SparkSession

  def readFromKafka(kafkaServer: String, topic: String): DataFrame

  def parserJsonData(dataFrame: DataFrame): DataFrame

  def readUsers(jdbcURI: String, jdbcTable: String, user: String, password: String): DataFrame

  def enrichUsersWithMetadata(usersDF: DataFrame, metadataDF: DataFrame): DataFrame

  def computeDevicesCountByCoordinates(dataFrame: DataFrame): DataFrame

  def writeToJdbc(dataFrame: DataFrame, jdbcURI: String, jdbcTable: String, user: String, password: String): Future[Unit]

  def writeToStorage(dataFrame: DataFrame, storageRootPath: String): Future[Unit]

  def run(args: Array[String]): Unit = {
    val Array(kafkaServer, topic, jdbcUri, jdbcMetadataTable, aggJdbcTable, jdbcUser, jdbcPassword, storagePath) = args

    println(s"Running with: ${args.toSeq}")

    val kafkaDF = readFromKafka(kafkaServer, topic)
    val usersDF = parserJsonData(kafkaDF)
    val user_metadataDF = readUsers(jdbcUri, jdbcMetadataTable, jdbcUser, jdbcPassword)
    val usersMetadataDF = enrichUsersWithMetadata(usersDF, user_metadataDF)
    /*
    val storageFuture = writeToStorage(antennaDF, storagePath)
    val aggByCoordinatesDF = computeDevicesCountByCoordinates(antennaMetadataDF)
    val aggFuture = writeToJdbc(aggByCoordinatesDF, jdbcUri, aggJdbcTable, jdbcUser, jdbcPassword)

    Await.result(Future.sequence(Seq(aggFuture, storageFuture)), Duration.Inf)*/

    spark.close()
  }

}
