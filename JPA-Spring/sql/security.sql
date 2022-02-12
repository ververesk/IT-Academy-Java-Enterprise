select * from usrs u ;
select * from roles;
select * from authority a; 
select * from user_roles;
select * from user_authority;

create table usrs (
	id bigserial,
	username varchar(50) not null,
	password varchar(255) not null,
	enabled boolean not null,
	primary key(id)
);

create table roles (
	id bigserial,
	name varchar(50) not null,
	primary key(id)
);

create table authority (
	id bigserial,
	name varchar(50) not null,
	primary key(id)
);

create table user_roles (
	user_id bigint not null,
	role_id bigint not null,
	primary key (user_id, role_id),
	foreign key (user_id) references usrs (id),
	foreign key (role_id) references roles (id)
);

create table user_authority (
	user_id bigint not null,
	authority_id bigint not null,
	primary key (user_id, authority_id),
	foreign key (user_id) references usrs (id),
	foreign key (authority_id) references "authority" (id)
);

insert into usrs(username, "password", enabled) values 
('admin', '$2a$12$LV31nYHfUhT0j5uXCiL.rewhwWQ5/PIaBW/0isH11n0qlK9WSCOHm', true),--1
('teacher', '$2a$12$LV31nYHfUhT0j5uXCiL.rewhwWQ5/PIaBW/0isH11n0qlK9WSCOHm', true),
('student', '$2a$12$LV31nYHfUhT0j5uXCiL.rewhwWQ5/PIaBW/0isH11n0qlK9WSCOHm', true)
;

insert into roles("name") values
('ROLE_TEACHER'),
('ROLE_ADMIN'),
('ROLE_STUDENT')
;

insert into authority("name") values
('READ_MATH'),
('READ_INFO')
;

insert into user_roles(user_id, role_id) values
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(3, 3)
;

insert into user_authority(user_id, authority_id) values
(2, 1)
;