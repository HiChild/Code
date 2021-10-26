package com.soe.leecode.tree2;

import java.util.HashSet;

public class MinMutation111 {
    int minStepCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<>(), 0, start, end, bank);
        return minStepCount == Integer.MAX_VALUE ? -1 : minStepCount;
    }

    private void dfs(HashSet<Object> steps, int stepCount, String start, String end, String[] bank) {
        if (start.equals(end)) {
            minStepCount = Math.min(stepCount, minStepCount);
            return;
        }
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != start.charAt(i)) {
                    if (++diff > 1) break;
                }
            }
            if (diff == 1 && !steps.contains(str)) {
                steps.add(str);
                dfs(steps, stepCount + 1, str, end, bank);
                steps.remove(str);
            }
        }
    }


}
