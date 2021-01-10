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