package com.microservice.beans;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "credentials")
public class Credentials {
    private String username;
    private String password;
    private String signature;
}
