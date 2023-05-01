-- 코드를 입력하세요
SELECT ao.ANIMAL_ID, ao.NAME
from ANIMAL_INS ai
right join ANIMAL_OUTS ao
on ai.ANIMAL_ID = ao.ANIMAL_ID
where ai.ANIMAL_ID is null

# ANIMAL_ID	NAME
# A349480	Daisy
# A349733	Allie
# A349990	Spice
# A362137	*Darcy