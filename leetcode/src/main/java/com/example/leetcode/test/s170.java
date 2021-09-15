package com.example.leetcode.test;

import java.util.*;

public class s170 {

    public static void main(String[] args) {

    }

}

//// 增，查频率一样多
//class TwoSum {
//    Map<Integer, Integer> freq = new HashMap<>();
//
//    public void add(int number) {
//        // 记录 number 出现的次数
//        freq.put(number, freq.getOrDefault(number, 0) + 1);
//    }
//
//    public boolean find(int value) {
//        for (Integer key : freq.keySet()) {
//            int other = value - key;
//            // 情况一
//            if (other == key && freq.get(key) > 1)
//                return true;
//            // 情况二
//            if (other != key && freq.containsKey(other))
//                return true;
//        }
//        return false;
//    }
//}
//
//
//// 查得更多
//class TwoSum {
//    Set<Integer> sum = new HashSet<>();
//    List<Integer> nums = new ArrayList<>();
//
//    public void add(int number) {
//        // 记录所有可能组成的和
//        for (int n : nums)
//            sum.add(n + number);
//        nums.add(number);
//    }
//
//    public boolean find(int value) {
//        return sum.contains(value);
//    }
//}




// 增，查频率一样多
class TwoSum {

    Map<Integer, Integer> freq = new HashMap<>();


    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0)+1);
    }

    public boolean find(int value) {

        Set<Integer> integers = freq.keySet();
        for (Integer integer : integers) {
            int other = value - integer;
            if (other != integer && freq.containsKey(other)) {
                return true;
            }
            if (other == integer && freq.get(other)>1) {
                return true;
            }

        }
        return false;

    }

}

//
////// 查得更多
//class TwoSum {
//
//    HashSet<Integer> set = new HashSet<>();
//    List<Integer> nums = new ArrayList<>();
//
//    public void add(int number) {
//        for (Integer num : nums) {
//            int sum = number + num;
//            set.add(sum);
//        }
//    }
//
//    public boolean find(int value) {
//        return set.contains(value);
//    }
//
//
//
//}