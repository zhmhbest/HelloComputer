package org.example.exception;

public class throw和throws {
    public static void main(String[] args)
            throws Exception // 表示该方法存在抛出此异常的可能性
    {
        // 手动制造异常抛出
        throw new Exception();
    }
}
