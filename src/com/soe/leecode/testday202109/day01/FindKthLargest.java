package com.soe.leecode.testday202109.day01;

import org.omg.CORBA.INTERNAL;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    static int[] sortedArray = {
           3,1,2,4
    };
    static int k = 2;

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int kthLargest = findKthLargest.findKthLargest2(sortedArray, k);
        System.out.println(kthLargest);
    }

    /**
     * 最小堆 方法一
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; ++i) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            int next = nums[i];
            if (next > heap.peek()) {
                heap.remove(heap.peek());
                heap.offer(next);
            }
        }
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        //快速选择
        int left = 0, right = nums.length - 1, targetIndex = nums.length - k;
        while (left < right) {
            int mid = quickSelection2(nums, left, right);
            if (mid == targetIndex) {
                return nums[mid];
            } else if (mid < targetIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    //辅助函数 快速选择
    private int quickSelection(int[] nums, int left, int right) {
        int i = left + 1, j = right;
        while (true) {
            while (i < right && nums[i] <= nums[left]) {
                ++i;
            }
            while (left < j && nums[j] >= nums[left]) {
                --j;
            }
            if (i >= j) {
                break;
            }
            int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
        }
        int temp = nums[left]; nums[left] = nums[j]; nums[j] = temp;
        return j;
    }

    //辅助函数2 快速选择
    private int quickSelection2(int[] nums, int begin, int end) {
        //随机
        Random random = new Random(System.currentTimeMillis());
        int index = begin + random.nextInt(end - begin + 1);
        int temp = nums[index]; nums[index] = nums[end]; nums[end] = temp;
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                temp = nums[i]; nums[i] = nums[counter]; nums[counter++] = temp;
            }
        }
        temp = nums[counter]; nums[counter] = nums[pivot]; nums[pivot] = temp;
        return counter;
    }
}
