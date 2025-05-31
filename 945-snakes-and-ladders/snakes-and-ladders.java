import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // [position, steps]
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int steps = current[1];

            for (int move = 1; move <= 6; move++) {
                int next = pos + move;
                if (next > n * n) break;

                int[] coords = getCoordinates(next, n);
                int row = coords[0], col = coords[1];
                if (board[row][col] != -1) next = board[row][col];

                if (next == n * n) return steps + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, steps + 1});
                }
            }
        }
        return -1;
    }

    private int[] getCoordinates(int pos, int n) {
        int row = (pos - 1) / n;
        int col = (pos - 1) % n;
        if (row % 2 == 1) col = n - 1 - col;
        row = n - 1 - row;
        return new int[]{row, col};
    }
}
