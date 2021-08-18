package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s144 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(-2);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(-4);
        TreeNode e = new TreeNode(-5);
        TreeNode f = new TreeNode(-6);
        TreeNode g = new TreeNode(-7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;

        System.out.println(preorderTraversal(a));
    }

//    给你二叉树的根节点 root ，返回它节点值的 前序 遍历。

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }


    public static void traverse(TreeNode root, List<Integer> res){
        if (root==null) {
            return;
        }
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }

}
