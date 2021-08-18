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


}
