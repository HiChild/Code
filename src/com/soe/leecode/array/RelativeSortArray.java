package com.soe.leecode.array;

import java.util.*;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] c = new int[arr2.length];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapArr1 = new HashMap<>();
        List list = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++) map.put(arr2[i], i);
        for (int i = 0; i < arr1.length; i++) mapArr1.put(i,arr1[i]);
        for (int arr : arr1) {
            if (map.containsKey(arr))
                c[map.get(arr)]++;
        }
        for (int i = 1; i < c.length; i++) c[i] += c[i-1];
        int totalNum = c[c.length - 1];
        int[] res = new int[arr1.length];
        int[] left = new int[arr1.length - totalNum];
        int k = 0;
        for (int i = 0 ; i < arr1.length; i++) {
            int val = mapArr1.get(i);
            if(map.containsKey(val)) {
                res[--c[map.get(val)]] = val;
            }else{
                left[k++] = val;
            }
        }
        Arrays.sort(left);
        System.arraycopy(left,0,res,totalNum,left.length);
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ints = relativeSortArray(arr1, arr2);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
