package org.example.calculator;

import org.example.calculator.operator.constants.ArithmeticEnumOperator;
import org.example.calculator.vo.PositiveNumber;

public class Calculator {
    public int calculate(PositiveNumber operand1, String operatorStr, PositiveNumber operand2) {
        return ArithmeticEnumOperator.calculate(operand1, operatorStr, operand2);
    }
}
