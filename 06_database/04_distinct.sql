# DISTINCT
-- 중복된 값을 제거하고 유니크한 값들의 목록만 보고 싶을 떄 사용
-- 특정 컬럼에 어떤 값들이 '종류별로' 있는지 확인할 떄 유용

SELECT
    DISTINCT category_code
FROM tbl_menu
ORDER BY category_code;

-- NULL 값을 포함한 열
SELECT DISTINCT
    ref_category_code
FROM tbl_category;

-- 열이 여러 개인 DISTINCT
-- 지정된 모든 열의 조합이 똑같을 떄만 중복으로 간주하여 제거(선택된 모든 컬럼을 하나의 묶음으로 본다)
SELECT DISTINCT
    tbl_menu.category_code,
    tbl_menu.orderable_status
FROM tbl_menu;