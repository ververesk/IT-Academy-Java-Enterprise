drop table users;
drop table authorities;
drop table students;
drop table administrators;
drop table administrators;
drop table teachers;
drop table student_cours;
drop table courses ;

CREATE TABLE users (
  username varchar(15),
  password varchar(100) not null,
  enabled boolean,
  PRIMARY KEY (username)
) ;
select * from users;

CREATE TABLE authorities (
  username varchar(15),
  authority varchar(25) not null,
  FOREIGN KEY (username) references users(username)
) ;

create table students (
id serial not null primary key,
name varchar(50) not null,
surname varchar(50) not null,
age int not null,
username varchar(15) constraint st_users_username_fk references users(username) on delete set null
);
ALTER TABLE students DROP CONSTRAINT  st_users_username_fk; 
ALTER TABLE students add  constraint st_name_unique unique (username);

create table courses (
course_id serial not null primary key,
course_name varchar(50) not null unique
);

create table administrators (
id serial not null primary key,
name varchar(50) not null,
surname varchar(50) not null,
username varchar(15) constraint adm_users_fk references users(username) on delete set null
);
ALTER TABLE administrators DROP CONSTRAINT  adm_users_fk; 
ALTER TABLE administrators add  constraint adm_name_unique unique (username);

create table teachers (
id serial not null primary key,
name varchar(50) not null,
surname varchar(50) not null,
salary int not null,
course_id int constraint teach_courses_fk references courses(course_id) on delete set null,
username varchar(15) constraint teach_users_fk references users(username) on delete set null
);
ALTER TABLE teachers DROP CONSTRAINT  teach_users_fk; 
ALTER TABLE teachers add  constraint t_name_unique unique (username);

CREATE TABLE student_cours_grades (
  student_id int NOT NULL,
  course_id int NOT NULL,
  grades int,
  PRIMARY KEY (student_id, course_id),
  FOREIGN KEY (student_id) REFERENCES students(id),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
 );
 
ALTER TABLE student_cours_grades ADD column id serial not null;

