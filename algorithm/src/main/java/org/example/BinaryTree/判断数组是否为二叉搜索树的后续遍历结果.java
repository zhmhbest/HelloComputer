package org.example.BinaryTree;

import org.example.EasyAssert;

import java.util.Stack;

public class 判断数组是否为二叉搜索树的后续遍历结果 {

    /**
     * 递归分治
     */
    static boolean verifyPostorder(int[] postorder) {
        return recurVerify(postorder, 0, postorder.length - 1);
    }
    static boolean recurVerify(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recurVerify(postorder, i, m - 1) && recurVerify(postorder, m, j - 1);
    }

    /**
     * 辅助单调栈
     * 仅凭后续遍历结果无法确定一颗二叉树
     * 后续遍历：左 右 根
     * 后续遍历倒序：根 右 左
     */
    static boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE; // 右上虚挂一个无穷大结点
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 当前结点在当前根左侧？
            if (postorder[i] > root) return false;

            // 栈顶大于当前元素？
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop(); // 从右侧退出，寻找左侧的父节点
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        /*
         *      5
         *     / \
         *    2   6
         *   / \
         *  1   3
         */
        final int[] data1 = {1, 6, 3, 2, 5};
        final int[] data2 = {1, 3, 2, 6, 5};

        EasyAssert.AssertEqual(false, verifyPostorder(data1));
        EasyAssert.AssertEqual(true, verifyPostorder(data2));

        EasyAssert.AssertEqual(false, verifyPostorder2(data1));
        EasyAssert.AssertEqual(true, verifyPostorder2(data2));
        System.out.println("OK");
    }
}
