package com.example.leetcode.labuladong;

import com.example.leetcode.bean_sha.ListNode;

public class hui_wen_lian_biao {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(2);
        ListNode f = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

//        boolean flag = fuc1(a);
//        System.out.println(flag);

        boolean flag2 = fuc2(a);
        System.out.println(flag2);


    }



    static ListNode left;
    static int count = 0;

    private static boolean fuc1(ListNode a) {

        left = a;

        return traverse1(left);
    }

    private static boolean traverse1(ListNode a) {



        if (a==null) {
            print_sha(count++);
            System.out.print("输入节点的值为：null\n");

            print_sha(--count);
            System.out.print("输出值为："+"true"+'\n');
            return true;
        }else {
            print_sha(count++);
            System.out.print("输入节点的值为："+a.val+'\n');
        }

        boolean x = traverse1(a.next);

        x = x && (a.val== left.val);

        left = left.next;

        print_sha(--count);
        System.out.print("输出值为："+x+'\n');
        return x;

    }



    private static boolean fuc2(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;

        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast !=null) {
            slow = slow.next;
        }

        ListNode x = reverse(slow);


        while (x != null){
            if (a.val != x.val) {
                return false;
            }
            x = x.next;
            a = a.next;
        }

        return true;
    }

    static ListNode reverse(ListNode a){

        ListNode cur = a;
        ListNode nxt = a;
        ListNode pre = null;

        while(nxt != null){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        return pre;
    }




    static void print_sha(int n){
        for (int i = 0; i < n; i++) {
            System.out.print("   ");
        }
    }


}


