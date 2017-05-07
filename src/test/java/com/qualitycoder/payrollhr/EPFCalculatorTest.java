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
        Double basicSalary = 100000d;
        EPFCalculator epf = new EPFCalculator(basicSalary);
        double epfValue = epf.calculate();
        assertThat(epfValue, is(20000.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -100000d;
        EPFCalculator epf = new EPFCalculator(basicSalary);
        epf.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        EPFCalculator epf = new EPFCalculator(basicSalary);
        epf.calculate();
    }
}
