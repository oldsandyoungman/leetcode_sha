package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

public class s1145 {

    public static void main(String[] args) {

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(btreeGameWinningMove(a,5,2));;

    }

//
//    有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
//
//             
//
//    游戏从「一号」玩家开始（「一号」玩家为红色，「二号」玩家为蓝色），最开始时，
//
//            「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
//
//            「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
//
//            「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
//
//             
//
//    之后两位玩家轮流进行操作，每一回合，玩家选择一个他之前涂好颜色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色。
//
//    如果当前玩家无法找到这样的节点来染色时，他的回合就会被跳过。
//
//    若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
//
//             
//
//    现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true；若无法获胜，就请返回 false。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/binary-tree-coloring-game
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode rootx = traverse1(root,x);
        int left = traverse(rootx.left);
        int right = traverse(rootx.right);
        int father = n - left - right -1;
        int max = Math.max(Math.max(left,right),father);
        if (max>n/2){
            return true;
        }else {
            return false;
        }


    }

    public static int traverse(TreeNode root){
        if (root==null){
            return 0;
        }
        return 1 + traverse(root.left) + traverse(root.right);
    }

    public static TreeNode traverse1(TreeNode root, int x){
        if (root==null) {
            return null;
        }
        if (root.val==x){
            return root;
        }
        TreeNode left = traverse1(root.left, x);
        if (left!=null){
            return left;
        }
        TreeNode right = traverse1(root.right, x);
        if (right!=null) {
            return right;
        }
        return null;
    }






//    public static int xLeft = 0, xRight = 0;
//
//    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
//        dfs(root, x);
//        int xParent = n - xLeft - xRight - 1;
//        return xParent > n / 2 || xLeft > n / 2 || xRight > n / 2;
//    }
//
//    public static int dfs(TreeNode root, int x) {
//        if (root == null) return 0;
//        int left = dfs(root.left, x);
//        int right = dfs(root.right, x);
//        if (root.val == x) {
//            xLeft = left;
//            xRight = right;
//        }
//        return 1 + left + right;
//    }


}
