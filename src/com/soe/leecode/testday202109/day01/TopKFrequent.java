package com.soe.leecode.testday202109.day01;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 */
public class TopKFrequent {
    static int[] sortedArray = {
            4,1,-1,2,-1,2,3
    };
    static int k = 2;

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] ints = topKFrequent.topKFrequent2(sortedArray, k);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 利用哈希桶求频率，利用最小堆堆求结果
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //堆内排序定义为按频率进行排序
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, (a,b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(key);
            } else if (map.get(key) > map.get(minHeap.peek())) {
                minHeap.remove();
                minHeap.add(key);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            list.add(minHeap.remove());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    //未完待续

    /**
     * 桶排序，第一次用桶记录位置，第二次用一个最大频率数+1的值作为新的桶进行排序；
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        //第一个桶，用来统计频次
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            int frequent = map.getOrDefault(num, 0) + 1;
            map.put(num, frequent);
            maxCount = Math.max(maxCount, frequent);
        }
        //创建第二个桶，用第一个桶每个元素的频率当作下标，直接放入桶中;
        List<Integer>[] bucket = new List[maxCount + 1];
        for (Integer key : map.keySet()) {
            int index = map.get(key);
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(key);
        }
        //开始倒叙遍历第二个桶，保存输出结果
        List<Integer> res = new ArrayList<>();
        for (int i = maxCount; i >= 0; --i) {
            if (bucket[i] == null) continue;
            for (Integer key  : bucket[i]) {
                if (res.size() == k) break;
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
