package com.egen.finalproject.controller;

import com.egen.finalproject.model.Menu;
import com.egen.finalproject.repository.ApiTableRepository;
import com.egen.finalproject.repository.MenuRepository;
import com.egen.finalproject.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MenuController {
    private MenuService menuService;


    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @Autowired
    private ApiTableRepository apiRepo;

    @Autowired
    private MenuRepository menuRepository;


    @RequestMapping(method = RequestMethod.GET, value = "location/menus/{id}")
    public ResponseEntity<List<Object>> getAllMenusWithLocationId(@PathVariable("id") int id) {
        List<Object> menuList = menuService.getAllMenusWithLocationId(id);

        return ResponseEntity.ok(menuList);
    }


    @RequestMapping(method = RequestMethod.GET,name= "trial", value = "/menus",params = {"pageNumber", "pageSize", "sortBy"})
    public ResponseEntity<Page<Menu>> getAllMenus(
            @RequestParam(defaultValue ="0") int pageNo,
            @RequestParam(defaultValue="3") int pageSize,
            @RequestParam(defaultValue="menuName") String sortBy
    ) {
        Page<Menu> menuList = menuService.getAllMenus(pageNo,pageSize,sortBy);

        return ResponseEntity.ok(menuList);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "/menus/{id}")
    public void deleteMenu(@PathVariable("id") int id) {
        menuRepository.deleteFromChildTable(id);
        menuService.deleteMenu(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/menu")
    public Menu updateMenu(@RequestBody Menu menu)
    {
        return(menuService.updateMenu(menu));
    }

   /* @RequestMapping(method = RequestMethod.POST,value = "/menu")
    public void createMenuInLocationId(@RequestBody Menu menu)
    {
        menuService.createMenuInLocationId(menu);
    }*/

}





