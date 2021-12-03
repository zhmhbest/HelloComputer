package org.example.BinaryTree;

public class 一棵树是否为另一颗的子结构 {
    static boolean isSubStructure(BinaryTreeNode A, BinaryTreeNode B) {
        return (
                A != null && B != null
        ) && (
                recurSubCheck(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)
        );
    }

    static boolean recurSubCheck(BinaryTreeNode A, BinaryTreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recurSubCheck(A.left, B.left) && recurSubCheck(A.right, B.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode tree0 = new BinaryTreeNode("/binTree0.json");
        tree0.print();
        BinaryTreeNode tree1 = new BinaryTreeNode("/binTree1.json");
        tree1.print();

        System.out.println(isSubStructure(tree1, tree0));
    }
}
