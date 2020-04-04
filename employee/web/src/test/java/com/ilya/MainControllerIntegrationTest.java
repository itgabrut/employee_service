package com.ilya;

import com.ilya.model.Employee;
import com.ilya.model.Salary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by ilya on 04.04.2020.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebApp.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerIntegrationTest {


    @Autowired
    private DataService employeeService;

    @LocalServerPort
    int port;

    @org.junit.Before
    public void add(){
        List<Employee> list = addMockEmployee(10);
        employeeService.addAll(list);
    }


    @Test
    public void getAllTest(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:"+port+"/employee/get";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    private List<Employee> addMockEmployee(int num){
        ArrayList<Employee> res = new ArrayList<Employee>();
        for(int i =0 ; i<num;i++){
            Employee employee = new Employee();
            employee.setName(String.format("Anton%d",i));
            Salary salary = new Salary();
            salary.setValue(1000 + i);
            employee.setSalary(salary);
            res.add(employee);
        }
        return res;

    }
}
