package com.ohgiraffers.springmybatis.menu.controller;

import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDto;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDto;
import com.ohgiraffers.springmybatis.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // 브라우저에서 다른 주소의 api를 호출 허용하는 설정
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menus")
    public ResponseEntity<List<MenuDto>> findMenuList() {
        return ResponseEntity.ok(menuService.findAllMenu());
    }

    @GetMapping("/menus/{menuCode}")
    public ResponseEntity<MenuDto> findMenuByCode(@PathVariable int menuCode) {
        MenuDto menu = menuService.findMenuByCode(menuCode);

        if (menu == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(menu);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> findCategoryList() {
        return ResponseEntity.ok(menuService.findAllCategory());
    }

    @PostMapping("/menus")
    public ResponseEntity<MenuDto> registMenu(@RequestBody MenuDto menu) {
        MenuDto newMenu = menuService.registNewMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
    }

    @PutMapping("/menus/{menuCode}")
    public ResponseEntity<Void> modifyMenu(@PathVariable int menuCode, @RequestBody MenuDto menu) {
        menu.setCode(menuCode); // xml로 넘어가면, #{ code }는 WHERE 절에서 수정 대상을 찾는 값으로 사용
        boolean isModified = menuService.modifyMenu(menu);

        if (!isModified) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/menus/{menuCode}")
    public ResponseEntity<Void> deleteMenu(@PathVariable int menuCode) {
        boolean isDeleted = menuService.deleteMenu(menuCode);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
