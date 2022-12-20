package me.jimyung.junittestsummary.conditionalTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class ConditionalTest {

    private final String ENV = "dev";

    @Test
    @DisplayName("참이면 다음 로직 실행, 거짓이면 테스트 중단")
    void assume_true_test() {
        // assumeTrue(조건)
        assumeTrue("dev".equals(ENV));

        System.out.println("테스트 환경입니다.");
    }

    @Test
    @DisplayName("참이면 람다 함수 실행 거짓이면 람다 함수 실행 x")
    void assuming_that_test() {
        // assumingThat(조건, 테스트)
        assumingThat("test".equals(ENV), () -> {
            System.out.println("테스트 환경입니다.");
        });
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName("EnabledOnOs의 밸류(들)에만 해당하는 OS에서 테스트 실행")
    void enabled_on_os_test() {
        System.out.println("윈도우 OS입니다.");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11, JRE.JAVA_17})
    @DisplayName("EnabledOnJre의 밸류(들)에만 해당하는 JRE에서 테스트 실행")
    void enabled_on_jre_test() {
        System.out.println("테스트가 실행 가능한 자바 버전입니다.");
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = "amd64")
    void enabled_if_systemProperty_test() {
        assertEquals("amd64", System.getProperty("os.arch"));
    }
}
