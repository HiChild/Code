package com.soe.leecode.search;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bsCol(matrix, target);
        if (row < 0) return false;
        return bsRow(matrix[row],target);
    }

    private int bsCol(int[][] matrix, int target) {
        int l = -1, right = matrix.length - 1,mid;
        while (l < right) {
            mid = (right - l + 1) / 2 + l;
            if (matrix[mid][0] <= target) {
                l = mid ;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean bsRow (int[] matrix, int target) {
        int l = 0, right = matrix.length- 1,mid ;
        while (l < right) {
            mid = (right + l ) /2;
            if (matrix[mid] == target) return true;
            if (matrix[mid] < target) {
                l = mid + 1 ;
            }else{
                right = mid -1;
            }
        }
        return matrix[right] == target;
    }



}
