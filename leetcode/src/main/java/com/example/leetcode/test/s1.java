package com.example.leetcode.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class s1 {

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int[] nums = {3, 3};
//        int[] nums = {3,2,4};
        int[] nums = {3, 1, 3, 6};
//        int target = 9;
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));

    }


//    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
//    你可以按任意顺序返回答案。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/two-sum
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && !map.get(other).equals(i)) {
                return new int[]{map.get(other), i};
            }
        }

//        for (int num : nums) {
//            int other = target - num;
//            if (map.containsKey(other) && !map.get(other).equals(map.get(num))) {
//                return new int[]{map.get(other), map.get(num)};
//            }
//        }
        return new int[]{-1, -1};

    }

//    // 索引变了，不能解决问题
//    public static int[] twoSum2(int[] nums, int target) {
//
//        Arrays.sort(nums);
//
//        int n = nums.length;
//        int left = 0;
//        int right = n-1;
//        while (left<right){
//            int sum = nums[left] + nums[right];
//            if (sum<target){
//                left++;
//            }else if (sum>target){
//                right--;
//            }else {
//                return new int[]{left, right};
//            }
//        }
//        return new int[]{-1,-1};
//
//    }


    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // 因为只有一个答案，所以覆盖了也不要紧

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other)!=i){
                return new int[]{i, map.get(other)};
            }
        }

        return new int[]{-1,-1};



    }


}



class TwoSum11 {

    HashMap<Integer, Integer> fre = new HashMap<>();

    // 向数据结构中添加一个数 number
    public void add(int number){
        fre.put(number, fre.getOrDefault(number, 0)+1);
    }
    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value){
        for (Integer integer : fre.keySet()) {
            int other = value - integer;
            if (other!=integer && fre.containsKey(other)){
                return true;
            }
            if (other==integer && fre.get(other)>1){
                return true;
            }
        }
        return false;
    }
}

class TwoSum22 {

    HashSet<Integer> sum = new HashSet<>();
    HashSet<Integer> num = new HashSet<>();

    // 向数据结构中添加一个数 number
    public void add(int number){
        for (Integer integer : num) {
            sum.add(integer+number);
        }
        num.add(number);
    }
    // 寻找当前数据结构中是否存在两个数的和为 value
    public boolean find(int value){
        return sum.contains(value);
    }
}

