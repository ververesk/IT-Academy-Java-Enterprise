select st.id, name, surname, course_name, grades
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where c.course_id=1

Update students set name='Noah', surname='Smith', age=18 where id=1;

select sum(salary) as "sum" from teachers t ;

select avg(salary) average_salary from teachers t ;

select st.id st_id, name, surname, course_name
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where c.course_id=1


select st.id, name, surname, course_name, grades
from students st join student_cours_grades scg on (st.id=scg.student_id)
join courses c on (scg.course_id=c.course_id)
where st.id=1