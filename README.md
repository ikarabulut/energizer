# energize
Streaming application for your smart battery data.

### How to start the energize application:

This project utilizes a [mock battery info generator](https://github.com/jyates/manning-energy-resources/tree/master/event-generators). The jar file is located within `/mock-energy-resources`

---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/energize-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
