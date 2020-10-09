- Información de antenas:

.Id de la antena
.Métrica:
    - status: +  0: antena activa y funcionando correctamente
              + -1: antena activa y funcionando con errores
              +  1: antena desactivada
    - devices_count: total de los clientes conectados en ese momento
    - battery: porcentaje del nivel de batería de la antena

(antenna_telemetry,Sending: {"id":"00000000-0000-0000-0000-000000000000","metric":"status","value":0})
(antenna_telemetry,Sending: {"id":"11111111-1111-1111-1111-111111111111","metric":"status","value":0})
(antenna_telemetry,Sending: {"id":"22222222-2222-2222-2222-222222222222","metric":"status","value":0})
(antenna_telemetry,Sending: {"id":"33333333-3333-3333-3333-333333333333","metric":"status","value":1})
(antenna_telemetry,Sending: {"id":"44444444-4444-4444-4444-444444444444","metric":"status","value":1})
(antenna_telemetry,Sending: {"id":"00000000-0000-0000-0000-000000000000","metric":"devices_count","value":10})
(antenna_telemetry,Sending: {"id":"11111111-1111-1111-1111-111111111111","metric":"devices_count","value":5})
(antenna_telemetry,Sending: {"id":"22222222-2222-2222-2222-222222222222","metric":"devices_count","value":5})
(antenna_telemetry,Sending: {"id":"33333333-3333-3333-3333-333333333333","metric":"devices_count","value":0})
(antenna_telemetry,Sending: {"id":"44444444-4444-4444-4444-444444444444","metric":"devices_count","value":0})
(antenna_telemetry,Sending: {"id":"00000000-0000-0000-0000-000000000000","metric":"battery","value":78})
(antenna_telemetry,Sending: {"id":"11111111-1111-1111-1111-111111111111","metric":"battery","value":59})
(antenna_telemetry,Sending: {"id":"22222222-2222-2222-2222-222222222222","metric":"battery","value":10})
(antenna_telemetry,Sending: {"id":"33333333-3333-3333-3333-333333333333","metric":"battery","value":100})
(antenna_telemetry,Sending: {"id":"44444444-4444-4444-4444-444444444444","metric":"battery","value":91})

- Información de dispositivos móviles:

.bytes: bytes transmitidos
.timestamp: información de la hora
.app: aplicación que se ha usado
.id: id del usuario
.antenna_id: antena que ha captado esa transmisión

