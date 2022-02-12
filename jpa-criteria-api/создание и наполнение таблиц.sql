drop table employees;
drop table departments;

CREATE TABLE departments (
  id serial NOT NULL,
  name varchar(15),
  max_salary int,
  min_salary int,
  PRIMARY KEY (id)
);

CREATE TABLE employees (
  id serial NOT NULL,
  name varchar(15),
  surname varchar(25),
  salary int,
  department_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (department_id) REFERENCES departments(id));
  
 insert into departments (name, max_salary, min_salary) 
 values
('HR', 1000, 500),
('IT', 1200,700),
('Marketing',900,600),
('logistics',1000,700);

select *from departments d ;

insert into employees (name, surname,salary,department_id)
values
('Daniel', 'Reed', 1000, 1),
('Logan', 'Cook', 950, 2),
	('Aiden', 'Morgan', 650, 3),
	('Matthew', 'Bell', 970, 4),
	('Ella', 'Cox', 710, 3),
	('Chloe', 'Ward', 660, 1),
	('Zoey', 'Grey', 1100, 2),
	('Ivan', 'Smith', 900, 4),
	('Margo', 'Robbi', 760, 3);
	
select * from employees e ;