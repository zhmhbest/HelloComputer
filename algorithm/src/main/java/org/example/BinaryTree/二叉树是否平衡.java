package org.example.BinaryTree;

import org.example.EasyAssert;

public class 二叉树是否平衡 {
    static int treeDepth(BinaryTreeNode node) {
        if (null == node) return 0;
        int ld = treeDepth(node.left);
        int rd = treeDepth(node.right);
        if (ld < 0 || rd < 0 || Math.abs(rd - ld) > 1) return -1;
        return 1 + Math.max(ld, rd);
    }

    static boolean isBalanced(BinaryTreeNode root) {
        return -1 != treeDepth(root);
    }

    public static void main(String[] args) {
        BinaryTreeNode balancedTree0 = new BinaryTreeNode("/binBalancedTree0.json");
        balancedTree0.print();
        EasyAssert.AssertEqual(true, isBalanced(balancedTree0));

        BinaryTreeNode tree6 = new BinaryTreeNode("/binTree6.json");
        tree6.print();
        EasyAssert.AssertEqual(false, isBalanced(tree6));
        System.out.println("OK");
    }
}
