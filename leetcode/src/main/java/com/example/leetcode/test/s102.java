package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s102 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right =g;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(levelOrder(a));
    }

//    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

//    public static List<List<Integer>> levelOrder(TreeNode root) {
////        List<Integer> a = new ArrayList<Integer>();
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> tmp = new ArrayList<>();
//        if (root==null){
//            return res;
//        }
//        Queue<TreeNode> q = new LinkedList<>();
//        Queue<Integer> num = new LinkedList<>();
//        q.offer(root);
//        num.offer(1);
//
//        int pre = 1;
//
//        while (!q.isEmpty()){
//
//            TreeNode cur = q.poll();
//            int cur_num = num.poll();
//
//            if(cur_num!=pre){
//                res.add(tmp);
//                pre = cur_num;
//                tmp = new ArrayList<>();
//            }
//
//            tmp.add(cur.val);
//
//            if (cur.left!=null) {
//                q.offer(cur.left);
//                num.offer(cur_num+1);
//            }
//            if (cur.right!=null) {
//                q.offer(cur.right);
//                num.offer(cur_num+1);
//            }
//
//
//        }
//
//        res.add(tmp);
//
//
//        return res;
//
//
//
//
//    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root==null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){

            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left!=null) {
                    q.offer(cur.left);
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                }
            }
            list.add(tmp);
        }

        return list;

    }

}
