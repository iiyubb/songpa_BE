-- Q1
SELECT
    category_code,
    category_name
FROM tbl_category
WHERE ref_category_code IS NOT NULL
ORDER BY category_name DESC ;

-- Q2
SELECT
    menu_name,
    menu_price
FROM tbl_menu
WHERE menu_name LIKE '%밥%'
  AND menu_price BETWEEN 20000 AND 30000;

-- Q3
SELECT * FROM tbl_menu
WHERE (menu_price < 10000) OR (menu_name LIKE '%김치%')
ORDER BY menu_price,
         menu_name DESC ;

-- Q4
SELECT a.*
FROM tbl_menu a
JOIN tbl_category b ON a.category_code = b.category_code
WHERE menu_price = 13000
  AND category_name NOT IN ('기타', '쥬스', '커피')
  AND orderable_status = 'Y';