package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s112 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

//        a.left = b;
//        a.right = c;
//        b.left = d;
//        b.right = e;
//        d.left = f;
//        d.right =g;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(hasPathSum(a, 1));
    }


//    给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
//
//    叶子节点 是指没有子节点的节点。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/path-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root==null) {
//            return false;
//        }
//        return traverse(root,targetSum);
//
//    }
//
//    public static boolean traverse(TreeNode root, int targetSum) {
//        if(targetSum==0 && root==null){
//            return true;
//        }
//        if (root==null){
//            return false;
//        }
//        return traverse(root.left, targetSum-root.val) || traverse(root.right, targetSum-root.val);
//    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


}
