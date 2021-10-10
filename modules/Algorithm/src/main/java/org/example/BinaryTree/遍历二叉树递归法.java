package org.example.BinaryTree;

import org.example.EasyAssert;

import java.util.LinkedList;
import java.util.List;

public class 遍历二叉树递归法 {
    /**
     * 前序遍历（递归法）
     */
    static List<Integer> preorderTraversal(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        preorderTraversalRecursion(holder, root);
        return holder;
    }

    static void preorderTraversalRecursion(List<Integer> holder, BinaryTreeNode node) {
        if (null == node) return;
        holder.add(node.val);
        preorderTraversalRecursion(holder, node.left);
        preorderTraversalRecursion(holder, node.right);
    }


    /**
     * 中序遍历（递归法）
     */
    static List<Integer> inorderTraversal(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        inorderTraversalRecursion(holder, root);
        return holder;
    }

    static void inorderTraversalRecursion(List<Integer> holder, BinaryTreeNode node) {
        if (null == node) return;
        inorderTraversalRecursion(holder, node.left);
        holder.add(node.val);
        inorderTraversalRecursion(holder, node.right);
    }


    /**
     * 后序遍历（递归法）
     */
    static List<Integer> postorderTraversal(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        postorderTraversalRecursion(holder, root);
        return holder;
    }

    static void postorderTraversalRecursion(List<Integer> holder, BinaryTreeNode node) {
        if (null == node) return;
        postorderTraversalRecursion(holder, node.left);
        postorderTraversalRecursion(holder, node.right);
        holder.add(node.val);
    }


    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree2.json");
        tree.print();
        List<Integer> r;

        r = preorderTraversal(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{0, 1, 7, 9, 8, 5, 6, 3, 2});

        r = inorderTraversal(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{9, 7, 8, 1, 6, 5, 0, 3, 2});

        r = postorderTraversal(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{9, 8, 7, 6, 5, 1, 2, 3, 0});
    }
}
