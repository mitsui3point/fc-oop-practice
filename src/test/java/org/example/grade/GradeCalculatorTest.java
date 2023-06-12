package org.example.grade;

import org.assertj.core.api.Assertions;
import org.example.grade.domain.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/**
 * 요구사항
 *  평균 학점 계산 방법 = (학점수 * 교과목 평점) 의 합계 / 수강신청 총학점 수
 *  MVC 패턴 기반으로 구현한다
 *  일급 컬렉션 사용
 *
 *  1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 *  2. 객체들 간의 관계를 고민
 *  3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *  4. 협력을 설계
 *  5. 객체들을 포괄하는 타입에 적절한 책임을 할당
 *  6. 구현하기
 *
 *  1. 학점 계산기 도메인: 이수한 과목(객체지향프로그래밍, 자료구조, 중국어회화), 학점 계산기
 *  2. 학점계산기(이수한 과목).학점계산
 *  3. 이수한 과목: 객체지향프로그래밍, 자료구조, 중국어회화 --> 과목(코스) 클래스 로 추상화
 *  4. 이수한 과목을 전달하여 평균학점 계산 요청 -->  학점 계산기 --> (학점수 * 교과목 평점) 의 합계 --> 과목(코스); 3학점짜리인지 2학점짜리인지, 교과목 평가가 A+ 인지 B 인지
 *  이수한 과목을 전달하여 평균학점 계산 요청 -->  학점 계산기 --> 수강신청 총학점 수            --> 과목(코스); 수강신청 총 학점이 6학점인지 12학점인지
 */
public class GradeCalculatorTest {
    @DisplayName("평균 학점 계산을 리턴받는다.")
    @ParameterizedTest
    @MethodSource("coursesSource")
    void calculateGrade(List<Course> courses) {
        //when
        double result = new GradeCalculator(courses).calculate();
        //then
        double expected = ((3 * 4.5) + (2 * 3.0) + (2 * 2.0)) / (3 + 2 + 2);
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("잘못된 학점을 입력할 경우 IllegalArgumentException 을 발생시킨다.")
    @ParameterizedTest
    @MethodSource("incorrectGradeSource")
    void calculateGradeFail(List<Course> incorrectGradeCourses, String errorMessage) {
        //when
        Assertions.assertThatCode(() -> {
                    new GradeCalculator(incorrectGradeCourses).calculate();
                })
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    public static Stream<Arguments> coursesSource() {
        return Stream.of(Arguments.arguments(
                List.of(
                        new Course("OOP", Course.MAJOR_CREDIT, "A+"),//4.5
                        new Course("Data structure", Course.GENERAL_CREDIT, "B"),//3.0
                        new Course("china language", Course.GENERAL_CREDIT, "C")//2.0
                )
        ));
    }

    public static Stream<Arguments> incorrectGradeSource() {
        String incorrectGradeMessage = "정확한 학점을 입력해 주세요.";
        return Stream.of(
                Arguments.arguments(List.of(new Course("OOP", Course.MAJOR_CREDIT, "Z")), incorrectGradeMessage),
                Arguments.arguments(List.of(new Course("OOP", Course.MAJOR_CREDIT, "M")), incorrectGradeMessage),
                Arguments.arguments(List.of(new Course("OOP", Course.MAJOR_CREDIT, "G")), incorrectGradeMessage)
        );
    }
}
