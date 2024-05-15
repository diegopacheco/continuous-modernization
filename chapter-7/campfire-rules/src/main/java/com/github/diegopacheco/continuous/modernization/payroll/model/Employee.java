package com.github.diegopacheco.continuous.modernization.payroll.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private String id;
    private String name;
    private BigDecimal salary;

    public Employee(){}

    public Employee(String id, String name, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public BigDecimal getSalary() {
        return salary;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }
}
