package org.example.calculator.ui;

import java.util.Scanner;

public class InputUI {
    private final Scanner scanner;

    public InputUI(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getOperation() {
        System.out.println("연산자를 입력하세요.");
        String operator = String.valueOf(scanner.next().charAt(0));
        return operator;
    }

    public int getOperand() {
        System.out.println("숫자를 입력하세요.");
        int operand1 = scanner.nextInt();
        return operand1;
    }
}