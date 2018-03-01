package main.java.FibbonacciNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class LastDigOfLargeFib {
    static double sqrtFive = Math.sqrt(5);

    private static BigInteger calc_fib(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        // Approx value of golden ratio, used mathematically to evaluate n-th fibonacci
        double bigPhi = 1.6180339;
        double littlePhi = -1/bigPhi;
        // must round up for it to be correct
        BigInteger theFib = BigInteger.valueOf(Math.round((Math.pow(bigPhi, n) - Math.pow(littlePhi, n)) / sqrtFive));

        return theFib.mod(BigInteger.valueOf(10));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }

}
