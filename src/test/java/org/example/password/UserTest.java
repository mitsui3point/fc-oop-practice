package org.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트 하기 쉬운 코드를 작성하다 보면 더 낮은 결합도를 가진 설계를 얻을 수 있음
 */
class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @RepeatedTest(30)
    void initPassword() {
        //given
        User user = new User();
        //when
        user.initPassword(new CorrectPasswordGenerator());//user.initPassword(() -> "aabbccdd");
        //then
        assertThat(user.getPassword()).isNotNull();
    }

    @DisplayName("패스워드 초기화를 실패한다.")
    @RepeatedTest(30)
    void initPasswordFail() {
        //given
        User user = new User();
        //when
        user.initPassword(new WrongPasswordGenerator());//user.initPassword(() -> "aa");
        //then
        assertThat(user.getPassword()).isNull();
    }
}