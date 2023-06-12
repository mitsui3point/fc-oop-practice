package org.example.grade;

import org.example.grade.domain.Course;
import org.example.ui.InputUI;
import org.example.ui.OutputUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeCalculatorMain {
    public static void main(String[] args) {
        InputUI input = new InputUI(new Scanner(System.in));
        OutputUI output = new OutputUI();

        int continueFlag = 0;

        List<Course> courses = new ArrayList<>();
        while (continueFlag == 0) {
            String name = input.getCourseName();
            int point = input.getCoursePoint();
            String grade = input.getCourseGrade();
            courses.add(new Course(name, point, grade));

            continueFlag = input.getContinueFlag();
        }
        output.printGradeCalculatorResult(new GradeCalculator(courses));
    }
}
