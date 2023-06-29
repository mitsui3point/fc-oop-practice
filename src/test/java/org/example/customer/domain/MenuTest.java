package org.example.customer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * 메뉴판
 */
public class MenuTest {
    @DisplayName("메뉴판에서 메뉴 이름에 해당하는 메뉴를 반환한다.")
    @Test
    void choose() {
        //given
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        //when
        MenuItem chooseMenuItem = menu.choose("돈까스");

        //then
        assertThat(new MenuItem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴이름을 선택할 시 예외를 반환한다.")
    @Test
    void chooseException() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        //when
        assertThatCode(() -> {
            MenuItem chooseMenuItem = menu.choose("돈부리");
        })
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
