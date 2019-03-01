package _74_SearchATwoDMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rowLen = matrix.length, colLen = matrix[0].length;
        int sr = 0, sc = colLen - 1;
        while (sr >= 0 && sr < rowLen && sc >= 0) {
            if (matrix[sr][sc] == target) {
                return true;
            } else if (matrix[sr][sc] < target){
                sr ++;
            } else {
                sc --;
            }
        }
        return false;
    }
}

