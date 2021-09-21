package org.example.LinkedList;

public class 十进制链表转整数 {
    static int getNumberValue(LinkedListNode head) {
        int result = 0;
        while (null != head) {
            result = result * 10 +  head.val;
            head = head.next;
        }
        return result;
    }
    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{7, 8, 3, 0, 5});
        l1.print();
        System.out.println(getNumberValue(l1));
    }
}
