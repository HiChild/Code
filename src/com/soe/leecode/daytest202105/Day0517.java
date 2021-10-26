package com.soe.leecode.daytest202105;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Day0517 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xi = dfs(root, null, 0, x);
        int[] yi = dfs(root, null, 0, y);
        return xi[1] == yi[1] && xi[0] != yi[0];
    }
    int[] dfs(TreeNode root, TreeNode fa, int depth, int t) {
        if (root == null) return new int[]{-1, -1}; // 使用 -1 代表为搜索不到 t
        if (root.val == t) {
            return new int[]{fa != null ? fa.val : 1, depth}; // 使用 1 代表搜索值 t 为 root
        }
        int[] l = dfs(root.left, root, depth + 1, t);
        if (l[0] != -1) return l;
        return dfs(root.right, root, depth + 1, t);
    }
}
