package com.soe.leecode.daytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    //方法一
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.isEmpty() || res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L,R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1],R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    //方法二（利用快排）

}
