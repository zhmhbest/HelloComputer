package org.example.Array;

public class 括号是否匹配 {
    static boolean isValid(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) return false;
                    int diff = ch -  stack.pop();
                    if (1 != diff && 2 != diff) return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(
                isValid("[")
        );
        System.out.println(
                isValid("]")
        );
        System.out.println(
                isValid("()")
        );
        System.out.println(
                isValid("()[]{}")
        );
        System.out.println(
                isValid("(]")
        );
        System.out.println(
                isValid("([)]")
        );
    }
}
