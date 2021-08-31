package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class s236 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        System.out.println(lowestCommonAncestor(a,b,i));
        System.out.println(lowestCommonAncestor2(a,b,i));
    }

//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) {
            return null;
        }
        if (root==p || root==q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left==null && right==null){
            return null;
        }
        if (left!=null && right!=null) {
            return root;
        }
        if (left==null){
            return right;
        }
        return left;


    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        List<TreeNode> listp = new ArrayList<>();
//        List<TreeNode> listq = new ArrayList<>();
//        traverse(root, p, listp);
//        traverse(root, q, listq);
//        TreeNode ans = root;
//        while (listp.size()>0 && listq.size()>0 && listp.get(listp.size()-1)==listq.get(listq.size()-1)){
//            ans = listp.remove(listp.size()-1);
//            listq.remove(listq.size()-1);
//        }
//        return ans;
//    }
//
//    public static boolean traverse(TreeNode root, TreeNode dst, List<TreeNode> list){
//
//        if(root==null){
//            return false;
//        }
//        if (root==dst) {
//            list.add(root);
//            return true;
//        }
//
//        if(traverse(root.left, dst, list)){
//            list.add(root);
//            return true;
//        }
//        if(traverse(root.right, dst, list)){
//            list.add(root);
//            return true;
//        }
//        return false;
//
//    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null) {
            return null;
        }
        if (root==p || root==q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right !=null) {
            return root;
        } else if (left!=null) {
            return left;
        } else {
            return right;
        }

    }

}
