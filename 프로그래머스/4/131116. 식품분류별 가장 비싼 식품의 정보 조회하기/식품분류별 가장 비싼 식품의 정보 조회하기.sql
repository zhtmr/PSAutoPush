-- 코드를 입력하세요


SELECT
category,
price,
product_name
from food_product
where price in  (select max(price) from food_product group by category)
and category in ('과자', '국', '김치', '식용유')
order by price desc
;


# SELECT CATEGORY,max(PRICE) as price, PRODUCT_NAME
# from FOOD_PRODUCT
# where CATEGORY In ('과자', '국', '김치','식용유')
# group by CATEGORY
# order by price desc
