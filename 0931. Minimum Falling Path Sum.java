class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }
        int dp[] = new int[matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            int currentRow[] = new int[matrix.length];
            for (int col = 0; col < matrix.length; col++) {
                if (col == 0) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col + 1]) + matrix[row][col];
                } else if (col == matrix.length - 1) {
                    currentRow[col] =
                        Math.min(dp[col], dp[col - 1]) + matrix[row][col];
                } else {
                    currentRow[col] = Math.min(dp[col],
                        Math.min(dp[col + 1], dp[col - 1])) + matrix[row][col];
                }
            }
            dp = currentRow;
        }
        int minFallingSum = Integer.MAX_VALUE;
        for (int col = 0; col < matrix.length; col++) {
            minFallingSum = Math.min(minFallingSum, dp[col]);
        }
        return minFallingSum;
    }
}
