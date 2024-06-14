# CRUD Application made with Spring Boot and React

## Backend

The backend is made with the Spring Boot version 3.2.6, Java 21, JPA and a Postgres access.

I've also added Mapstruct and Lombok as code generators to create the mappers and builders.

To start the backend, run the following command:

```
cd backend
mvn spring-boot:run
```

### Local database

Create the local database with the sql script upder the following path

backend\src\main\resources\db\sql

## Frontend

The frontend is made with the ReactJS version 18.0.2

To run the frontend, run the following command:

```
cd frontend
npm install
nx serve
```
