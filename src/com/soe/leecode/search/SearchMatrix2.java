package com.soe.leecode.search;

public class SearchMatrix2 {
    class Solution {
        public boolean searchMatrix(int[][] mat, int t) {
            int m = mat.length, n = mat[0].length;
            int l = 0, r = m * n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[mid / n][mid % n] <= t) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return mat[r / n][r % n] == t;
        }
    }
}
