# Write your MySQL query statement below
select * from Cinema 
    where 
        (id & 1) = 1 
    AND 
        description != 'boring' 
    ORDER BY rating DESC;