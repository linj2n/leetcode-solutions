package _733;

/*
 1 1 1  -->  2 2 2
 1 1 0       2 2 0
 1 0 1       2 0 2
*/
public class FloodFill {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return dfs(image, sr, sc, newColor);
    }

    // dfs
    private int[][] dfs(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i ++) {
            int x = sr + dx[i], y = sc + dy[i];
            if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == oldColor) {
                dfs(image, x, y, newColor);
            }
        }
        return image;
    }
}
