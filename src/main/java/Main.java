import java.util.Scanner;

/**
 * 运行模板
 */
public class Main {
    static int lastRemaining(int n, int k) {
        int v = 0;
        for (int i = 1; i <= n; i++) {
            v = (v + k) % i;
        }
        return v;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(lastRemaining(n, k));
        // 2 3
        // 2
    }
}
