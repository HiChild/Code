package com.soe.leecode.tree2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestValues2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    //level表示的是第几层，集合res中的第一个数据表示的是
    // 第一层的最大值，第二个数据表示的是第二层的最大值……
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null)
            return;
        //如果走到下一层了直接加入到集合中
        if (level == res.size()) {
            res.add(root.val);
        } else {
            //注意：我们的level是从1开始的，也就是说root
            // 是第一层，而集合list的下标是从0开始的，
            // 所以这里level要减1。
            // Math.max(res.get(level - 1), root.val)表示的
            // 是遍历到的第level层的root.val值和集合中的第level
            // 个元素的值哪个大，就要哪个。
            res.set(level, Math.max(res.get(level), root.val));
        }
        //下面两行是DFS的核心代码
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
    }
}
