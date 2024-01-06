package com.mcommande.commandewebapp.repository;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


public class CustomProperties {
    private String apiUrl ;

    public String getApiUrl() {
        return "http://localhost:9201";
    }
}