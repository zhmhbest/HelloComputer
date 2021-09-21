package org.example.LinkedList;

public class 判断链表中是否有环 {
    /**
     * 龟兔赛跑，若有环，则兔子早晚能追上乌龟
     * 循环终止条件
     *      有指针为null：无环
     *      指针相同且不为null：有环
     * O(n)时间复杂度
     */
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
