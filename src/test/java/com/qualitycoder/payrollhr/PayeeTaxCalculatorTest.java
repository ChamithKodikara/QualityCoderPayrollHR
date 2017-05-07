package com.qualitycoder.payrollhr;

import com.qualitycoder.payrollhr.constants.SalaryConstants;
import com.qualitycoder.payrollhr.salary.PayeeTaxCalculator;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Chamith
 */
public class PayeeTaxCalculatorTest {

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryLess30() {
        Double basicSalary = 22000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(0.0));
    }

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryBetween30_50() {
        Double basicSalary = 35000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(SalaryConstants.PAYEE_TAX_SALARY_30_50));
    }

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryBetween50_75() {
        Double basicSalary = 55000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(SalaryConstants.PAYEE_TAX_SALARY_50_75));
    }

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryBetween75_100() {
        Double basicSalary = 80000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(SalaryConstants.PAYEE_TAX_SALARY_75_100));
    }

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryBetween100_125() {
        Double basicSalary = 115000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(SalaryConstants.PAYEE_TAX_SALARY_100_125));
    }

    @Test
    public void shouldCalculatePayeeTaxWhenBasicSalaryAbove125() {
        Double basicSalary = 150000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        double payeeTaxValue = payeeTax.calculate();
        assertThat(payeeTaxValue, is(SalaryConstants.PAYEE_TAX_SALARY_125_ABOVE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNegative() {
        Double basicSalary = -100000d;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        payeeTax.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenBasicSalaryNull() {
        Double basicSalary = null;
        PayeeTaxCalculator payeeTax = new PayeeTaxCalculator(basicSalary);
        payeeTax.calculate();
    }
}
