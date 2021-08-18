package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s94 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = d;
//        c.left = d;
//        c.right = e;

        List<Integer> integers = inorderTraversal(null);
        System.out.println(integers);

    }

//    给定一个二叉树的根节点 root ，返回它的 中序 遍历。

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        StringBuilder sb = new StringBuilder();
//        traverse(root, sb);
//        String[] split = sb.toString().split(SEP);
//        List<Integer> res = new ArrayList<>();
//        for (String s : split) {
//            if (!s.equals(NULL)) {
//                res.add(Integer.parseInt(s));
//            }
//        }
//
//        return res;
//
//    }
//
//    public static String NULL = "null";
//    public static String SEP = ",";
//
//    public static void traverse(TreeNode root, StringBuilder sb){
//
//        if (root==null) {
//            sb.append(NULL);
//            return;
//        }
//
//        traverse(root.left, sb);
//
//        sb.append(SEP).append(root.val).append(SEP);
//
//        traverse(root.right, sb);
//
////        sb.append(SEP);
//    }



    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;

    }

    public static void traverse(TreeNode root, List<Integer> list){

        if (root==null) {
            return;
        }

        traverse(root.left, list);

        list.add(root.val);

        traverse(root.right, list);

    }

}
