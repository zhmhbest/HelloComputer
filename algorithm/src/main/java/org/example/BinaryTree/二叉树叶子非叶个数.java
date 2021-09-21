package org.example.BinaryTree;

public class 二叉树叶子非叶个数 {
    static int getLeafCount(BinaryTreeNode node) {
        if (null == node) return 0;
        if (null == node.left && null == node.right) return 1;
        return getLeafCount(node.left) + getLeafCount(node.right);
    }

    static int getNotLeafCount(BinaryTreeNode node) {
        if (null == node) return 0;
        if (null == node.left && null == node.right) return 0;
        return 1 + getNotLeafCount(node.left) + getNotLeafCount(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode tree2 = new BinaryTreeNode("/binTree2.json");
        tree2.print();
        System.out.println(getLeafCount(tree2));
        System.out.println(getNotLeafCount(tree2));

        BinaryTreeNode tree1 = new BinaryTreeNode("/binTree1.json");
        tree1.print();
        System.out.println(getLeafCount(tree1));
        System.out.println(getNotLeafCount(tree1));
    }
}
