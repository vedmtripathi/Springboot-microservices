# Spring Data REST and JPA Example
This project depicts the Spring Boot Example with Spring Data REST and JPA Example.

# in memory DB
URL: http://localhost:8080/h2-console

JDBC connection String- jdbc:h2:mem:testdb

## Description
This Project shows the list of Users which are stored in the In-Memory H2 Database. Using the following endpoints, different operations can be achieved:
- `/users/all` - This returns the list of Users in the Users table which is created in H2
- `/users/{name}` - This returns the details of the Users passed in URL
- `/users/load` - Add new users using the Users model. eg. {"name": "IOT", "teamName": "Digital", "salary": 10000000,"id":3 }

## Libraries used
- Spring Boot
- Spring Configuration
- Spring REST Controller
- Spring JPA
- H2
- Development Tools

## Compilation Command
- `mvn clean install` - Plain maven clean and install
