package com.soe.leecode.testday202109.day17;

import java.util.*;


/**
 * 126. 单词接龙 II
 */
public class FindLadders3 {

    static String testBegin = "hit";
    static String testEnd = "cog";
    static List<String> wl = Arrays.asList("hot","dot","dog","lot","log","cog");


    public static void main(String[] args) {
        test();
    }

    public static void test() {
        FindLadders3 findLadders = new FindLadders3();
        List<List<String>> ladders = findLadders.findLadders(testBegin, testEnd, wl);
        System.out.println(ladders);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) return ans;
        bsf(beginWord, endWord, wordList, ans);
        return ans;
    }

    private void bsf(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(path);
        boolean found = false;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            //当前这一层不能及时更新入visit，不然会导致结果不全，必须等当前一层遍历完成后，统一加入visit；
            Set<String> subVisit = new HashSet<>();
            int n_queue = queue.size();
            while (n_queue-- > 0) {
                //p 为当前路径
                List<String> p = queue.poll();
                //temp为当前路径末尾的单词
                String temp = p.get(p.size() - 1);
                List<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    //剪枝
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            found = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                        }
                        p.add(neighbor);
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size() - 1);
                        subVisit.add(neighbor);
                    }
                }
                for (String neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                        }
                    }

                }
            }
            visited.addAll(subVisit);
            if (found) {
                break;
            }
        }
    }

    private List<String> getNeighbors(String temp, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            char old_char = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == old_char) continue;
                chars[i] = ch;
                String str = String.valueOf(chars);
                if (dict.contains(str)) {
                    res.add(str);
                }
            }
            chars[i] = old_char;
        }
        return res;
    }


}
