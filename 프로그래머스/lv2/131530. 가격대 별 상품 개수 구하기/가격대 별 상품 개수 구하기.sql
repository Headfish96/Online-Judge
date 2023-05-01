-- 코드를 입력하세요
SELECT (PRICE - price%10000) as PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from PRODUCT
group by PRICE_GROUP
order by PRICE_GROUP


# SELECT ProductNumber, Category =  
# CASE ProductLine  
# WHEN 'R' THEN 'Road'  
# WHEN 'M' THEN 'Mountain'  
# WHEN 'T' THEN 'Touring'  
# WHEN 'S' THEN 'Other sale items' 
# ELSE 'Not for sale'  
# END, Name  
# FROM Production.Product  
# ORDER BY ProductNumber;