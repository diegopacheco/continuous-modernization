package com.github.diegopacheco.continuous.modernization.payroll.model;

import java.util.Objects;

public class Customer {

    private String name;
    private String email;
    private String dob;

    public Customer() {}

    public Customer(String name, String email, String dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(dob, customer.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, dob);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
