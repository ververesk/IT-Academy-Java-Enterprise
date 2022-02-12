select * from courses;
select * from teachers t ;
select * from students s ;
select * from student_cours_grades scg ;

INSERT INTO courses (course_name)
VALUES
	('math'),
	('computer science'),
	('java'),
	('sql'),
	('html'),
	('js'),
	('english')
	;
insert into courses (course_name) VALUES ('makkkth');
delete from courses where course_id=16;
select * from courses;
select course_id from courses where course_name = 'sql';
update courses set course_name = 'deutch' where course_id =59;



INSERT INTO teachers (name, surname, salary, course_id, username)
VALUES
	('Daniel', 'Reed', 100, 1, 'reed'),
	('Logan', 'Cook', 110, 2, 'cook'),
	('Aiden', 'Morgan', 100, 3, 'morgan'),
	('Matthew', 'Bell', 110, 4, 'bell'),
	('Ella', 'Cox', 100, 5, 'cox'),
	('Chloe', 'Ward', 120, 6, 'ward'),
	('Zoey', 'Grey', 160, 7, 'grey');



INSERT INTO students (name, surname, age, username)
VALUES
	('Noah', 'Smith', 18, 'smith'),
	('Liam', 'Miller', 19, 'miller'),
	('Mason', 'Jones', 20, 'jones'),
	('Jacob', 'Brown', 21, 'brown'),
	('James', 'Davis', 24, 'davis'),
	('Emma', 'Wilson', 35, 'wilson'),
	('Olivia', 'Moore', 45, 'moore'),
	('Sophia', 'White', 27, 'white'),
	('Ava', 'Green', 31, 'green'),
	('Mia', 'Black', 50, 'black');

INSERT INTO students (name, surname, age)
VALUES
	('Ken', 'Smith', 18);






select * from student_cours_grades scg ;

update student_cours_grades scg set grades=8 where id=23;







	
