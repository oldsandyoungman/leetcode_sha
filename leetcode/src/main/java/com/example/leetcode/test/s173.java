package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.*;

public class s173 {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(-1);
        TreeNode b = new TreeNode(-2);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(-4);
        TreeNode e = new TreeNode(-5);
        TreeNode f = new TreeNode(-6);
        TreeNode g = new TreeNode(-7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;


        BSTIterator obj = new BSTIterator(a);
        System.out.println(obj.next());    // 返回 3
        System.out.println(obj.next());    // 返回 7
        System.out.println(obj.hasNext()); // 返回 True
        System.out.println(obj.next());    // 返回 9
        System.out.println(obj.hasNext()); // 返回 True
        System.out.println(obj.next());    // 返回 15
        System.out.println(obj.hasNext()); // 返回 True
        System.out.println(obj.next());    // 返回 20
        System.out.println(obj.hasNext()); // 返回 False

        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();



    }

//    实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
//    BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
//    boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
//    int next()将指针向右移动，然后返回指针处的数字。
//    注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
//
//    你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

}


class BSTIterator {
    Deque<TreeNode> q = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while (cur!=null){
            q.push(cur);
            cur = cur.left;
        }
    }

    public int next(){
        TreeNode cur = q.pop();
        if (cur.right!=null){
            TreeNode nxt = cur.right;
            while (nxt!=null){
                q.push(nxt);
                nxt = nxt.left;
            }
        }
        return cur.val;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }




}


//class BSTIterator {
//    Deque<TreeNode> stack = new LinkedList<TreeNode>();
//    public BSTIterator(TreeNode root) {
//        TreeNode node = root;
//        while(node!=null) {
//            stack.push(node);
//            node=node.left;
//        }
//    }
//
//    public int next() {
//        TreeNode node = stack.pop();
//        if(node.right!=null) {
//            TreeNode p = node.right;
//            while(p!=null) {
//                stack.push(p);
//                p=p.left;
//            }
//        }
//        return node.val;
//    }
//
//    public boolean hasNext() {
//        return !stack.isEmpty();
//    }
//}
//
