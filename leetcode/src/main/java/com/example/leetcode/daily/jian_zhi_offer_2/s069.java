package com.example.leetcode.daily.jian_zhi_offer_2;

public class s069 {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray(arr));
    }

//    符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
//
//    arr.length >= 3
//    存在 i（0 < i < arr.length - 1）使得：
//    arr[0] < arr[1] < ... arr[i-1] < arr[i]
//    arr[i] > arr[i+1] > ... > arr[arr.length - 1]
//    给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/B1IidL
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static int peakIndexInMountainArray(int[] arr) {

        int i = 1;
        int n = arr.length;
        while (i<n){
            if (arr[i]>arr[i-1]){
                i++;
            }else {
                break;
            }
        }
        return i-1;

    }

}
