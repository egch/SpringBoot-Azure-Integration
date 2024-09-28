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

## Credits
* https://learn.microsoft.com/en-us/azure/developer/java/spring-framework/getting-started-with-spring-cloud-function-in-azure
* https://medium.com/microsoftazure/create-azure-function-with-spring-cloud-function-ab150216d2bd
* https://github.com/eugenp/tutorials/blob/cbc5cad1613516c8a3307e7ec94b6a07603e1c39/spring-cloud-modules/spring-cloud-functions-azure/pom.xml
* https://github.com/tzolov/hello-spring-function-azure/tree/di-integration