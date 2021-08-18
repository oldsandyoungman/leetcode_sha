package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s113 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(pathSum(a, 7));
    }

//    给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

    public static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<Integer> list = new ArrayList<>();

        traverse(root, targetSum, list);
        return res;
    }

    public static void traverse(TreeNode root, int targetSum, List<Integer> list){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null){
            if (targetSum==root.val) {
                list.add(root.val);
                List<Integer> now = new ArrayList<>(list);
                res.add(now);
                list.remove(list.size()-1);
                return;
            }
        }
        list.add(root.val);
        traverse(root.left, targetSum-root.val, list);
//        list.remove(list.size()-1);
        traverse(root.right, targetSum-root.val, list);
        list.remove(list.size()-1);

    }

}
