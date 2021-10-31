package org.example.String;

import org.example.EasyAssert;

import java.util.HashMap;

public class 银行大写数字 {
    final static HashMap<String, String> CurrencyTypes = new HashMap<String, String>() {{
        put("CNY", "人民币");
        put("USD", "美元");
        put("EUR", "欧元");
        put("JPY", "日元");
        put("GBP", "英镑");
    }};
    final static HashMap<Long, String> NumberNames = new HashMap<Long, String>() {{
        put(-3L, "厘");
        put(-2L, "分");
        put(-1L, "角");
        put(0L, "零");
        put(1L, "壹");
        put(2L, "贰");
        put(3L, "叁");
        put(4L, "肆");
        put(5L, "伍");
        put(6L, "陆");
        put(7L, "柒");
        put(8L, "捌");
        put(9L, "玖");
        put(10L, "拾");
        put(100L, "佰");
        put(1000L, "仟");
        put(10000L, "万");
        put(100000L, "拾万");
        put(1000000L, "佰万");
        put(10000000L, "仟万");
        put(100000000L, "亿");
        put(1000000000L, "拾亿");
        put(10000000000L, "佰亿");
        put(100000000000L, "仟亿");
        put(1000000000000L, "万亿");
    }};

    static Long[] capitalNumber(String s) throws Exception {
        long v = 0L, c = 0L;
        long iV = 0L, iC = 0L;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <='9') ch-= '0';
            else if ('.' == ch) {
                continue;
            } else if (',' == ch) {
                iV = v; iC = c; // 整数部分
                v = 0L; c = 0;
                continue;
            } else {
                throw new Exception("金额错误");
            }
            v = v * 10 + ch;
            c++;
        }
        if (0 == iC){
            // 未发现小数点
            iV = v; iC = c; // 整数部分
            v = 0L; c = 0;
        }
        return new Long[]{iV, iC, v, c};
    }

    static String capitalName(String capitalType, Long[] capitalValues) throws Exception {
        if (!CurrencyTypes.containsKey(capitalType)) throw new Exception("币种错误");
        StringBuilder builder = new StringBuilder();
        builder.append(CurrencyTypes.get(capitalType));
        long t, i, v, w;
        // 整数部分
        i = 0;
        v = capitalValues[0];
        w = (long) Math.pow(10, capitalValues[1] - 1);
        for(;;) {
            t = v / w;
            if (1 == w) {
                builder.append(NumberNames.get(t));
            } else {
                builder.append(NumberNames.get(t)).append(NumberNames.get(w));
            }
            if (++i == capitalValues[1]) break;
            v %= w;
            w /= 10;
        }
        builder.append("元");
        // 小数部分
        i = 0;
        v = capitalValues[2];
        w = (long) Math.pow(10, capitalValues[3] - 1);
        for(;;) {
            t = v / w;
            builder.append(NumberNames.get(t)).append(NumberNames.get(--i));
            if (-i == capitalValues[3]) break;
            v %= w;
            w /= 10;
        }
        return builder.toString();
    }

    static String capitalFigure(String s){
        if (s.length() > 3)  {
            try {
                return capitalName(
                        s.substring(0, 3),
                        capitalNumber(s.substring(3))
                );
            } catch (Exception e) {
                return e.getMessage();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        EasyAssert.AssertEqual(capitalFigure("UDS123"), "币种错误");
        EasyAssert.AssertEqual(capitalFigure("USD1.233,123"), "美元壹仟贰佰叁拾叁元壹角贰分叁厘");
        EasyAssert.AssertEqual(capitalFigure("CNY7.342,098"), "人民币柒仟叁佰肆拾贰元零角玖分捌厘");
        System.out.println("OK");
    }
}
