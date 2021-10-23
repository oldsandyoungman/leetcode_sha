package com.example.leetcode.daily;

import javax.print.DocFlavor;
import java.util.*;

public class s599 {

    public static void main(String[] args) {
//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

    }

//    假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
//    你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static String[] findRestaurant2(String[] list1, String[] list2) {
        int n1 = list1.length;
        int n2 = list2.length;

        int nn = Math.min(n1,n2);

        Map<String, Integer> m = new HashMap<>();
        int i = nn;
        for (String s : list1) {
            m.put(s, m.getOrDefault(s,0)+i);
            i--;
        }
        i = nn;
        for (String s : list2) {
            m.put(s, m.getOrDefault(s,0)+i);
            i--;
        }

        List<String> res = new ArrayList<>();
        int min_num = 2002;

        for (String s : m.keySet()) {
            int cur = m.get(s);
            if (cur > min_num){
                min_num = cur;
                res.clear();
                res.add(s);
            }else if (cur==min_num){
                res.add(s);
            }
        }

        int n = res.size();
        String[] result = new String[n];
        for (int j = 0; j < n; j++) {
            result[j] = res.remove(0);
        }
        return result;

//        PriorityQueue<sha> q = new PriorityQueue<>((o1, o2) -> {
//            return Integer.compare(o1.num, o2.num);
//        });
//
//        for (String s : m.keySet()) {
//            q.add(new sha(s, m.get(s)));
//        }
//
//        int nn = q.peek().num;



    }





    public static String[] findRestaurant(String[] list1, String[] list2) {

        int n1 = list1.length;
        int n2 = list2.length;


        Map<String, Integer> m = new HashMap<>();

        List<String> res = new ArrayList<>();

        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }
        int sum = n1+n2-1;
        for (int i = 0; i < list2.length; i++) {
            String cs = list2[i];
            if (m.containsKey(cs)){
                int cur = i+m.get(cs);
                if (sum>cur){
                    sum = cur;
                    res.clear();
                    res.add(cs);
                } else if (sum==cur) {
                    res.add(cs);
                }
            }
        }

//        int nn = res.size();
//        String[] result = new String[nn];
//        for (int i = 0; i < nn; i++) {
//            result[i] = res.remove(0);
//        }
//        return result;

        return res.toArray(new String[res.size()]);

    }





}

class sha{
    String s;
    int num;

    public sha(String s, int num) {
        this.s = s;
        this.num = num;
    }



}
