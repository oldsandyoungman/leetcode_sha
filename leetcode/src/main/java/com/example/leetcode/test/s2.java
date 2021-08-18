package com.example.leetcode.test;

import com.example.leetcode.bean_sha.ListNode;

public class s2 {

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
        b.next = c;
//        c.next = d;
        d.next = e;
        e.next = f;

//        boolean flag = fuc1(a);
//        System.out.println(flag);

//        boolean flag2 = fuc2(a);



//        System.out.println(addTwoNumbers(a,d));
        System.out.println(a);
        System.out.println(e);
        System.out.println(addTwoNumbers(a,e));
//        System.out.println(addTwoNumbers(a,d));
//        System.out.println(addTwoNumbers(a,d));



//        System.out.println(addTwoNumbers(l1,l0));
//        System.out.println(addTwoNumbers(l1,a));
//        System.out.println(addTwoNumbers(a,l1));

        System.out.println(addTwoNumbers(null,null));

    }

//    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//    请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return traverse2(l1, l2, 0);

    }

    public static ListNode traverse2(ListNode l1, ListNode l2, int a){

        ListNode temp;




        if(l1==null && l2==null){
            if(a==1){
                temp = new ListNode(1);
                return temp;
            }else {
                return null;
            }

        }else if(l2 == null){
            if(l1.val+a>=10){
                l1.val = l1.val + a - 10;
                temp = traverse2(l1.next, null,1);
            }else {
                l1.val = l1.val + a;
                temp = traverse2(l1.next, null,0);
            }
            l1.next = temp;
            return l1;
        } else if(l1 == null){
            if(l2.val+a>=10){
                l2.val = l2.val + a -10;
                temp = traverse2(null, l2.next,1);
            }else {
                l2.val = l2.val + a;
                temp = traverse2(null, l2.next,0);
            }
            l2.next = temp;
            return l2;
        }else {

            if(l1.next==null && l2.next==null && l1.val==0 && l2.val==0){
                return l1;
            }

            if(l1.val + l2.val + a >= 10){
                l1.val = l1.val + l2.val + a -10;
                temp = traverse2(l1.next, l2.next, 1);

            }else {
                l1.val = l1.val + l2.val + a;
                temp = traverse2(l1.next, l2.next, 0);
            }
            l1.next = temp;
            return l1;


        }

    }

    public ListNode traverse(ListNode l1, ListNode l2, int a){


//        if(l1.next==null && l2.next==null){
//            if(l1.val + l2.val + a>10){
//                l1.val = (l1.val + l2.val + a)%10;
//                ListNode temp = new ListNode(1);
//                l1.next = temp;
//            }else{
//                l1.val = (l1.val + l2.val + a)%10;
//            }
//        }
//
//
//
//
//


        if (l1==null && l2==null){

            if(a==1){
                ListNode temp = new ListNode(1);
                return temp;
            }
            return null;

        }else if(l1==null){

            if(l2.val + a>10){
                l2.next = traverse(null, l2.next, 1);
                return l2;
            }else{
                l2.next = traverse(l1.next, l2.next, 0);
                return l2;
            }


        }else if(l2==null){

            if(l1.val + a>10){
                l1.next = traverse(l1.next, null, 1);
                return l1;
            }else{
                l1.next = traverse(l1.next, null, 0);
                return l1;
            }

        }else{

            if(l1.val + l2.val + a>10){
                l1.val = (l1.val + l2.val + a)%10;
                traverse(l1.next, l2.next, 1);
            }else{
                l1.val = (l1.val + l2.val + a)%10;
                traverse(l1.next, l2.next, 0);
            }



        }


        return null;



    }


}

