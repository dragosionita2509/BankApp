CREATE TABLE BANK(
title varchar(30) not null,
address varchar(30) not null
);

CREATE TABLE client(
CNP varchar(13) primary key,
first_name varchar(30) not null,
last_name varchar(30) not null,
age integer not null,

constraint cl_first_name_ck check(first_name NOT LIKE '%[^A-Z]%'),
constraint cl_last_name_ck check(last_name NOT LIKE '%[^A-Z]%'),
constraint cl_cnp_ck check(length(CNP) = 13)
);


CREATE TABLE CARD(
card_number varchar(30) primary key,
CNP varchar(13) not null,
expiration_date varchar(30) not null,
CVC integer not null,
PIN integer not null,

constraint card_num_ck check(card_number NOT LIKE'%[^0-9]%'),
constraint card_num_len_ck check(length(card_number) = 16),
constraint card_cvc_ck check(length(CVC) = 3),
constraint card_pin_ck check(length(pin) = 4)
);


CREATE TABLE CURRENT_ACCOUNT(
IBAN varchar(24) primary key,
balance float not null,
opening_date varchar(30) not null,
currency varchar(3) not null,
card_number varchar(30),

constraint ca_iban_len_ck check(length(iban) = 24),
constraint ca_curr_ck check(currency in ('EUR','USD','RON'))
);

ALTER TABLE CURRENT_ACCOUNT 
ADD CONSTRAINT 
foreign key(card_number)
references card(card_number) on delete cascade;

ALTER TABLE CARD
ADD CONSTRAINT fk_card_client
foreign key(CNP)
references client(cnp) on delete cascade;