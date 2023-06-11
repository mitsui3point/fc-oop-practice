package org.example.calculator;

public class Calculator {
    public int calculate(int operand1, String operator, int operand2) {
        validate(operand1, operator, operand2);
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("연산할 수 없는 수식입니다.");
        }
    }

    private void validate(int operand1, String operator, int operand2) {
        if (isOperandNegativeOrZero(operand1, operand2)) {
            throw new IllegalArgumentException("0이나 음수는 연산할 수 없습니다.");
        }
        if (isOperatorNull(operator)) {
            throw new IllegalArgumentException("연산할 수 없는 수식입니다.");
        }
    }

    private boolean isOperatorNull(String operator) {
        return operator == null;
    }

    private boolean isOperandNegativeOrZero(int operand1, int operand2) {
        return operand1 <= 0 || operand2 <= 0;
    }
}
