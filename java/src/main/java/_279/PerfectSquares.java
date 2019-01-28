package _279;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PerfectSquares {
    public int numSquares(int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);   // dist 数组表示所有的点到 0 的距离，初始值为 MAX_VALUE，表示无穷大
        dist[0] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);

        while (!deque.isEmpty()) {
            int s = deque.removeFirst();
            if (s == n) {
                return dist[n];
            }
            // 存放下一层所有的状态
            for (int j = 1; s + j * j <= n; j ++) {
                int temp = s + j * j;
                if (dist[temp] > dist[s] + 1) {
                    dist[temp] = dist[s] + 1;
                    deque.addLast(temp);
                }
            }
        }
        return 0;
    }
}
