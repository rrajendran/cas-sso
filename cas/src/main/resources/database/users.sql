drop database cas;
create database cas;
use cas;

create table user(
	username varchar(20) not null,
	password varchar(29) not null,
	primary key(username)
);

insert into user(username,password) values("ramesh","welcome1");
insert into user(username,password) values("admin","secret");
insert into user(username,password) values("radhika","mani");