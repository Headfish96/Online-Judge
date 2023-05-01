-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(p.PRICE * os.SALES_AMOUNT) as SALES
from PRODUCT p
join OFFLINE_SALE os
on p.product_id = os.product_id
group by PRODUCT_CODE
order by sum(p.PRICE * os.SALES_AMOUNT) DESC, PRODUCT_CODE ASC
