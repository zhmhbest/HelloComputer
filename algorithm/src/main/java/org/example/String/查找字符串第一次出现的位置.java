package org.example.String;

public class 查找字符串第一次出现的位置 {
    /**
     * 暴力匹配
     */
    static int indexOf(String searchStr, String findStr) {
        final int m = findStr.length();
        final int n = searchStr.length() - m;
        for (int i = 0; i <= n; i++) {
            int j = 0; for (; j < m; j++) {
                if (searchStr.charAt(i + j) != findStr.charAt(j)) break;
            }
            if (m == j) return i;
        }
        return -1;
    }

    /**
     * Knuth-Morris-Pratt
     */
    static int indexOfByKMP(String searchStr, String findStr) {
        final int n = searchStr.length(), m = findStr.length();
        if (m == 0) return 0;

        int[] pi = new int[m]; // 初始化为0
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && findStr.charAt(i) != findStr.charAt(j)) j = pi[j - 1];
            if (findStr.charAt(i) == findStr.charAt(j)) j++;
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && searchStr.charAt(i) != findStr.charAt(j)) j = pi[j - 1];
            if (searchStr.charAt(i) == findStr.charAt(j))  j++;
            if (j == m) return i - m + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf("", ""));
        System.out.println(indexOf("", "hello"));
        System.out.println(indexOf("hello", ""));
        System.out.println(indexOf("hello", "ll"));
        System.out.println(indexOf("hello", "e"));
        System.out.println(indexOf("hello", "lo"));

        System.out.println(indexOfByKMP("", ""));
        System.out.println(indexOfByKMP("", "hello"));
        System.out.println(indexOfByKMP("hello", ""));
        System.out.println(indexOfByKMP("hello", "ll"));
        System.out.println(indexOfByKMP("hello", "e"));
        System.out.println(indexOfByKMP("hello", "lo"));
    }
}
