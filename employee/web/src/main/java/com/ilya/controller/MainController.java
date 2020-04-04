package com.ilya.controller;

import com.ilya.DataService;
import com.ilya.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAll(){
        dataService.deleteAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee){
        dataService.addEmployee(employee);
    }

    @RequestMapping(value = "/change",method = RequestMethod.PUT)
    public void changeSalary(@RequestBody Employee employee){
        dataService.changeSalary(employee);
    }

    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("test");
    }
}
