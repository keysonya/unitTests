package com.epam;

import com.epam.tat.module4.Calculator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Double.NaN;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Iana_Kasimova on 12/12/2017.
 */
@RunWith(value = Parameterized.class)
public class TestCtg {

    Calculator calculator;

    @Parameter(value = 0)
    public String a;

    @Parameter(value = 1)
    public double b;

    @Parameter(value = 2)
    public double result;

    @Parameters(name = "test(ctg{0}={2})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"90", 90, 0},
                {"45", 45, 1},
                {"0", 0, NaN}

        });
    }

    @Before
    public void beforeTest(){
        calculator = new Calculator();
    }

    @Test
    public void testCtgString(){
        System.out.println(Double.parseDouble(a));
        assertThat(calculator.ctg(Math.toRadians(Double.parseDouble(a))), is(result));
    }


    @Test
    public void testCtgDouble() {
        assertThat(calculator.ctg(Math.toRadians(b)), is(result));
    }

    @AfterClass
    public static void afterTests(){
        System.out.println("tests are finished!");
    }
}
