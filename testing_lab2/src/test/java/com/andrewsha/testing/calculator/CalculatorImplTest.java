package com.andrewsha.testing.calculator;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorImplTest {
	private final static CalculatorImpl calculator = new CalculatorImpl();

	public static Stream<Arguments> coupleOfDoublesProvider() {
        return Stream.of(Arguments.of(1, 2), Arguments.of(3, 4),
                Arguments.of(-50.1234, 42.0001), Arguments.of(0, 0),
                Arguments.of(0.0000000001, 4));
    }

    @ParameterizedTest
    @MethodSource("coupleOfDoublesProvider")
    public void sumTest(double a, double b) {
        Assertions.assertEquals((double) (a + b), calculator.sum(a, b));
    }

    @ParameterizedTest
    @MethodSource("coupleOfDoublesProvider")
    public void subtractTest(double a, double b) {
        Assertions.assertEquals((double) (a - b), calculator.subtract(a, b));
    }

    @ParameterizedTest
    @MethodSource("coupleOfDoublesProvider")
    public void multiplyTest(double a, double b) {
        Assertions.assertEquals((double) (a * b), calculator.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("coupleOfDoublesProvider")
    public void divideTest(double a, double b) {
        try {
            Assertions.assertEquals((double) (a / b), calculator.divide(a, b));
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof ArithmeticException);
        }
    }

    //

    @Test
    public void divideTest_b_lessThanMinimum_then_throwException() {
        double a = 153.153;
        double b = 0.0000000001;

        boolean isThrown = false;
        try {
            calculator.divide(a, b);
        } catch (Exception e) {
            if (e instanceof ArithmeticException) {
                isThrown = true;
            } ;
        }
        Assertions.assertTrue(isThrown);
    }
}


