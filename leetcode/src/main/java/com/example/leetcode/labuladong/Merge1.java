package com.example.leetcode.labuladong;

class Merge1 {

    public static void main(String[] args) {
//        Comparable[] a = {2,3,5,1,4,6};
        Comparable[] a = {2,5,3,1,6,4};
//        Comparable[] a = {1,6,4};



//        Comparable[] a = {2,6,3,5,1,4};
//        Comparable[] a = {2,6,4,5,1,3};
        sort_sha(a);
//        for (Comparable comparable : a) {
//            System.out.println(comparable);
//        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static Comparable[] aux;

    public static void sort_sha(Comparable[] a) {

        aux = new Comparable[a.length];

        int hi = a.length - 1;
        sort_sha(a, 0, hi);
    }

    public static void sort_sha(Comparable[] a, int lo, int hi) {
        if(lo>=hi){
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort_sha(a, lo, mid);
        sort_sha(a, mid + 1, hi);

        if(mid==2){
            System.out.println("yep");
//            2,3,5,1,4,6
//            a[0]=2;
//            a[1]=3;
//            a[2]=5;
//            a[3]=1;
//            a[4]=4;
//            a[5]=6;
        }

        merge_sha(a, lo, mid, hi);


    }

    public static void merge_sha(Comparable[] a, int lo, int mid, int hi) {

//        System.arraycopy(a, 0, aux, 0, hi+1);

        for (int k = lo; k<= hi; k++){
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k < hi + 1; k++) {

            if (i>mid){
                a[k] = aux[j++];

            }else if (j>hi){
                a[k] = aux[i++];

            }else if(less_sha(aux[i], aux[j])){
                a[k] = aux[i++];

            }else {
                a[k] = aux[j++];
            }


        }

    }

    public static boolean less_sha(Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

}
