/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.microservice.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author gonzalo
 */
@Configuration
public class Beans {
    
    @Bean
    Gson pretty() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
}
