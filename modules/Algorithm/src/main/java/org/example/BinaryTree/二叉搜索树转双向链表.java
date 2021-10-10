package org.example.BinaryTree;

public class 二叉搜索树转双向链表 {
    static BinaryTreeNode pre;
    static void inorderRecur(BinaryTreeNode node) {
        if(node == null) return;
        inorderRecur(node.left);
        {
            pre.right = node;
            node.left = pre;
            pre = node;
        }
        inorderRecur(node.right);
    }
    static BinaryTreeNode treeToDoublyList(BinaryTreeNode root) {
        if(root == null) return null;
        // 哨兵
        BinaryTreeNode head = new BinaryTreeNode();
        pre = head;
        inorderRecur(root);
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }

    public static void main(String[] args) {
        BinaryTreeNode searchTree0 = new BinaryTreeNode("/binSearchTree0.json");
        searchTree0.print();
        treeToDoublyList(searchTree0).printDblLinkedList();
    }
}
