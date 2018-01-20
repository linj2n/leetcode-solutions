class Solution {
    public int islandPerimeter(int[][] grid) {
        int edgeCount = 0, l = grid[0].length,w = grid.length;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i-1][j] == 0) edgeCount ++;
                    if (i == w - 1 || grid[i+1][j] == 0) edgeCount ++;
                    if (j == 0 || grid[i][j-1] == 0) edgeCount ++;
                    if (j == l - 1 || grid[i][j+1] == 0) edgeCount ++;
                }
            }
        }
        return edgeCount;
    }
}