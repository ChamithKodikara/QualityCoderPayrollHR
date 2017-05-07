package com.qualitycoder.payrollhr;

import com.qualitycoder.payrollhr.salary.EPFCalculator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Chamith
 */
public class EPFCalculatorTest {
    @Test
    public void shouldCalculateEPFWhenBasicSalaryGiven() {
        Double basicSalary = 10000d;
        EPFCalculator cal = new EPFCalculator(basicSalary);
        double epf = cal.calculate();
        assertThat(epf, is(2000.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -10000d;
        EPFCalculator cal = new EPFCalculator(basicSalary);
        cal.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        EPFCalculator cal = new EPFCalculator(basicSalary);
        cal.calculate();
    }
}
