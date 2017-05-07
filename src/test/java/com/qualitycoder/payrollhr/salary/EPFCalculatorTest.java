package com.qualitycoder.payrollhr.salary;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Chamith
 */
public class EPFCalculatorTest {
    @Test
    public void shouldCalculateEPFWhenBasicSalaryAndEPFContributionGiven() {
        Double basicSalary = 100000d;
        Double epfContribution = 8d;
        EPFCalculator epf = new EPFCalculator(basicSalary, epfContribution);
        double epfValue = epf.calculate();
        assertThat(epfValue, is(20000.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -100000d;
        Double epfContribution = 8d;
        EPFCalculator epf = new EPFCalculator(basicSalary, epfContribution);
        epf.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        Double epfContribution = 8d;
        EPFCalculator epf = new EPFCalculator(basicSalary, epfContribution);
        epf.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEPFContributionNull() {
        Double basicSalary = 100000d;
        Double epfContribution = null;
        EPFCalculator epf = new EPFCalculator(basicSalary, epfContribution);
        epf.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenEPFContributionNegative() {
        Double basicSalary = 100000d;
        Double epfContribution = -8d;
        EPFCalculator epf = new EPFCalculator(basicSalary, epfContribution);
        epf.calculate();
    }
}
