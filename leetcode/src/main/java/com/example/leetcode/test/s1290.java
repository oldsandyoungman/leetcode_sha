package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s1290 {
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(0);
        ListNode g = new ListNode(1);
        ListNode h = new ListNode(1);
        ListNode i = new ListNode(1);
        ListNode j = new ListNode(0);
        ListNode k = new ListNode(0);
        ListNode l = new ListNode(0);
        ListNode m = new ListNode(0);
        ListNode n = new ListNode(0);
        ListNode o = new ListNode(0);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        k.next = l;
        l.next = m;
        m.next = n;
        n.next = o;

        System.out.println(a);
        System.out.println(getDecimalValue(a));

    }

//    给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
//
//    请你返回该链表所表示数字的 十进制值 。


    public static int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head!=null){
            sum = sum*2 + head.val;
            head = head.next;
        }


        return sum;

    }


}
