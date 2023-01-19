package com.studentapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity extends BaseEntity {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public StudentEntity setAddress(String address) {
        this.address = address;
        return this;
    }
}
