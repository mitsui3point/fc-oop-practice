package org.example.ui;

import org.example.calculator.Calculator;
import org.example.calculator.vo.PositiveNumber;
import org.example.grade.GradeCalculator;

public class OutputUI {

    public void printCalculatorResult(int operand1, String operator, int operand2, Calculator calculator) {
        int result = calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
        System.out.println(result);
    }

    public void printGradeCalculatorResult(GradeCalculator gradeCalculator) {
        double result = gradeCalculator.calculate();
        System.out.println(result);
    }
}