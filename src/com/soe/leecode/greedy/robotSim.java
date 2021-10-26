package com.soe.leecode.greedy;

import java.util.HashSet;

public class robotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        // 使用 集合 Set 存储障碍物的坐标，用来检查下一步是否受阻
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]); //简单粗暴的好方法
        }
        // 定义四个方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        // curDir 当前方向  ；  (x,y) 起始坐标
        int curDir = 0, x = 0, y = 0;
        int tx, ty;
        int ans = 0;
        for (int command : commands) {
            if (command > 0) {
                for (int i = 0; i < command; i++) {
                    tx = x + dx[curDir];
                    ty = y + dy[curDir];
                    // 下一步有障碍物，结束当前命令，跳至下一命令
                    if (set.contains(tx + "," + ty)) break;
                    x = tx;
                    y = ty;
                    // 记录行走过程中最大欧式距离的平方
                    ans = Math.max(ans, x * x + y * y);
                }
            } else {// 机器人得到转弯的指令，就更新方向
                curDir = command == -1 ? (curDir + 1) % 4 : (curDir + 3) % 4;
            }
        }
        return ans;
    }
}
