alter table student_cours_grades delete column student_name;
ALTER TABLE student_cours_grades ADD column id serial not null;
alter table student_cours_grades ADD column course_name varchar(20);
UPDATE student_cours_grades
SET student_name = 'James'
WHERE id=10;

UPDATE student_cours_grades
SET course_name = 'sql'
WHERE course_id =4;


select * from student_cours_grades;

select st.id, name, surname, course_name, grades
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where c.course_id=1


select sum(salary) as "sum" from teachers t ;

select avg(salary) average_salary from teachers t ;

select st.id st_id, name, surname, course_name
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where c.course_id=1;
--math
select grades, student_name
from student_cours_grades 
where course_id=1;

select st.id, name, surname, course_name, grades
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where st.id=1
--view math
create view math as 
select id, grades, student_name
from student_cours_grades 
where course_id=1;


UPDATE math
SET grades = 9
WHERE student_name='Noah';

select * from math;

--view NoahSmith
create view NoahSmith as 
select id, grades, course_name
from student_cours_grades 
where student_id=1;

select * from NoahSmith;

