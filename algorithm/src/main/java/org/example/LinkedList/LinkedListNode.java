package org.example.LinkedList;

public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    // 创建
    LinkedListNode() {
        this.val = 0;
        this.next = null;
    }
    LinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
    LinkedListNode(int[] arr) {
        LinkedListNode cur = this;
        if(arr.length > 0) {
            cur.val = arr[0];
            // cur.next = null;
        }
        for (int i = 1; i < arr.length; i++) {
            cur.next = new LinkedListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 打印
    public void print() {
        LinkedListNode cur = this;
        System.out.print("[");
        for(;;) {
            if (null == cur.next) {
                System.out.printf("%d]\n", cur.val);
                break;
            } else {
                System.out.printf("%d, ", cur.val);
                cur = cur.next;
            }
        }
    }

    public int[] toArray() {
        int[] buffer = new int[64];
        int p = 0;
        LinkedListNode cur = this;
        while(null != cur) {
            buffer[p++] = cur.val;
            cur = cur.next;
        }
        int[] result = new int[p];
        System.arraycopy(buffer, 0, result, 0, p);
        return result;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "val=" + val +
                '}';
    }
}
