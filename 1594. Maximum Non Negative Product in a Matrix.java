class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    max[0][0] = grid[0][0];
                    min[0][0] = grid[0][0];
                } else if (i == 0) {
                    max[i][j] = grid[i][j] * max[0][j - 1];
                    min[i][j] = grid[i][j] * min[0][j - 1];
                } else if (j == 0) {
                    max[i][j] = grid[i][j] * max[i - 1][0];
                    min[i][j] = grid[i][j] * min[i - 1][0];
                } else {
                    long maxOrMin0 = grid[i][j] * Math.max(max[i][j - 1], max[i - 1][j]);
                    long maxOrMin1 = grid[i][j] * Math.min(min[i][j - 1], min[i - 1][j]);
                    max[i][j] = Math.max(maxOrMin0, maxOrMin1);
                    min[i][j] = Math.min(maxOrMin0, maxOrMin1);
                }
            }
        }
        
        if (max[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (max[m - 1][n - 1] % 1_000_000_007);
        }
    }
}
