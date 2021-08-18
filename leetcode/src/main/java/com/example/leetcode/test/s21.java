package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s21 {
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(0);

        a.next = b;
        b.next = c;
//        c.next = d;
        d.next = e;
        e.next = f;

        System.out.println(a);
        System.out.println(d);
        System.out.println(mergeTwoLists(a,d));
        System.out.println(mergeTwoLists(null, null));

    }

//    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1==null) {
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if (l1==null) {
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
