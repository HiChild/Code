package com.soe.leecode.sort;

public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length - 1);
    }

    public int mergeSort(int[] nums,int begin, int end) {
        if (begin == end) return 0;
        int mid = (end + begin) >> 1;
        count = mergeSort(nums,mid + 1, end) +  mergeSort(nums,begin, mid);
        int[] res = new int[end - begin + 1];
        int k = 0;
        int i = begin, j = mid + 1;

        for (int s = begin,e = j; s <= mid; s++) {
            while (e <= end && nums[s] > (long)2 * nums[e]) e++;
            count += e - j;
        }

        while (i <= mid && j <= end) {
            res[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            res[k++] = nums[i++];
        }
        while (j <= end) {
            res[k++] = nums[j++];
        }
        System.arraycopy(res,0,nums,begin, k);
        return count;
    }

    public static void main(String[] args) {
        ReversePairs obj = new ReversePairs();
        int i = obj.reversePairs(new int[]{1, 3, 2, 3, 1});
        System.out.println(i);
    }
}
