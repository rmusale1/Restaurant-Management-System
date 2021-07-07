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
import org.springframework.data.domain.Page;

import java.util.List;

public interface MenuService {
    public List<Object> getAllMenusWithLocationId(int id);
    public void deleteMenu(int id);
    public Menu updateMenu(Menu menu);
    public Page<Menu> getAllMenus(int pageNo, int pageSize, String sortBy);
    //public void createMenuInLocationId(Menu menu);
}
