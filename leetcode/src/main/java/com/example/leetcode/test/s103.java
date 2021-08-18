package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class s103 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(1);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(-1);
        TreeNode g = new TreeNode(5);
        TreeNode h = new TreeNode(1);
        TreeNode i = new TreeNode(6);
        TreeNode j = new TreeNode(8);

        a.left = b;
        a.right = c;
        b.left = d;

        c.left = e;
        c.right = f;

        d.left = g;
        d.right = h;

        e.right = i;
        f.right = j;

//        List<Integer> integers = inorderTraversal(null);
        System.out.println(zigzagLevelOrder(a));
        System.out.println("[[0], [4, 2], [1, 3, -1], [8, 6, 1, 5]]");
    }

//    给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean direction = true;
        TreeNode cur;
        while (!q.isEmpty()){

            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                cur = q.removeFirst();
                if (direction) {
                    tmp.add(cur.val);
                }else {
                    tmp.add(0,cur.val);
                }

                if (cur.left!=null) {
                    q.add(cur.left);
                }
                if (cur.right!=null) {
                    q.add(cur.right);
                }
            }
            direction = !direction;
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        //创建队列，保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//先把节点加入到队列中
        boolean leftToRight = true;//第一步先从左边开始打印
        while (!queue.isEmpty()) {
            //记录每层节点的值
            List<Integer> level = new ArrayList<>();
            //统计这一层有多少个节点
            int count = queue.size();
            //遍历这一层的所有节点，把他们全部从队列中移出来，顺便
            //把他们的值加入到集合level中，接着再把他们的子节点（如果有）
            //加入到队列中
            for (int i = 0; i < count; i++) {
                //poll移除队列头部元素（队列在头部移除，尾部添加）
                TreeNode node = queue.poll();
                //判断是从左往右打印还是从右往左打印。
                if (leftToRight) {
                    //如果从左边打印，直接把访问的节点值加入到列表level的末尾即可
                    level.add(node.val);
                } else {
                    //如果是从右边开始打印，每次要把访问的节点值
                    //加入到列表的最前面
                    level.add(0, node.val);
                }
                //左右子节点如果不为空会被加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把这一层的节点值加入到集合res中
            res.add(level);
            //改变下次访问的方向
            leftToRight = !leftToRight;
        }
        return res;
    }

}
