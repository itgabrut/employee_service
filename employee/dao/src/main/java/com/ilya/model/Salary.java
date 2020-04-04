package com.ilya.model;

import javax.persistence.*;

/**
 * Created by ilya on 04.04.2020.
 */
@Entity
@Table(name = "SALARY")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private Integer value;

    public Integer getId() {
        return id;
    }

    public Integer getValue() {
        return value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
