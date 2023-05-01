-- 코드를 입력하세요
SELECT date_format(DATETIME,'%H') as HOUR, COUNT(ANIMAL_ID) as COUNT
from ANIMAL_OUTS
group by HOUR
having hour > 8 and hour < 20
order by HOUR
