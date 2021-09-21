package org.example.String;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    static int romanToInt(String s) {
        Map<Character, Integer> Symbols = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        final int strLen = s.length();
        assert strLen > 0;
        int accNum = 0, curVal, nxtVal = Symbols.get(s.charAt(0));
        for (int i = 0; i < strLen - 1; i++) {
            curVal = nxtVal;
            nxtVal = Symbols.get(s.charAt(i + 1));
            // 负号正负取决于当前值与后一个值的关系
            accNum += curVal < nxtVal ? -curVal : curVal;
        }
        return accNum + nxtVal;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("IV")); // 4
        System.out.println(romanToInt("IX")); // 9
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }
}
