package com.github.diegopacheco.continuous.modernization.payroll.payments;

import com.github.diegopacheco.continuous.modernization.payroll.PayrollProcessor;
import com.github.diegopacheco.continuous.modernization.payroll.model.Employee;
import com.github.diegopacheco.continuous.modernization.payroll.service.PayrollService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;

public class OfflinePaymentProcessorToBeDeleted implements PayrollProcessor {

    private Logger logger = LogManager.getLogger(OfflinePaymentProcessorToBeDeleted.class);

    @Override
    public boolean processPayroll(Employee employee) {
        logger.log(Level.INFO,
                "OfflinePaymentProcessor.processPayroll" +
                        " will be deleted! Please stop calling it!" +
                        " Context: env: " + System.getProperty("DEPLOY_ENV").toString() +
                        " timestamp: " + Instant.now());
        return true;
    }

}
