package main.java.LeastCommonMultiple;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Input:
 14159572 63967072

 Your output:
 -527892768

 Correct output:
 226436590403296
 */

public class LeastCommonMultiple {
    private static BigInteger lcm(int a, int b) {
        // use BigInt for large ints
        BigInteger a_bigint = BigInteger.valueOf(a);
        BigInteger b_bigint = BigInteger.valueOf(b);
        // find GCD
        BigInteger gcd = BigInteger.valueOf(findGCD(a, b));
        // get product of a and b
        BigInteger product = a_bigint.multiply(b_bigint);
        // divide product by gcd
        return product.divide(gcd);
    }

    /**
     * Reuse method from GCD challenge
     */
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

        System.out.println(lcm(a, b));
    }

}
