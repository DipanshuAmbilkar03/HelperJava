select 
    c.class
from Courses c
group by class
having count(distinct student) >= 5;