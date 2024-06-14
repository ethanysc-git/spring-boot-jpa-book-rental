--liquibase formatted sql

--changeset application:1
CREATE TABLE inventory (
      id uuid NOT NULL,
      book_id uuid NULL,
      user_id uuid NULL,
      loan_date timestamp without time zone NULL,
      CONSTRAINT borrowed_book_pkey PRIMARY KEY (id)
);
