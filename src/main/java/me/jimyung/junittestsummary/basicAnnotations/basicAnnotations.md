# Junit5의 기본 애노테이션

기본적으로 JUnit은 아래와 같은 애노테이션을 지원합니다.

1. @Test
    - 테스트 메서드임을 표시하는 애노테이션입니다.

2. @BeforeAll
    - 클래스 내의 모든 테스트가 실행되기 전에 한번 해당 애노테이션이 붙은 메서드가 실행되게 만드는 애노테이션입니다.

3. @BeforeEach
    - 클래스 내의 모든 테스트가 실행되기 전에 테스트의 갯수만큼 해당 애노테이션이 붙은 메서드가 실행되게 만드는 애노테이션입니다.

4. @AfterAll
    - 클래스 내의 모든 테스트가 실행된 후에 한번 해당 애노테이션이 붙은 메서드가 실행되게 만드는 애노테이션입니다.

5. @AfterEach
    - 클래스 내의 모든 테스트가 실행된 후에 테스트의 갯수만큼 해당 애노테이션이 붙은 메서드가 실행되게 만드는 애노테이션입니다.

6. @Disabled
    - 해당 애노테이션이 붙은 메서드는 테스트시 실행되지 않습니다.

## JUnit5의 각 애노테이션에 대응하는 JUnit4의 애노테이션

JUnit4 사용자는 JUnit5에서도 동일한 기능의 테스트 관련 애노테이션을 사용할 수 있습니다.

아래는 JUnit5의 각 애노테이션에 대응하는 JUnit4의 애노테이션 표입니다.

| JUnit5      | JUnit4       |
|-------------|--------------|
| @Test       | @Test        |
| @BeforeAll  | @BeforeClass |
| @BeforeEach | @Before      |
| @AfterAll   | @AfterClass  |
| @AfterEach  | @After       |
| @Disabled   | @Ignored     |

## 테스트 코드

덧셈, 뺄셈, 곱셈, 나눗셈 연산을 수행하는 테스트가 있다고 가정해봅시다.

메서드는 총 네 가지이며, @BeforeAll, @AfterAll은 각각 한번 @BeforeEach, @AfterEach는 각 네번 실행되어야 정상입니다.

코드와 실행 결과는 아래와 같습니다.

### 코드

src/test/java/me/jimyung/junittestsummary/basicAnnotations/BasicAnnotationsTest.java
```java
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
```

### 실행 결과
![image](https://user-images.githubusercontent.com/30682847/208291375-385291ed-26a6-479b-b32d-48e674c59c80.png)
