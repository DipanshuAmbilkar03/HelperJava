select id from (
    select id,temperature, lag(temperature) 
        over (order by id) as prev from weather
) t 
    where temperature > prev;


select today.id from weather yesterday cross join weather today 
    where DATEDIFF(today.recordDate,yesterday.recordDate ) = 1 
    and today.temperature > yesterday.temperature;


select w1.id 
from 
    weather as w1 
    join weather as w2 
    on w1.id = w2.id + 1
    where w1.temperature > w2.temperature;
