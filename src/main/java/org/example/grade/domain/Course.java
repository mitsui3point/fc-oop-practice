package org.example.grade.domain;

public class Course {
    public static final int MAJOR_CREDIT = 3;
    public static final int GENERAL_CREDIT = 2;
    private final String subject;
    private final int credit;
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {
        switch (this.grade) {
            case "A+": return 4.5;
            case "A": return 4.0;
            case "B+": return 3.5;
            case "B": return 3.0;
            case "C+": return 2.5;
            case "C": return 2.0;
            case "D+": return 1.5;
            case "D": return 1.0;
            case "F": return 0.0;
            default:
                throw new IllegalArgumentException("정확한 학점을 입력해 주세요.");
        }
    }

    /**
     * getter 를 이용하여 호출하는 client object 에서 계산하는것이 아니라,
     * client object 에서 course object 로 메세지를 전달함으로서 작업계산을 위임함
     *
     * 이렇게 리팩토링으로 설계를 변경함으로서,
     * 기존에 client object 마다 변경해야 했던 코드와 달리
     * 변경포인트가 한곳으로 좁혀지기 때문에 응집도가 높아졌다고 할 수 있다.
     *
     * 항상 염두에 두어야 할 것이,
     * getter 를 client object 에 가져와서 처리하는 방식이 아니라,
     * 해당 정보를 가진 객체(course object) 에게 메세지를 던져서 작업을 처리해주도록 한다면 변화에 유연한 코드를 만들 수 있다.
     */
    public double multiplyCreditAndCourseGrade() {
        return this.credit * getGradeToNumber();
    }
}
