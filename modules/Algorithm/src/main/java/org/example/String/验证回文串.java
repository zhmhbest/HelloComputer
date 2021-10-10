package org.example.String;

import org.example.EasyAssert;

public class 验证回文串 {
    static int getCharacter(char ch) {
        int r;
        if ('A' <= ch && ch <= 'Z') r = ch - 'A' + 10;
        else if ('a' <= ch && ch <= 'z') r = ch - 'a' + 10;
        else if ('0' <= ch && ch <= '9') r = ch - '0';
        else r = -1;
        return r;
    }

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            int chL = -1;
            while (i < s.length() && -1 == chL) chL = getCharacter(s.charAt(i++));
            int chR = -1;
            while (j >= 0 && -1 == chR) chR = getCharacter(s.charAt(j--));
            if (chL != chR) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EasyAssert.Assert(isPalindrome(""));
        EasyAssert.Assert(isPalindrome(" "));
        EasyAssert.Assert(isPalindrome("  "));
        EasyAssert.Assert(!isPalindrome("ab"));
        EasyAssert.Assert(!isPalindrome("0P"));
        EasyAssert.Assert(isPalindrome(".,"));
        EasyAssert.Assert(isPalindrome("A man, a plan, a canal: Panama"));
        EasyAssert.Assert(!isPalindrome("race a car"));
        System.out.println("OK");
    }
}
