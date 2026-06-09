package com.ohgiraffers.springmybatis.menu.service;

import com.ohgiraffers.springmybatis.menu.model.dao.MenuMapper;
import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDto;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDto> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public MenuDto findMenuByCode(int menuCode) {
        return menuMapper.findMenuByCode(menuCode);
    }

    public List<CategoryDto> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public MenuDto registNewMenu(MenuDto menu) {
        menuMapper.registMenu(menu);
        return menu;
    }

     @Transactional
    public boolean modifyMenu(MenuDto menu) {
        return menuMapper.modifyMenu(menu) > 0;
    }

    @Transactional
    public boolean deleteMenu(int menuCode) {
        return menuMapper.deleteMenu(menuCode) > 0;
    }
}
