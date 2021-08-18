package com.example.leetcode.test;

public class s600 {
    public static void main(String[] args) {
//        int x = 16;
//        int x =7;
//        int x =6;
//        int x =4;
//        int x =1;//2
//        int x =2;//3
//        int x =3;//3
//        int x =4;//4
//        int x =5;//5
//        int x =6;//5
//        int x =7;//5
//        int x =8;//6
//        int x =9;//7
//        int x =10;//8
//        int x =11;//8
//        int x =12;//8
//        int x =13;//8
//        int x =14;//8
//        int x =15;//8
//        int x =16;//9
//        int x =17;//10
//        int x =18;//11
//        int x =19;//11
//        int x =20;//12
//        int x =21;//13
//        int x =22;//13
//        int x =23;//13
//        int x =24;//13
//        int x =25;//13
//        int x =26;//13
//        int x =27;//13
//        int x =28;//13
//        int x =29;//13
//        int x =30;//13
//        int x =31;//13
//        int x =32;//14


        int[] aa = {1,2,3,3,4,5,5,5,6,7,8,8,8,8,8,8,9,10,11,11,12,13,13,13,13,13,13,13,13,13,13,13,14};
        for (int i = 0; i < 20; i++) {
            if(findIntegers(i)!=aa[i]){
                System.out.println("wrong"+ i);
            }

        }
//        System.out.println(findIntegers(x));
//        System.out.println(findIntegers_by_num(5));
    }

//    给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。

    public static int findIntegers(int n) {

        String s = Integer.toBinaryString(n);
        int num = s.length();

        char[] chars = s.toCharArray();
        int temp = 0;
        boolean flag = false;
        for (int i = 1; i < chars.length; i++) {
//            if(i - temp == 1){
//
//                if(chars[i]=='1'){
//                    flag = true;
//                }
//
//                chars[i] = '0';
//
//            }else {
//                if(flag){
//                    chars[i] = '1';
//                }
//
//                temp = i;
//            }

            if(chars[i]=='1'){
                if(i - temp == 1){
                    chars[i] = '0';
                    flag = true;
                }else {
                    temp = i;
                }
            }else {
                if(flag){
                    if(i - temp != 1) {
                        chars[i] = '1';
                        temp = i;
                    }
                }
            }


        }

        int sum = 0;

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='1'){
                sum += findIntegers_by_num(num-i);
            }
        }

        return sum + 1;
    }

    // 小于2^（num-1），包括0的个数
    public static int findIntegers_by_num(int num) {

        if (num==1){
            return 1;
        }else {
            if (num == 2){
                return 2;
            }else {
                return findIntegers_by_num(num-1) + findIntegers_by_num(num-2);
            }
        }



    }
}
