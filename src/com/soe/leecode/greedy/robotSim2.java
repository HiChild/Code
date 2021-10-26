package com.soe.leecode.greedy;

import java.util.HashSet;
import java.util.Set;

public class robotSim2 {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        //将障碍物节点加入set
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0]+","+obstacle[1]);
        }
        //定义方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int currDir = 0,x = 0,y = 0;
        int maxLen = 0;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    int tx = x + dx[currDir];
                    int ty = y + dy[currDir];
                    if (set.contains(tx + "," + ty)) break;
                    x = tx;
                    y = ty;
                    maxLen = Math.max(maxLen, x*x + y*y);
                }
            } else {
                currDir = command == -1 ? (currDir+1) % 4 : (currDir + 3) % 4;
            }
        }
        return maxLen;
    }
}
