package org.example.exception;

public class Error和Exception {
    public static void main(String[] args) {
        try {
            // 运行时异常，捕获后可以继续运行
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 错误，之和系统将强制退出
        throw new Error();

        // System.out.println("OK"); // 此代码不可达
    }
}
