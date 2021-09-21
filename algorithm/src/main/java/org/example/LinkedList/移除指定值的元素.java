package org.example.LinkedList;

public class 移除指定值的元素 {
    static LinkedListNode removeElements(LinkedListNode head, int val) {
        LinkedListNode dumpHead = new LinkedListNode();
        LinkedListNode dmp = dumpHead;
        LinkedListNode cur = head;
        while (null != cur) {
            if (val != cur.val) {
                dmp.next = cur;
                dmp = dmp.next;
            }
            cur = cur.next;
        }
        dmp.next = null;
        return dumpHead.next;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{1, 1, 3, 1, 2, 5, 1});
        l1.print();
        removeElements(l1, 1).print();
    }
}
