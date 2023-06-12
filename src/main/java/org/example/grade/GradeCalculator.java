package org.example.grade;

import org.example.grade.domain.Course;

import java.util.List;

public class GradeCalculator {
    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    public double calculate() {

        double multiplyCreditAndGradeNumber = this.courses
                .stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();

        int totalCredit = this.courses
                .stream()
                .mapToInt(Course::getCredit)
                .sum();

        return multiplyCreditAndGradeNumber / totalCredit;
    }
}
