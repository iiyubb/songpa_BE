package com.ohgiraffers.springmybatis.menu.model.dao;

import com.ohgiraffers.springmybatis.menu.model.dto.CategoryDto;
import com.ohgiraffers.springmybatis.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDto> findAllMenu();

    MenuDto findMenuByCode(@Param("menuCode") int menuCode);

    List<CategoryDto> findAllCategory();

    int registMenu(MenuDto menu);

    int modifyMenu(MenuDto menu);

    int deleteMenu(@Param("menuCode") int menuCode);
}
