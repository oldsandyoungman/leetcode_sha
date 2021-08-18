package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class s110 {

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
        d.left = f;
        d.right =g;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(isBalanced(a));
    }

//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//    本题中，一棵高度平衡二叉树定义为：

//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

//    public static boolean isBalanced(TreeNode root) {
//
//        length(root);
//        return traverse(root);
//
//    }
//
//    public static boolean traverse(TreeNode root){
//        if (root==null) {
//            return true;
//        }
//        int left = map.getOrDefault(root.left,0);
//
//        int right = map.getOrDefault(root.right,0);
//
//        return traverse(root.left) && traverse(root.right) && Math.abs(right-left)<=1;
//
//    }
//
//    public static Map<TreeNode, Integer> map = new HashMap<>();
//
//    public static int length(TreeNode root){
//        if (root==null) {
//            return 0;
//        }
//        if (map.containsKey(root)){
//            return map.get(root);
//        }else {
//            int res = Math.max(length(root.left),length(root.right))+1;
//            map.put(root,res);
//            return res;
//        }
//
//    }


    public static boolean isBalanced(TreeNode root) {
        if (traverse(root)==-1){
            return false;
        }else {
            return true;
        }
    }


    private static int traverse(TreeNode root) {

        if (root==null) {
            return 0;
        }
        int left = traverse(root.left);
        if (left==-1){
            return -1;
        }
        int right = traverse(root.right);
        if (right==-1){
            return -1;
        }
        if (Math.abs(right-left)<=1){
            return Math.max(left, right)+1;
        }else {
            return -1;
        }


    }

}
