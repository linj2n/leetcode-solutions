package _733;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 1 1 1  -->  2 2 2
 1 1 0       2 2 0
 1 0 1       2 0 2
*/
public class FloodFill {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return bfs(image, sr, sc, newColor);
    }

    // BFS
    private int[][] bfs(int[][] image, int sr, int sc, int newColor) {
        boolean[][] isVisited = new boolean[image.length][image[0].length];

        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(sr, sc));
        isVisited[sr][sc] = true;

        while (!deque.isEmpty()) {
            Point curr = deque.removeFirst();
            int oldColor = image[curr.r][curr.c];
            image[curr.r][curr.c] = newColor;
            for (int i = 0; i < 4; i ++) {
                int row = curr.r + dx[i], col = curr.c + dy[i];
                if (row >= 0 && row < image.length && col >= 0 && col < image[0].length
                        && image[row][col] == oldColor
                        && !isVisited[row][col]) {
                    deque.addLast(new Point(row, col));
                    isVisited[row][col] = true;
                }
            }
        }
        return image;
    }

    // DFS
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
