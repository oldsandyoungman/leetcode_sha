package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s230 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(4);
//        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = d;
//        c.left = d;
//        c.right = e;

        System.out.println(kthSmallest(a,2));
    }

//    给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。


//    public static int kthSmallest(TreeNode root, int k) {
//
//        traverse(root, k);
//        return res;
//
//    }
//
//    public static int rank = 0;
//    public static int res;
//
//    public static void traverse(TreeNode root, int k){
//
//        if (root==null) {
//            return;
//        }
//
//        traverse(root.left, k);
//
//        rank++;
//        if (rank==k) {
//            res = root.val;
//        }
//
//        traverse(root.right, k);
//
//    }


    public static int kthSmallest(TreeNode root, int k) {

        traverse(root,k);
        return res;

    }

    public static int rank;
    public static int res;

    public static void traverse(TreeNode root, int k){
        if (root==null){
            return;
        }
        traverse(root.left, k);

        rank++;

        if (rank==k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);



    }



}
