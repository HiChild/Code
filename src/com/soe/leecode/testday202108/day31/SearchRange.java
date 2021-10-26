package com.soe.leecode.testday202108.day31;

import java.util.Arrays;

/**
 * 二分查找求区间
 */
public class SearchRange {
    static int[] sortedArray = {
            5,7,7,7,8,10
    };
    static int myTarget = 7;

    public static void main(String[] args) {
//        暴力法
//        test01();
        testBinarySearchRange();
    }

    static public void testBinarySearchRange() {
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.binarySearchRange(sortedArray, myTarget);
        System.out.println(Arrays.toString(ints));
    }

    static public void testLeft() {
        SearchRange searchRange = new SearchRange();
        int left = searchRange.findLeft(sortedArray, myTarget);
        System.out.println(left);
    }

    static public void testRight() {
        SearchRange searchRange = new SearchRange();
        int right = searchRange.findRight(sortedArray, myTarget);
        System.out.println(right);
    }
    static public void test01 () {
        SearchRange searchRange = new SearchRange();
        int[] ints = searchRange.searchRange(sortedArray, myTarget);
        System.out.println(Arrays.toString(ints));
    }

    public int[] searchRange(int[] nums, int target) {
        //暴力
        int left = -1, right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == target) {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

    public int[] binarySearchRange(int[] nums, int target) {
        //两次二分查找
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    /**
     * 二分查找求目标值的右区间
     * @param nums
     * @param target
     * @return
     */
    public int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1,mid;
        while (left < right) {
            mid = left + (right - left + 1)/2;
            //调试时打开以下注释代码
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);
//            System.out.println("mid = " + mid);
            if (nums[mid] <= target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    /**
     * 二分查找求目标值的左区间
     * @param nums
     * @param target
     * @return
     */
    public int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1,mid;
        while (left < right) {
            mid = left + (right - left)/2;
            //调试时打开以下注释代码
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);
//            System.out.println("mid = " + mid);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        return nums[right] == target ? left : -1;
    }

    //////////////////////////////////////////////////////
    /**
     * 左闭右开式写法，注意返回值可能会数组越界；
     */

    /**
     * 二分查找求目标值的右区间
     * @param nums
     * @param target
     * @return 注意返回值有可能向右越界；
     */
    public int _findRight(int[] nums, int target) {
        int left = 0, right = nums.length,mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 二分查找求目标值的左区间
     * @param nums
     * @param target
     * @return 返回值是右端点+1的位置，所以使用时需要 -1处理;
     */
    public int _findLeft(int[] nums, int target) {
        int left = 0, right = nums.length,mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (nums[mid] >= target) {
                right = mid ;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
