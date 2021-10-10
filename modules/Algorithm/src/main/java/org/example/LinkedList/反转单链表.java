package org.example.LinkedList;

import java.util.Arrays;

public class 反转单链表 {

    /**
     * 反转单链表
     * 存后
     * 改后为前
     * 存前
     * 走后
     */
    static LinkedListNode reverseList(LinkedListNode head) {
        LinkedListNode pre = null, cur = head, nxt;
        while (null != cur) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * 反转K个长度的链表
     * @return 未完成个数, 左头, 左尾, 右头（可能为NULL）
     */
    static Object[] reverseKLengthList(LinkedListNode head, int k) {
        LinkedListNode pre = null, cur = head, nxt;
        while (0 != k-- && null != cur) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return new Object[]{k + 1, pre, head, cur};
    }


    public static void main(String[] args) {
        final int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));

        reverseList(new LinkedListNode(arr)).print();

        Object[] ls = reverseKLengthList(new LinkedListNode(arr), 3);
        System.out.println(ls[0]);
        LinkedListNode l1 = (LinkedListNode) ls[1];
        LinkedListNode l2 = (LinkedListNode) ls[2];
        LinkedListNode l3 = (LinkedListNode) ls[3];
        l1.print();
        l2.print();
        l3.print();
    }
}
