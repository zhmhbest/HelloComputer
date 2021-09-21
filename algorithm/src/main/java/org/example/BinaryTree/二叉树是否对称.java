package org.example.BinaryTree;

import org.example.EasyAssert;

public class 二叉树是否对称 {
    static boolean recurSymmetricCheck(BinaryTreeNode l, BinaryTreeNode r) {
        int numAvailable = (null == l ? 0 : 1) + (null == r ? 0 : 1);
        if (0 == numAvailable) return true;
        if (1 == numAvailable || l.val != r.val) return false;
        return recurSymmetricCheck(l.left, r.right) && recurSymmetricCheck(l.right, r.left);
    }
    static boolean isSymmetric(BinaryTreeNode root) {
        if (null == root) return true;
        return recurSymmetricCheck(root.left, root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode symmetricTree0 = new BinaryTreeNode("/binSymmetricTree0.json");
        symmetricTree0.print();
        EasyAssert.AssertEqual(true, isSymmetric(symmetricTree0));

        BinaryTreeNode symmetricTree1 = new BinaryTreeNode("/binSymmetricTree1.json");
        symmetricTree1.print();
        EasyAssert.AssertEqual(true, isSymmetric(symmetricTree1));

        BinaryTreeNode tree0 = new BinaryTreeNode("/binTree0.json");
        tree0.print();
        EasyAssert.AssertEqual(false, isSymmetric(tree0));

        BinaryTreeNode tree5 = new BinaryTreeNode("/binTree5.json");
        tree5.print();
        EasyAssert.AssertEqual(false, isSymmetric(tree5));

        System.out.println("OK");
    }
}
