package com.ilya;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Created by ilya on 04.04.2020.
 */
@org.springframework.boot.test.context.TestConfiguration
@ComponentScan(basePackages = {"com.ilya.controller","com.ilya.security"})
@SpringBootConfiguration
public class TestConfiguration {
}
