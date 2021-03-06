package main.java.GreatestCommonDivisor;

import java.util.Scanner;

/**
 * Using Euclidean algorithm to find the greatest common divisor of two integers ≤ 2 · 10^9
 */
public class GCD {
    public static int findGCD(int a, int b) {
        int minNum;
        int maxNum;
        if (a == b){
            return a;
        } else {
            //assign min & max
            minNum = (a < b) ? a : b;
            maxNum = (b < a) ? a : b;
            // remainder initialized to arbitrary invalid int
            int rem = -1;
            // Euclidean algorithm: keep dividing max by min and replacing max with remainder until it's zero
            while (rem != 0){
                rem = maxNum % minNum;
                if (rem == 0){
                    return minNum;
                }
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
