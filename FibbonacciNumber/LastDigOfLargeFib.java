package main.java.FibbonacciNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class LastDigOfLargeFib {
    static final double sqrtFive = Math.sqrt(5);
    // Golden ratio numbers, used mathematically to evaluate n-th fibonacci
    static final double bigPhi = 1.6180339;
    static final double littlePhi = -1 / bigPhi;

    private static BigInteger calc_fib(int n) {
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger theFib = BigInteger.ZERO;

        // golden ratio works up to 28
        if (n > 1 || n <= 28) {
            // must round up for it to be correct
            theFib = BigInteger.valueOf(Math.round((Math.pow(bigPhi, n) - Math.pow(littlePhi, n)) / sqrtFive));
            return theFib.mod(BigInteger.valueOf(10));
        }

        // Calculate the 28th Fib num, then continue on calculating the standard way
        BigInteger prev2 = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 27) - Math.pow(littlePhi, 27)) / sqrtFive));
        BigInteger prev = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 28) - Math.pow(littlePhi, 28)) / sqrtFive));
        for (int i = 29; i < n; i++) {
            theFib = prev2.add(prev);
            prev2 = prev;
            prev = theFib;
        }
        return theFib.mod(BigInteger.valueOf(10));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }

}
