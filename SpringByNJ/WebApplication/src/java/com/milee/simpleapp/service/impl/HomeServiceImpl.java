/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.simpleapp.service.impl;

import com.milee.simpleapp.service.HomeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maitrayee
 */
@Service
@Qualifier("techs")
public class HomeServiceImpl implements HomeService {

    @Override
    public List getProducts() {
        ArrayList list = new ArrayList();
        list.add("JAVA");
        list.add("Python");
        list.add("JavaScript");
        
        return list;
    }

}
