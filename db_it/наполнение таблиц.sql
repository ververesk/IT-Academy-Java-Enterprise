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

INSERT INTO users (username , "password", enabled)
VALUES
	('ivanov', '{noop}ivanov', true),
	('smith', '{noop}smith', true),
	('miller', '{noop}miller', true),
	('jones', '{noop}jones', true),
	('brown', '{noop}brown', true),
	('davis', '{noop}davis', true),
	('wilson', '{noop}wilson', true),
	('moore', '{noop}moore', true),
	('white', '{noop}white', true),
	('green', '{noop}green', true),
	('black', '{noop}black', true),
	('reed', '{noop}reed', true),
	('cook', '{noop}cook', true),
	('morgan', '{noop}morgan', true),
	('bell', '{noop}bell', true),
	('cox', '{noop}cox', true),
	('ward', '{noop}ward', true),
	('grey', '{noop}grey', true);
select * from users;


INSERT INTO administrators (name, surname, username)
VALUES
	('Igor', 'Ivanov', 'ivanov');

select * from administrators a ;

INSERT INTO teachers (name, surname, salary, course_id, username)
VALUES
	('Daniel', 'Reed', 100, 1, 'reed'),
	('Logan', 'Cook', 110, 2, 'cook'),
	('Aiden', 'Morgan', 100, 3, 'morgan'),
	('Matthew', 'Bell', 110, 4, 'bell'),
	('Ella', 'Cox', 100, 5, 'cox'),
	('Chloe', 'Ward', 120, 6, 'ward'),
	('Zoey', 'Grey', 160, 7, 'grey');

select * from teachers t ;

INSERT INTO authorities (username, authority)
VALUES
	('ivanov', 'ROLE_ADMINISTRATOR'),
	('smith', 'ROLE_smith'),
	('miller', 'ROLE_miller'),
	('jones', 'ROLE_jones'),
	('brown', 'ROLE_brown'),
	('davis', 'ROLE_davis'),
	('wilson', 'ROLE_wilson'),
	('moore', 'ROLE_moore'),
	('white', 'ROLE_white'),
	('green', 'ROLE_green'),
	('black', 'ROLE_black'),
	('reed', 'ROLE_MATH'),
	('cook', 'ROLE_CS'),
	('morgan', 'ROLE_JAVA'),
	('bell', 'ROLE_SQL'),
	('cox', 'ROLE_HTML'),
	('ward', 'ROLE_JS'),
	('grey', 'ROLE_ENG');

select * from authorities a ;

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
DELETE FROM public.students
WHERE id=12;
select name, surname, age from students;
select * from students s ;
commit;
delete 

select * from student_cours_grades scg ;

update student_cours_grades scg set grades=8 where id=23;







	
