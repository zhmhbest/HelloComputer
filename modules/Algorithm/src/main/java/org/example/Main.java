package org.example;

import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 运行模板
 */
public class Main {
    static int lastRemaining(int n, int k) {
        int v = 0;
        for (int i = 1; i <= n; i++) {
            v = (v + k) % i;
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(Math.round(-1.6));
        System.out.println(Math.ceil(-1.5));
        System.out.println(Math.floor(-1.5));

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(lastRemaining(n, k));
        // 2 3
        // 2
    }
}
