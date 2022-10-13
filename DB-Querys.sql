create database Project;


create table Users(id int primary key,email varchar(255), password varchar(255),role varchar(255))

create table Template(tid int identity(201,1) Primary key,t_name varchar(255))

create table TemplateAssigned(tid int  foreign key references Template(tid), eid int foreign key references Users(id),id int identity(1,1))

Alter Table TemplateAssigned add constraint uni_key Unique(tid,eid);


insert into Users values(102,'lokesh@gmail.com','1234','employee')
insert into Template values ('Java')

select role from Users where email = 'lokesh@gmail.com' and password = '1234';

delete from Users where id = 102;
delete from TemplateAssigned where eid = 102;

insert into TemplateAssigned values(201,101),(201,102)

select * from Users;
select * from Template;

select * from TemplateAssigned;

drop table TemplateAssigned
drop table Template;
drop table Users;