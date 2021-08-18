package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;
import com.example.leetcode.bean_sha.TreeNode;

import java.util.*;

public class s2227 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
//        e.left = h;
//        e.right = i;

//        System.out.println(Arrays.toString(listOfDepth(a)));
        System.out.println();

        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        int oldestKey = cache.keySet().iterator().next();
        System.out.println(oldestKey);
        System.out.println(oldestKey);
        System.out.println(oldestKey);

//        HashMap<Integer, LinkedHashSet<Integer>> kk = new HashMap<>();
//        kk.putIfAbsent()


    }

//    实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。



    public static boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(traverse(root.left) - traverse(root.right))<1);
    }

    public static int traverse(TreeNode root){
        if (root==null){
            return 0;
        }
        return Math.max(traverse(root.left),traverse(root.right));

    }
}
