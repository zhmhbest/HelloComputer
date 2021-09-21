package org.example.BinaryTree;

import org.example.EasyAssert;

public class 二叉树最近公共祖先 {
    static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        // 当前结点是否含为所搜索子结点
        if (null == root || p == root || q == root) return root;

        BinaryTreeNode l = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode r = lowestCommonAncestor(root.right, p, q);

        // 当前结点其子节点是否含有所搜索结点
        // 1.有一为null，则在另一侧
        // 2.均不为null，则为当前临时根
        switch((l == null ? 0 : 1) + (r == null ? 0 : 2)) {
            case 1: return l;
            case 2: return r;
            case 3: return root;
            default: return null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode tree4 = new BinaryTreeNode("/binTree4.json");
        tree4.print();
        EasyAssert.AssertEqual(3, lowestCommonAncestor(tree4, tree4.left, tree4.right).val);
        EasyAssert.AssertEqual(5, lowestCommonAncestor(tree4, tree4.left.left, tree4.left.right).val);
        System.out.println("OK");
    }
}
