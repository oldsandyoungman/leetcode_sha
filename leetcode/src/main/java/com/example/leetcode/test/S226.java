package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class S226 {

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
        c.right = g;

        System.out.println(invertTree(a));


    }

//    翻转一棵二叉树。

    public static TreeNode invertTree2(TreeNode root) {

        if(root==null){
            return null;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);


        return root;
    }



    public static TreeNode invertTree(TreeNode root) {

        if (root==null) {
            return null;
        }

        TreeNode new_left = invertTree(root.left);

        root.left = invertTree(root.right);
        root.right = new_left;

        return root;
    }

}
