package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s199 {
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

        System.out.println(rightSideView(a));

    }

//    给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

//    public static List<Integer> rightSideView(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if (root==null){
//            return list;
//        }
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while (!q.isEmpty()){
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode cur = q.poll();
//                if (i==n-1){
//                    list.add(cur.val);
//                }
//                if (cur.left!=null) {
//                    q.offer(cur.left);
//                }
//                if (cur.right!=null) {
//                    q.offer(cur.right);
//                }
//            }
//        }
//        return list;
//    }

    public static List<Integer> res;
    public static List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        traverse(root,0);
        return res;
    }
    public static void traverse(TreeNode root, int depth){
        if (root==null) {
            return;
        }
        if(depth==res.size()){
            res.add(root.val);
        }
        depth++;
        traverse(root.right,depth);
        traverse(root.left,depth);

    }

}
