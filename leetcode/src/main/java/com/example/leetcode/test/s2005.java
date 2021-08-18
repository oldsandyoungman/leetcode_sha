package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class s2005 {
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

//        a=null;

        System.out.println(a);
//        System.out.println(detectCycle(a).val);
        System.out.println(Arrays.toString(reversePrint(null)));
    }

//    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

    public static ArrayList<Integer> al = new ArrayList<>();

    public static int[] reversePrint(ListNode head) {

        traverse(head);

        int[] res = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            res[i] = al.get(i);
        }
        return res;

    }

    public static void traverse(ListNode a){

        if(a==null){
            return;
        }

        traverse(a.next);

        al.add(a.val);

    }
}
