package org.example.grade;

import org.example.grade.domain.Course;

import java.util.List;

/**
 * 일급 컬렉션(First class collection)
 *
 * {@link Course} 를 여러개 가진 List(Collections) 형태의 정보 1개'만' instance 로 가진 클래스.
 * 필드에 다른 멤버변수가 있으면 안된다.
 */
public class Courses {
    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * multiplyCreditAndCourseGrade
     * totalCredit
     * 를 일급 컬렉션에서 처리함으로서 응집도를 높임
     */
    public double multiplyCreditAndGradeNumber() {
        return this.courses
                .stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int totalCredit() {
        return this.courses
                .stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
