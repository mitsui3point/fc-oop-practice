package org.example.grade;

import org.example.grade.domain.Course;

import java.util.List;

public class GradeCalculator {
    private final Courses courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculate() {

        double multiplyCreditAndGradeNumber = this.courses.multiplyCreditAndGradeNumber();

        int totalCredit = this.courses.totalCredit();

        return multiplyCreditAndGradeNumber / totalCredit;
    }
}
