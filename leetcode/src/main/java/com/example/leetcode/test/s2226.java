package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;
import com.example.leetcode.bean_sha.TreeNode;

import java.util.*;

public class s2226 {

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

        System.out.println(Arrays.toString(listOfDepth(a)));
        System.out.println();

    }

//    给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> res_list = new ArrayList<>();
        if (tree==null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(tree);
        while (!q.isEmpty()){
            int n = q.size();
            ListNode dummy = new ListNode(0);
            ListNode cur_ln = dummy;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                cur_ln.next = new ListNode(cur.val);
                cur_ln = cur_ln.next;
                if (cur.left!=null){
                    q.offer(cur.left);
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                }
            }
            res_list.add(dummy.next);
        }
        return res_list.toArray(new ListNode[] {});
    }

}
