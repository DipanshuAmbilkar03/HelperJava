# Write your MySQL query statement below
select distinct p.product_id, IFNULL(round(s.sumt/s.total,2),0) as average_price 
    from Prices as p
        left join (
            select
                u.product_id,
                SUM(u.units) as total,
                SUM(p.price*u.units) as sumt
            FROM UnitsSold u
            JOIN Prices p
                ON u.product_id = p.product_id
                AND u.purchase_date BETWEEN p.start_date AND p.end_date
                group by u.product_id
        ) s 
    on p.product_id = s.product_id;