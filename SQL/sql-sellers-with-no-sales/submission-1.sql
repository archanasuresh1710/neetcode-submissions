select seller_name from seller 
where seller_id not in (
    select s.seller_id
    from seller s join orders o on s.seller_id = o.seller_id
    where extract(year from o.sale_date) = 2020
    group by s.seller_id 
) order by seller_name