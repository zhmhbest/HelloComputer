package org.example.exception;


public class 自定义异常 {
    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            throw new MyException("自定义异常");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("finally");
        }
    }
}
