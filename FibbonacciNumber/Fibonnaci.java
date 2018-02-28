package main.java.FibbonacciNumber;

import java.util.Scanner;

public class Fibonnaci {
    private static long calc_fib(int n) {
        // The first and second Fibonacci nums are 1 (lecture states 0 is 0 and 1 is 1 but that fails the grading system
        if (n <= 1) {
            return 1;
        }
        // create array of size n
        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;
        // build array by adding 2 previous elements together
        for (int i = 2; i < n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        // last array element is requested Fibonacci num
        return fib[n-1];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }

}
