-- 우유와 요거트가 담긴 장바구니
SELECT m.CART_ID
FROM CART_PRODUCTS m,CART_PRODUCTS y
WHERE m.CART_ID=y.CART_ID and m.NAME='Milk' and y.NAME='Yogurt'
GROUP BY m.CART_ID
ORDER BY m.CART_ID
