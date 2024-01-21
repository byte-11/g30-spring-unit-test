package uz.byte11.springbootunittest.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRepeatedTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @RepeatedTest(value = 10, name = "[{currentRepetition}]")
    void sum() {
        Random random = new Random();
        int a = random.nextInt(1, 10000);
        int b = random.nextInt(1, 10000);
        int sum = a + b;
        assertEquals(sum, calculator.sum(a, b));
    }

    @ParameterizedTest
    @ValueSource(strings = {"AV", "ALS", "KVL", "CSd"})
    void testParameterizedTests(String value){
        assertEquals(value.toUpperCase(), value);
    }

    @ParameterizedTest
    @MethodSource("sumArgStream")
    void testSumWithMethodParameters(SumArg arg){
        assertEquals(arg.expected, calculator.sum(arg.getB(), arg.getA()));
    }

    static Stream<SumArg> sumArgStream(){
        return Stream.of(
                new SumArg(1, 3, 4),
                new SumArg(3, 5, 8),
                new SumArg(1, 3, 4),
                new SumArg(1, 3, 4),
                new SumArg(1, 3, 4)
        );
    }

    @AllArgsConstructor
    @Getter
    @ToString
    private static class SumArg {
        private int a;
        private int b;
        private int expected;
    }
}