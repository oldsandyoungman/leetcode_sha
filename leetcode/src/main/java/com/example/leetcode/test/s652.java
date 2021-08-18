package com.example.leetcode.test;

import com.example.leetcode.bean_sha.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class s652 {
    public static void main(String[] args) {

    }

//    给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
//    两棵树重复是指它们具有相同的结构以及相同的结点值。

    public HashMap<String, Integer> map = new HashMap<>();
    public List<TreeNode> list = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse(root);
        return list;

    }

    public String traverse(TreeNode root){

        if(root==null){
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String result = left + "," + right + "," + root.val;
        int fre = map.getOrDefault(result,0);

        if (fre==1) {
            list.add(root);
        }

        map.put(result, fre+1);

        return result;

    }

}
