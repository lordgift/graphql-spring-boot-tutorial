create database sample;
use sample;

create table MY_USER
(
    ID int auto_increment primary key,
    NAME varchar(100) null,
    POSITION varchar(100) null,
    LAST_UPDATED DATETIME null
);

INSERT INTO MY_USER (NAME, POSITION, LAST_UPDATED) value ('Me', 'Tester', sysdate());


select * from MY_USER