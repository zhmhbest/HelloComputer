package org.example.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树路径和 {
    static LinkedList<List<Integer>> resHolder = new LinkedList<>();
    static LinkedList<Integer> memPath = new LinkedList<>();
    static int targetScore = 0;

    static void recurPath(BinaryTreeNode node, int accScore) {
        if (node == null) return;
        memPath.add(node.val);
        accScore += node.val;
        if (null == node.left && null == node.right) {
            if (accScore == targetScore) {
                List<Integer> dump = new ArrayList<>(memPath.size());
                dump.addAll(memPath);
                resHolder.add(dump);
            }
        }
        recurPath(node.left, accScore);
        recurPath(node.right, accScore);
        memPath.removeLast();
    }

    static List<List<Integer>> pathSum(BinaryTreeNode root, int target) {
        resHolder.clear();
        memPath.clear();
        targetScore = target;
        //
        recurPath(root, 0);
        return resHolder;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree7.json");
        tree.print();
        System.out.println(pathSum(tree, 22));
    }
}
