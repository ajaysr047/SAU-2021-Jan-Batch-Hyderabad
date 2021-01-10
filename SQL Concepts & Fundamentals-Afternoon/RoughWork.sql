					-- Table Creation -- 

create table location (loc_code varchar(5) primary key, loc_name varchar(20)); 
create table category (ctgy_code varchar(5) primary key, ctgy_name varchar(20));
create table salesEx (se_id varchar(10) primary key, se_name varchar(20), se_dob date, se_gender char(1) check (se_gender in ('M', 'F')), se_mobile varchar(10));
create table customer (cus_id varchar(10) primary key, cus_name varchar(20), cus_dob date, cus_gender char(1) check (cus_gender in ('M', 'F')), cus_mobile varchar(10), cus_location varchar(5), foreign key(cus_location) references location(loc_code));
create table product (p_code varchar(5) primary key, p_name varchar(20), unit_price double, p_category varchar(5), foreign key(p_category) references category(ctgy_code));

create table orderT (or_id varchar(10) primary key, cus_id varchar(10), se_id varchar(10), purchase_date date not null, foreign key(cus_id) references customer(cus_id), foreign key(se_id) references salesEx(se_id));
create table order_product(or_id varchar(10), p_code varchar(5), units int not null, primary key(or_id, p_code));

select * from order_product;
					-- Data Insertion -- 
                    
-- Location data -- 

insert into location values("L01", "Chennai");
insert into location values("L02", "Bangalore");
insert into location values("L03", "Hyderabad");
insert into location values("L04", "Kochi");
insert into location values("L05", "Mumbai");

-- Category data -- 

insert into category values("C01", "Home Appliances");
insert into category values("C02", "Cosmetics");
insert into category values("C03", "Dairy");

-- Customer data -- 

insert into customer values("CS01", "Ryan", "1998-01-07", "M", "9821345678", "L01");
insert into customer values("CS02", "Alice", "1997-03-02", "F", "9821545680", "L02");
insert into customer values("CS03", "Tom", "1988-01-07", "M", "9922343658", "L03");
insert into customer values("CS04", "Asher", "2000-01-12", "F", "9821345678", "L04");
insert into customer values("CS05", "Dennis", "1975-01-07", "M", "9821345328", "L05");

insert into customer values("CS06", "John", "1998-01-07", "M", "9821345633", "L01");
insert into customer values("CS07", "Maria", "1997-03-02", "F", "9821541280", "L02");
insert into customer values("CS08", "Sam", "1988-01-07", "M", "9922343638", "L03");
insert into customer values("CS09", "June", "2000-01-12", "F", "9621345678", "L04");
insert into customer values("CS10", "Max", "1975-01-07", "M", "9921345328", "L05");

-- Sales Executive data -- 

insert into salesEx values("SE01", "Alan", "1998-01-07", "M", "9921335670");
insert into salesEx values("SE02", "Bella", "1997-03-02", "F", "9821545635");
insert into salesEx values("SE03", "Issac", "1988-01-07", "M", "9922343659");
insert into salesEx values("SE04", "Taylor", "2001-01-14", "F", "9921345678");
insert into salesEx values("SE05", "Kayce", "1975-05-23", "F", "9821345325");

-- Product data -- 

insert into product values("P01", "Washing Machine", 10000, "C01");
insert into product values("P02", "Chimney", 8000, "C01");
insert into product values("P03", "Skin Lotion", 2000, "C02");
insert into product values("P04", "Hair Dye", 500, "C02");
insert into product values("P05", "Cheese", 200, "C03");
insert into product values("P06", "Yogurt", 150, "C03");

-- Order data -- 

insert into orderT values("OR01", "CS01", "SE01", "2021-01-03");
insert into orderT values("OR02", "CS04", "SE02", "2021-01-03");
insert into orderT values("OR03", "CS05", "SE03", "2021-01-03");

insert into orderT values("OR04", "CS10", "SE04", "2021-01-04");
insert into orderT values("OR05", "CS06", "SE05", "2021-01-04");
insert into orderT values("OR06", "CS02", "SE03", "2021-01-04");

insert into orderT values("OR07", "CS09", "SE01", "2021-01-05");
insert into orderT values("OR08", "CS05", "SE04", "2021-01-05");
insert into orderT values("OR09", "CS02", "SE03", "2021-01-05");

insert into orderT values("OR10", "CS07", "SE01", "2021-01-06");

insert into orderT values("OR11", "CS01", "SE05", "2021-01-07");
insert into orderT values("OR12", "CS05", "SE03", "2021-01-07");

insert into orderT values("OR13", "CS10", "SE05", "2021-01-08");
insert into orderT values("OR14", "CS09", "SE02", "2021-01-08");
insert into orderT values("OR15", "CS08", "SE04", "2021-01-08");

insert into orderT values("OR16", "CS04", "SE01", "2021-01-09");
insert into orderT values("OR17", "CS02", "SE03", "2021-01-09");
insert into orderT values("OR18", "CS06", "SE03", "2021-01-09");

