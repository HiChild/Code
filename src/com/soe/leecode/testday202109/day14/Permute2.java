package com.soe.leecode.testday202109.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leecode 46全排列
 */
public class Permute2 {

    static int[] test = {1,2,3};

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Permute2 permute = new Permute2();
        List<List<Integer>> permute1 = permute.permute(test);
        System.out.println(permute1);
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtracking(nums, 0, res);
        return res;
    }

    private void backtracking(int[] nums, int level, ArrayList<List<Integer>> res) {
        if (level == nums.length) {
            //            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));  //stream严重拖慢性能
            res.add(arr2List(nums));
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            //加上此if语句为去重全排列
            if (isOk(nums, i, level)) {
                int temp = nums[level]; nums[level] = nums[i]; nums[i] = temp;
                backtracking(nums, level + 1, res);
                temp = nums[level]; nums[level] = nums[i]; nums[i] = temp;
            }
        }

    }

    private List<Integer> arr2List(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return list;
    }

    private boolean isOk(int[] nums , int i, int level) {
        return i == level || nums[i] != nums[level];
    }
}
