
drop table students;
drop table teachers;
drop table student_cours;
drop table courses ;


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

--view math
CREATE OR REPLACE VIEW public.math
AS SELECT student_cours_grades.id,
    student_cours_grades.grades,
    student_cours_grades.student_name
   FROM student_cours_grades
  WHERE student_cours_grades.course_id = 1;
 
 --info for student
 CREATE OR REPLACE VIEW public.noahsmith
AS SELECT student_cours_grades.id,
    student_cours_grades.grades,
    student_cours_grades.course_name
   FROM student_cours_grades
  WHERE student_cours_grades.student_id = 1;

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






 


