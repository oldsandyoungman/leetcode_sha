package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s1373 {

    public static void main(String[] args) {

    }

//    给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
//
//    二叉搜索树的定义如下：
//
//    任意节点的左子树中的键值都 小于 此节点的键值。
//    任意节点的右子树中的键值都 大于 此节点的键值。
//    任意节点的左子树和右子树都是二叉搜索树。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static int maxSumBST(TreeNode root) {
        traverse(root);
        return max_res;
    }



    public static int max_res = 0;

    /**
     *
     * @param root 输入的根节点
     * @return int[4]
     *          int[0]：1代表是BST，0代表不是BST
     *          int[1]：以root为根节点的子树中的最小值
     *          int[2]：以root为根节点的子树中的最大值
     *          int[3]：以root为根节点的子树中的键值和
     */

    public static int[] traverse(TreeNode root){

        if (root==null){
            return new int[]{1,Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        if (left[0] == 1 && right[0]==1 && root.val>left[2] && root.val<right[1]) {
            int temp = left[3]+right[3]+ root.val;
            max_res = Math.max(max_res, temp);
            int new_max = Math.max(right[2], root.val);
            int new_min = Math.min(left[1], root.val);
            return new int[]{1,new_min, new_max, temp};
        }else {
            return new int[]{0,Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }


    }



}
