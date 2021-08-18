package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s235 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(lowestCommonAncestor(a,d,a));

//        System.out.println(1<<2);
    }

//    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//    例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
//
//
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val>q.val){
            return traverse(root, q, p);
        }else {
            return traverse(root, p, q);
        }

    }

    public static TreeNode traverse(TreeNode root, TreeNode left, TreeNode right){
        if (root==null) {
            return null;
        }

        if (root.val>=left.val && root.val<=right.val){
            return root;
        } else if (root.val>right.val) {
            return traverse(root.left, left, right);
        } else {
            return traverse(root.right, left, right);
        }

    }

}
