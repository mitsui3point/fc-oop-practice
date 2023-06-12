package org.example.grade;

import org.assertj.core.api.Assertions;
import org.example.grade.domain.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseTest {
    @DisplayName("과목을 생성한다.")
    @Test
    void create() {
        Assertions.assertThatCode(() -> new Course("OOP", 3, "A+"))
                .doesNotThrowAnyException();
    }
}
