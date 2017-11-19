# transactions-statistics-service
## Description

This is a REST API for transactions statistics. One API is to send transactions and another one is to get statistic based of the transactions of the last 60 seconds.

## Version
```
0.1.0
```
## Run the application
#### Clone the application
Open your terminal and run the following command:
```
cd /tmp
git clone git@github.com:Sponch/transactions-statistics-service.git
cd transactions-statistics-service
```
#### Build the application
To build, test and create a package, run the following command in your terminal:
```
mvn clean install package
```
#### Run the application
To run the application, run this command in your terminal:
```
java -jar target/transactions-statistics-service-0.1.0.jar
```
#### Visualization of REST API using [Swagger](./swagger.png) 

To see the live documentation of this API, access this URL:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Generate Coverage of tests

To see the coverage of tests of the API, run the following command. 
#### Generate report 
```
mvn test jacoco:report
```
#### Open Report
```
open target/site/jacoco/index.html
```
## Coverage
[Coverage Result](./coverage.png)

## Technologies utilized
 - Java 8
 - Spring Boot
 - Junit (tests)
 - Swagger (UI)
 
## Strategy of development

- Utilization of ConcurrentLinkedQueue to receive the transactions. ConcurrentLinkedQueue is an unbounded thread-safe queue and it's possible to handle the concurrency of requests to add transactions
- Thread that run each 300ms to check if there are old transactions to be removed and regenated the statistics
- TransactionsRepository use callback to update statistics of StatisticsService  
- Use of synchronized statements to avoid thread interference and memory consistency errors


