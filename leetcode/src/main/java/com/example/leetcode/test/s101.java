package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class s101 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(2);

        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        c.left = f;
//        c.right =g;
//        c.left = d;
//        c.right = e;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(isSymmetric(a));
    }

//    给定一个二叉树，检查它是否是镜像对称的。

//    public static boolean isSymmetric(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//
//        Queue<TreeNode> p = new LinkedList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        p.offer(root.left);
//        q.offer(root.right);
//
//        while (!p.isEmpty()){
//            if(q.isEmpty()){
//                return false;
//            }
//
//            TreeNode curp = p.poll();
//            TreeNode curq = q.poll();
//
//            if (curp==null){
//                if(curq!=null){
//                    return false;
//                }else {
//                    continue;
//                }
//            }
//
//            if (curq==null) {
//                return false;
//            }
//
//            if(curp.val!=curq.val){
//                return false;
//            }
//            p.offer(curp.left);
//            p.offer(curp.right);
//            q.offer(curq.right);
//            q.offer(curq.left);
//
//        }
//
//        return q.isEmpty();
//
//
//    }







//    public static boolean isSymmetric(TreeNode root) {
//        if (root==null) {
//            return true;
//        }
//        return traverse(root.left, root.right);
//    }
//
//    public static boolean traverse(TreeNode left, TreeNode right){
//
//        if (left==null && right==null){
//            return true;
//        }
//        if (left==null || right==null){
//            return false;
//        }
//        if (left.val!=right.val) {
//            return false;
//        }
//
//        return traverse(left.left, right.right) && traverse(left.right, right.left);
//
//    }

    public static boolean isSymmetric(TreeNode root) {
        if (root==null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()){
            TreeNode first = q.poll();
            TreeNode second = q.poll();

            if(first==null && second==null){
                continue;
            }
            if (first==null || second==null) {
                return false;
            }
            if (first.val != second.val) {
                return false;
            }

            q.offer(first.left);
            q.offer(second.right);
            q.offer(first.right);
            q.offer(second.left);
        }

        return true;

    }

}
