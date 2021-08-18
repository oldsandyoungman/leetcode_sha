package com.example.leetcode.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class s1200 {
    public static void main(String[] args) {
//        int[] arr = {4,2,1,3};
//        int[] arr = {1,3,6,10,15};
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }

//    给你个整数数组 arr，其中每个元素都 不相同。
//
//    请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int[] abs_arr = new int[arr.length-1];

        for (int i = 0; i < arr.length-1; i++) {
            abs_arr[i] = arr[i+1] - arr[i];
        }

        int min_sha = Integer.MAX_VALUE;
        List<Integer> min_index = new ArrayList<>();

        for (int i = 0; i < abs_arr.length; i++) {
            if (abs_arr[i] < min_sha){
                min_sha = abs_arr[i];
                min_index.clear();
                min_index.add(i);
            }else {
                if(abs_arr[i] == min_sha){
                    min_index.add(i);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (Integer minIndex : min_index) {
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[minIndex]);
            temp.add(arr[minIndex + 1]);
            result.add(temp);
        }

        return result;


    }


}
