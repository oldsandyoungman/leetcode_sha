package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s24 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(0);


        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        System.out.println(a);
        System.out.println(swapPairs(a));
//        System.out.println(swapKnode(a,4));

    }

//    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    public static ListNode swapPairs(ListNode head) {

        return swapKnode(head, 2);

    }

    public static ListNode swapKnode(ListNode head, int k){

        if(head == null){
            return null;
        }

        ListNode right = head;

        for (int i = 0; i < k; i++) {
            if(right==null){
                return head;
            }
            right = right.next;
        }

        ListNode cur = head;
        ListNode nxt = head;
        ListNode pre = null;

        while (nxt != right){
            nxt = nxt.next;
            cur.next = pre;
//            nxt.next = cur;
            pre = cur;
            cur = nxt;

        }

        head.next = swapKnode(right, k);

        return pre;

    }

}
