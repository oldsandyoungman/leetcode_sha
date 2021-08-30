package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s297 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.right = d;
//        c.left = d;
//        c.right = e;

//        String aa = serialize(a);
//        System.out.println(aa);
//        TreeNode res = deserialize(aa);
//        System.out.println("done");

//        String aa = serialize2(a);
//        System.out.println(aa);
//        TreeNode res = deserialize2(aa);
//        System.out.println(res);
//        System.out.println("done");

        String aa = serialize3(a);
        System.out.println(aa);
        TreeNode res = deserialize3(aa);
        System.out.println(res);
        System.out.println("done");


    }

//    序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//    请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//    提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

    public static String NULL = "null";

    public static String SEP = ",";

//    // Encodes a tree to a single string.
//    public static String serialize(TreeNode root) {
//
//        StringBuilder sb = new StringBuilder();
//        serialize(root, sb);
//
//        return '[' + sb.toString() + ']';
////        return sb.toString();
//
//    }
//
//    public static void serialize(TreeNode root, StringBuilder sb){
//
//        if (root==null) {
//            sb.append(NULL);
//            return;
//        }
//        sb.append(root.val);
//        sb.append(SEP);
//
//        serialize(root.left, sb);
//
//        sb.append(SEP);
//
//        serialize(root.right, sb);
//
//
//
//    }
//
//    // Decodes your encoded data to tree.
//    public static TreeNode deserialize(String data) {
//        LinkedList<String> nodes = new LinkedList<>();
//        data = data.substring(1,data.length()-1);
//        for (String s : data.split(SEP)) {
//            nodes.addLast(s);
//        }
//        return deserialize(nodes);
//    }
//
//    public static TreeNode deserialize(LinkedList<String> nodes) {
//
//        if(nodes.size()==0){
//            return null;
//        }
//
//        String str_root = nodes.removeFirst();
//
//        if(str_root.equals(NULL)){
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.parseInt(str_root));
//
//        root.left = deserialize(nodes);
//        root.right = deserialize(nodes);
//
//        return root;
//    }









//    // Encodes a tree to a single string.
//    public static String serialize(TreeNode root) {
//
//        StringBuilder sb = new StringBuilder();
//        serialize(root, sb);
//
////        sb.deleteCharAt(sb.length()-1);
//
//        return '[' + sb.toString() + ']';
////        return sb.toString();
//
//    }
//
//    public static void serialize(TreeNode root, StringBuilder sb){
//
//        if (root==null) {
//            sb.append(NULL);
//            return;
//        }
//
//        serialize(root.left, sb);
//
//        sb.append(SEP);
//
//        serialize(root.right, sb);
//
//        sb.append(SEP);
//
//        sb.append(root.val);
//
//
//
//    }
//
//
//
//    // Decodes your encoded data to tree.
//    public static TreeNode deserialize(String data) {
//        LinkedList<String> nodes = new LinkedList<>();
//        data = data.substring(1,data.length()-1);
//        for (String s : data.split(SEP)) {
//            nodes.addLast(s);
//        }
//        return deserialize(nodes);
//    }
//
//    public static TreeNode deserialize(LinkedList<String> nodes) {
//
//        if(nodes.size()==0){
//            return null;
//        }
//
//        String str_root = nodes.removeLast();
//
//        if(str_root.equals(NULL)){
//            return null;
//        }
//
//        TreeNode root = new TreeNode(Integer.parseInt(str_root));
//
//        root.right = deserialize(nodes);
//        root.left = deserialize(nodes);
//
//        return root;
//    }
//
//



    public static String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()){
            TreeNode cur = q.poll();

            if(cur==null){
                sb.append(NULL).append(SEP);
                continue;
            }

            sb.append(cur.val).append(SEP);

            q.offer(cur.left);
            q.offer(cur.right);

        }

        return '[' + sb.substring(0,sb.length()-1) + ']';

    }

    public static TreeNode deserialize(String data) {

        String[] nodes = data.substring(1, data.length() - 1).split(SEP);

        if(nodes[0].equals(NULL)){
            return null;
        }


        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (i<nodes.length){

            TreeNode parent = q.poll();

            String left = nodes[i++];

            if(left.equals(NULL)){
                assert parent != null;
                parent.left = null;
            }else {
                assert parent != null;
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }


            String right = nodes[i++];

            if(right.equals(NULL)){
                parent.right = null;
            }else {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }


        }

        return root;




//
//        // 第一个元素就是 root 的值
//        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
//
//        // 队列 q 记录父节点，将 root 加入队列
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        for (int i = 1; i < nodes.length; ) {
//            // 队列中存的都是父节点
//            TreeNode parent = q.poll();
//            // 父节点对应的左侧子节点的值
//            String left = nodes[i++];
//            if (!left.equals(NULL)) {
//                parent.left = new TreeNode(Integer.parseInt(left));
//                q.offer(parent.left);
//            } else {
//                parent.left = null;
//            }
//            // 父节点对应的右侧子节点的值
//            String right = nodes[i++];
//            if (!right.equals(NULL)) {
//                parent.right = new TreeNode(Integer.parseInt(right));
//                q.offer(parent.right);
//            } else {
//                parent.right = null;
//            }
//        }
//        return root;



    }




    public static StringBuilder sb = new StringBuilder();

    public static String serialize2(TreeNode root) {
        traverse2(root);
        return sb.toString();

    }

    public static void traverse2(TreeNode root){
        if (root==null) {
            sb.append('#').append(',');
            return;
        }

        sb.append(root.val).append(',');

        traverse2(root.left);
        traverse2(root.right);

    }

    public static TreeNode deserialize2(String data) {
        LinkedList<String> res = new LinkedList<>();
        for (String s : data.split(",")) {
            res.addLast(s);
        }
        return deserialize2(res);
    }

    private static TreeNode deserialize2(LinkedList<String> res) {
        if (res.size()==0){
            return null;
        }
        String cur = res.removeFirst();
        if ("#".equals(cur)){
            return null;
        }
        TreeNode curnode = new TreeNode(Integer.parseInt(cur));
        curnode.left = deserialize2(res);
        curnode.right = deserialize2(res);
        return curnode;
    }




    public static String serialize3(TreeNode root) {
        if (root==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val).append(',');

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();

                assert cur != null;
                if (cur.left!=null) {
                    q.offer(cur.left);
                    sb.append(cur.left.val).append(',');
                }else {
                    sb.append('#').append(',');
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                    sb.append(cur.right.val).append(',');
                }else {
                    sb.append('#').append(',');
                }
            }
        }
        return sb.toString();
    }


    public static TreeNode deserialize3(String data) {
        if (data==null) {
            return null;
        }
        LinkedList<String> res = new LinkedList<>();
        for (String s : data.split(",")) {
            res.addLast(s);
        }
        TreeNode root = new TreeNode(Integer.parseInt(res.removeFirst()));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!res.isEmpty()){
            TreeNode parent = q.poll();
            String left = res.removeFirst();
            if (!"#".equals(left)) {
                assert parent != null;
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            }else {
                assert parent != null;
                parent.left = null;
            }
            String right = res.removeFirst();
            if (!"#".equals(right)) {
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else {
                parent.right = null;
            }
        }

        return root;

    }





}
