package org.example.LinkedList;

public class 链表数字相加进位 {

    static LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
        LinkedListNode cur = new LinkedListNode();
        LinkedListNode hed = cur;
        int adv = 0, val;
        for (;;) {
            switch ((l1 == null ? 0 : 1) + (l2 == null ? 0 : 2)) {
                case 3:
                    val = l1.val + l2.val;
                    if(adv > 0) { val++; adv--; }
                    if(val >= 10) { adv++; val -= 10; }
                    cur.next = new LinkedListNode(val);
                    cur = cur.next;
                    l1 = l1.next;
                    l2 = l2.next;
                    break;
                case 2:
                    val = l2.val;
                    if(adv > 0) { val++; adv--; }
                    if(val >= 10) { adv++; val -= 10; }
                    cur.next = new LinkedListNode(val);
                    cur = cur.next;
                    l2 = l2.next;
                    break;
                case 1:
                    val = l1.val;
                    if(adv > 0) { val++; adv--; }
                    if(val >= 10) { adv++; val -= 10; }
                    cur.next = new LinkedListNode(val);
                    cur = cur.next;
                    l1 = l1.next;
                    break;
                case 0:
                    if(adv > 0) {
                        cur.next = new LinkedListNode(adv);
                    }
                    return hed.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(new int[]{3, 9, 6, 2});
        LinkedListNode l2 = new LinkedListNode(new int[]{2, 5, 4});
        addTwoNumbers(l1, l2).print();
    }
}
