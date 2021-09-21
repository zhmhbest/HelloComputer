package org.example.Mathematics;

public class 编花篮 {
    public static void waveBasket(char ch0, char ch1, int length) {
        final char[] chs = {ch0, ch1};
        float center = (float) (length) / 2;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((0 == i || (length - 1) == i) && (0 == j || (length - 1) == j)) {
                    System.out.print(' ');
                } else {
                    float dR = (float) Math.abs(i + 0.5 - center);
                    float dC = (float) Math.abs(j + 0.5 - center);
                    int d2 = (int) Math.ceil(Math.max(dR, dC));
                    System.out.print(chs[d2 % 2]);
                }
            }
            System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        waveBasket('B', 'A', 11);
        waveBasket('@', 'W', 5);
    }
}
