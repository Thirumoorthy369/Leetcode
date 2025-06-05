class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[] minrow = new int[row];
        int[] maxcol = new int[col];

        Arrays.fill(minrow, Integer.MAX_VALUE);
        Arrays.fill(maxcol, Integer.MIN_VALUE);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] < minrow[i]) {
                    minrow[i] = matrix[i][j];
                }
            }
        }

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][j] > maxcol[j]) {
                    maxcol[j] = matrix[i][j];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == minrow[i] && matrix[i][j] == maxcol[j]) {
                    result.add(matrix[i][j]);
                }
            }
        }

        return result;
    }
}
