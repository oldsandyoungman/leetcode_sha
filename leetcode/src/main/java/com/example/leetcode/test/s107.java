package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s107 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(-1);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(6);
        TreeNode j = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;

        c.left = e;
        c.right = f;

        d.left = g;
        d.right = h;

        e.right = i;
        f.right = j;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(levelOrderBottom(a));
        System.out.println("[[0], [4, 2], [1, 3, -1], [8, 6, 1, 5]]");
    }


//    给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left!=null){
                    q.add(cur.left);
                }
                if (cur.right!=null) {
                    q.add(cur.right);
                }
            }
            res.add(0,tmp);
        }
        return res;


    }

}
