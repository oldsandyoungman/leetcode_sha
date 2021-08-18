package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s100 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = d;
//        c.left = d;
//        c.right = e;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(isSameTree(a,b));
    }

//    给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        return traverse(p,q);

    }

    public static boolean traverse(TreeNode p, TreeNode q){
        if (q==null && p==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        if (p.val!=q.val) {
            return false;
        }

        boolean left = traverse(p.left, q.left);

        boolean right = traverse(p.right, q.right);

        return left && right;
    }

}
