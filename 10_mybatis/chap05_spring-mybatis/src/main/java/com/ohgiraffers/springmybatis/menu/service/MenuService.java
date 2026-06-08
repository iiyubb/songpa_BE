package com.ohgiraffers.springmybatis.menu.service;

import com.ohgiraffers.springmybatis.menu.model.dao.MenuMapper;
import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDto;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDto;
import org.springframework.stereotype.Service;

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
}
