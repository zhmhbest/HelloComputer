package org.example.LinkedList;

import org.example.EasyAssert;

public class K个一组反转列表 {

    /**
     * 反转K个长度的链表
     *
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

    static LinkedListNode reverseKGroup(LinkedListNode head, int k) {
        LinkedListNode rH = null, pT = null;
        LinkedListNode cH = head, cT, nH;
        do {
            Object[] tuple = reverseKLengthList(cH, k);
            int rK = (int) tuple[0];
            cH = (LinkedListNode) tuple[1];
            cT = (LinkedListNode) tuple[2];
            nH = (LinkedListNode) tuple[3];
            if (0 != rK) {
                // 如果不够K个再转回去
                tuple = reverseKLengthList(cH, k - rK);
                // rK = (int) tuple[0];
                cH = (LinkedListNode) tuple[1];
                cT = (LinkedListNode) tuple[2];
                nH = (LinkedListNode) tuple[3];
            }
            if (null == rH)  rH = cH;
            if (null != pT) pT.next = cH;
            pT = cT;
            cH = nH;
        } while (null != nH);
        return rH;
    }

    public static void main(String[] args) {
        final int[] arr1 = {1, 2, 3, 4, 5, 6};
        final int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
        EasyAssert.AssertEqual(
                new int[]{2, 1, 4, 3, 6, 5},
                reverseKGroup(new LinkedListNode(arr1), 2).toArray()
        );
        EasyAssert.AssertEqual(
                new int[]{3, 2, 1, 6, 5, 4, 7, 8},
                reverseKGroup(new LinkedListNode(arr2), 3).toArray()
        );
        System.out.println("OK");
    }
}
