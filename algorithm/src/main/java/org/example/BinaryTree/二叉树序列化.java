package org.example.BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 二叉树序列化 {
    /**
     * 序列化：带null层次遍历
     */
    static String serialize(BinaryTreeNode root) {
        // 空树
        if(root == null) return "[]";
        StringBuilder builder = new StringBuilder("[");
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if(node != null) {
                builder.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                builder.append("null,");
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    /**
     * 反序列化
     */
    static BinaryTreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        // 去除[]
        data = data.substring(1, data.length() - 1);
        String[] dataArray = data.split(",");

        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(dataArray[0]));
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if(!dataArray[i].equals("null")) {
                node.left = new BinaryTreeNode(Integer.parseInt(dataArray[i]));
                queue.add(node.left);
            }
            i++;
            if(!dataArray[i].equals("null")) {
                node.right = new BinaryTreeNode(Integer.parseInt(dataArray[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = new BinaryTreeNode("/binTree7.json");
        tree.print();

        String treeString = serialize(tree);
        System.out.println(treeString);
        deserialize(treeString).print();
    }
}
