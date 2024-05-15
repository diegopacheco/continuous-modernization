package com.github.diegopacheco.continuous.modernization.payroll.payments;

import com.github.diegopacheco.continuous.modernization.payroll.PayrollProcessor;
import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;

public class OfflinePaymentProcessor implements PayrollProcessor {

    @Override
    public boolean processPayroll(Employee employee) {
        // Here, you would integrate with the real legacy system that do employee payments.
        System.out.println("Processing payment for employee: " + employee.getName());
        return true;
    }

}