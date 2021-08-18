package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s328 {

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
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = g;
//        g.next = h;
//        h.next = i;

//        a=null;

        System.out.println(a);
        System.out.println(oddEvenList(a));

    }

//    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
//    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。



    public static ListNode oddEvenList(ListNode head) {

        if(head == null || head.next==null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode newoddhead = head;
        ListNode newevenhead = head.next;

        head = head.next;

        while(head.next!=null){
            head = head.next;

            if(odd.next==even){
                odd.next = even.next;
                odd = even.next;
            }else {
                even.next = odd.next;
                even = odd.next;
            }


        }

        odd.next = newevenhead;
        even.next = null;

        return newoddhead;



    }
}
