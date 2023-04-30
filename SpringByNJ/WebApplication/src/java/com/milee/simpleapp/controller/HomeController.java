/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.simpleapp.controller;

import com.milee.simpleapp.service.HomeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maitrayee
 */
@Controller
@RequestMapping("home.fin")
public class HomeController {
    // Dependency Injection
    // Spring will find the class that was implemented this interface and create the object of that class
    // And method of that class will be called with this object
    
    // Annotations - Instructions(metadata) to the framework
    @Autowired
    @Qualifier("techs")
    HomeService homeService; 
    
    // home.fin?cmdAction=loadHomePage
    @RequestMapping(params = "cmdAction=loadHomePage")
    public ModelAndView getHomePage(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndview = new ModelAndView("home");
        modelAndview.addObject("data", homeService.getProducts());
        modelAndview.addObject("process", "homePage");
        return modelAndview;
    }
    
    @RequestMapping(params = "cmdAction=loadHome")
    public ModelAndView loadHome(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("process", "home");
        return modelAndview;
    }
    
    @RequestMapping(params = "cmdAction=loadNoBrainer")
    public ModelAndView loadNoBrainer(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("process", "brainer");
        return modelAndview;
    }
    
    @RequestMapping(params = "cmdAction=loadOnlyBrainy")
    public ModelAndView loadOnlyBrainy(HttpServletRequest req, HttpServletResponse res) {
        ModelAndView modelAndview = new ModelAndView("index");
        modelAndview.addObject("process", "brainy");
        return modelAndview;
    }
    
    @RequestMapping(produces="application/json",method=RequestMethod.GET, params="cmdAction=getProducts")
    public @ResponseBody List getProducts(){
        return homeService.getProducts();
    }
}
