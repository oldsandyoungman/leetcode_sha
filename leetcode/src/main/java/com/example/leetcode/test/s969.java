package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class s969 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4,1};
        System.out.println(Arrays.toString(arr));
        System.out.println(pancakeSort(arr));
    }

//    给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
//
//    一次煎饼翻转的执行过程如下：
//
//    选择一个整数 k ，1 <= k <= arr.length
//    反转子数组 arr[0...k-1]（下标从 0 开始）
//    例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
//
//    以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/pancake-sorting
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static List<Integer> pancakeSort(int[] arr) {
        res = new ArrayList<>();
        int n = arr.length;
        traverse(arr, n);
        return res;
    }
    public static List<Integer> res;
    public static void traverse(int[] arr, int m){
        int n = arr.length;
        if (m==1){
            return;
        }
        int max = 0;
        int max_num = 0;
        for (int i = 0; i < m; i++) {
            if (max<arr[i]){
                max = arr[i];
                max_num = i;
            }
        }
        if (max_num==m-1) {
//            reverse_sha(arr,0,max_num-1);
            traverse(arr, m-1);
        }else {
            res.add(max_num+1);
            reverse_sha(arr,0,max_num);
            System.out.println(Arrays.toString(arr));

            res.add(m);
            reverse_sha(arr, 0, m-1);
            System.out.println(Arrays.toString(arr));

            traverse(arr, m-1);
        }

    }
    public static void reverse_sha(int[] arr, int i, int j){
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


}
