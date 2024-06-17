# CRUD Application made with Spring Boot and React

## Book Rental

## Demo Vedio : https://www.youtube.com/watch?v=nHgYjZNSwVY

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

## if BUILD FAILURE, Run Build Task

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
npm add --global nx@latest
nx dev
```

## SQL Script (Done)

SQL script for checking DB status

```
WITH inventories_table AS
    (
    SELECT
        book_id,
        array_to_string(array_agg(distinct inventory.id),',') AS inventories,
        COUNT( * ) AS balance
    FROM inventory
    where inventory.loan_date is null
    GROUP BY book_id
    )
SELECT
    book.id,
    book.author,
    book.title,
    book.image,
    inventories_table.inventories,
    inventories_table.balance
FROM  book
LEFT JOIN inventories_table ON book.id = inventories_table.book_id
GROUP BY book.id, inventories_table.inventories,inventories_table.balance

```
