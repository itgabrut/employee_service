package com.ilya;

import com.ilya.controller.MainController;
import com.ilya.model.Employee;
import com.ilya.model.Salary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ilya on 04.04.2020.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(MainController.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class UnitWS {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DataService service;

    @Test
    public void getEmployees() throws Exception {

        Employee alex = new Employee();
        alex.setName("Alex");
        Salary salary = new Salary();
        salary.setValue(2000);
        alex.setSalary(salary);

        List<Employee> allEmployees = Arrays.asList(alex);

        given(service.getAll()).willReturn(allEmployees);

        mvc.perform(get("/get")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())))
                .andDo(MockMvcResultHandlers.print());

        System.out.println("Returned");
    }
}
