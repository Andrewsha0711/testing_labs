package com.andrewsha.testing.calculator;

public class CalculatorImpl implements Calculator {

    public double sum(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (Math.abs(b) < 10 * Math.pow(10, -8)) {
            throw new ArithmeticException("second number must be greater than 10e-8");
        }
        return a / b;
    }
}
