package org.example.lesson4;

public class Triangle {

    static double triangleArea(double sideA, double sideB, double sideC) throws Exception {
        if (sideA == 0 || sideB == 0 || sideC == 0) throw new Exception("Сторона не может быть равна 0");

        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideC + sideB <= sideA)
            throw new Exception("Треугольник не существует , сумма длин каждых двух сторон должна быть больше длины третьей стороны");

        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}
