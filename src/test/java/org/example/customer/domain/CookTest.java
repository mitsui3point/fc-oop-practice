package org.example.customer.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CookTest {
    @DisplayName("요리를 생성한다.")
    @Test
    void create() {
        Assertions.assertThatCode(() -> {
            new Cook("만두", 5000);
        }).doesNotThrowAnyException();
    }
}
