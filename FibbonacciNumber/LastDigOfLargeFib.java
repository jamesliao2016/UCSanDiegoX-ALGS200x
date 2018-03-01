package main.java.FibbonacciNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class LastDigOfLargeFib {

    private static BigInteger calc_fib(int n) {
        final double sqrtFive = Math.sqrt(5);
        // Golden ratio numbers, used mathematically to evaluate n-th fibonacci
        final double bigPhi = 1.6180339;
        final double littlePhi = -1 / bigPhi;
        BigInteger theFib = BigInteger.valueOf(0);
        if (n <= 1) {
            return BigInteger.valueOf(n);
        } else if (n > 1 && n <= 28) {
        // golden ratio works up to 28
            // must round up for it to be correct
            theFib = BigInteger.valueOf(Math.round((Math.pow(bigPhi, n) - Math.pow(littlePhi, n)) / sqrtFive));
            return theFib.mod(BigInteger.valueOf(10));
        } else { //if (n > 28)
            // Calculate the 27 & 28th Fib num, then continue on calculating by addition
            BigInteger prev2 = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 27) - Math.pow(littlePhi, 27)) / sqrtFive));
            System.out.println("prev2/f(27) = " + prev2);
            BigInteger prev = BigInteger.valueOf(Math.round((Math.pow(bigPhi, 28) - Math.pow(littlePhi, 28)) / sqrtFive));
            System.out.println("prev/f(28) = " + prev);

            for (int i = 28; i < n; i++) {
                theFib = prev2.add(prev);
                prev2 = prev;
                prev = theFib;
            }
            System.out.println(theFib);
            return theFib.mod(BigInteger.valueOf(10));
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }

}
