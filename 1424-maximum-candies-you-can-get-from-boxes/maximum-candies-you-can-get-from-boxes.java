import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;

        // Track which boxes we’ve already opened to avoid duplicates
        boolean[] visited = new boolean[n];

        // Track which keys we’ve collected
        boolean[] haveKey = new boolean[n];

        // Track which boxes we currently own (i.e., they’re in our hands)
        boolean[] haveBox = new boolean[n];

        // Queue for BFS traversal (boxes we can try to open)
        Queue<Integer> queue = new LinkedList<>();

        // Total candies collected so far
        int totalCandies = 0;

        // Step 1: Register all the initial boxes we have
        for (int box : initialBoxes) {
            haveBox[box] = true;

            // If the box is already open, we can explore it immediately
            if (status[box] == 1) {
                queue.offer(box);
            }
        }

        // Step 2: Process all boxes we can open using BFS
        while (!queue.isEmpty()) {
            int box = queue.poll();

            // Skip this box if we’ve already visited it before
            if (visited[box]) continue;
            visited[box] = true;

            // Collect candies from the current box
            totalCandies += candies[box];

            // Step 3: Process keys found inside the current box
            for (int key : keys[box]) {
                haveKey[key] = true;

                // If we also have the box corresponding to the key and haven’t opened it yet
                if (haveBox[key] && !visited[key]) {
                    queue.offer(key);  // We can now open it!
                }
            }

            // Step 4: Process new boxes found inside the current box
            for (int contained : containedBoxes[box]) {
                haveBox[contained] = true;

                // If the contained box is already open or we now have the key to it
                if ((status[contained] == 1 || haveKey[contained]) && !visited[contained]) {
                    queue.offer(contained);  // Queue it for exploration
                }
            }
        }

        // Step 5: Return the total candies collected
        return totalCandies;
    }
}
