package com.gabriel.empms.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private String position;
    private String email;
    private double salary;
}
