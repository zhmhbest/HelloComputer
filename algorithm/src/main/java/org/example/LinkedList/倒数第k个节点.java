package org.example.LinkedList;

import org.example.EasyAssert;

public class 倒数第k个节点 {
    /**
     * former先走k步，此时former-latter两者保持k个距离
     * former与latter同走，former指向null结束
     * 返回latter的值
     */
    static LinkedListNode getKthFromEnd(LinkedListNode head, int k) {
        LinkedListNode former = head, latter = head;
        while (0 != k--) former = former.next;
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        LinkedListNode l1 = new LinkedListNode(arr);
        l1.print();
        EasyAssert.AssertEqual(4, getKthFromEnd(l1, 2).val);
        EasyAssert.AssertEqual(3, getKthFromEnd(l1, 3).val);
        EasyAssert.AssertEqual(2, getKthFromEnd(l1, 4).val);
    }
}
