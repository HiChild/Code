package com.soe.leecode;

import java.util.*;

public class Merge {
    public static int[][] merge(int[][] intervals) {
        Map<Integer,Integer> resMap = new HashMap<>();
        Set<Integer> start = new HashSet<>();
        Set<Integer> end = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        int k = 0;
        for(int[] pair : intervals) {
            start.add(pair[0]);
            end.add(pair[1]);
            temp.add(pair[0]);
            temp.add(pair[1]);
        }
        Collections.sort(temp);

        for(int i = 1; i < temp.size();) {
            if (temp.get(i).equals(temp.get(i-1))) {
                temp.remove(((Object)temp.get(i)));
                temp.remove(((Object)temp.get(i-1)));
                continue;
            }
            i++;
        }

        int startF = Integer.MAX_VALUE, endF = Integer.MAX_VALUE;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < temp.size(); ) {
            if(start.contains(temp.get(i))) {
                startF = temp.get(i);
                if(startF ==  endF) {
                    temp.remove((Object)endF);
                    temp.remove((Object)startF);
                }
                if (flag1) flag2 = true;
                flag1 = true;
            }else if(end.contains(temp.get(i))) {
                flag1 = false;
                endF =  temp.get(i);
                if (flag2 && startF <  endF) {
                    temp.remove((Object)endF);
                    temp.remove((Object)startF);
                    flag2 = false;
                    continue;
                }
            }
            i++;
        }
        int n = temp.size()/2;
        int index = 0;
        int[][] res = new int[n][2];
        for (int i = 0; i < temp.size(); i += 2, index++) {
            res[index][0] = temp.get(i);
            res[index][1] = temp.get(i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] test2 = {{1,4},{4,5},{5,6},{2,8}};
        int[][] merge = merge(test2);
        for (int[] nums : merge) {
            System.out.println(nums[0] + "," + nums[1]);
        }
    }

}
