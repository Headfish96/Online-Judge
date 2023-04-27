-- 코드를 입력하세요
select AI.ANIMAL_ID, AI.NAME
from ANIMAL_INS AI
join ANIMAL_OUTS AO
on AI.ANIMAL_ID = AO.ANIMAL_ID
where AI.DATETIME > AO.DATETIME
order by AI.DATETIME

# A362383	Morado       보호시작일: 2016-04-21 08:19:00 입양일 2016-03-22 17:53:00
# A381217   Cherokee     보호시작일: 2017-07-08 09:41:00 입양일 2017-06-09 18:51:00

# select *
# from ANIMAL_OUTS
# where ANIMAL_ID = 'A381217'