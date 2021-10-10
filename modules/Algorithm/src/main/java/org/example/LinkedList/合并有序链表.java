package org.example.LinkedList;

public class 合并有序链表 {

    static LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode head = new LinkedListNode();
        LinkedListNode n1 = l1;
        LinkedListNode n2 = l2;
        LinkedListNode cur = head;
        for (; ; ) {
            switch ((null == n1 ? 0 : 1) + (null == n2 ? 0 : 2)) {
                case 0:
                    return head.next;
                case 1:
                    cur.next = n1; n1 = n1.next; break;
                case 2:
                    cur.next = n2; n2 = n2.next; break;
                case 3:
                    if(n1.val < n2.val) {
                        cur.next = n1; n1 = n1.next;
                    } else {
                        cur.next = n2; n2 = n2.next;
                    }
                    break;
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{1, 3, 5});
        LinkedListNode l2 = new LinkedListNode(new int[]{1, 5, 7});
        l1.print();
        l2.print();
        mergeTwoLists(l1, l2).print();
    }
}
