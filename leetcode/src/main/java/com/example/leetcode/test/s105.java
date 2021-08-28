package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s105 {

    public static void main(String[] args) {

    }

//    给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    public TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {

        if (prestart>preend) {
            return null;
        }

        int rootval = preorder[prestart];

        TreeNode root = new TreeNode(rootval);

        int index = instart;
        while (inorder[index]!=rootval) {
            index++;
        }
        int len = index - instart;

        root.left = build(preorder, prestart+1, prestart+len, inorder, instart, index-1);
        root.right = build(preorder, prestart+len+1, preend, inorder, index+1, inend);

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {

        return traverse(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }

    public static TreeNode traverse(int[] preorder, int prelo, int prehi, int[] inorder, int inolo, int inohi){
        if (prelo>prehi) {
            return null;
        }
        int index = inolo;
        while (inorder[index]!=preorder[prelo]){
            index++;
        }

        int len = index - inolo;

        TreeNode root = new TreeNode(preorder[prelo]);
        root.left = traverse(preorder,prelo+1, prelo+len, inorder, inolo, index-1);
        root.right = traverse(preorder, prelo+len+1, prehi, inorder, index+1, inohi);
        return root;
    }




}
