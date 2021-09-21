package org.example;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;


public class IO {
    public static InputStream getResourceStream(String name) {
        return IO.class.getResourceAsStream(name);
    }

    /**
     * 读取资源目录文本文件
     *
     * @param name 资源位置
     * @return 文本内容
     */
    public static String readResourceText(String name) {
        InputStream is = getResourceStream(name);
        if (null != is) {
            try {
                int fileSize = is.available();
                byte[] buffer = new byte[fileSize];
                int readSize = is.read(buffer);
                if (readSize != fileSize) {
                    return null;
                }
                return new String(buffer, 0, fileSize, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject readResourceJsonObject(String name) {
        return JSONObject.fromObject(readResourceText(name));
    }

    public static JSONArray readResourceJsonArray(String name) {
        return JSONArray.fromObject(readResourceText(name));
    }

    public static String readText(String fileName) {
        try {
            return readText(new FileInputStream(fileName));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static String readText(InputStream is) {
        try {
            byte[] buff = new byte[is.available()];
            int size = is.read(buff);
            return new String(buff, 0, size, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static int[][] lol2aoa(JSONArray mat) {
        final int m = mat.size();
        final int n = mat.getJSONArray(0).size();
        int[][] buff = new int[m][n];
        for (int i = 0; i < m; i++) {
            JSONArray line = mat.getJSONArray(i);
            for (int j = 0; j < n; j++) {
                buff[i][j] = line.getInt(j);
            }
        }
        return buff;
    }

    public static int[][] parseMatrix(String text) {
        return lol2aoa(JSONArray.fromObject(text));
    }

    public static Random random = new Random();

    public static int generateRandomInt(int size) {
        return (int) (random.nextFloat() * size);
        // [0, size)
    }

    public static int[] generateRandomIntArray(int maxLength, int randomRange) {
        int len = Math.abs(generateRandomInt(maxLength + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = generateRandomInt(randomRange);
        }
        return arr;
    }
    public static int[] generateRandomIntArray(int maxLength) {
        return generateRandomIntArray(maxLength, maxLength + 1);
    }
    public static int[] generateRandomIntOrderArray(int maxLength) {
        int[] arr = generateRandomIntArray(maxLength, maxLength + 1);
        Arrays.sort(arr);
        return arr;
    }
    public static int[] generateRandomDistinctIntArray(int maxLength, int randomRange) {
        if (randomRange < maxLength) throw new AssertionError();
        maxLength++;
        int len = Math.abs(generateRandomInt(maxLength));
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            for (; ; ) {
                arr[i] = generateRandomInt(randomRange);
                if (!set.contains(arr[i])) {
                    set.add(arr[i]);
                    break;
                }
            }
        }
        return arr;
    }

    // 高位在前
    public static void printBytesH(int v) {
        String[] r = new String[4];
        for (int i = 0; i < r.length; i++) {
            byte b = (byte) (v >> (8 * i) & 0xFF);
            r[r.length - i - 1] = String.format("%X", b);
        }
        System.out.println(Arrays.toString(r));
    }
    // 高位在前
    public static void printBytesH(long v) {
        String[] r = new String[8];
        for (int i = 0; i < r.length; i++) {
            byte b = (byte) (v >> (8 * i) & 0xFF);
            r[r.length - i - 1] = String.format("%X", b);
        }
        System.out.println(Arrays.toString(r));
    }
    // 低位在前
    public static void printBytesL(int v) {
        String[] r = new String[4];
        for (int i = 0; i < r.length; i++) {
            byte b = (byte) (v >> (8 * i) & 0xFF);
            r[i] = String.format("%X", b);
        }
        System.out.println(Arrays.toString(r));
    }
    // 低位在前
    public static void printBytesL(long v) {
        String[] r = new String[8];
        for (int i = 0; i < r.length; i++) {
            byte b = (byte) (v >> (8 * i) & 0xFF);
            r[i] = String.format("%X", b);
        }
        System.out.println(Arrays.toString(r));
    }

    // 打印有符号整型表示的无符号数据的值
    public static long toUnsignedIntegerValue(int x) {
        return ((long)x) & 0x00000000FFFFFFFFL;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row: matrix) {
            System.out.print("|");
            for (int i = 0; i < row.length - 1; i++) {
                System.out.printf("%3d ", row[i]);
            }
            System.out.printf("%3d |\n", row[row.length - 1]);
        }
        System.out.print("\n");
    }
}
