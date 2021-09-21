package org.example.LinkedList;

public class 链表中是否有环 {

    static boolean hasCycle(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        for (;;) {
            // fast不为null，则slow一定不为null
            if (null == fast || null == fast.next) return false;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{3, 2, 0, -4});
        l1.print();
        System.out.println(hasCycle(l1));

        // 构成换-4 -> 2
        l1.next.next.next.next = l1.next;
        System.out.println(hasCycle(l1));
    }
}
