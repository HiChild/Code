package com.soe.leecode.tree2;

import java.util.HashSet;

public class MinMutation1 {
    int minStepCount = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dsf(new HashSet<String>(), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }

    private void dsf(HashSet<String> step, int stepCount, String start, String end, String[] bank) {
        if (start.equals(end)) {
            minStepCount = Math.min(minStepCount, stepCount);
            return;
        }
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++)
                if (start.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dsf(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}
