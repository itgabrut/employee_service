package com.ilya;

import com.ilya.model.Employee;
import com.ilya.repo.CRUDRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by ilya on 04.04.2020.
 */
@Service
public class DataService {


    @Autowired
    private CRUDRepo repo;

    public Iterable<Employee> getAll(){
        Iterable<Employee> employees = repo.findAll();
        return employees;
    }

    @Transactional
    public void deleteAll(){
        repo.deleteAll();
    }

    @Transactional
    public void changeSalary(Employee employee){
        Optional<Employee> update = repo.findById(employee.getId());
        update.get().setSalary(employee.getSalary());
    }

    public void addEmployee(Employee employee){
        repo.save(employee);
    }
    @Transactional
    public void addAll(Collection<Employee> employees){
            repo.saveAll(employees);
    }
}
