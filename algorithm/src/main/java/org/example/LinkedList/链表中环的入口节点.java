package org.example.LinkedList;

public class 链表中环的入口节点 {
    static LinkedListNode detectCycle(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) { // 已经判定有环
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{3, 2, 0, -4});
        l1.print();
        System.out.println(detectCycle(l1));

        // 构成换-4 -> 2
        l1.next.next.next.next = l1.next;
        System.out.println(detectCycle(l1));
    }
}
