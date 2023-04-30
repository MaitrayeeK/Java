/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.consumer.controller;

import com.milee.consumer.service.ConsumerService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author Maitrayee
 */
@Controller
@RequestMapping("consumer.fin")
public class ConsumerController {
    @Autowired
    ConsumerService consumerService;
    
    @RequestMapping(params="cmdAction=getProducts")
    public ModelAndView getProducts(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndView = new ModelAndView("index");
        List data = consumerService.getProducts();
        modelAndView.addObject("response", data);
        return modelAndView;
    }
}
