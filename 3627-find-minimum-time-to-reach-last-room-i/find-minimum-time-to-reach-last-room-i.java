import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // {time, row, col}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], x = cur[1], y = cur[2];
            if (x == n - 1 && y == m - 1) return time;
            if (time > dist[x][y]) continue;

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int newTime = Math.max(time, moveTime[nx][ny]) + 1;
                    if (newTime < dist[nx][ny]) {
                        dist[nx][ny] = newTime;
                        pq.offer(new int[]{newTime, nx, ny});
                    }
                }
            }
        }

        return -1; // unreachable
    }
}
