package com.example.leetcode.daily;

public class s860 {

    public static void main(String[] args) {

    }

//    在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//
//    每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
//
//    注意，一开始你手头没有任何零钱。
//
//    给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/lemonade-change
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean lemonadeChange(int[] bills) {
        int i5 = 0;
        int i10 = 0;
        int i20 = 0;

        int n = bills.length;

        for (int bill : bills) {

            if (bill == 5) {
                i5++;
            } else if (bill == 10) {

                if (i5 > 0) {
                    i5--;
                    i10++;
                } else {
                    return false;
                }

            } else {

                if (i10 > 0) {
                    if (i5 > 0) {
                        i10--;
                        i5--;
                    } else {
                        return false;
                    }
                } else {
                    if (i5 > 2) {
                        i5 -= 3;
                    } else {
                        return false;
                    }
                }

            }
        }

        return true;

    }

}
