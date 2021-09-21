package org.example.BinaryTree;

import org.example.EasyAssert;
import java.util.LinkedList;

public class 二叉搜索树第K大结点 {

    // 本质为第K次中序遍历

    /**
     * 第K大的元素
     * 中序遍历 + 循环队列
     */
    static int kthLargest(BinaryTreeNode root, final int k) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<>();
        int[] buffer = new int[k];
        int i = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            buffer[i] = root.val;
            i = (i + 1) % k;
            root = root.right;
        }
        return buffer[i];
    }

    public static void main(String[] args) {
        BinaryTreeNode searchTree0 = new BinaryTreeNode("/binSearchTree0.json");
        searchTree0.print();

        EasyAssert.AssertEqual(kthLargest(searchTree0, 3), 4);
        EasyAssert.AssertEqual(kthLargest(searchTree0, 2), 5);
        EasyAssert.AssertEqual(kthLargest(searchTree0, 1), 6);
        System.out.println("OK");
    }
}
