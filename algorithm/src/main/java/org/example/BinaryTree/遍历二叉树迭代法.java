package org.example.BinaryTree;

import org.example.EasyAssert;
import java.util.LinkedList;
import java.util.List;

public class 遍历二叉树迭代法 {
    /**
     * 前序遍历（迭代法）
     */
    static List<Integer> preorderTraversalIterative(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();

        BinaryTreeNode node = root;
        while (!stack.isEmpty() || null != node) {
            while (null != node) {
                holder.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return holder;
    }

    /**
     * 中序遍历（迭代法）
     */
    static List<Integer> inorderTraversalIterative(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            holder.add(root.val);
            root = root.right;
        }
        return holder;
    }

    /**
     * 后序遍历（迭代法）
     */
    static List<Integer> postorderTraversalIterative(BinaryTreeNode root) {
        LinkedList<Integer> holder = new LinkedList<>();
        if (root == null) return holder;
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        BinaryTreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                holder.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return holder;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree2.json");
        tree.print();
        List<Integer> r;

        r = preorderTraversalIterative(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{0, 1, 7, 9, 8, 5, 6, 3, 2});

        r = inorderTraversalIterative(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{9, 7, 8, 1, 6, 5, 0, 3, 2});

        r = postorderTraversalIterative(tree);
        System.out.println(r);
        EasyAssert.AssertEqual(r, new int[]{9, 8, 7, 6, 5, 1, 2, 3, 0});
    }
}
