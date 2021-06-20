## Organisational News Portal

This is an Organisational News API Application that enables a user to View Departments, Employees and News.

## AUTHOR:
joseph kabue wangari



### PRE-REQUISITES & Creating Tables:
In Postgres SQL:

* CREATE DATABASE news_portal;

* CREATE TABLE departments(id SERIAL PRIMARY KEY,name varchar, description varchar, total_employees int);

* CREATE TABLE employees(id SERIAL PRIMARY KEY, name varchar , role varchar, position varchar, department_id int);

* CREATE TABLE news (id SERIAL PRIMARY KEY,title varchar, content varchar, writtenBy varchar,type varchar,department_id int);



### TECHNOLOGIES USED:

* [Java ]
* [Intellij Idea]
* [Spark]
* [HTML]


# LICENSE
This project is licensed under the MIT License - see the LICENSE file for details