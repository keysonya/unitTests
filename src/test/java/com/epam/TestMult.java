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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Iana_Kasimova on 12/12/2017.
 */
@RunWith(value = Parameterized.class)
public class TestMult{

    Calculator calculator;

    @Parameter(value = 0)
    public String a;

    @Parameter(value = 1)
    public String b;

    @Parameter(value = 2)
    public double c;

    @Parameter(value = 3)
    public double d;

    @Parameter(value = 4)
    public long e;

    @Parameter(value = 5)
    public long f;

    @Parameter(value = 6)
    public long result;

    @Parameters(name = "test({0}*{1}={6})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"3", "2", 3, 2, 3, 2, 6},
                {"3", "-2", 3, -2, 3, -2, -6},
                {"-3", "-2", -3, -2, -3, -2, 6},
                {"10", "5.5", 10, 5.5, 11, 5, 55},
                {"0", "0", 0, 0, 0, 0, 0},
        });
    }

    @Before
    public void beforeTest(){
        calculator = new Calculator();
    }

    @Test
    public void testMultString(){
        assertThat(calculator.mult(Double.parseDouble(a), Double.parseDouble(b)), is((double)result));
    }


    @Test
    public void testMultDouble() {
        assertThat(calculator.mult(c, d), is((double) result));
    }

    @Test
    public void testMultLong(){
        assertThat(calculator.mult(e, f), is(result));
    }

    @Test
    public void testMultDoubleWithPoint(){
        assertThat(calculator.mult(-2.5, 7.5), is(-18.75));
    }

    @AfterClass
    public static void afterTests(){
        System.out.println("tests are finished!");
    }
}
