-- 동명 동물 수 찾기
SELECT NAME , count(ANIMAL_ID) COUNT
FROM ANIMAL_INS
group by NAME
having count(NAME) > 1
order by NAME asc