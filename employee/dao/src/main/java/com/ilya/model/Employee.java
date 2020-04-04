package com.ilya.model;

import org.omg.CORBA.portable.IDLEntity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by ilya on 04.04.2020.
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salaryID" , referencedColumnName = "id")
    private Salary salary;


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
