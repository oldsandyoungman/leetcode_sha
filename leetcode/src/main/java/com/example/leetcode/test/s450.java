package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s450 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(5);
        TreeNode g= new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(deleteNode(a, 4));


    }

//    给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//    一般来说，删除节点可分为两个步骤：
//
//    首先找到需要删除的节点；
//    如果找到了，删除它。
//    说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }

        if (root.val==key){
            if (root.left==null) {
                return root.right;
            }
            if ( root.right==null) {
                return root.left;
            }
            TreeNode rep = getMin(root.right);
            root.val = rep.val;
            root.right = deleteNode(root.right, rep.val);

        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private static TreeNode getMin(TreeNode root) {
        while (root.left!=null){
            root = root.left;
        }
        return root;
    }

//
//    public static TreeNode find_sha(TreeNode root, int key){
//        if (root==null) {
//            return null;
//        }
//        if (root.val==key){
//            return root;
//        } else if (root.val < key) {
//            return find_sha(root.right, key);
//        } else {
//            return find_sha(root.left, key);
//        }
//
//    }

}
