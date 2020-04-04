package com.ilya;

import com.ilya.model.Employee;
import com.ilya.model.Salary;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ilya on 04.04.2020.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class EmployeeServiceImplIntegrationTest {


    @Autowired
    private DataService employeeService;


    @Test
    public void addGetTest(){
        List<Employee> list = addMockEmployee(10);

        employeeService.addAll(list);


        Iterable<Employee> fetched = employeeService.getAll();
        List<Employee> employees = new ArrayList<Employee>();
        fetched.forEach(employees::add);
        assertThat(employees.size(),is(10));
        assertEquals("Anton9",employees.get(9).getName());
//        assertArrayEquals(list.toArray(),employees.toArray());
    }

    private List<Employee> addMockEmployee(int num){
        ArrayList<Employee> res = new ArrayList<>();
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

    // write test cases here
}
