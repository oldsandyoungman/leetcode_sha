package com.example.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

public class s1023 {

    public static void main(String[] args) {

//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String pattern = "FB";

//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String pattern = "FoBa";


        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        System.out.println(camelMatch(queries, pattern));


    }

//    如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
//
//    给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
//
//             
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/camelcase-matching
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static List<Boolean> camelMatch(String[] queries, String pattern) {

        int N = pattern.length();

        List<Boolean> res = new ArrayList<>();

        for (String query : queries) {
            int n = query.length();
            int left = 0;
            int right = 0;

            boolean flag_done = false;

            while (left<n) {

                char c = query.charAt(left);

                if (right<N){

                    if (c==pattern.charAt(right)){
                        right++;
                        left++;
                    }else if (c<='Z'){
                        res.add(false);
                        flag_done = true;
                        break;
                    }else {
                        left++;
                    }

                }else {

                    if (c<='Z'){
                        res.add(false);
                        flag_done = true;
                        break;
                    }else {
                        left++;
                    }


                }

            }

            if (!flag_done){

                if (right<N){
                    res.add(false);
                }else {
                    res.add(true);
                }

            }



        }


        return res;

    }

}
