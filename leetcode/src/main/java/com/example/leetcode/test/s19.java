package com.example.leetcode.test;


import com.example.leetcode.bean_sha.ListNode;

public class s19 {
    public static void main(String[] args) {

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(0);

        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;

        System.out.println(a);
//        System.out.println(removeNthFromEnd2(a,5));
//        System.out.println(removeNthFromEnd2(a,6));
        System.out.println(removeNthFromEnd2(a,1));

    }
//    给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
//    进阶：你能尝试使用一趟扫描实现吗？

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode l1 = head;
        ListNode l2 = head;

        for (int i = 0; i < n+1; i++) {
            if(l1.next != null){
                l1=l1.next;
            }else{
                head = head.next;
                return head;
            }

        }
        while (l1!=null){
            l1 = l1.next;
            l2 = l2.next;
        }

        l2.next = l2.next.next;

        return head;


    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode l1 = head;
        ListNode l2 = head;
        ListNode pre = null;

        for (int i = 0; i < n; i++) {
            if(l1.next != null){
                l1 = l1.next;
            }else {
                return head.next;
            }
        }
        while (l1!=null){
            if(l2==head){
                pre = head;
            }else {
                pre = pre.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        pre.next = l2.next;

        return head;


    }

}
