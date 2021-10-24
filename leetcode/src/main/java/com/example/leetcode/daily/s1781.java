package com.example.leetcode.daily;

import java.util.HashMap;

public class s1781 {

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

//    一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
//
//    比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
//    给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/sum-of-beauty-of-all-substrings
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//    // 不大行
//    public static int beautySum(String s) {
//        int n = s.length();
//        HashMap<Character, Integer> m = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            m.put(c, m.getOrDefault(c, 0)+1);
//        }
//        int[] res = new int[m.size()];
//        int i = 0;
//        for (Character c : m.keySet()) {
//            res[i++] = m.get(c);
//        }
//        int max_sha = 0;
//        int min_sha = n;
//        for (int re : res) {
//            if (re>max_sha){
//                max_sha = re;
//            }
//            if (re<min_sha) {
//                min_sha = re;
//            }
//        }
//        return max_sha-min_sha;
//    }

    public static int beautySum(String s) {
        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                count[c-'a']++;

                int maxsha = 0;
                int minsha = n;
                for (int i1 : count) {
                    if (i1>maxsha){
                        maxsha = i1;
                    }
                    if (i1>0 && i1<minsha){
                        minsha = i1;
                    }
                }
                res += maxsha - minsha;
            }
        }
        return res;


    }


    public int beautySum2(String s) {
        int length=s.length();
        int sum=0;
        for(int k=3;k<=length;k++){
            int l=0;
            int r=0;
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int[] count=new int[26];
            while(r<length){
                count[s.charAt(r)-'a']++;
                r++;
                while(l+k==r){
                    min=Integer.MAX_VALUE;
                    max=Integer.MIN_VALUE;
                    for(int i=0;i<26;i++){
                        if(count[i]>0){
                            min=Math.min(min,count[i]);
                            max=Math.max(max,count[i]);
                        }
                    }
                    sum+=max-min;
                    count[s.charAt(l)-'a']--;
                    l++;
                }
            }
        }
        return sum;
    }



}
