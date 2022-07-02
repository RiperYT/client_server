SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE IF EXISTS zlagoda;

create database zlagoda;

\connect zlagoda
	
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;	
	
create table if not exists "Employee"
(
    id_employee     varchar(10)    not null
        constraint employee_pk
            primary key,
    empl_surname    varchar(50)    not null,
    empl_name       varchar(50)    not null,
    empl_patronymic varchar(50)    not null,
    empl_role       varchar(10)    not null,
    salary          numeric(13, 4) not null,
    date_of_birth   date           not null,
    date_of_start   date           not null,
    phone_number    varchar(13)    not null,
    city            varchar(50)    not null,
    street          varchar(50)    not null,
    zip_code        varchar(9)     not null
);

create table if not exists "Customer_card"
(
    card_number     varchar(13) not null
        constraint customer_card_pk
            primary key,
    cust_surname    varchar(50) not null,
    cust_name       varchar(50) not null,
    cust_patronymic varchar(50),
    phone_number    varchar(13) not null,
    city            varchar(50),
    street          varchar(50),
    zip_code        varchar(9),
    percent         integer     not null
);

create unique index if not exists customer_card_card_number_uindex
    on "Customer_card" (card_number);

create table if not exists "Check"
(
    check_number varchar(10)    not null
        constraint check_pk
            primary key,
    id_employee  varchar(10)    not null
        constraint check_employee_id_employee_fk
            references "Employee"
            on update cascade,
    card_number  varchar(13)
        constraint check_customer_card_card_number_fk
            references "Customer_card"
            on update cascade,
    print_date   timestamp      not null,
    sum_total    numeric(13, 4) not null,
    vat          numeric(13, 4) not null
);

create unique index if not exists check_check_number_uindex
    on "Check" (check_number);

create table if not exists "Category"
(
    category_number serial
        constraint category_pk
            primary key,
    category_name   varchar(50) not null
);

create unique index if not exists category_category_number_uindex
    on "Category" (category_number);

create table if not exists "Product"
(
    id_product      serial
        constraint product_pk
            primary key,
    category_number integer      not null
        constraint product_category_category_number_fk
            references "Category"
            on update cascade,
    product_name    varchar(50)  not null,
    characteristics varchar(100) not null
);

create unique index if not exists product_id_product_uindex
    on "Product" (id_product);

create table if not exists "Store_Product"
(
    "UPC"               varchar(12)    not null
        constraint store_product_pk
            primary key,
    "UPC_prom"          varchar(12)
        constraint store_product_store_product_upc_fk
            references "Store_Product"
            on update cascade on delete set null,
    id_product          integer        not null
        constraint store_product_product_id_product_fk
            references "Product"
            on update cascade,
    selling_price       numeric(13, 4) not null,
    products_number     integer        not null,
    promotional_product boolean        not null
);

create unique index if not exists store_product_upc_uindex
    on "Store_Product" ("UPC");

create table if not exists "Sale"
(
    "UPC"          varchar(12)    not null
        constraint sale_store_product_upc_fk
            references "Store_Product"
            on update cascade,
    check_number   varchar(10)    not null
        constraint sale_check_check_number_fk
            references "Check"
            on update cascade on delete cascade,
    product_number integer        not null,
    selling_price  numeric(13, 4) not null,
    constraint sale_pk
        primary key (check_number, "UPC")
);

create unique index if not exists sale_check_number_uindex
    on "Sale" (check_number);

create unique index if not exists sale_upc_uindex
    on "Sale" ("UPC");

