create table RegisteredServiceImpl (
    expression_type VARCHAR(15) DEFAULT 'ant' not null,
    id bigint not null auto_increment,
    allowedToProxy bit not null,
    anonymousAccess bit not null,
    description varchar(255),
    enabled bit not null,
    evaluation_order integer not null,
    ignoreAttributes bit not null,
    name varchar(255),
    serviceId varchar(255),
    ssoEnabled bit not null,
    theme varchar(255),
    username_attr longtext,
    primary key (id)
);  

create table SERVICETICKET (
    ID varchar(255) not null,
    NUMBER_OF_TIMES_USED integer,
    CREATION_TIME bigint,
    EXPIRATION_POLICY longblob not null,
    LAST_TIME_USED bigint,
    PREVIOUS_LAST_TIME_USED bigint,
    FROM_NEW_LOGIN bit not null,
    TICKET_ALREADY_GRANTED bit not null,
    SERVICE longblob not null,
    ticketGrantingTicket_ID varchar(255),
    primary key (ID)
);
 
create table TICKETGRANTINGTICKET (
    ID varchar(255) not null,
    NUMBER_OF_TIMES_USED integer,
    CREATION_TIME bigint,
    EXPIRATION_POLICY longblob not null,
    LAST_TIME_USED bigint,
    PREVIOUS_LAST_TIME_USED bigint,
    AUTHENTICATION longblob not null,
    EXPIRED bit not null,
    SERVICES_GRANTED_ACCESS_TO longblob not null,
    ticketGrantingTicket_ID varchar(255),
    primary key (ID)
) ;
 
create table locks (
    application_id varchar(255) not null,
    expiration_date datetime,
    unique_id varchar(255),
    primary key (application_id)
) ;
 
create table rs_attributes (
    RegisteredServiceImpl_id bigint not null,
    a_name varchar(255) not null,
    a_id integer not null,
    primary key (RegisteredServiceImpl_id , a_id)
) ;
 
alter table SERVICETICKET add index FK7645ADE132A2C0E5 (ticketGrantingTicket_ID), add constraint FK7645ADE132A2C0E5 foreign key (ticketGrantingTicket_ID) references TICKETGRANTINGTICKET (ID);
 
alter table TICKETGRANTINGTICKET add index FKB4C4CDDE32A2C0E5 (ticketGrantingTicket_ID), add constraint FKB4C4CDDE32A2C0E5 foreign key (ticketGrantingTicket_ID) references TICKETGRANTINGTICKET (ID);
 
alter table rs_attributes add index FK4322E153C595E1F (RegisteredServiceImpl_id), add constraint FK4322E153C595E1F foreign key (RegisteredServiceImpl_id) references RegisteredServiceImpl (id);