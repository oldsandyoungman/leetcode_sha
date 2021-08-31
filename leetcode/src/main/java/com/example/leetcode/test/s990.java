package com.example.leetcode.test;

import com.example.leetcode.bean_sha.UF;

public class s990 {

    public static void main(String[] args) {
//        String[] equations = new String[]{"a==b","c!=a"};
        String[] equations = new String[]{"a==b","e==c","b==c","a!=e"};

        System.out.println(equationsPossible(equations));
    }

//    给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
//    只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1)=='=') {
                int i = equation.charAt(0)-'a';
                int j = equation.charAt(3)-'a';
                uf.union(i,j);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1)=='!') {
                int i = equation.charAt(0)-'a';
                int j = equation.charAt(3)-'a';
                if (uf.isconnect(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
