package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class S226 {

    public static void main(String[] args) {

    }

//    翻转一棵二叉树。

    public static TreeNode invertTree(TreeNode root) {

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

}
