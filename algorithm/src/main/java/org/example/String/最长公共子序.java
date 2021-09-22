package org.example.String;

public class 最长公共子序 {
    static int longestCommonSubsequence(String s1, String s2) {
        final int n1 = s1.length();
        final int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第0行，第0列全为0

        for (int i = 1; i <= n1; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        System.out.println(
                longestCommonSubsequence("abcde", "ace")
        );
    }

}
