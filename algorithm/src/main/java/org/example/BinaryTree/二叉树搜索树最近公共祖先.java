package org.example.BinaryTree;

import org.example.EasyAssert;

public class 二叉树搜索树最近公共祖先 {
    static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        BinaryTreeNode ancestor = root;
        // 二分查找
        for (; ; ) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                // p,q 在当前结点左侧
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                // p,q 在当前结点右侧
                ancestor = ancestor.right;
            } else {
                // 一左一右
                break;
            }
        }
        return ancestor;
    }

    public static void main(String[] args) {
        BinaryTreeNode searchTree0 = new BinaryTreeNode("/binSearchTree0.json");
        searchTree0.print();

        BinaryTreeNode p, q, r;
        p = searchTree0.left;
        q = searchTree0.right;
        r = lowestCommonAncestor(searchTree0, p, q);
        System.out.printf("(%d, %d) => %d\n", p.val, q.val, r.val);
        EasyAssert.AssertEqual(5, r.val);

        p = searchTree0.left.left;
        q = searchTree0.left.right;
        r = lowestCommonAncestor(searchTree0, p, q);
        System.out.printf("(%d, %d) => %d\n", p.val, q.val, r.val);
        EasyAssert.AssertEqual(3, r.val);

        p = searchTree0.left.left.left;
        q = searchTree0.left.right;
        r = lowestCommonAncestor(searchTree0, p, q);
        System.out.printf("(%d, %d) => %d\n", p.val, q.val, r.val);
        EasyAssert.AssertEqual(3, r.val);

        p = searchTree0.left.left.left;
        q = searchTree0.right;
        r = lowestCommonAncestor(searchTree0, p, q);
        System.out.printf("(%d, %d) => %d\n", p.val, q.val, r.val);
        EasyAssert.AssertEqual(5, r.val);
    }
}
