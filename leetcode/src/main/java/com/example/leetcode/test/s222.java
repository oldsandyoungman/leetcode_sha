package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class s222 {
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
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right = g;

//        System.out.println(countNodes(a));

        System.out.println(1<<2);
    }

//    给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

    public static int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }

        int left = countlevel(root.left);
        int right = countlevel(root.right);

        if (left==right){
            return countNodes(root.right) + (1<<left);
        }else {
            return countNodes(root.left) + (1<<right);
        }



    }

    public static int countlevel(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(countlevel(root.left),countlevel(root.right))+1;
    }



//    public static int countNodes(TreeNode root) {
//        if (root==null){
//            return 0;
//        }
//        int sum = 0;
//        int h =0;
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while (!q.isEmpty()){
//            h++;
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode cur = q.poll();
//                if (sum==0) {
//                    if (cur.left==null || cur.right==null){
//                        sum = (int) (Math.pow(2,h) - 1);
//                    }
//                }
//                if (cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if (cur.right!=null){
//                    q.offer(cur.right);
//                }
//
//            }
//            if (sum>0){
//                sum += q.size();
//                return sum;
//            }
//
//        }
//
//
//        return 0;
//
//
//    }


}


