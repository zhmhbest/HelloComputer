package org.example.LinkedList;

public class 删除有序链表中的重复元素 {

    /**
     * 当前节点与下一个节点值相同
     *      当前next执行下下个节点
     * 否则
     *      当前节点前进
     */
    static LinkedListNode deleteDuplicates(LinkedListNode head) {
        if (null == head) return null;

        LinkedListNode cur = head;
        while (null != cur.next) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{1, 1, 1, 2, 3, 3});
        l1.print();
        deleteDuplicates(l1).print();
    }
}
