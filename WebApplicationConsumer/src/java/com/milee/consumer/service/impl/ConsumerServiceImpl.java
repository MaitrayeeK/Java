/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.consumer.service.impl;

import com.milee.consumer.repository.ConsumerRepository;
import com.milee.consumer.service.ConsumerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maitrayee
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    
    @Autowired
    ConsumerRepository consumerRepository;
    
    @Override
    public List getProducts() {
        return consumerRepository.getProducts();
    }

}
