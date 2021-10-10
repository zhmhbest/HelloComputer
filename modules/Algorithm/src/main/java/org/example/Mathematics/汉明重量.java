package org.example.Mathematics;

import org.example.EasyAssert;
import org.example.IO;


public class 汉明重量 {
    /**
     * 其二进制形式中1的数量
     */
    static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 0x00000001;
        }
        return count;
    }

    public static void main(String[] args) {
        int t = 0xABCD1234;
        EasyAssert.AssertEqual(15, hammingWeight(t));
        System.out.println("OK");
    }
}
