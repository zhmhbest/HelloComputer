package org.example.exception;

public class finally和return {
    static int defaultReturn() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("remain");
        return -1;
    }

    static int tryAndFinallyReturn1() {
        try {
            System.out.println("try");
            return 1;
        } finally {
            System.out.println("finally");
            return 3;
        }
        // return -1; // 该语句无法访问
    }

    static int tryAndFinallyReturn2() {
        int r = 0;
        try {
            System.out.println("try");
            r = 1;
            return r;
        } finally {
            System.out.println("finally");
            r = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int[] tryAndFinallyReturn3() {
        int[] r = {0};
        try {
            System.out.println("try");
            r[0] = 1;
            return r;
        } finally {
            System.out.println("finally");
            r[0] = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int catchAndFinallyReturn1() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
        // return -1; // 该语句无法访问
    }

    static int catchAndFinallyReturn2() {
        int r = 0;
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            r = 2;
            return r;
        } finally {
            System.out.println("finally");
            r = 3;
        }
        // return -1; // 该语句无法访问
    }

    static int[] catchAndFinallyReturn3() {
        int[] r = {0};
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            System.out.println("catch");
            r[0] = 2;
            return r;
        } finally {
            System.out.println("finally");
            r[0] = 3;
        }
        // return -1; // 该语句无法访问
    }

    /**
     * 结论：
     * 若finally直接return，则以finally为准
     * 若finally改变return引用的值，则返回值改变
     * 若finally改变return基础变量的值，则返回值不改变
     */
    public static void main(String[] args) {
        System.out.println(defaultReturn());
        // try、catch、finally、remain、-1
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn1());
        // try、finally、3
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn2());
        // try、finally、1
        System.out.println("--------");

        System.out.println(tryAndFinallyReturn3()[0]);
        // try、finally、3
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn1());
        // try、catch、finally、3
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn2());
        // try、catch、finally、2
        System.out.println("--------");

        System.out.println(catchAndFinallyReturn3()[0]);
        // try、catch、finally、3
        System.out.println("--------");
    }
}
