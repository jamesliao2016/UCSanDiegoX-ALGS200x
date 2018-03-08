package main.java.MaxPairwiseProduct;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(BigInteger[] numbers) {
        int indexOne = 0;
        int n = numbers.length;

        if (n == 2){
            return numbers[0].multiply(numbers[1]);
        }

        // iterate through array twice, store index of largest and second largest num
        for (int i = 1; i < n; ++i) {
            // if numbers[i] is greater than numbers at indexone, replace maxIndex with i
            if (numbers[i].compareTo(numbers[indexOne]) == 1) { // -1, 0 or 1 = less, equal, or greater
                indexOne = i;
            }
        }
        // swap the largest & last elements of the array
        BigInteger maxTemp = numbers[indexOne];
        numbers[indexOne] = numbers[n - 1];
        numbers[n - 1] = maxTemp;
        // repeat the process to find the second max element
        int indexTwo = 0;
        for (int j = 1; j < (n - 1); j++){
            int result = numbers[j].compareTo(numbers[indexTwo]);
            if ((result == 1) || (result == 0)){
                indexTwo = j;
            }
        }

        // multiply them, return result
        return numbers[n-1].multiply(numbers[indexTwo]);
    }

    public static void main(String[] args) {
        // Fast Scanner does not have nextBigInteger(), so changed to regular Scanner
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] numbers = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextBigInteger();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
