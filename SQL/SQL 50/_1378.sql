# Write your MySQL query statement below
select eu.unique_Id,e.name from Employees e
    left join EmployeeUNI as eu
        on eu.id = e.id;