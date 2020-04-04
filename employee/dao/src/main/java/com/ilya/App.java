package com.ilya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Hello world!
 *
 */
@Configuration
@PropertySource(
        value = "classpath:persistence.properties"
)
@ComponentScan(basePackages = {"repo","model"})
//otherwise you should set EntityManagerFactory && DataSource && TransactionManager manually
@EnableAutoConfiguration
public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    private javax.sql.DataSource dataSource;

    @Transactional
    @PostConstruct
    public void givenTomcatConnectionPoolInstance_whenCheckedPoolClassName_thenCorrect() {
        dataSource.getClass().getName()
                .equals("org.apache.tomcat.jdbc.pool.DataSource");
    }
}
