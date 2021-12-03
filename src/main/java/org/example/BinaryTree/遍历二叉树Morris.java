package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 遍历二叉树Morris {

    static List<Integer> preorderTraversalMorris(BinaryTreeNode root) {
        List<Integer> holder = new ArrayList<>();
        if (root == null) return holder;

        BinaryTreeNode p1 = root, p2;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    holder.add(p1.val);
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                }
            } else {
                holder.add(p1.val);
            }
            p1 = p1.right;
        }
        return holder;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree1.json");
        tree.print();
        System.out.println(preorderTraversalMorris(tree));
        // System.out.println(inorderTraversalIterative(tree));
        // System.out.println(postorderTraversalIterative(tree));
    }
}
