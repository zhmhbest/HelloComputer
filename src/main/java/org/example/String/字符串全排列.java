package org.example.String;

import java.util.ArrayList;
import java.util.List;

public class 字符串全排列 {
    static List<String> holder = new ArrayList<>();

    static void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    /**
     * @param A 数组
     * @param P 每轮固定的元素
     */
    static void fullArrangementRecur(char[] A, final int P) {
        if (P == (A.length - 1)) {
            holder.add(String.valueOf(A));
            return;
        }
        for (int i = P; i < A.length; i++) {
            swap(A, i, P);
            fullArrangementRecur(A, P + 1); // 对剩余的元素进行全排列
            swap(A, i, P);
        }
    }

    static List<String> fullArrangement(String s) {
        holder.clear();
        char[] chs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) chs[i] = s.charAt(i);
        fullArrangementRecur(chs, 0);
        return holder;
    }

    public static void main(String[] args) {
        System.out.println(fullArrangement("abc"));
        System.out.println(fullArrangement("abcd"));
    }
}
