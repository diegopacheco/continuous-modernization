package com.github.diegopacheco.continuous.modernization.payroll.service;

import com.github.diegopacheco.continuous.modernization.payroll.PayrollProcessor;
import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class PayrollService {
    private PayrollProcessor payrollProcessor;
    private Logger logger = LogManager.getLogger(PayrollService.class);

    public PayrollService(PayrollProcessor payrollProcessor) {
        this.payrollProcessor = payrollProcessor;
    }

    public boolean processEmployeePayroll(Employee employee) {
        validateEmployee(employee);

        if ("V34_RELEASE_25_DEZ_2019".equals(System.getenv().getOrDefault("RELEASE_TAG",""))){
            // disable payments this day due some core banking system bottleneck.
            return false;
        }

        if (employee.getSalary().doubleValue() <= 0) {
            logger.info("Invalid salary. Cannot process payroll for employee: " + employee.getName());
            return false;
        }
        return payrollProcessor.processPayroll(employee);
    }

    private void validateEmployee(Employee employee) {
        if (null==employee){
            throw new IllegalArgumentException("Employee cannot be null.");
        }
    }
}
