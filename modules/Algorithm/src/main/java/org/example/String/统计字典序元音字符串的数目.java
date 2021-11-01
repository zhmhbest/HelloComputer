package org.example.String;

public class 统计字典序元音字符串的数目 {
    static final char[] SingleVowels = {'a', 'e', 'i', 'o', 'u'};

    static int solve(char c, int n) {
        if (n == 1) return 1;
        int r = 0;
        int j = SingleVowels.length;
        for (int i = 0; i < SingleVowels.length; i++) {
            if (SingleVowels[i] == c) j = i;
            if (i >= j) r += solve(SingleVowels[i], n - 1);
        }
        return r;
    }

    static int countVowelStrings(int n) {
        int r = 0;
        for (char c : SingleVowels) r += solve(c, n);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
    }
}
