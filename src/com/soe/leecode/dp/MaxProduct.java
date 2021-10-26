package com.soe.leecode.dp;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        /**
         * 标签：动态规划
         * 遍历数组时计算当前最大值，不断更新
         * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
         * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
         * 当负数出现时则imax与imin进行交换再进行下一步计算
         * 时间复杂度：O(n)
         *
         */
        int imax = 1, imin = 1,max = -Integer.MAX_VALUE;
        for(int num: nums) {
            if (num < 0) {
                int t = imax;
                imax = imin;
                imin = t;
            }
            imax = Math.max(num * imax,num);
            imin = Math.min(num * imin,num);
            max = Math.max(max, imax);
        }
        return max;
    }
}
