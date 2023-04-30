/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.simpleapp.service.impl;

import com.milee.simpleapp.service.HomeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maitrayee
 */
@Service
// @Primary // When we need to call this bean to be inject (One interface and multiple beans)
@Qualifier("otech") // A qualifier for this bean (can be used where we want to inject this bean) (inject this bean with this qualifier)
public class HomeServiceImpl2 implements HomeService {

    @Override
    public List getProducts() {
        ArrayList list = new ArrayList();
        list.add("Artificial Intelligence");
        list.add("Machine Learning");
        
        return list;
    }
    
    

}
