package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.example.leetcode.test.s21.mergeTwoLists;

public class s23 {
    public static void main(String[] args) {

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(7);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(8);
        ListNode g = new ListNode(3);
        ListNode h = new ListNode(6);
        ListNode i = new ListNode(9);

        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(0);


        a.next = b;
        b.next = c;
//        c.next = d;
        d.next = e;
        e.next = f;
//        f.next = g;
        g.next = h;
        h.next = i;
//        e.next = f;

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(a);
        list.add(d);
        list.add(g);
//        list.add(null);

        ListNode[] list_yep = new ListNode[list.size()];
        list.toArray(list_yep);

        System.out.println(a);
        System.out.println(d);
//        System.out.println(mergeKLists(list_yep));
        System.out.println(mergeKLists2(list_yep));
//        System.out.println(mergeKLists(list_yep));
//        System.out.println(mergeTwoLists(null, null));

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

    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }

        ArrayList<ListNode> listArray = new ArrayList<>(Arrays.asList(lists));

        ListNode temp = listArray.get(0);

        for (int i = 1; i < listArray.size(); i++) {
            temp = mergeTwoLists(temp,listArray.get(i));
        }

        return temp;

    }

    public static ListNode mergeKLists2(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }

        ListNode up = null;
        ListNode head = null;
//        boolean flag = true;


        while (true){

            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i]!=null){
                    if(min>lists[i].val){
                        min = lists[i].val;
                        index = i;
                    }
                }
            }

            if(index == -1){
                break;
            }else{
                if(up==null){
                    up = lists[index];
                    lists[index] = lists[index].next;
                    head = up;
                }else {
                    up.next = lists[index];
                    up = lists[index];
                    lists[index] = lists[index].next;
                }

            }
        }

        return head;
    }

    public static ListNode mergeKLists3(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }

        ListNode up;
        int[] numlists = new int[lists.length];
        for (int i = 0; i < lists.length; i++) {
            numlists[i] = lists[i].val;
        }

        boolean flag = true;
        int index;

        while (flag){
            index = minindex(numlists);
            up = lists[index];
            lists[index] = lists[index].next;

            if(lists[index]==null){
//                numlists[index] =
//                flag = false;
            }

        }

        return null;

    }

    public static int minindex(int[] numlists){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < numlists.length; i++) {
            if(min>numlists[i]){
                min = numlists[i];
                index = i;
            }
        }
        return index;
    }



}
