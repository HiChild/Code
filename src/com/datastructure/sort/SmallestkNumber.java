package com.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 * NC119
 */
public class SmallestkNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>(k);
        Arrays.sort(input);
        for (int i = 0; i < k; ++i) list.add(input[i]);
        return list;
    }
}
