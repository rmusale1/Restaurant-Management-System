/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.service;

import com.egen.finalproject.model.Location;
import com.egen.finalproject.model.Menu;
import com.egen.finalproject.repository.LocationRepository;
import com.egen.finalproject.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public List<Object> getAllMenusWithLocationId(int id) {
        return menuRepository.getAllMenusWithLocationId(id);
    }

    @Override
    public void deleteMenu(int id) {
        Optional<Menu> findMenu = menuRepository.findById(id);
        menuRepository.deleteById(id);
    }

    @Override
    public Menu updateMenu(Menu menu) {
        Optional<Menu> existingMenu = menuRepository.findById(menu.getMenuId());
        return menuRepository.save(menu);
    }

    @Override
    public Page<Menu> getAllMenus(int pageNo, int pageSize, String sortBy) {
        return menuRepository.findAll(PageRequest.of( pageNo, pageSize, Sort.by("menuName")));

    }

   /* @Override
    public void createMenuInLocationId(Menu menu) {
        menuRepository.save(menu);
    }*/

}
