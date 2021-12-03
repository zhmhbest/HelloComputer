package org.example.Mathematics;

import org.example.EasyAssert;

import java.util.HashMap;
import java.util.Scanner;

public class 素数和为此数 {
    static HashMap<Long, Boolean> primes = new HashMap<Long, Boolean>() {{
        put(0L, true); put(1L, true); put(2L, true);
        put(3L, true); put(4L, false); put(5L, true);
    }};

    static boolean isPrime(final long N) {
        if (primes.containsKey(N)) return primes.get(N);
        if (0 == N % 2) { primes.put(N, false); return false; }
        final long M = (int) Math.sqrt(N);
        for (long i = 3; i <= M; i+=2) {
            if (0 == N % i) {
                primes.put(N, false);
                return false;
            }
        }
        primes.put(N, true);
        return true;
    }

    static long countPrimeAdd(final long N) {
        int count = 0;
        for (long i = 2; i <= N / 2; i++) {
            if (isPrime(i) && isPrime(N - i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // long inputNum = scanner.nextLong();
        // System.out.println(countPrimeAdd(inputNum));
        EasyAssert.AssertEqual(countPrimeAdd(10), 2);
    }
}
