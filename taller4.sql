create database Login;
use Login;

create table users (
user_id int auto_increment primary key ,
user_firstname  VARCHAR(40) not null,
user_lastname   VARCHAR(40) not null,
user_email    VARCHAR(60) not null,
user_password  varbinary (255)
);

create table category (
category_id integer auto_increment primary key not null,
category_name varchar(40) not null);

create table products (
product_id integer not null auto_increment,
product_name varchar(40) not null, 
product_value int not null, 
category_id_fk int not null, 
foreign key(category_id_fk) references category (category_id), 
primary key(product_id)) auto_increment;


insert into Login.users (user_firstname, user_lastname, user_email, user_password) values (upper ('pedro'), upper ('cortez'), 'email@gmail.com', aes_encrypt('ñero', '$2a$12$kdxJ0X5wdsv6PiVsh65wzeFuLucUaDn23ceJOnLR2UXb9ojGcUnG.'));
insert into Login.users (user_firstname, user_lastname, user_email, user_password) values (upper ('Mariana'), upper ('Alvarez'), 'giu@gmail.com', aes_encrypt('loviu', '$2a$12$cyYB1dwpDKIwc8DTy9L/..pyz/n5pGuGMQXJONLfI1t.GFcWxnEfC'));

select user_firstname, user_lastname, user_email, user_password, 
cast(aes_decrypt(user_password, '$2a$12$kdxJ0X5wdsv6PiVsh65wzeFuLucUaDn23ceJOnLR2UXb9ojGcUnG.') as char (50)) end_data from users where user_id=1;  
select user_firstname, user_lastname, user_email, user_password, 
cast(aes_decrypt(user_password, '$2a$12$cyYB1dwpDKIwc8DTy9L/..pyz/n5pGuGMQXJONLfI1t.GFcWxnEfC') as char (50)) end_data from users where user_id=2;  


select * from users;
