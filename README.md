# transactions-statistics-service
Statistics of transactions in the last 60 seconds

## Version
```
0.1.0
```

## Description

This is a REST API for transactions statistics. One API is to send transactions and another one is to get statistic based of the transactions of the last 60 seconds.

## Run the application
##### Clone the application

```
cd /tmp
git clone git@github.com:Sponch/transactions-statistics-service.git
cd transactions-statistics-service
```
#### Build the application
```
mvn clean install package
```
#### Run the application
Change the version to run the application
```
java -jar target/transactions-statistics-service-<VERSION>.jar
```
## Generate Coverage of tests
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