(devices,Sending: {"bytes":9165,"timestamp":1602050472,"app":"SKYPE","id":"00000000-0000-0000-0000-000000000006","a
ntenna_id":"00000000-0000-0000-0000-000000000000"})
(devices,Sending: {"bytes":3809,"timestamp":1602050472,"app":"SKYPE","id":"00000000-0000-0000-0000-000000000007","a
ntenna_id":"00000000-0000-0000-0000-000000000000"})
(devices,Sending: {"bytes":5136,"timestamp":1602050472,"app":"FACETIME","id":"00000000-0000-0000-0000-000000000008"
,"antenna_id":"00000000-0000-0000-0000-000000000000"})
(devices,Sending: {"bytes":1893,"timestamp":1602050472,"app":"TELEGRAM","id":"00000000-0000-0000-0000-000000000009"
,"antenna_id":"00000000-0000-0000-0000-000000000000"})
(devices,Sending: {"bytes":8365,"timestamp":1602050472,"app":"FACETIME","id":"00000000-0000-0000-0000-000000000010"
,"antenna_id":"00000000-0000-0000-0000-000000000000"})
(devices,Sending: {"bytes":8335,"timestamp":1602050472,"app":"SKYPE","id":"00000000-0000-0000-0000-000000000011","a
ntenna_id":"11111111-1111-1111-1111-111111111111"})
(devices,Sending: {"bytes":7423,"timestamp":1602050472,"app":"FACETIME","id":"00000000-0000-0000-0000-000000000012"
,"antenna_id":"11111111-1111-1111-1111-111111111111"})
(devices,Sending: {"bytes":4677,"timestamp":1602050472,"app":"SKYPE","id":"00000000-0000-0000-0000-000000000013","a
ntenna_id":"11111111-1111-1111-1111-111111111111"})
(devices,Sending: {"bytes":3268,"timestamp":1602050472,"app":"FACEBOOK","id":"00000000-0000-0000-0000-000000000014"
,"antenna_id":"11111111-1111-1111-1111-111111111111"})
(devices,Sending: {"bytes":9102,"timestamp":1602050472,"app":"TELEGRAM","id":"00000000-0000-0000-0000-000000000015"
,"antenna_id":"11111111-1111-1111-1111-111111111111"})
(devices,Sending: {"bytes":9921,"timestamp":1602050472,"app":"FACEBOOK","id":"00000000-0000-0000-0000-000000000016"
,"antenna_id":"22222222-2222-2222-2222-222222222222"})
(devices,Sending: {"bytes":5494,"timestamp":1602050472,"app":"SKYPE","id":"00000000-0000-0000-0000-000000000017","a
ntenna_id":"22222222-2222-2222-2222-222222222222"})
(devices,Sending: {"bytes":9507,"timestamp":1602050472,"app":"TELEGRAM","id":"00000000-0000-0000-0000-000000000018"
,"antenna_id":"22222222-2222-2222-2222-222222222222"})
(devices,Sending: {"bytes":5387,"timestamp":1602050472,"app":"FACEBOOK","id":"00000000-0000-0000-0000-000000000019"
,"antenna_id":"22222222-2222-2222-2222-222222222222"})
(devices,Sending: {"bytes":9424,"timestamp":1602050472,"app":"FACEBOOK","id":"00000000-0000-0000-0000-000000000020"
,"antenna_id":"22222222-2222-2222-2222-222222222222"})

--bases de datos:

CREATE TABLE IF NOT EXISTS user_metadata(id TEXT, name TEXT, email TEXT, quota BIGINT)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000001', 'andres', 'andres@gmail.com', 200000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000002', 'paco', 'paco@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000003', 'juan', 'juan@gmail.com', 100000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000004', 'fede', 'fede@gmail.com', 5000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000005', 'gorka', 'gorka@gmail.com', 200000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000006', 'luis', 'luis@gmail.com', 200000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000007', 'eric', 'eric@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000008', 'carlos', 'carlos@gmail.com', 100000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000009', 'david', 'david@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000010', 'juanchu', 'juanchu@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000011', 'charo', 'charo@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000012', 'delicidas', 'delicidas@gmail.com', 1000000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000013', 'milagros', 'milagros@gmail.com', 200000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000014', 'antonio', 'antonio@gmail.com', 1000000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000015', 'sergio', 'sergio@gmail.com', 1000000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000016', 'maria', 'maria@gmail.com', 1000000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000017', 'cristina', 'cristina@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000018', 'lucia', 'lucia@gmail.com', 300000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000019', 'carlota', 'carlota@gmail.com', 200000)
INSERT INTO user_metadata (id, name, email, quota) VALUES ('00000000-0000-0000-0000-000000000020', 'emilio', 'emilio@gmail.com', 200000)

.id: UUID del dispositivo movil
.name: Nombre del usuario
.email: Número de bytes transmitidos
.quota: Número de bytes por hora permitidos

Me piden:

Para Speed Layer: (streaming(StreamingJob)):
    .Total de bytes recibidos por antena
    .Total de bytes transmitidos por id de usuario
    .Total de bytes transmitidos por aplicación
    
    pide que las métricas sean agregadas cada 5 minutos y guardar en postgres
    enviar los datos en formato PARQUET a googlecloud storage particionado por año, mes, dia y hora

Para Batch Layer: (procesamiento(BatchJob)):
    .Total de bytes recibidos por antena
    .Total de bytes transmitidos por mail de usuario
    .Total de bytes transmitidos por aplicación
    .Email de usuarios que han sobrepasado la cuota por hora
    
    ser capaz de calcular para un año, mes, dia, hora pasados por argumentos, las métricas anteriores
    almacenar en postgresql

Para Serving layer: (Dashboard):


Salidas:
-con argumento antenna_telemetry y case class AntennaMessage
+-------------------+--------------------+-------------+-----+
|          timestamp|                  id|       metric|value|
+-------------------+--------------------+-------------+-----+
|2020-10-08 21:41:17|00000000-0000-000...|       status|    0|
|2020-10-08 21:41:17|44444444-4444-444...|       status|    1|
|2020-10-08 21:41:17|00000000-0000-000...|devices_count|   10|

-con argumento devices y case class UsersMessage
+-----+----------+--------+--------------------+--------------------+
|bytes| timestamp|     app|                  id|          antenna_id|
+-----+----------+--------+--------------------+--------------------+
| 6597|1602221895|FACEBOOK|00000000-0000-000...|11111111-1111-111...|
| 1363|1602221895|FACEBOOK|00000000-0000-000...|33333333-3333-333...|
| 4650|1602221895|TELEGRAM|00000000-0000-000...|33333333-3333-333...|
| 6450|1602221895|FACETIME|00000000-0000-000...|33333333-3333-333...|