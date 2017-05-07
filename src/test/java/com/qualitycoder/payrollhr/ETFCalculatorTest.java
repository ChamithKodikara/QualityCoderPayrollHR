package com.qualitycoder.payrollhr;

import com.qualitycoder.payrollhr.salary.ETFCalculator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Chamith
 */
public class ETFCalculatorTest {
    @Test
    public void shouldCalculateEPFWhenBasicSalaryGiven() {
        Double basicSalary = 10000d;
        ETFCalculator cal = new ETFCalculator(basicSalary);
        double epf = cal.calculate();
        assertThat(epf, is(300.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -10000d;
        ETFCalculator cal = new ETFCalculator(basicSalary);
        cal.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        ETFCalculator cal = new ETFCalculator(basicSalary);
        cal.calculate();
    }
}
