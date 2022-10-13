create database Project;
use Project;

create table Users(
user_id int identity(101,1),
user_name varchar(255),
user_email varchar(255), 
password varchar(255),
role varchar(255),
CONSTRAINT user_email_unique unique(user_email),
Constraint user_name_unique unique(user_name),
CONSTRAINT pk_user primary key(user_id)
)


create table Template(
template_id int identity(201,1),
template_name varchar(255) ,
CONSTRAINT pk_template primary key(template_id),
CONSTRAINT template_unique unique(template_name)
)

CREATE TABLE Topic(
topic_id int identity(1,1),
template_id int,
topic_name varchar(255),
CONSTRAINT fk_topic_template foreign key (template_id) references Template(template_id) ON DELETE CASCADE,
CONSTRAINT pk_topic primary key(topic_id,template_id),
CONSTRAINT topic_unique Unique(template_id,topic_name)
)



create table StatusTable(
status_id int identity(1,1),
template_id int,
user_id int,
topic_id int,
CONSTRAINT fk_status_user foreign key (user_id) references Users(user_id) ON DELETE CASCADE,
CONSTRAINT fk_status_topic foreign key (topic_id,template_id) references Topic(topic_id,template_id) ON DELETE CASCADE,
CONSTRAINT pk_status primary key(status_id),
constraint status_unique Unique(template_id,user_id,topic_id)
)


INSERT INTO Users values('abhishek','abhishek@gmail.com','abhishek123','super admin');
INSERT INTO Users values('lokesh','lokeshk@gmail.com','lokesh123','super admin');
INSERT INTO Users values('pavani','pavani@gmail.com','pavani123','super admin');
INSERT INTO Users values('ambika','ambika@gmail.com','ambika123','admin');
INSERT INTO Users values('harini','harini@gmail.com','harini123','employee');
INSERT INTO Users values('ammulu','ammulu@gmail.com','ammulu123','employee');
INSERT INTO Users values('sirisha','sirisha@gmail.com','sirisha123','admin');





insert into Template values ('Java_training');
insert into Template values ('python_training');
/*insert into Template values ('Java_training');*/

insert into Topic values(201,'static methods');
insert into Topic values(201,'interface methods');
insert into Topic values(202,'static methods');

insert into StatusTable values(201,101,1);
insert into StatusTable values(201,101,2);
insert into StatusTable values(202,102,3);




select * from Users;
select * from Template;
select * from Topic;
select * from StatusTable;


drop table StatusTable;
drop table Topic;
drop table Template;
drop table Users;