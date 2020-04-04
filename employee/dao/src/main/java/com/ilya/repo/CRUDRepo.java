package com.ilya.repo;

import com.ilya.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ilya on 04.04.2020.
 */
public interface CRUDRepo extends CrudRepository<Employee, Integer> {

    public List<Employee> findByName(String name);

}
