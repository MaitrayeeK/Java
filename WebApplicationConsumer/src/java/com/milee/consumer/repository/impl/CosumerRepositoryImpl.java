/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.milee.consumer.repository.impl;

import com.milee.consumer.repository.ConsumerRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Maitrayee
 */
@Repository
public class CosumerRepositoryImpl implements ConsumerRepository{

    RestTemplate restTemplate = new RestTemplate();
    
    @Override
    public List getProducts() {
        String url = "http://localhost:8080/WebApplication/product.fin";
        HttpHeaders headers = new HttpHeaders();
        headers.add("signature", UUID.randomUUID().toString());
        HttpEntity entity = new HttpEntity(headers);
        
        //uri variables
        Map <String, String> uriVariables = new HashMap<>();
        uriVariables.put("cmdAction", "getProducts");
        ResponseEntity <List> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class, uriVariables);
        return response.getBody();
    }

}
