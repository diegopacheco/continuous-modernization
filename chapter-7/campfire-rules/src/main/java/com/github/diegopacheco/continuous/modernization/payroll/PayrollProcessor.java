package com.github.diegopacheco.continuous.modernization.payroll;

import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;

public interface PayrollProcessor {
    boolean processPayroll(Employee employee);
}
