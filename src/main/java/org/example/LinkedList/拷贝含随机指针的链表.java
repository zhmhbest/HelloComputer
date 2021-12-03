package org.example.LinkedList;

public class 拷贝含随机指针的链表 {
    static RandomLinkedListNode copyRandomList(RandomLinkedListNode head) {
        if (head == null) return null;

        RandomLinkedListNode freshNode, freshHead;

        for (RandomLinkedListNode node = head; node != null; node = node.next.next) {
            freshNode = new RandomLinkedListNode(node.val);
            freshNode.next = node.next;
            node.next = freshNode;
        }
        for (RandomLinkedListNode node = head; node != null; node = node.next.next) {
            freshNode = node.next;
            freshNode.random = (node.random != null) ? node.random.next : null;
        }
        freshHead = head.next;
        for (RandomLinkedListNode node = head; node != null; node = node.next) {
            freshNode = node.next;
            node.next = node.next.next;
            freshNode.next = (freshNode.next != null) ? freshNode.next.next : null;
        }
        return freshHead;
    }

    public static void main(String[] args) {
        RandomLinkedListNode head = RandomLinkedListNode.fromString("[[7,null],[13,0],[11,4],[10,2],[1,0]]");
        copyRandomList(head).print();
    }
}
