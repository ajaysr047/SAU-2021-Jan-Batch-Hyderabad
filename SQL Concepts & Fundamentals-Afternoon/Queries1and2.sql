											-- Queries -- 
                -- 1. Retrieve the most sold product per day in a specific location (take any location) in last week -- 

                
-- Query to get product name along with order details
select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code;

-- Query to get neccessary data from complete order for further processing
select orderT.or_id, orderT.se_id, orderT.cus_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id;

-- Creating view for the detailed order for easier access
create view DetailedOrderT as (select orderT.or_id, orderT.cus_id, orderProDetail.p_code, orderProDetail.p_name, orderProDetail.units, orderT.purchase_date from orderT inner join (select or_id, op.p_code, p_name, units from order_product op inner join product p on p.p_code = op.p_code) orderProDetail on orderProDetail.or_id = orderT.or_id);

-- View or drop view
select * from DetailedOrderT;
drop view DetailedOrderT;

-- Filtering out data based on location and date along with sum of units 
select p_code, purchase_date, sum(units) from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

-- Creating view with the filtered data for ease of access 
-- (In case of location change the view "tempSum" have to be dropped and re created with the new location code)
create view tempSum as select p_code, purchase_date, sum(units) units from DetailedOrderT dot inner join (select cus_id from customer where cus_location = "L01") ct on ct.cus_id = dot.cus_id and dot.purchase_date > now() - interval 1 week group by p_code, purchase_date ;

-- view or drop view 
select * from tempSum;
drop view tempSum;

-- Query to find max units from sum of units in the view grouped by the purchase date(Already filtered for 7 days in view)
select purchase_date, max(units) from tempSum group by (purchase_date);

-- Query to find p_code based on purchase date , max units and sum units
select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits;

-- Final query to give expected result (most sold product per day in a specific location (take any location) in last week)
select t.purchase_date, p.p_name, t.maxUnits from product p inner join (select tempSum.purchase_date, tempSum.p_code, t.maxUnits from tempSum inner join (select purchase_date, max(units) maxUnits from tempSum group by (purchase_date)) t on t.purchase_date = tempSum.purchase_Date and tempSum.units = t.maxUnits) t on p.p_code = t.p_code;





					-- 2 list all the sales persons details along with the count of products sold by them (if any) till current date -- 

-- Query to get product code and se_id (Sales Executive id)
select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id;

-- Query to get sum of all items sold by each sales executive
select se_id, sum(units) from (select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id) t group by se_id;

-- Final query to give expected result (all the sales persons details along with the count of products sold by them (if any) till current date)
select salesEx.se_id, salesEx.se_name, saleDetail.Sold_Units, se_mobile, se_dob, se_gender from salesEx inner join (select se_id, sum(units) Sold_Units from (select se_id, p_code, units from orderT inner join order_product on orderT.or_id = order_product.or_id) t group by se_id) saleDetail on saleDetail.se_id = salesEx.se_id;

