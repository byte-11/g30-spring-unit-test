package uz.byte11.springbootunittest.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(value = DisplayNameGenerator.Standard.class)
@DisplayName("Calculator")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
//        System.out.println("setUp()");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
//        System.out.println("tearDown()");
        calculator = null;
    }

    @Test
    @DisplayName("Calculator sum test")
//    @Order(3)
    void testSum() {
//        System.out.println("testSum()");
//        int sum = calculator.sum(2, 3);
//        if (sum == 5) {
//            System.out.println("test passed");
//        } else {
//            System.out.println("test not passed");
//        }
        assertEquals(5, calculator.sum(2, 3));
        assertEquals(7, calculator.sum(2, 5));
        assertEquals(10, calculator.sum(5, 5));

    }

    @Test
//    @Order(2)
    void testDivide() {
//        System.out.println("testDivide()");
//        int div = calculator.divide(4, 2);
        assertEquals(1, calculator.divide(4, 3));
//        assertEquals(0, calculator.divide(112, 0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(123, 0));
    }

    @Test
//    @Order(1)
    void test_Underscore_Method_Name() {
    }

    @Test
    @DisabledIf(value = "isNotTesting", disabledReason = "isNotTesting returning true")
    void disabledTest() {

    }

    @Test
    @EnabledIf(value = "isNotTesting", disabledReason = "isNotTesting returning true")
    void enabledTest() {

    }

    boolean isNotTesting() {
        return false;
    }

    @Test
    @DisabledOnOs({OS.OTHER})
    void testOS() {
    }

    @Test
    @EnabledOnOs({OS.MAC})
    void testOSEnabled() {
    }
}