package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s237 {

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
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = f;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

//        a=null;

        System.out.println(a);
        deleteNode(c);
        System.out.println(a);
    }

//    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }
}
