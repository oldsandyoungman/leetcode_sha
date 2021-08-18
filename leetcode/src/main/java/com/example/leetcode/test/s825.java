package com.example.leetcode.test;

public class s825 {
    public static void main(String[] args) {

        int[] a = {16,16};
//        int[] a = {16,17,18};
//        int[] a ={20,30,100,110,120};
        System.out.println(numFriendRequests(a));
    }


//        人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
//
//        当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求：
//
//        age[B] <= 0.5 * age[A] + 7
//        age[B] > age[A]
//        age[B] > 100 && age[A] < 100
//        否则，A 可以给 B 发送好友请求。
//
//        注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。
//
//        求总共会发出多少份好友请求?

    public static int numFriendRequests(int[] ages) {

        int[] count= new int[121];
        int num = 0;

        for (int age : ages) {
            count[age]++;
        }

        for (int i = 0; i < count.length; i++) {
            int counti = count[i];
            for (int j = 0; j < count.length; j++) {
                int countj = count[j];

//        age[B] <= 0.5 * age[A] + 7
//        age[B] > age[A]
//        age[B] > 100 && age[A] < 100
                if(j <= 0.5 * i + 7){
                }else {
                    if(j > i){
                    }else{
                        if(j > 100 && i < 100){
                        }else {
                            if(i!=j){
                                num = num + counti*countj;
                            }
                            else {
                                num = num + counti*countj - counti;
                            }
                        }
                    }
                }
            }
        }

        return num;
    }
}
