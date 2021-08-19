package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class s99 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = d;
//        c.left = d;
//        c.right = e;

//        List<Integer> integers = inorderTraversal(null);
        recoverTree(a);
        System.out.println(a);
    }

//    给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
//
//    进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/recover-binary-search-tree
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    public static void recoverTree(TreeNode root) {
//
//        traverse(root, null, null);
////        System.out.println(res);
//        System.out.println(parent);
//        System.out.println(cur);
//
//    }
//
//    public static List<TreeNode> list = new ArrayList<>();
//    public static List<TreeNode> parent = new ArrayList<>();
//    public static List<TreeNode> cur = new ArrayList<>();
//    public static TreeNode pa = null;
//
//
//    public static void traverse(TreeNode root, Integer min, Integer max){
//
//        if(root==null){
//            return;
//        }
//        if (min!=null && min>root.val) {
//            cur.add(root);
//            parent.add(pa);
//            return;
//        }
//        if (max!=null && max<root.val){
//            cur.add(root);
//            parent.add(pa);
//            return;
//        }
//
//        pa = root;
//
//        traverse(root.left, min, root.val);
//        traverse(root.right, root.val, max);
//
//    }

//    public static void recoverTree(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode firstNode = null;
//        TreeNode secondNode = null;
//        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
//        TreeNode p = root;
//        while (p != null || !stack.isEmpty()) {
//            while (p != null) {
//                stack.push(p);
//                p = p.left;
//            }
//            p = stack.pop();
//            if (firstNode == null && pre.val > p.val) firstNode = pre;
//            if (firstNode != null && pre.val > p.val) secondNode = p;
//            pre = p;
//            p = p.right;
//        }
//        int tmp = firstNode.val;
//        firstNode.val = secondNode.val;
//        secondNode.val = tmp;
//    }





//    public static TreeNode firstNode = null;
//    public static TreeNode secondNode = null;
//    public static TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
//
//    public static void recoverTree(TreeNode root) {
//
//        in_order(root);
//        int tmp = firstNode.val;
//        firstNode.val = secondNode.val;
//        secondNode.val = tmp;
//    }
//
//    private static void in_order(TreeNode root) {
//        if (root == null) return;
//        in_order(root.left);
//        if (firstNode == null && preNode.val > root.val) firstNode = preNode;
//        if (firstNode != null && preNode.val > root.val) secondNode = root;
//        preNode = root;
//        in_order(root.right);
//    }


    public static TreeNode first = null;
    public static TreeNode second = null;
    public static TreeNode pre = new TreeNode(Integer.MIN_VALUE);


    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        if (first == null && pre.val > root.val) {
            first = pre;
        }
        if (first != null && pre != null && pre.val > root.val) {
            second = root;
        }
        pre = root;

        traverse(root.right);

    }

}
