class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSquareSideLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    maxSquareSideLength = Math.max(maxSquareSideLength, dp[i][j]);
                }
            }
        }
        return maxSquareSideLength * maxSquareSideLength;
    }
}
