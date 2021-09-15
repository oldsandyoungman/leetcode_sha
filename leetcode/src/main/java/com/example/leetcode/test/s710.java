package com.example.leetcode.test;

import java.util.*;

public class s710 {

    public static void main(String[] args) {
        Solution233 solution = new Solution233(5, new int[]{1,4});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }

//    给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
//
//    对它进行优化使其尽量少调用系统方法 Math.random() 。
//
//    提示:
//
//            1 <= n <= 1000000000
//            0 <= blacklist.length < min(100000, N)
//            [0, n) 不包含 n ，详细参见 interval notation 
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


}


//class Solution233 {
//    int sz;
//    HashMap<Integer, Integer> mapping = new HashMap<>();
//
//    public Solution233(int n, int[] blacklist) {
//        sz = n - blacklist.length;
//        for (int b : blacklist) {
//            mapping.put(b, 666);
//        }
//
//        int last = n - 1;
//        for (int b : blacklist) {
//            // 如果 b 已经在区间 [sz, N)
//            // 可以直接忽略
//            if (b >= sz) {
//                continue;
//            }
//            while (mapping.containsKey(last)) {
//                last--;
//            }
//            mapping.put(b, last);
//            last--;
//        }
//
//
//    }
//
//    public int pick() {
//        Random rd = new Random();
//        // 随机选取一个索引
//        int index = rd.nextInt(sz);
////        index = 4;
//        // 这个索引命中了黑名单，
//        // 需要被映射到其他位置
//        if (mapping.containsKey(index)) {
//            return mapping.get(index);
//        }
//        // 若没命中黑名单，则直接返回
//        return index;
//    }
//}

//class Solution233 {
//
//    int sz;
//    HashMap<Integer, Integer> mapping = new HashMap<>();
//    Random rd = new Random();
//
//    public Solution233(int n, int[] blacklist) {
//        sz = n - blacklist.length;
//
//        for (int b : blacklist) {
//            mapping.put(b, 666);
//        }
//
//        int last = n-1;
//
//        for (int b : blacklist) {
//            if (b>=sz) {
//                continue;
//            }
//            while (mapping.containsKey(last)){
//                last--;
//            }
//            mapping.put(b, last);
//            last--;
//
//        }
//
//    }
//
//    public int pick() {
//        int index = rd.nextInt(sz);
//        if (mapping.containsKey(index)){
//            return mapping.get(index);
//        }
//        return index;
//    }
//}








class Solution233 {

    Map<Integer, Integer> m;
    Random r;
    int wlen;

    public Solution233(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wlen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < n; i++) w.add(i);
        for (int x : b) w.remove(x);
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wlen)
                m.put(x, wi.next());
    }

    public int pick() {
        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);
    }

}