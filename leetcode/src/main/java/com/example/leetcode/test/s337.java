package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class s337 {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(1);
        a.left = b;
        a.right = c;
        b.right = d;
        c.right = e;
        System.out.println(rob(a));
        System.out.println(rob5(a));
        System.out.println(rob6(a));
    }

//    在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//    计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/house-robber-iii
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static Map<TreeNode, Integer> memo = new HashMap<>();

    public static int rob2(TreeNode root) {

        if (root==null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int res1 = root.val
                + (root.left==null?0:rob(root.left.left) + rob(root.left.right))
                + (root.right==null?0:rob(root.right.left) + rob(root.right.right));

        int res2 = rob(root.left) + rob(root.right);

        int res = Math.max(res1, res2);
        memo.put(root, res);
        return res;

    }



    public static int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 0:抢当前层
     * 1:不抢当前层
     */
    public static int[] dp(TreeNode root){
        if (root==null) {
            return new int[]{0,0};
        }

        int[] left = dp(root.left);
        int[] right = dp(root.right);

        int res1 = root.val + left[1] + right[1];
        int res2 = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);

        return new int[]{res1, res2};

    }




    public static int rob5(TreeNode root) {
        map = new HashMap<>();
        dp_sha(root);
        return map.get(root);

    }

    public static HashMap<TreeNode, Integer> map;

    public static int dp_sha(TreeNode root){
        if (root==null) {
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }

        int do_it = root.val
                + (root.left==null?0:dp_sha(root.left.left)+dp_sha(root.left.right))
                + (root.right==null?0:dp_sha(root.right.left)+dp_sha(root.right.right));

        int not_do_it = dp_sha(root.left) + dp_sha(root.right);

        int res = Math.max(do_it, not_do_it);
        map.put(root, res);
        return res;

    }


    public static int rob6(TreeNode root) {

        int[] res = dp6(root);

        return Math.max(res[0], res[1]);

    }
    // dp[0]:选当前这个；dp[1]：不选当前这个
    public static int[] dp6(TreeNode root) {

        if (root==null) {
            return new int[]{0,0};
        }

        int[] left = dp6(root.left);
        int[] right = dp6(root.right);

        int dp0 = root.val + left[1] + right[1];
        int dp1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{dp0, dp1};
    }




}
