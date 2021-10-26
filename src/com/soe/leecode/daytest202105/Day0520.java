package com.soe.leecode.daytest202105;

import java.util.*;

/**
 * 692. 前K个高频单词
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 解法一
 */
public class Day0520 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> {
                    if (o1.getValue() != o2.getValue()) {
                        return o1.getValue() - o2.getValue();
                    } else {
                        return o2.getKey().compareTo(o1.getKey());
                    }

                });

        List<String> res = new LinkedList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            queue.offer(e);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        while (!queue.isEmpty()) {
            res.add(0, queue.poll().getKey());
        }

        return res;
    }


    /**
     * 解法2
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Object[]> heap = new PriorityQueue<>(k, (a,b)-> {
            //如果词频不同，根据词频升序
            int c1 = (Integer)a[0], c2 = (Integer) b[0];
            if (c1 != c2) return c1 - c2;
            //如果词频相同，则按照字典序倒序
            String s1 = (String)a[1], s2 = (String)b[1];
            return s2.compareTo(s1);
        });
        for (String s : map.keySet()) {
            int cnt = map.get(s);
            if (heap.size() < k) {
                heap.add(new Object[]{cnt, s});
            } else {
                Object[] peek = heap.peek();
                if (cnt > (Integer)peek[0]) {
                    heap.poll();
                    heap.add(new Object[]{cnt, s});
                } else if (cnt == (Integer)peek[0]) {
                    String top = (String)peek[1];
                    if (s.compareTo(top) < 0) {
                        heap.poll();
                        heap.add(new Object[]{cnt, s});
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) ans.add((String)heap.poll()[1]);
        Collections.reverse(ans);
        return ans;
    }
}
