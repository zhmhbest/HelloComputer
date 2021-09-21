package org.example.Bit;

public class 位运算实现加法 {
    static int add(int a, int b) {
        while(b != 0) {             // 当进位为 0 时跳出
            int c = (a & b) << 1;   // c = 进位
            a = a ^ b;              // a = 非进位和
            b = c;                  // b = 进位
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }
}
