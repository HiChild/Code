package com.soe.leecode.testday202109.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leecode 46全排列
 */
public class Permute {

    static int[] test = {1,2,3};

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Permute permute = new Permute();
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
            res.add(arr2List(nums));  //stream严重拖慢性能
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            //加上此if语句为去重全排列
            int temp = nums[level]; nums[level] = nums[i]; nums[i] = temp;
            backtracking(nums, level + 1, res);
            temp = nums[level]; nums[level] = nums[i]; nums[i] = temp;
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
