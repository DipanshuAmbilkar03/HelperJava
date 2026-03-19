# Write your MySQL query statement below

with cte as (
    SELECT e.id,e.name,e.salary,d.name as D_Name, DENSE_RANK() OVER (PARTITION BY d.id ORDER BY e.salary desc) 
        as des_salary
from Employee e join Department d on d.id=e.departmentId)
SELECT D_Name as Department,name as Employee,
salary as Salary 
FROM cte
where des_salary <=3