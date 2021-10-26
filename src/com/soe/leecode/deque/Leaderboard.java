package com.soe.leecode.deque;

import java.util.*;

class Leaderboard {
    private TreeMap<Integer,Integer> treeMap;
    //PriorityQueue 只保证堆头最大或最小，内部并不保证有序

    public Leaderboard() {
        treeMap = new TreeMap<Integer,Integer>();
    }

    public void addScore(int playerId, int score) {
        treeMap.put(playerId,treeMap.getOrDefault(playerId,0) + score);
    }

    public int top(int K) {
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>(treeMap.values());
        list.sort(((o1, o2) -> Integer.compare(o2,o1)));
        for (int i = 0; i < K; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void reset(int playerId) {
        treeMap.remove(playerId);
    }

    public static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.addScore(1,82);
        leaderboard.addScore(2,84);
        leaderboard.addScore(3,47);
        leaderboard.addScore(4,86);
        leaderboard.addScore(5,92);
        leaderboard.addScore(6,74);
        leaderboard.addScore(7,34);
        leaderboard.addScore(8,67);
        leaderboard.addScore(9,76);
        leaderboard.addScore(10,73);
        int top1 = leaderboard.top(4);
        leaderboard.top(4);
        int top2 = leaderboard.top(8);
        int score = leaderboard.top(2);
        System.out.println("score -- > :" + top1);
        System.out.println("score -- > :" + top2);


    }
}