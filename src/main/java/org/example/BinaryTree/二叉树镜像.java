package org.example.BinaryTree;

public class 二叉树镜像 {
    static BinaryTreeNode mirrorTree(BinaryTreeNode root) {
        if (null == root) return null;

        BinaryTreeNode dump = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = dump;
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree2 = new BinaryTreeNode("/binTree2.json");
        tree2.print();
        mirrorTree(tree2).print();

        BinaryTreeNode tree3 = new BinaryTreeNode("/binTree3.json");
        tree3.print();
        mirrorTree(tree3).print();
    }
}
