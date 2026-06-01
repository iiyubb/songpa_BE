package com.ohgiraffers.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MenuController {

    private final List<MenuDto> menus = new ArrayList<>();

    public MenuController() {
        menus.add(new MenuDto(1, "아메리카노", 3000));
        menus.add(new MenuDto(2, "카페라떼", 4000));
        menus.add(new MenuDto(3, "바닐라라떼", 4500));
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto>> findMenus() throws InterruptedException {

        Thread.sleep(3000);
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/menus/{menuCode}")
    public ResponseEntity<MenuDto> findMenu(
            @PathVariable int menuCode
    ) throws InterruptedException {

        Thread.sleep(2000);
        MenuDto foundMenu = menus.stream()
                .filter(menu -> menu.getMenuCode() == menuCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(menuCode + "번 메뉴가 존재하지 않음!!"));

        return ResponseEntity.ok(foundMenu);
    }

    @PostMapping("/admin/menus")
    public ResponseEntity<Map<String, Object>> registMenu(
            @RequestBody MenuDto menu
    ) {
        menus.add(menu);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "관리자 메뉴 등록 성공");
        response.put("menu", menu);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
