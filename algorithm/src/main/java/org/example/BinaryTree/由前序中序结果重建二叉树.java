package org.example.BinaryTree;

import java.util.HashMap;

public class 由前序中序结果重建二叉树 {
    static HashMap<Integer, Integer> inorderMap = new HashMap<>();
    static int[] preorderHolder;

    /**
     * 前序遍历的第一个节点就是根。
     * 中序遍历中通过根 区分哪些是左子树的，哪些是右子树的。
     */
    static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        preorderHolder = preorder;
        inorderMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            // 中序值所对应的序号
            inorderMap.put(inorder[i], i);
        }
        return recurBuild(0, 0, inorder.length - 1);
    }

    static BinaryTreeNode recurBuild(int preIndex, int inLeftIndex, int inRightIndex) {
        // 相等就是自己
        if (inLeftIndex > inRightIndex) return null;

        // 先序值
        BinaryTreeNode root = new BinaryTreeNode(preorderHolder[preIndex]);
        // 根据先序值，获取在中序中的位置
        int inIndex = inorderMap.get(preorderHolder[preIndex]);

        // 左根结点为(preIndex + 1)
        // 左半部分在中序的[inLeftIndex, inIndex - 1]内
        root.left = recurBuild(preIndex + 1, inLeftIndex, inIndex - 1);

        // 右根结点为 = 当前根节点 + 左子树的数量 - 1
        // 左子树的数量 = inIndex - inLeftIndex
        // 右半部分在中序的[inIndex + 1, inRightIndex)]内
        root.right = recurBuild(preIndex + (inIndex - inLeftIndex) + 1, inIndex + 1, inRightIndex);
        return root;
    }

    public static void main(String[] args) {
        final int[] preorder1 = {3, 9, 8, 5, 4, 10, 20, 15, 7};
        final int[] inorder1 = {4, 5, 8, 10, 9, 3, 15, 20, 7};
        buildTree(preorder1, inorder1).print();
        /* ------------------
         *         3
         *        / \
         *       9  20
         *      /  /  \
         *     8  15   7
         *    / \
         *   5  10
         *  /
         * 4
         * ------------------ */

        final int[] preorder2 = {3, 9, 2, 1, 7};
        final int[] inorder2 = {9, 3, 1, 2, 7};
        buildTree(preorder2, inorder2).print();
        /* ------------------
         *         3
         *        / \
         *       9   2
         *         /  \
         *         1   7
         * ------------------ */
    }
}
