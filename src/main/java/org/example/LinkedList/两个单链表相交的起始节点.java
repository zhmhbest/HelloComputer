package org.example.LinkedList;

public class 两个单链表相交的起始节点 {

    static LinkedListNode getIntersectionNode(LinkedListNode headA, LinkedListNode headB) {
        if (headA == null || headB == null) return null;

        LinkedListNode n1 = headA;
        LinkedListNode n2 = headB;
        while (n1 != n2) {
            n1 = (n1 == null ? headB : n1.next);
            n2 = (n2 == null ? headA : n2.next);
        }
        return n1;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{4, 1});
        LinkedListNode l2 = new LinkedListNode(new int[]{5, 0, 1});
        LinkedListNode l3 = new LinkedListNode(new int[]{8, 4, 5});

        l1.print();
        l2.print();
        try {
            getIntersectionNode(l1, l2).print();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        l1.next.next = l3;
        l2.next.next.next = l3;
        l1.print();
        l2.print();
        getIntersectionNode(l1, l2).print();
    }
}
