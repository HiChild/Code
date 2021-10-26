package com.soe.leecode.testday202109.day17;

import java.util.*;



/**
 * 126. 单词接龙 II  //由c++代码改过来的 -》代码有问题，无效
 */
public class FindLadders {

    static String testBegin = "hit";
    static String testEnd = "cog";
    static List<String> wl = Arrays.asList("hot","dot","dog","lot","log","cog");


    public static void main(String[] args) {
        test();
    }

    public static void test() {
        FindLadders findLadders = new FindLadders();
        List<List<String>> ladders = findLadders.findLadders(testBegin, testEnd, wl);
        System.out.println(ladders);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return ans;
        dict.remove(beginWord);
        dict.remove(endWord);
        Set<String> q1 = new HashSet<>();
        q1.add(beginWord);
        Set<String> q2 = new HashSet<>();
        q2.add(endWord);
        HashMap<String, List<String>> next = new HashMap<>();
        boolean reversed = false, found = false;
        while (!q1.isEmpty()) {
            Set<String> q = new HashSet<>();
            for (String w : q1) {
                char[] s = w.toCharArray();
                //对s每个字符进行遍历
                for (int i = 0; i < s.length; ++i) {
                    //保存字符待回溯
                    char ch = s[i];
                    // 将当前字符改变为26个字母中的任意一个
                    for (int j = 0; j < 26; ++j) {
                        s[i] = (char) (j + 'a');
                        String str = String.valueOf(s);
                        if (q2.contains(str)) {
                            if (reversed) {
                                if (!next.containsKey(str)) {
                                    next.put(str, new ArrayList<>());
                                }
                                next.get(str).add(w);
                            } else {
                                if (!next.containsKey(w)) {
                                    next.put(w, new ArrayList<>());
                                }
                                next.get(w).add(str);
                            }
                            found = true;
                        }
                        if (dict.contains(str)) {
                            if (reversed) {
                                if (!next.containsKey(str)) {
                                    next.put(str, new ArrayList<>());
                                }
                                next.get(str).add(w);
                            } else {
                                if (!next.containsKey(w)) {
                                    next.put(w, new ArrayList<>());
                                }
                                next.get(w).add(str);
                            }
                            q.add(str);
                        }
                    }
                    //回溯
                    s[i] = ch;
                }
            }
            if (found) {
                break;
            }
            for (String s : q) {
                dict.remove(s);
            }
            if (q.size() <= q2.size()) {
                q1 = q;
            } else {
                reversed = !reversed;
                q1 = q2;
                q2 = q;
            }
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            backtracking(beginWord, endWord, next, path, ans);
        }
        return ans;
    }

    private void backtracking(String src, String dst, HashMap<String, List<String>> next, List<String> path, List<List<String>> ans) {
        if (src.equals(dst)) {
            ans.add(path);
            return;
        }
        for (String s : next.get(src)) {
            path.add(s);
            backtracking(s, dst, next, path, ans);
            path.remove(s);
        }
    }
}
