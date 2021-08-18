package com.example.leetcode.test;

import com.example.leetcode.bean_sha.Node;

import java.util.LinkedList;
import java.util.Queue;

public class s117 {

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;

        System.out.println("Node{val=1, left=Node{val=2, left=Node{val=4, left=null, right=null, next=Node{val=5, left=null, right=null, next=Node{val=7, left=null, right=null, next=null}}}, right=Node{val=5, left=null, right=null, next=Node{val=7, left=null, right=null, next=null}}, next=Node{val=3, left=null, right=Node{val=7, left=null, right=null, next=null}, next=null}}, right=Node{val=3, left=null, right=Node{val=7, left=null, right=null, next=null}, next=null}, next=null}");
        System.out.println(connect(a));

    }

//    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
//
//    初始状态下，所有 next 指针都被设置为 NULL。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//    public static Node connect(Node root) {
//
//        if (root==null){
//            return null;
//        }
//
//        Queue<Node> q = new LinkedList<>();
//        q.offer(root);
//        Node cur;
//        Node pre = null;
//        while (!q.isEmpty()){
//            int n = q.size();
//            for (int i = 0; i < n; i++) {
//                cur = q.poll();
//                if (i>0) {
//                    pre.next = cur;
//                }
//                pre = cur;
//                if (cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if (cur.right!=null) {
//                    q.offer(cur.right);
//                }
//            }
//        }
//        return root;
//
//    }

    public static Node connect(Node root) {

        if (root==null) {
            return null;
        }

        Node cur = root;

        while (cur!=null){

            Node dump = new Node(0);
            Node left = dump;

            while (cur!=null){
                if (cur.left!=null) {
                    left.next = cur.left;
                    left = left.next;
                }
                if (cur.right!=null) {
                    left.next = cur.right;
                    left = left.next;
                }
                cur = cur.next;
            }
            cur = dump.next;
        }

        return root;

    }
}