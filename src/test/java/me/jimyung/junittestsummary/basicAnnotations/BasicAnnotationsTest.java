package me.jimyung.junittestsummary.basicAnnotations;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BasicAnnotationsTest {

    int beforeEachCount = 1;
    int afterEachCount = 1;

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.printf("BeforeEach %d\n", beforeEachCount++);
    }

    @AfterEach
    void afterEach() {
        System.out.printf("AfterEach %d\n", afterEachCount++);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @Test
    void 덧셈_테스트() {
        int a = 1;
        int b = 100;

        assertEquals(101, a + b);
    }

    @Test
    void 뺄셈_테스트() {
        int a = 1;
        int b = 100;

        assertEquals(-99, a - b);
    }

    @Test
    void 곱셈_테스트() {
        int a = 1;
        int b = 100;

        assertEquals(100, a * b);
    }

    @Test
    void 나눗셈_테스트() {
        int a = 1;
        int b = 100;

        assertEquals(0.01, (double) a / b);
    }
}
