package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s82 {

    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = i;

        System.out.println(a);
        System.out.println(deleteDuplicates(a));

    }
//    存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
//
//    返回同样按升序排列的结果链表。

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null){
            return null;
        }else if(head.next==null){
            return head;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        boolean flag = false;

        while (cur!=null && cur.val==pre.val){
            flag = true;
            pre.next = cur.next;
            cur = cur.next;
        }

        if(flag){
            return deleteDuplicates(cur);
        }else {
            head.next = deleteDuplicates(cur);
            return head;
        }

    }

    public static ListNode deleteDuplicates2(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        ListNode ago = null;
        ListNode newhead = null;

        while (cur!=null){

            if(cur.val==pre.val){



//                pre.next = cur.next;
//                cur = cur.next;
//                ago.next = cur;

            }else {

                cur = cur.next;
                pre = pre.next;



//                if(ago==null){
//                    ago = pre;
//                    newhead = ago;
//                }
//
//                ago.next = cur;
//
//                cur = cur.next;
//                pre = pre.next;

            }

        }



        return head;
    }

    public static ListNode deleteDuplicates3(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        ListNode ago = null;

        while (cur!=null){
            if(cur.val==pre.val){

                pre.next = cur.next;
                cur = cur.next;
            }else {
                cur = cur.next;
                pre = pre.next;
            }

        }

        return head;
    }


}
