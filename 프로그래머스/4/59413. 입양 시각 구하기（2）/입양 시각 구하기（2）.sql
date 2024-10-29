with recursive cte as (
    select 
        0 as hour
    union all
    select hour + 1 
    from cte
    where hour < 23
)

select c.hour, count(a.datetime) as count
from cte c
left join animal_outs a
on c.hour = hour(a.datetime)
group by c.hour