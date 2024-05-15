package com.github.diegopacheco.continuous.modernization.payroll.payments;

import com.github.diegopacheco.continuous.modernization.payroll.PayrollProcessor;
import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;

public class BankPaymentProcessor implements PayrollProcessor {

    @Override
    public boolean processPayroll(Employee employee) {
        // Here, you would integrate with a real bank transfer system.
        System.out.println("Processing bank transfer for employee: " + employee.getName());
        return true;
    }

}