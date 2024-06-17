# CRUD Application made with Spring Boot and React

## Backend(Done)

Current progress

1. Basic setting (Local DataBase and fake data by mocked.ql)
2. Set up folder path
3. Build WebConfig file for cors and RestExceptionHandler file for exception msg
4. Build Entities base on the Postgre DB
5. Build Dtos and Mappers
6. Build Repository Interface for Entity to use JPA in Service
7. Build Service for Jpa findAll() and findById(id)
8. Build Service and Controller for borrow and return logic

The backend is made with the Spring Boot version 3.2.6, Java 21, JPA and a Postgres access.

I've also added Mapstruct and Lombok as code generators to create the mappers and builders.

To start the backend, run the following command:

```
cd backend
mvn spring-boot:run
```

### Local database

Create the local database with the sql script files under the following path

backend\src\main\resources\db\sql

## Frontend (Done)

The frontend is made with the ReactJS version 18.3.1, using Next with TypeScript

Current progress

1. Set up UI (rwd available)
2. Set Login UI
3. Build Frontend borrow and return logic (vo.o.2)

To run the frontend, run the following command:

```
cd frontend
npm install
nx serve
```
