/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.repository;

import com.egen.finalproject.model.Menu;
import com.egen.finalproject.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    @Query(value ="Select m.menu_id,m.menu_name,l.location_location_id From menu m " +
            "inner join location_menu_items l on m.menu_id=l.menu_items_menu_id " +
            "where l.location_location_id=:id",nativeQuery = true)
    public List<Object> getAllMenusWithLocationId(int id);

    @Modifying
    @Query(value ="Delete From location_menu_items where menu_items_menu_id= :id "
            ,nativeQuery = true)
    public void deleteFromChildTable(int id);

    //public void createMenuInLocationId(Menu menu);


}
