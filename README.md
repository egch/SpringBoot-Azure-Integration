# SpringBoot-Azure-Integration
A Proof of Concept (POC) demonstrating the integration of Spring Boot with Microsoft Azure SDK. 
This project explores how to connect a Spring Boot application with Azure services such as storage, databases, and messaging, using Azure SDK libraries for seamless cloud interaction.

## Azure Function
### Local Execution
```shell
$  mvn package
$  mvn azure-functions:run
```
To check if it works:
```shell
$ curl  http://localhost:7071/api/hello
```