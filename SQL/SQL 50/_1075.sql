# Write your MySQL query statement below

select p.project_id,round(avg(e.experience_years),2) as average_years 
    from Project as p
        left join Employee e
        on p.employee_id = e.employee_id
            group by p.project_id;

select distinct project_id,ifnull(round(s.sum_/s.count_,2),0) as average_years 
    from Project as p 
        left join (
            select 
                e.employee_id,
                sum(e.experience_years) as sum_,
                count(e.experience_years) as count_

                from Employee as e
                join Project p 
                on e.employee_id = p.project_id
        ) s
        on s.employee_id = p.project_id;
