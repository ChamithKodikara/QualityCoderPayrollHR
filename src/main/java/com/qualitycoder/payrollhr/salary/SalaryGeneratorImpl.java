package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.App;
import com.qualitycoder.payrollhr.constants.SalaryConstants;
import com.qualitycoder.payrollhr.model.OTDetail;
import org.apache.log4j.Logger;

/**
 * @author Chamith
 */
public class SalaryGeneratorImpl implements SalaryGenerator {
    private final static Logger LOGGER = Logger.getLogger(App.class);

    @Override
    public double generate(double basicSalary, double epfContribution, OTDetail otDetail) {
        double totalSalary = 0;

        Calculator epfCalculator = new EPFCalculator(basicSalary, epfContribution);
        Calculator etfCalculator = new ETFCalculator(basicSalary);
        Calculator payeeTaxCalculator = new PayeeTaxCalculator(basicSalary);
        Calculator regularOTCalculator = new OTCalculator(otDetail.getBasicHourlyRate(), otDetail.getRegularOTHours(), SalaryConstants.OT_TYPE_REGULAR);
        Calculator doubleOTCalculator = new OTCalculator(otDetail.getBasicHourlyRate(), otDetail.getDoubleOTHours(), SalaryConstants.OT_TYPE_DOUBLE);

        try {
            double epf = epfCalculator.calculate();
            double etf = etfCalculator.calculate();
            double payeeTax = payeeTaxCalculator.calculate();
            double regularOT = regularOTCalculator.calculate();
            double doubleOT = doubleOTCalculator.calculate();
            double epfDeductFromSalary = 0.0;
            epfDeductFromSalary = basicSalary / 100 * epfContribution;
            totalSalary = (basicSalary + regularOT + doubleOT) - (epfDeductFromSalary + payeeTax);
        } catch (IllegalArgumentException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }

        return totalSalary;
    }
}
