package com.ilya.controller;

import com.ilya.DataService;
import com.ilya.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ilya on 04.04.2020.
 */
@RestController
public class MainController {

    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Employee> getAll(){
        return dataService.getAll();
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.GET)
    public void removeAll(HttpServletResponse httpServletResponse){
        dataService.deleteAll();
        httpServletResponse.setHeader("Location", "http://localhost:3000");
        httpServletResponse.setStatus(302);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Employee addEmployee(@RequestBody Employee employee){
        return dataService.addEmployee(employee);
    }

    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public Employee changeSalary(@RequestBody Employee employee){
        return dataService.changeSalary(employee);
    }

    @RequestMapping(value = "/test")
    public void test(Authentication authentication){
        System.out.println("test");
        System.out.println(authentication.getAuthorities().iterator().next().getAuthority());
    }
}
