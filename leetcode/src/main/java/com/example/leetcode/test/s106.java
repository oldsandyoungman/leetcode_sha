package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s106 {

    public static void main(String[] args) {

    }

//    根据一棵树的中序遍历与后序遍历构造二叉树。

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

    }

    public TreeNode build(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {

        if(instart>inend){
            return null;
        }

        int rootval = postorder[postend];

        TreeNode root = new TreeNode(rootval);

        int index = instart;
        while (inorder[index]!=rootval) {
            index++;
        }
        int len = index - instart;

        root.left = build(inorder, instart, index-1, postorder, poststart, poststart+len-1);
        root.right = build(inorder, index+1, inend, postorder, poststart+len, postend-1);

        return root;

    }

}
