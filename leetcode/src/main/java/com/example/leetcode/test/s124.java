package com.example.leetcode.test;

import com.example.leetcode.bean_sha.Node;
import com.example.leetcode.bean_sha.TreeNode;

public class s124 {

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

//        System.out.println("Node{val=1, left=Node{val=2, left=Node{val=4, left=null, right=null, next=Node{val=5, left=null, right=null, next=Node{val=7, left=null, right=null, next=null}}}, right=Node{val=5, left=null, right=null, next=Node{val=7, left=null, right=null, next=null}}, next=Node{val=3, left=null, right=Node{val=7, left=null, right=null, next=null}, next=null}}, right=Node{val=3, left=null, right=Node{val=7, left=null, right=null, next=null}, next=null}, next=null}");
        System.out.println(maxPathSum(a));
    }

//    路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
//
//    路径和 是路径中各节点值的总和。
//
//    给你一个二叉树的根节点 root ，返回其 最大路径和 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static int max_sha = Integer.MIN_VALUE;
//    public static int maxPathSum(TreeNode root) {
//        traverse(root);
//        return max_sha;
//    }
//
//    public static int traverse(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int left = traverse(root.left);
//        int right = traverse(root.right);
//        max_sha = Math.max(max_sha, root.val + left + right);
//        return Math.max(0,root.val + Math.max(left, right));
//    }




    static int result = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    // 函数功能：返回当前节点能为父亲提供的贡献，需要结合上面的图来看！
    private static int dfs(TreeNode root) {
        // 如果当前节点为叶子节点，那么对父亲贡献为 0
        if(root == null) return 0;
        // 如果不是叶子节点，计算当前节点的左右孩子对自身的贡献left和right
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 更新最大值，就是当前节点的val 加上左右节点的贡献。
        result = Math.max(result, root.val + left + right);
        // 计算当前节点能为父亲提供的最大贡献，必须是把 val 加上！
        int max = Math.max(root.val + left, root.val + right);
        // 如果贡献小于0的话，直接返回0即可！
        return Math.max(max, 0);
    }



//    public static int maxPathSum(TreeNode root) {
//
//    }
//
//    public static int max_sha = Integer.MIN_VALUE;
//    public static int traverse(TreeNode root){
//
//        int left = traverse(root.left);
//        int right = traverse(root.right);
//        max_sha = Math.max(max_sha, root.val+left+right);
//        return root.val + Math.max(left, right);
//    }




}
