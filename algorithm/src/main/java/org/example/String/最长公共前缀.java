package org.example.String;

public class 最长公共前缀 {
    /**
     * 纵向匹配
     */
    static String longestCommonPrefix(String[] strs) {
        StringBuilder holder = new StringBuilder();
        for (int colIndex = 0; ; colIndex++) {
            if (colIndex >= strs[0].length()) return holder.toString(); // 越界
            char ch = strs[0].charAt(colIndex);
            for (int i = 1; i < strs.length; i++) {
                // 越界或不等
                if (colIndex >= strs[i].length() || strs[i].charAt(colIndex) != ch)
                    return holder.toString();
            }
            holder.append(ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(new String[]{"fl", "flow", "flight"})
        );
        System.out.println(
                longestCommonPrefix(new String[]{"flower", "fl", "flight"})
        );
        System.out.println(
                longestCommonPrefix(new String[]{"flower", "flow", "flight"})
        );
        System.out.println(
                longestCommonPrefix(new String[]{"dog", "racecar", "car"})
        );
    }
}
