create database BMS;
use BMS;

create table sign_up(
form_no varchar(10) PRIMARY KEY not null,
Reg_Name varchar(25) not null,
F_name varchar(255) not null,
DOB varchar(11) not null,
gender varchar(6) not null,
E_mail varchar(25) not null,
Marital_status varchar(3) not null,
City varchar(10) not null,
Address varchar(50) not null,
PIN_Code varchar(10) not null,
State varchar(15) not null
);
select * from  login;
create table add_sign_up(
form_no varchar(10) not null,
Religion varchar(10) not null,
Category varchar(10) not null,
Education varchar(10) not null,
Income double not null,
Occupation varchar(20) not null,
PAN int not null,
Aadhar_no int primary key not null,
Senior_citizen varchar(5) not null,
Exist_account varchar(5) not null,
foreign key(form_no) references sign_up(form_no)
);

create table acc_sign_up(
form_no varchar(10) not null,
Account_Type varchar(50) not null,
Card_number varchar(20) primary key not null,
PIN varchar(20) not null,
Services varchar(255) not null,
foreign key(form_no) references sign_up(form_no)
);

create table login(
form_no varchar(20) not null,
Card_number varchar(20) not null,
PIN varchar(20) primary key not null,
foreign key(form_no) references sign_up(form_no),
foreign key(Card_number) references acc_sign_up(Card_number)
);


create table bank_trans(
PIN varchar(20) not null,
transaction_date varchar(50) not null,
transaction_amount int not null,
transaction_type varchar(15) not null,
foreign key(PIN) references login(PIN)
);

select * from bank_trans;


create table account(
PIN varchar(20) not null,
Balance int not null,
foreign key(PIN) references login(PIN)
);
show tables;

select * from account;
select * from login;
SELECT BALANCE FROM ACCOUNT WHERE PIN="324";
SELECT * FROM BANK_TRANS WHERE PIN="7078";


