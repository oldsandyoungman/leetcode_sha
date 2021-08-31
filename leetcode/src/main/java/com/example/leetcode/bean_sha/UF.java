package com.example.leetcode.bean_sha;

public class UF {
    public int count;
    public int[] size;
    public int[] parent;

    public UF(int n) {
        this.count = n;
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    public void union(int m, int n){
        int pm = find(m);
        int pn = find(n);
        if (pm!=pn) {
            if (size[pm] > size[pn]) {
                parent[pn] = pm;
                size[pm] += size[pn];
            }else {
                parent[pm] = pn;
                size[pn] += size[pm];
            }
        }
        count--;
    }

    public int find(int x){
        while (parent[x]!=x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean isconnect(int m, int n){
        int pm = find(m);
        int pn = find(n);
        return pm == pn;
    }

    public int count(){
        return this.count;
    }


}
