package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class s111 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
//        a.right = c;
        b.left = d;
//        b.right = e;
        d.left = f;
//        d.right =g;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(minDepth(a));
        System.out.println(minDepth2(a));
    }

//    给定一个二叉树，找出其最小深度。
//
//    最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//    说明：叶子节点是指没有子节点的节点。

//    public static int minDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        }
//        if (root.left==null && root.right==null) {
//            return 1;
//        }
//        if (root.left==null) {
//            return minDepth(root.right)+1;
//        }
//        if (root.right==null) {
//            return minDepth(root.left)+1;
//        }
//        return Math.min(minDepth(root.left),minDepth(root.right))+1;
//    }


//    public static int minDepth(TreeNode root) {
//        if (root==null) {
//            return 0;
//        }
//
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        int depth = 1;
//
//        while (!q.isEmpty()){
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                TreeNode tmp = q.poll();
//                if (tmp.left==null && tmp.right==null) {
//                    return depth;
//                }
//                if (tmp.left!=null){
//                    q.offer(tmp.left);
//                }
//                if (tmp.right!=null){
//                    q.offer(tmp.right);
//                }
//            }
//            depth++;
//
//        }
//        return depth;
//
//    }


    public static int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                assert cur != null;
                if (cur.left==null && cur.right==null){
                    return depth;
                }
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }



    public static int minDepth2(TreeNode root) {
        if (root==null) {
            return 0;
        }

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int dep = 1;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode now = q.poll();
                assert now != null;
                if (now.left==null && now.right==null){
                    return dep;
                }
                if (now.left!=null){
                    q.offer(now.left);
                }
                if (now.right!=null){
                    q.offer(now.right);
                }
            }
            dep++;
        }
        return dep;
    }


}
