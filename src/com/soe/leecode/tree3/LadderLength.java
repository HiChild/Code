package com.soe.leecode.tree3;

import java.util.HashSet;
import java.util.List;

public class LadderLength {
    //超时
    int minStepCount = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        helper(new HashSet<>(),1,beginWord,endWord,wordList);
        return minStepCount == Integer.MAX_VALUE ? 0 : minStepCount + 1;
    }

    private void helper(HashSet<Object> steps, int stepCount, String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            minStepCount = Math.min(stepCount,minStepCount);
            return;
        }
        for (String str : wordList) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != beginWord.charAt(i))
                    if (++diff > 1) break;
            }
            if (diff == 1 && !steps.contains(str)){
                steps.add(str);
                helper(steps, stepCount+1, str, endWord, wordList);
                steps.remove(str);
            }
        }
    }
}
