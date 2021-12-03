package org.example.LinkedList;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomLinkedListNode extends LinkedListNode {
    // public int val;
    public RandomLinkedListNode next;
    public RandomLinkedListNode random;

    public RandomLinkedListNode() {
        super();
        this.random = null;
    }

    public RandomLinkedListNode(int val) {
        super(val);
        this.random = null;
    }

    public static RandomLinkedListNode fromString(String s) {
        JSONArray nodes = JSONArray.fromObject(s);
        ArrayList<RandomLinkedListNode> nHolder = new ArrayList<>(nodes.size());
        ArrayList<Integer> rHolder = new ArrayList<>(nodes.size());
        RandomLinkedListNode head = new RandomLinkedListNode();
        RandomLinkedListNode p = head;
        for (int i = 0; i < nodes.size(); i++) {
            JSONArray node = nodes.getJSONArray(i);
            p.next = new RandomLinkedListNode(node.getInt(0));
            p = p.next;
            nHolder.add(p);
            try {
                rHolder.add(node.getInt(1));
            } catch (JSONException e) {
                rHolder.add(null);
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            Integer random = rHolder.get(i);
            if (null != random) {
                nHolder.get(i).random = nHolder.get(random);
            }
        }
        return head.next;
    }

    // 打印
    public void print() {
        RandomLinkedListNode p = this;
        HashMap<RandomLinkedListNode, Integer> map = new HashMap<>();
        int i = 0;
        while (null != p) {
            map.put(p, i++);
            p = p.next;
        }

        p = this;
        System.out.print("[");
        for (; ; ) {
            if (null == p.next) {
                System.out.printf("(%d,%d)]\n", p.val, map.get(p.random));
                break;
            } else {
                System.out.printf("(%d,%d), ", p.val, map.get(p.random));
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        // fromString("[]");
        fromString("[[7,null],[13,0],[11,4],[10,2],[1,0]]").print();
    }
}
