package com.soe.leecode.daytest;

/**
 * 307. 区域和检索 - 数组可修改
 *
 * 数组不变，求区间和：「前缀和」、「树状数组」、「线段树」
 *
 * 多次修改某个数，求区间和：「树状数组」、「线段树」
 *
 * 多次整体修改某个区间，求区间和：「树状数组」、「线段树」
 *
 * 多次将某个区间变成同一个数，求区间和：「线段树」
 *
 * 作者：AC_OIer
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable/solution/guan-yu-ge-lei-qu-jian-he-wen-ti-ru-he-x-41hv/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumArrayTree {
//    树状数组
    int n;
    int[] nums;
    int[] tree;
    int lowbit(int x) {
        return x & -x;
    }
    int query (int x) {
        int ans = 0;
        for (int i = x;i > 0; i -=lowbit(i)) ans+=tree[i];
        return ans;
    }
    void add(int x,int u) {
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }
    public NumArrayTree(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; ++i) add(i + 1, nums[i]);
    }

    public void update(int i, int val) {
        add(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int l, int r) {
        return query(r + 1) - query(l);
    }

    /**
     * 树状数组模板
     */
//    // 上来先把三个方法写出来
//    {
//        int[] tree;
//        int lowbit(int x) {
//        return x & -x;
//    }
//        // 查询前缀和的方法
//        int query(int x) {
//        int ans = 0;
//        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
//        return ans;
//    }
//        // 在树状数组 x 位置中增加值 u
//        void add(int x, int u) {
//        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
//    }
//    }
//
//    // 初始化「树状数组」，要默认数组是从 1 开始
//    {
//        for (int i = 0; i < n; i++) add(i + 1, nums[i]);
//    }
//
//    // 使用「树状数组」：
//    {
//        void update(int i, int val) {
//        // 原有的值是 nums[i]，要使得修改为 val，需要增加 val - nums[i]
//        add(i + 1, val - nums[i]);
//        nums[i] = val;
//    }
//
//        int sumRange(int l, int r) {
//        return query(r + 1) - query(l);
//    }
//    }




}
