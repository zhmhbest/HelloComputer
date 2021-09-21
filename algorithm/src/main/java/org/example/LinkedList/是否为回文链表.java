package org.example.LinkedList;

import org.example.EasyAssert;

public class 是否为回文链表 {
    static boolean isPalindrome(LinkedListNode head) {
        // 使用快慢指针找到后半部分
        LinkedListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        LinkedListNode half = slow.next;
        if (null == half) return true; // 单节点
        // slow.print();

        // 反转后半部分
        LinkedListNode pre = null, cur = half, nxt;
        while (null != cur) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        half = pre;
        // pre.print();

        // 后半部分长度小于等于前半部分
        LinkedListNode l1 = head, l2 = half;
        while (null != l2) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedListNode l0 = new LinkedListNode(new int[]{});
        LinkedListNode l1 = new LinkedListNode(new int[]{1});
        LinkedListNode l2 = new LinkedListNode(new int[]{1, 2});
        LinkedListNode l3 = new LinkedListNode(new int[]{1, 2, 2, 1});
        LinkedListNode l4 = new LinkedListNode(new int[]{1, 2, 3, 2, 1});

        EasyAssert.AssertEqual(true, isPalindrome(l0));
        EasyAssert.AssertEqual(true, isPalindrome(l1));
        EasyAssert.AssertEqual(false, isPalindrome(l2));
        EasyAssert.AssertEqual(true, isPalindrome(l3));
        EasyAssert.AssertEqual(true, isPalindrome(l4));
    }
}
