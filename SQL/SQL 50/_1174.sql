# Write your MySQL query statement below
with main as (
    Select *,
(case when order_date = customer_pref_delivery_date  then 'immediate' else 'scheduled' end) as status
from delivery
),
ranks as(
    Select *,
    row_number() over(partition by customer_id order by order_date) as rn
    from main
),
firstorders as (
    Select * from ranks
    where rn = 1
)
Select round((100*(Select count(*) from firstorders where status = 'immediate')/(Select count(*) from firstorders)),2) as immediate_percentage 
    