package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s92 {
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
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        System.out.println(a);
        System.out.println(reverseBetween(a,2,4));

    }

//    给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。


//    public static ListNode reverseBetween(ListNode head, int left, int right) {
//
//        if(left==1){
//
//            return reverseK(head,right);
//
//        }else {
//            head.next = reverseBetween(head.next, left-1, right-1);
//            return head;
//        }
//
//    }
//
//    public static ListNode reverseK(ListNode head, int k) {
//
//        if(head==null || k==0){
//            return head;
//        }
//
//        ListNode pre = null;
//        ListNode cur = head;
//        ListNode nxt = head;
//
//        for (int i = 0; i < k; i++) {
//            nxt = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = nxt;
//        }
//
//        head.next = cur;
//        return pre;
//
//    }
//
//    public static ListNode reverseBetween2(ListNode head, int left, int right) {
//
//        left--;
//        right--;
//
//        if (head==null){
//            return null;
//        }
//
//        ListNode cur = head;
//        ListNode nxt;
//        ListNode pre = null;
//        ListNode sup = null;
//
//        for (int i = 0; i < left; i++) {
//            if(sup==null){
//                sup = head;
//            }else {
//                sup = cur;
//            }
//            cur = cur.next;
//        }
//
//        nxt = cur;
//
//        for (int i = 0; i < right - left+1; i++) {
//            nxt = cur.next;
//
//            cur.next = pre;
//
//            pre = cur;
//            cur = nxt;
//
//        }
//
//        if(sup==null){
//            sup = head;
//            sup.next = cur;
//            return pre;
//        }
//
//        sup.next.next = cur;
//        sup.next = pre;
//
//        return head;
//
//
//    }

    public static ListNode suc;
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left>1) {
            head.next = reverseBetween(head.next, left-1, right-1);
            return head;
        }

        if (right==1) {
            suc = head.next;
            return head;
        }

        ListNode last = reverseBetween(head.next, 1, right-1);
        head.next.next = head;
        head.next = suc;

        return last;

    }



}
