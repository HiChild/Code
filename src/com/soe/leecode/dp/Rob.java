package com.soe.leecode.dp;


import java.util.HashMap;
import java.util.Map;

public class Rob {


    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<>();
        return internalRob(root,map);

    }

    public int internalRob (TreeNode root, Map<TreeNode,Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) return map.get(root);
        int momey = root.val;
        if (root.left != null) {
            momey += internalRob(root.left.left,map) + internalRob(root.left.right,map);
        }
        if (root.right != null) {
            momey += internalRob(root.right.left,map) + internalRob(root.right.right,map);
        }
        int res = Math.max(momey, internalRob(root.left,map)+internalRob(root.right,map));
        map.put(root, res);
        return res;
    }
//    public int rob(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int momey = root.val;
//        if (root.left != null) {
//            momey += rob(root.left.left) + rob(root.left.right);
//        }
//        if (root.right != null) {
//            momey += rob(root.right.left) + rob(root.right.right);
//        }
//        return Math.max(momey, rob(root.left)+rob(root.right));
//    }
}
