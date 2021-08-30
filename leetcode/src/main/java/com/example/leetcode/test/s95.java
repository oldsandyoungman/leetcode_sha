package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s95 {

    public static void main(String[] args) {

    }

//    给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

//    public static List<TreeNode> generateTrees(int n) {
//        return build(1,n);
//    }
//
////    public static List<TreeNode> sum = new ArrayList<>();
//
//    public static List<TreeNode> build(int lo, int hi){
//        List<TreeNode> res = new ArrayList<>();
//
//        if (lo>hi) {
//            res.add(null);
//            return res;
//        }
//
//        for (int i = lo; i <= hi; i++) {
//
//            List<TreeNode> left = build(lo, i-1);
//            List<TreeNode> right = build(i+1, hi);
//
//            for (TreeNode lefttreeNode : left) {
//                for (TreeNode righttreenode : right) {
//
//                    TreeNode root = new TreeNode(i);
//                    root.left = lefttreeNode;
//                    root.right = righttreenode;
//                    res.add(root);
//                }
//            }
//        }
//
//        return res;
//
//    }

    public static List<TreeNode> generateTrees(int n) {
        return build(1,n);
    }

    public static List<TreeNode> build(int lo, int hi){
        List<TreeNode> res = new ArrayList<>();
        if (lo>hi) {
            return res;
        }

        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = build(lo, i-1);
            List<TreeNode> right = build(i+1, hi);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }

        return res;



    }


}
