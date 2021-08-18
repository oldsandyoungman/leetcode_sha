package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s257 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
//        e.left = h;
//        e.right = i;

        System.out.println(binaryTreePaths(a));
    }

//    给定一个二叉树，返回所有从根节点到叶子节点的路径。

    public static List<String> list;

    public static List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if (root==null){
            return list;
        }
        List<Integer> path = new ArrayList<>();
        traverse(root, path);
        return list;
    }

    public static void traverse(TreeNode root, List<Integer> path){
        if (root==null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i!=path.size()-1){
                    sb.append("->");
                }
            }
            list.add(sb.toString());
            return;
        }

        path.add(root.val);

        traverse(root.left, path);

//        path.remove(path.size()-1);

        traverse(root.right, path);

        path.remove(path.size()-1);

    }
}
