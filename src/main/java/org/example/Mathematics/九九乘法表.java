package org.example.Mathematics;

public class 九九乘法表 {
    static void print99Table() {
        int i, j;
        for (i = 1; i < 10; i++) {
            for (j = 1; j < i + 1; j++) {
                System.out.printf("%d×%d=%d\t", j, i, i * j);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        print99Table();
    }
}
