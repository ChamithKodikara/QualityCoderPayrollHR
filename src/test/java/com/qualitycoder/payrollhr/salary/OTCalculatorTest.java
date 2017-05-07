package com.qualitycoder.payrollhr.salary;

import com.qualitycoder.payrollhr.constants.SalaryConstants;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Chamith
 */
public class OTCalculatorTest {
    @Test
    public void shouldCalculateRegularOT_WhenHourlyRateAndHoursWorkedGiven() {
        Double basicHourlyRate = 100d;
        Double hoursWorked = 4d;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        double otValue = ot.calculate();
        assertThat(otValue, is(600.0));
    }

    @Test
    public void shouldCalculateDoubleOT_WhenHourlyRateAndHoursWorkedGiven() {
        Double basicHourlyRate = 100d;
        Double hoursWorked = 4d;
        String otType = SalaryConstants.OT_TYPE_DOUBLE;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        double otValue = ot.calculate();
        assertThat(otValue, is(800.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHourlyRateMoreThan_4_RegularOT() {
        Double basicHourlyRate = -100d;
        Double hoursWorked = 5d;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHourlyRateMoreThan_8_DoubleOT() {
        Double basicHourlyRate = -100d;
        Double hoursWorked = 9d;
        String otType = SalaryConstants.OT_TYPE_DOUBLE;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHourlyRateNegative() {
        Double basicHourlyRate = -100d;
        Double hoursWorked = 4d;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHourlyRateNull() {
        Double basicHourlyRate = null;
        Double hoursWorked = 4d;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHoursWorkedNull() {
        Double basicHourlyRate = 100000d;
        Double hoursWorked = null;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenHoursWorkedNegative() {
        Double basicHourlyRate = 100000d;
        Double hoursWorked = -8d;
        String otType = SalaryConstants.OT_TYPE_REGULAR;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOTTypeNotGiven() {
        Double basicHourlyRate = 100000d;
        Double hoursWorked = -8d;
        String otType = null;
        OTCalculator ot = new OTCalculator(basicHourlyRate, hoursWorked, otType);
        ot.calculate();
    }
}
