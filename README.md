# SpringBootApacheKafka
Spring Boot project to create topics for saving some information including String, POJO, publishing and consuming those informations
Software: Apache-Kafka should be pre-installed, then run zookeeper-server and kafka-server by following commands given below:
To start Zookeeper::--
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
To start kafka-server::--
.\bin\windows\kafka-server-start.bat .\config\server.properties
To create Topics in broker::-
.\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092
To write some event in topics::--
.\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092
To read events::-
.\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092
