package com.ilya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



/**
 * Hello world!
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.ilya"})
public class WebApp
{

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

}
