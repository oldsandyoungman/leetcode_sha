package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s129 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(-2);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(-4);
        TreeNode e = new TreeNode(-5);
        TreeNode f = new TreeNode(-6);
        TreeNode g = new TreeNode(-7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;

        System.out.println(sumNumbers(a));

    }

//    给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
//    每条从根节点到叶节点的路径都代表一个数字：
//
//    例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
//    计算从根节点到叶节点生成的 所有数字之和 。
//
//    叶节点 是指没有子节点的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int sumNumbers(TreeNode root) {
        traverse(root,0);
        return res;
    }

    public static int res = 0;

    public static void traverse(TreeNode root, int now){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null){
            res += 10*now + root.val;
            return;
        }

        traverse(root.left, 10*now + root.val);
        traverse(root.right, 10*now + root.val);

    }

}
