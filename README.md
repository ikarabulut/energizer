# Energize
Streaming application utilizing Kafka streams to recieve realtime battery data from a mock server
and stream that data into a db for upstream applications. The goal of this project is to practice Java, Kafka, and event driven
applications.


## Project Details

---
**Technologies used**
- Java 21
- Dropwizard as JeAS
- Apache Avro
- Kafka & Kafka Streams
- Postgres
- Docker-compose

**Important files**
- `/config`: dropwizard config files for the api server and kafka stream application
- `src/main/java/api`: Code for the api server
- `src/main/java/stream`: Code for the stream application
- `src/main/java/resources`: Sql statement for initial creation of db on docker compose run
- `/mock-energy-resources`: Holds the jar file for the [mock battery info generator](https://github.com/jyates/manning-energy-resources/tree/master/event-generators)

## Run Locally

---
1. `mvn clean install` to build your application
2. `mvn clean package` to package your application. **Currently utilizes FAT jar, to update see `pom.xml`**
3. `docker compose up`
   - From root directory, this will spin up your postgres db, kafka service, initialize your topic, zookeeper, and schema registry.
4. Start API server
   - `java -jar target/energize-1.0-SNAPSHOT.jar server config/config.yml`
5. Start Streams application
   - `java -cp target/energize-1.0-SNAPSHOT.jar com.ikarabulut.energize.stream.DeviceStateStream stream config/stream.yml`
6. Start mock battery app
   - `java -jar event-generators-1.2-SNAPSHOT-jar-with-dependencies.jar events --target http://localhost:8080/api/send`


## Health Check

---

To see your applications health enter url `http://localhost:8081/healthcheck`
