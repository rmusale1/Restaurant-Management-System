/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.repository;

import com.egen.finalproject.model.ApiTable;
import com.egen.finalproject.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiTableRepository extends JpaRepository<ApiTable,Integer> {
    @Query("select u from ApiTable u where ( u.apiUrl = :name)"
            +" and (u.date = :date)")
    List<ApiTable> findByNameAndDate(@Param("name") String urlName,@Param("date")String date);

    public List<ApiTable> findByApiUrlContaining(String apiUrl);
   // Page<ApiTable> findAll(Pageable pageable);
    List<ApiTable> findByApiUrlAndAndDate(String apiUrl,String date);

}