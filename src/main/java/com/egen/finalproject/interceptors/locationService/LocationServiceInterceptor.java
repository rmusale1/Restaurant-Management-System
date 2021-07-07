/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.egen.finalproject.interceptors.locationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.egen.finalproject.model.ApiTable;
import com.egen.finalproject.repository.ApiTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LocationServiceInterceptor implements HandlerInterceptor {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    private String apiURl;
    private long executionTime;

    @Autowired
    ApiTableRepository aptRepo;





    @Override
    public boolean preHandle
            (HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        threadLocal.set(System.currentTimeMillis());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        ApiTable apiTable = new ApiTable();

        //System.out.println(request.getRequestURL().);
         apiURl = ((HttpServletRequest)request).getRequestURL().toString().substring(22);
        executionTime =System.currentTimeMillis() - threadLocal.get();
        //System.out.println(executionTime);
        //System.out.println(apiURl);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
         String newDate = formatter.format(date);
        //System.out.println(strDate);
        //ApiTable pp = aptRepo.findByApiUrlContaining(apiURl);
        //System.out.println("************************************"+pp);
       if(aptRepo.findByApiUrlContaining(apiURl)==null) {

           apiTable.setApiUrl(apiURl);
           apiTable.setExecutionTime(executionTime);
           apiTable.setDate(newDate);
           //apiTable.setDate(current);
           aptRepo.save(apiTable);
       }



    }
    @Override
    public void afterCompletion
            (HttpServletRequest request, HttpServletResponse response, Object
                    handler, Exception exception) throws Exception {

        //System.out.println( request.getRequestURL() + "-> request time: " + (System.currentTimeMillis() - threadLocal.get()) );
        //System.out.println(request.getRequestURL());
        //long exectutionTime=System.currentTimeMillis() - threadLocal.get();
        //System.out.println(exectutionTime);
    }
}