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
    public void shouldCalculateETFWhenBasicSalaryGiven() {
        Double basicSalary = 100000d;
        ETFCalculator etf = new ETFCalculator(basicSalary);
        double etfValue = etf.calculate();
        assertThat(etfValue, is(3000.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -100000d;
        ETFCalculator etf = new ETFCalculator(basicSalary);
        etf.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        ETFCalculator etf = new ETFCalculator(basicSalary);
        etf.calculate();
    }
}
