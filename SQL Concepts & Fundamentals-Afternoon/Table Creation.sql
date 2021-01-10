					-- Table Creation -- 

create table location (loc_code varchar(5) primary key, loc_name varchar(20)); 
create table category (ctgy_code varchar(5) primary key, ctgy_name varchar(20));
create table salesEx (se_id varchar(10) primary key, se_name varchar(20), se_dob date, se_gender char(1) check (se_gender in ('M', 'F')), se_mobile varchar(10));
create table customer (cus_id varchar(10) primary key, cus_name varchar(20), cus_dob date, cus_gender char(1) check (cus_gender in ('M', 'F')), cus_mobile varchar(10), cus_location varchar(5), foreign key(cus_location) references location(loc_code));
create table product (p_code varchar(5) primary key, p_name varchar(20), unit_price double, p_category varchar(5), foreign key(p_category) references category(ctgy_code));

create table orderT (or_id varchar(10) primary key, cus_id varchar(10), se_id varchar(10), purchase_date date not null, foreign key(cus_id) references customer(cus_id), foreign key(se_id) references salesEx(se_id));
create table order_product(or_id varchar(10), p_code varchar(5), units int not null, primary key(or_id, p_code));