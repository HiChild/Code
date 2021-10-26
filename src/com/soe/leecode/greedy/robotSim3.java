package com.soe.leecode.greedy;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

public class robotSim3 {
    public int robotSim(int[] commands, int[][] obstacles) {
        //使用Pair数据结构优化了时间
        Set<Pair<Integer,Integer>> set = new HashSet<>();
        //将障碍物节点加入set
        for (int[] obstacle : obstacles) {
            set.add(new Pair<>(obstacle[0],obstacle[1]));
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
                    if (set.contains(new Pair<>(tx,ty))) break;
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
