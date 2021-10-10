package org.example.BinaryTree;

import net.sf.json.JSONObject;
import org.example.IO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeNode {
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(int val, BinaryTreeNode l, BinaryTreeNode r) {
        this.val = val;
        this.left = l;
        this.right = r;
    }

    public BinaryTreeNode(JSONObject root) {
        // System.out.println(root);
        this.val = root.getInt("val");
        JSONObject left = root.getJSONObject("left");
        JSONObject right = root.getJSONObject("right");
        // 递归构建
        this.left = (left.isNullObject() ? null : new BinaryTreeNode(left));
        this.right = (right.isNullObject() ? null : new BinaryTreeNode(right));
    }

    public BinaryTreeNode(String treeResource) {
        this(IO.readResourceJsonObject(treeResource));
    }

    private static String duplicateChars(String ch, int l) {
        if (l <= 0) return "";
        return String.join("", Collections.nCopies(l, ch));
    }

    private static final String SpaceChars = "\t\t";
    private void printUnit(BinaryTreeNode node, int depth) {
        if (null == node) {
            System.out.printf("%s%s\n", duplicateChars(SpaceChars, depth), ".");
            return;
        }
        printUnit(node.right, depth + 1);
        System.out.printf("%s%d\n", duplicateChars(SpaceChars, depth), node.val);
        printUnit(node.left, depth + 1);
    }
    public void print() {
        System.out.println(duplicateChars("=", 32));
        printUnit(this, 0);
        System.out.println(duplicateChars("=", 32));
    }

    public void printDblLinkedList() {
        List<Integer> holder = new LinkedList<>();
        BinaryTreeNode root = this;
        holder.add(root.val);
        BinaryTreeNode node = root.right;
        while (null != node && node != root) {
            holder.add(node.val);
            node = node.right;
        }
        System.out.println(holder);
    }

    public static void main(String[] args) {
        // JSONObject root = IO.readResourceJsonObject("/binTree0.json");
        new BinaryTreeNode("/binTree0.json").print();
        new BinaryTreeNode("/binTree1.json").print();
    }
}
