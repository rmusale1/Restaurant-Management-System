/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.service;

import com.egen.finalproject.model.ApiTable;
import com.egen.finalproject.repository.ApiTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiExecServiceImpl implements ApiExecService {

    @Autowired
    ApiTableRepository apiTableRepository;


    @Override
    public List<ApiTable> findApiByNameAndDate(String name, String date) {
        return (apiTableRepository.findByNameAndDate(name,date));
    }

    @Override
    public List<ApiTable> filterByNameAndDate(String name, String date) {
        return apiTableRepository.findByApiUrlAndAndDate(name,date);
    }
}
