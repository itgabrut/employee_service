package com.ilya;

import com.ilya.model.Employee;
import com.ilya.model.Salary;
import com.ilya.repo.CRUDRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by ilya on 04.04.2020.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DaoTest {

    @Autowired
    private CRUDRepo repo;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void getAllTest(){

        repo.deleteAll();
        for(int i =0 ; i<3;i++){
            Employee employee = new Employee();
            employee.setName(String.format("Anton%d",i));
            Salary salary = new Salary();
            salary.setValue(1000 + i);
            employee.setSalary(salary);
            salary.setEmployee(employee);
            entityManager.persist(employee);
        }

        Iterable<Employee> employees = repo.findAll();
        assertThat(employees.iterator().next().getName(),is("Anton0"));
    }
}
