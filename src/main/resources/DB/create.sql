SET MODE PostgreSQL;
CREATE TABLE IF NOT EXISTS employees (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 title VARCHAR,
department_id VARCHAR,
);
CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 details VARCHAR,
);
CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 employees INTEGER
);
/