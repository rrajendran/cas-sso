drop database cas;
create database cas;
use cas;

create table user(
	username varchar(20) not null,
	password varchar(50) not null,
	authorities varchar(200) default "ROLE_USER",
	primary key(username)
);

insert into user(username,password,authorities) values("ramesh",sha1("welcome1"), "ROLE_USER,ROLE_SUPERVISOR");
insert into user(username,password,authorities) values("admin",sha1("secret"),"ROLE_USER,ROLE_ADMIN");
insert into user(username,password,authorities) values("user",sha1("user"),"ROLE_USER");