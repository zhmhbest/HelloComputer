package org.example.BinaryTree;

public class 二叉树深度 {
    static int getTreeDepth(BinaryTreeNode node) {
        if (null == node) return 0;
        return (
                1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right))
        );
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree2.json");
        tree.print();
        System.out.println(getTreeDepth(tree));
    }
}
