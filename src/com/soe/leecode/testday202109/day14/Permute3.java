package com.soe.leecode.testday202109.day14;

import java.util.*;
import java.util.stream.Collectors;

/**
 * leecode 46全排列
 */
public class Permute3 {

    static int[] test = {1, 2, 3};
    ArrayList<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Permute3 permute = new Permute3();
        List<List<Integer>> permute1 = permute.permute(test);
        System.out.println(permute1);
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, new LinkedList<Integer>());
        return res;
    }

    private void backtracking(int[] nums, boolean[] visited, Deque<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);
                backtracking(nums, visited, path);
                path.removeLast();
                visited[i] = false;
            }
        }
    }

}
