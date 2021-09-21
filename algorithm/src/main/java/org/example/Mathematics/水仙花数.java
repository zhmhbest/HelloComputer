package org.example.Mathematics;

public class 水仙花数 {
    static boolean isNarcissus(int num) {
        int n = num;
        int a = n / 100; n %= 100;
        int b = n / 10; n %= 10;
        int c = n;
        return (num == a * a * a + b * b * b + c * c * c);
    }

    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            if (isNarcissus(i)) {
                System.out.println(i);
            }
        }
    }

}
