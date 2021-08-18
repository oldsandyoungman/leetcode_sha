package com.example.leetcode.test;

public class s551 {

    public static void main(String[] args) {

        System.out.println(checkRecord("PPALLLP"));

    }

//    给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
//
//            'A'：Absent，缺勤
//'L'：Late，迟到
//'P'：Present，到场
//    如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
//
//    按 总出勤 计，学生缺勤（'A'）严格 少于两天。
//    学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
//    如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/student-attendance-record-i
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean checkRecord(String s) {

        char[] chars = s.toCharArray();
        int sumA = 0;
        int sumL = 0;
        for (char c : chars) {
            if (c=='A'){
                sumL = 0;
                sumA++;
                if (sumA>1) {
                    return false;
                }
            } else if (c=='L') {
                sumL++;
                if (sumL>2){
                    return false;
                }
            } else {
                sumL = 0;
            }
        }
        return true;

    }

}
