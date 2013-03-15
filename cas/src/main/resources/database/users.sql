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

create table persistent_logins (
	username varchar(64) not null,
    series varchar(64) primary key,
    token varchar(64) not null,
    last_used timestamp not null
);


CREATE TABLE COM_STATISTICS
 (
  STAT_SERVER_IP VARCHAR2(15)  NOT NULL,
  STAT_DATE      DATE          NOT NULL,
  APPLIC_CD      VARCHAR2(5)   NOT NULL,
  STAT_PRECISION VARCHAR2(6)   NOT NULL,
  STAT_COUNT     NUMBER        NOT NULL,
  STAT_NAME      VARCHAR2(100) NOT NULL
 );
 
 CREATE TABLE COM_AUDIT_TRAIL
 (
  AUD_USER      VARCHAR2(100)  NOT NULL,
  AUD_CLIENT_IP VARCHAR(15)    NOT NULL,
  AUD_SERVER_IP VARCHAR(15)    NOT NULL,
  AUD_RESOURCE  VARCHAR2(100)  NOT NULL,
  AUD_ACTION    VARCHAR2(100)  NOT NULL,
  APPLIC_CD     VARCHAR2(5)    NOT NULL,
  AUD_DATE      TIMESTAMP      NOT NULL
 );