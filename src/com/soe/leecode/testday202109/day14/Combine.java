package com.soe.leecode.testday202109.day14;

import java.util.ArrayList;
import java.util.List;

public class Combine {

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> combine1 = combine.combine(4, 2);
        System.out.println(combine1);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] comb = new int[k];
        int count = 0;
        backtracking(res, comb, count, 1 , n, k);
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[] comb, int count, int pos, int n, int k) {
        if (count == k) {
            res.add(arr2List(comb));
            return;
        }

        for (int i = pos; i <= n; ++i) {
            comb[count++] = i;
            backtracking(res, comb, count,i + 1, n, k);
            --count;
        }
    }

    private List<Integer> arr2List(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return list;
    }


}
