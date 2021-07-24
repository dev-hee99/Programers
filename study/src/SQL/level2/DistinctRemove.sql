-- 중복 제거하기
SELECT count(distinct name)
from ANIMAL_INS
where NAME IS NOT NULL