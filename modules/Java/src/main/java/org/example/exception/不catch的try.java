package org.example.exception;

public class 不catch的try {

    /**
     * 结论
     * 在try开头的代码块中catch和finally必须保留一个
     */
    public static void main(String[] args) {
        try {
            System.out.println("try");
        } finally {
            System.out.println("finally");
        }

        try {
            System.out.println("try");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
