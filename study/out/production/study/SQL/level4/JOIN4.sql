-- 보호소에서 중성화한 동물
SELECT ins.ANIMAL_ID, ins.ANIMAL_TYPE, ins.NAME
FROM ANIMAL_INS ins INNER JOIN ANIMAL_OUTS outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.SEX_UPON_INTAKE NOT LIKE outs.SEX_UPON_OUTCOME
ORDER BY ins.ANIMAL_ID
