/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.controller;

import com.egen.finalproject.model.ApiTable;
import com.egen.finalproject.service.ApiExecService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ApiExecController {

    private ApiExecService apiExecService;


    public ApiExecController(ApiExecService apiExecService){
        this.apiExecService = apiExecService;
    }



    @RequestMapping(method = RequestMethod.GET,value ="/apis", params = {"name", "date"})
    public ResponseEntity<List<ApiTable>> getAllLocations(
            @RequestParam String name,
            @RequestParam String date
    ){
        //List<Location> entityList =locationService.getAllLocations();

        return ResponseEntity.ok(apiExecService.findApiByNameAndDate(name,date));
    }


    @RequestMapping(method = RequestMethod.GET,value ="/time", params = {"name", "date"})
    public ResponseEntity<List<ApiTable>> getAllApis(
            @RequestParam String name,
            @RequestParam String date
    ){
        //List<Location> entityList =locationService.getAllLocations();

        return ResponseEntity.ok(apiExecService.filterByNameAndDate(name,date));
    }



}

