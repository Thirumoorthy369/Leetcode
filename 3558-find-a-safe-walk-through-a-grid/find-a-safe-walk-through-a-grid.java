import java.util.*;

public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 3D boolean array to track visited states: [row][col][remaining health]
        boolean[][][] visited = new boolean[m][n][health + 1];
        Queue<int[]> queue = new LinkedList<>();

        int initialHealth = health - grid.get(0).get(0);
        if (initialHealth <= 0) return false;

        queue.offer(new int[]{0, 0, initialHealth});
        visited[0][0][initialHealth] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], currHealth = current[2];

            // Check if we've reached the destination
            if (row == m - 1 && col == n - 1) return true;

            // Explore neighboring cells
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newHealth = currHealth - grid.get(newRow).get(newCol);
                    if (newHealth > 0 && !visited[newRow][newCol][newHealth]) {
                        visited[newRow][newCol][newHealth] = true;
                        queue.offer(new int[]{newRow, newCol, newHealth});
                    }
                }
            }
        }

        // No valid path found
        return false;
    }
}
