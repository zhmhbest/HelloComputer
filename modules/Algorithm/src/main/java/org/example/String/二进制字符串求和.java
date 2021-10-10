package org.example.String;

public class 二进制字符串求和 {
    static String addBinary(String a, String b) {
        StringBuilder holder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1, w = 0, v; ; ) {
            switch ((i >= 0 ? 1 : 0) + (j >= 0 ? 2 : 0)) {
                case 0:
                    if (w > 0) holder.append(w);
                    return holder.reverse().toString();
                case 1:
                    v = (a.charAt(i--) - '0') + w;
                    break;
                case 2:
                    v = (b.charAt(j--) - '0') + w;
                    break;
                default:
                    v = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + w;
                    break;
            }
            if (w > 0) w--;
            if (v >= 2) { w++;v -= 2; }
            holder.append(v);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                addBinary("11", "1")
        );
        System.out.println(
                addBinary("1010", "1011")
        );
    }
}
