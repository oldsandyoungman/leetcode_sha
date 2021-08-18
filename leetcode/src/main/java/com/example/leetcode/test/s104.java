package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s104 {

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
        System.out.println(maxDepth(a));
        System.out.println("[[0], [4, 2], [1, 3, -1], [8, 6, 1, 5]]");
    }

//    给定一个二叉树，找出其最大深度。
//
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
//    说明: 叶子节点是指没有子节点的节点。

    public static int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));

    }

}
