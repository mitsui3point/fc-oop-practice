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
                .mapToDouble(o -> o.getCredit() * o.getGradeToNumber())// TODO Refactoring : 학점수 * 교과목 평점
                .sum();

        int totalCredit = this.courses
                .stream()
                .mapToInt(o -> o.getCredit())
                .sum();

        return multiplyCreditAndGradeNumber / totalCredit;
    }
}
