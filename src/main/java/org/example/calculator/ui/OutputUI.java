package org.example.calculator.ui;

import org.example.calculator.Calculator;
import org.example.calculator.vo.PositiveNumber;

public class OutputUI {

    private Calculator calculator;

    public OutputUI(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printResult(int operand1, String operator, int operand2) {
        int result = calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        System.out.println(result);
    }
}