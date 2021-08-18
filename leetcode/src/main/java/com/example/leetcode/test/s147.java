package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s147 {

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;
//        h.next = i;

//        a=null;

        System.out.println(a);
        System.out.println(insertionSortList(a));
//        reorderList(a);
//        System.out.println(a);
    }

//    插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//    每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//             
//
//    插入排序算法：
//
//    插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//    每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//    重复直到所有输入数据插入完为止。

    public static ListNode insertionSortList(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        ListNode nxt = head.next;

        while (cur!=null){

            if(cur.val<pre.val){

                nxt = cur.next;
                pre.next = null;
                cur.next = pre;
                pre = cur;
                cur = nxt;

            }

            if(pre==null){
                pre = head;
            }

        }


        return null;

    }


}
