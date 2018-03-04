package main.java.GreatestCommonDivisor;

import java.util.Scanner;

/**
 * Using Euclidean algorithm to find the greatest common divisor of two integers ≤ 2 · 10^9
 */
public class GCD {
    private static int findGCD(int a, int b) {
        int minNum = -1;
        int maxNum = -1;
        if (a == b){
            return a;
        } else {
            //assign min & max
            minNum = (a < b) ? a : b;
            maxNum = (b < a) ? a : b;
            // initialized to arbitrary invalid int
            int rem = -1;
            while (rem != 0){
                // divide maxNum by minNum and get remainder
                rem = maxNum % minNum;
                if (rem == 0){
                    return minNum;
                }
                // rem replaces original maxNum & we reassign vars.
                maxNum = minNum;
                minNum = rem;
            }
        }
        return minNum;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(findGCD(a, b));
    }

}
