class Solution {
    public int minPathSum(int[][] g) {
        int m = g.length, n = g[0].length;
        int[] a = new int[n];
        a[0] = g[0][0];
        for (int j = 1; j < n; j++)
         {
            a[j] = a[j - 1] + g[0][j];
        }
        for (int i = 1; i < m; i++)
         {
            a[0] += g[i][0];
            for (int j = 1; j < n; j++) {
                a[j] = Math.min(a[j], a[j - 1]) + g[i][j];
            }
        }
        return a[n - 1];
    }
}