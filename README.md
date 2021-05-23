# Getting Started

### Prerequisites
* Git
* JDK 8 or later
* Gradle
* Postgres DB

### Configuration
Database configuration:

File : src/main/resources/application-dev.properties
Change below values
* [spring.datasource.url=jdbc:postgresql://localhost:5432/products_db_v1
* [spring.datasource.username=postgres
* [spring.datasource.password=example

Initial database values are in below location
* [src/main/resources/db-scripts/init-script.sql
