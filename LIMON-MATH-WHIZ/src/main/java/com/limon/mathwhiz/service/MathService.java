
package com.limon.mathwhiz.service;

public class MathService {

    // Prime Number Function
    public static int isPrime(int number) {

        if (number < 2) {
            return 0;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return 0;
            }
        }

        return 1;
    }

    // Modulus Function
    public static int calculateMod(int a, int b) {

        if (b == 0) {
            throw new IllegalArgumentException(
                    "Divisor cannot be zero"
            );
        }

        return a % b;
    }

    // Sine Function
    public static double calculateSin(double degree) {

        double radians = Math.toRadians(degree);

        return Math.sin(radians);
    }

    // Cosine Function
    public static double calculateCos(double degree) {

        double radians = Math.toRadians(degree);

        return Math.cos(radians);
    }

    // Tangent Function
    public static double calculateTan(double degree) {

        double radians = Math.toRadians(degree);

        if (Math.abs(Math.cos(radians)) < 1e-10) {
            throw new IllegalArgumentException(
                    "Tangent is undefined at this angle"
            );
        }

        return Math.tan(radians);
    }
}
