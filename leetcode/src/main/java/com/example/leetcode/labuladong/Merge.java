package com.example.leetcode.labuladong;

class Merge {

    public static void main(String[] args) {
//        Comparable[] a = {2,6,3,5,1,4};
//        Comparable[] a = {2,3,5,1,4,6};
        Comparable[] a = {2,5,3,1,6,4};
        sort(a);
//        for (Comparable comparable : a) {
//            System.out.println(comparable);
//        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    // 不要在 merge 函数里构造新数组了
    // 因为 merge 函数会被多次调用，影响性能
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        // 直接一次性构造一个足够大的数组，简洁，高效
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        if(mid == 2){
            System.out.println("yep");
        }

        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if      (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi)               {
                a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            else                           {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}