insert into orderT values("OR19", "CS04", "SE01", "2021-01-10");
insert into orderT values("OR20", "CS02", "SE01", "2021-01-10");
insert into orderT values("OR21", "CS09", "SE03", "2021-01-10");

insert into orderT values("OR22", "CS01", "SE03", "2021-01-07");

-- order product data -- 

insert into order_product values("OR01", "P01", 10);
insert into order_product values("OR01", "P06", 20);

insert into order_product values("OR02", "P03", 5);
insert into order_product values("OR02", "P05", 2);

insert into order_product values("OR03", "P02", 23);
insert into order_product values("OR03", "P04", 2);

insert into order_product values("OR04", "P03", 6);
insert into order_product values("OR04", "P06", 13);

insert into order_product values("OR05", "P01", 10);
insert into order_product values("OR05", "P06", 20);

insert into order_product values("OR06", "P03", 10);

insert into order_product values("OR07", "P06", 50);

insert into order_product values("OR08", "P02", 2);

insert into order_product values("OR09", "P01", 1);
insert into order_product values("OR09", "P06", 6);

insert into order_product values("OR10", "P02", 10);
insert into order_product values("OR10", "P05", 20);

insert into order_product values("OR11", "P05", 1);
insert into order_product values("OR11", "P03", 2);

insert into order_product values("OR12", "P02", 10);

insert into order_product values("OR13", "P05", 25);

insert into order_product values("OR14", "P02", 1);

insert into order_product values("OR15", "P05", 40);

insert into order_product values("OR16", "P01", 1);
insert into order_product values("OR16", "P02", 40);

insert into order_product values("OR17", "P02", 1);

insert into order_product values("OR18", "P05", 20);

insert into order_product values("OR19", "P06", 10);

insert into order_product values("OR20", "P03", 2);

insert into order_product values("OR21", "P01", 2);
insert into order_product values("OR21", "P05", 12);
insert into order_product values("OR21", "P06", 20);

insert into order_product values("OR22", "P03", 20);











					-- View Data --
select * from location;
select * from category;
select * from customer;
select * from salesEx;
select * from products;
select * from orderT;
select * from order_product;


											-- Queries -- 
                -- Retrieve the most sold product per day in a specific location (take any location) in last week -- 

select cus_id from customer where cus_location = "L01";

select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id;

select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day;

select * from order_product op inner join (select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day) t on t.or_id = op.or_id;

select t.purchase_date, op.p_code, op.units from order_product op inner join (select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day) t on t.or_id = op.or_id;

select * from product p inner join (select t.purchase_date, op.p_code, op.units from order_product op inner join (select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day) t on t.or_id = op.or_id) t on t.p_code = p.p_code;

select t.purchase_date, p.p_name, t.units from product p inner join (select t.purchase_date, op.p_code, op.units from order_product op inner join (select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day) t on t.or_id = op.or_id) t on t.p_code = p.p_code;


select purchase_date, max(units) from (select t.purchase_date, p.p_name, t.units from product p inner join (select t.purchase_date, op.p_code, op.units from order_product op inner join (select ot.or_id, ot.cus_id, ot.se_id, ot.purchase_date from orderT ot inner join (select cus_id from customer where cus_location = "L01") t on t.cus_id = ot.cus_id and ot.purchase_date > now() - INTERVAL 7 day) t on t.or_id = op.or_id) t on t.p_code = p.p_code) t group by (t.purchase_date);



-- New


select cus_id, loc_code, loc_name from customer inner join location on cus_location = loc_code;

select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code;


select orderT.or_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id;

create view DetailedOrderT as (select orderT.or_id, orderT.cus_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id);

select * from DetailedOrderT;



select cus_id from customer where cus_location = "L01";

select * from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id ;

select * from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week;


select p_code, purchase_date, sum(units) from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

create view tempSum as select p_code, purchase_date, sum(units) units from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

select * from tempSum;

select purchase_date, max(units) from tempSum group by (purchase_date);

select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits;



-- Works -- 
select t.purchase_date, p.p_name, t.maxUnits from product p inner join (select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits) t on p.p_code = t.p_code;


-- Test -- 
drop view tempSum;

select orderT.or_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id;

create view DetailedOrderT as (select orderT.or_id, orderT.cus_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id);

select p_code, purchase_date, sum(units) from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L04") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

create view tempSum as select p_code, purchase_date, sum(units) units from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L04") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

select purchase_date, max(units) from tempSum group by (purchase_date);

select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits;

select t.purchase_date, p.p_name, t.maxUnits from product p inner join (select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits) t on p.p_code = t.p_code;



					-- list all the sales persons details along with the count of products sold by them (if any) till current date -- 

select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id;

select se_id, sum(units) from (select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id) t group by se_id;

select salesEx.se_id, salesEx.se_name, saleDetail.Sold_Units, se_mobile, se_dob, se_gender from salesEx inner join (select se_id, sum(units) Sold_Units from (select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id) t group by se_id) saleDetail on saleDetail.se_id = salesEx.se_id;


