package com.github.diegopacheco.continuous.modernization.payroll.payments;

import com.github.diegopacheco.continuous.modernization.payroll.PayrollProcessor;
import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;
import com.github.diegopacheco.continuous.modernization.payroll.service.PayrollService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayrollServiceRefactored {
    private PayrollProcessor payrollProcessor;
    private Logger logger = LogManager.getLogger(PayrollService.class);

    public PayrollServiceRefactored(PayrollProcessor payrollProcessor) {
        this.payrollProcessor = payrollProcessor;
    }

    public boolean processEmployeePayroll(Employee employee) {
        if (!validateEmployee(employee)) return false;
        return payrollProcessor.processPayroll(employee);
    }

    private boolean validateEmployee(Employee employee) {
        if (null==employee){
            throw new IllegalArgumentException(
                    "Employee cannot be null.");
        }
        if (employee.getSalary().doubleValue() <= 0) {
            logger.info("Invalid salary. Cannot process " +
                    "payroll for employee: " + employee.getName());
            return false;
        }
        return true;
    }
}