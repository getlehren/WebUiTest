package org.example.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangleTest {

    @ParameterizedTest
    @CsvSource({
            "3,3,3,3.897114317029974",
            "4,9,10,17.984368212422698",
            "2,4,5,3.799671038392666"
    })
    void testTriangleArea(double sideA, double sideB, double sideC , double result) throws Exception {
        Assertions.assertEquals(result, Triangle.triangleArea(sideA,sideB,sideC));
    }

    @ParameterizedTest
    @CsvSource({
            "0,3,3",
            "4,0,10",
            "2,4,0"
    })
    void testTriangleAreaWithZeroSide(double sideA, double sideB, double sideC) throws Exception {
        Assertions.assertThrows(Exception.class, () -> {Triangle.triangleArea(sideA,sideB,sideC);});
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "4,2,2",
            "3,6,3"
    })
    void testTriangleNotExist(double sideA, double sideB, double sideC) throws Exception {
        Assertions.assertThrows(Exception.class, () -> {Triangle.triangleArea(sideA,sideB,sideC);});
    }
}