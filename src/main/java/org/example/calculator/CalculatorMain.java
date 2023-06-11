package org.example.calculator;

import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int operand1 = sc.nextInt();

        System.out.println("연산자를 입력하세요.");
        String operator = String.valueOf(sc.next().charAt(0));

        System.out.println("숫자를 입력하세요.");
        int operand2 = sc.nextInt();

        int result = new Calculator().calculate(operand1, operator, operand2);
        System.out.println(result);
    }
}
