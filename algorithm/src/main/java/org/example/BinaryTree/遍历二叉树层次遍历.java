package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 遍历二叉树层次遍历 {
    static List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> holder = new LinkedList<>();
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        if (null != root) {
            queue.offer(root);
            queue.offer(null);
        }
        List<Integer> line = new LinkedList<>();

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (null == node) {
                holder.add(line);
                line = new LinkedList<>();
                if (0 != queue.size()) queue.offer(null);
            } else {
                line.add(node.val);
                if (null != node.left) queue.offer(node.left);
                if (null != node.right) queue.offer(node.right);
            }
        }
        return holder;
    }

    static List<Integer> levelTraversal(BinaryTreeNode root) {
        List<Integer> holder = new LinkedList<>();
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        if (null != root) queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            holder.add(node.val);
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }
        // int[] buffer = new int[holder.size()];
        // for (int i = 0; i < holder.size(); i++) buffer[i] = holder.get(i);
        return holder;
    }

    /**
     * 之字形打印
     */
    static List<List<Integer>> levelZhiTraversal(BinaryTreeNode root) {
        List<List<Integer>> holder = new ArrayList<>();
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int layerIndex = 0;

        while (!queue.isEmpty()) {
            // 打印奇数层
            List<Integer> line = new ArrayList<>();
            layerIndex++;
            int layerLength = queue.size();
            while (0 != layerLength--) {
                if(1 == (layerIndex % 2)) {
                    // 从左向右打印
                    BinaryTreeNode node = queue.removeFirst();
                    line.add(node.val);
                    // 先左后右加入下层节点
                    if (null != node.left ) queue.addLast(node.left);
                    if (null != node.right) queue.addLast(node.right);
                } else {
                    // 从右向左打印
                    BinaryTreeNode node = queue.removeLast();
                    line.add(node.val);
                    // 先右后左加入下层节点
                    if (null != node.right) queue.addFirst(node.right);
                    if (null != node.left ) queue.addFirst(node.left);
                }
            }
            holder.add(line);
        }
        return holder;
    }

    public static void main(String[] args) {
        System.out.println(levelTraversal(null));
        System.out.println(levelOrder(null));
        System.out.println(levelZhiTraversal(null));

        BinaryTreeNode tree2 = new BinaryTreeNode("/binTree2.json");
        tree2.print();
        System.out.println(levelTraversal(tree2));
        System.out.println(levelOrder(tree2));
        System.out.println(levelZhiTraversal(tree2));

        BinaryTreeNode tree3 = new BinaryTreeNode("/binTree3.json");
        tree3.print();
        System.out.println(levelTraversal(tree3));;
        System.out.println(levelOrder(tree3));
        System.out.println(levelZhiTraversal(tree3));
    }
}
