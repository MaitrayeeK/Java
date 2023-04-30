/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.simpleapp.api;

import com.milee.simpleapp.service.HomeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Maitrayee
 */

@RestController
@RequestMapping(value="product.fin")
public class ProductController {
    @Autowired
    @Qualifier("techs")
    HomeService homeService;
    
    @RequestMapping(produces="application/json",method=RequestMethod.GET, params="cmdAction=getProducts")
    public ResponseEntity<List> getProducts(){
        List data = homeService.getProducts();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
