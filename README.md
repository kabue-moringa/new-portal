## Organisational News Portal

This is an Organisational News API Application that enables a user to View Departments, Employees and News.

## AUTHOR:
joseph kabue wangari


### PROJECT DESCRIPTIONS
A Java/Spark application with a rest REST API for querying and retrieving scoped news and information.


### PRE-REQUISITES & Creating Tables:
In Postgres SQL:

* CREATE DATABASE news_portal;

* CREATE TABLE departments(id SERIAL PRIMARY KEY,name varchar, description varchar,employees int);

* CREATE TABLE employees(id SERIAL PRIMARY KEY, name varchar , title varchar, department_id int);

* CREATE TABLE news (id SERIAL PRIMARY KEY,title varchar, details varchar);

### DROPPING TABLES

*  nativage to main/resources/db 

 * `run  psql < drop.sql
 
 
 
### TECHNOLOGIES USED:

* [Java ]
* [Intellij Idea]
* [Spark]
* [HTML]

## End points

|          | URL                                                           | HTTP Verb   |                                              DESCRIPTION|
       |--                                              |  ---        |                                   ---      |
                  
       |/departments                                    |get             |Get departments                       
       |/departments/:id                                |get             |get depertments          
       |/employees                                      |get             |get employees
       |/employees/:id                                  |get             |get employees id          
       |/news                                           |get             |get news       
       /news/:id                                        |get             |get news using news_id     
       |/departments/new                                |post            |add a new department                       |
       |/employees/news                                 |post            |add empolyee news                               
       /news/new                                        |post            |add news
        
     
                                                                   
                                                                         




### support $ contact:
* Phone number: (+254713952973)
              : (+254717252081)
              
* Email Address: josephkabue019@gmail.com            
# LICENSE
This project is licensed under the MIT License - see the LICENSE file for details