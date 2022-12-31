class Solution {
    int empty, numOfWalks = 0;
    int startX, startY;

    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    empty++;
                }
            }
        }

        dfs(grid, startX, startY);

        return numOfWalks;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1 || grid[i][j] == -2) {
            return;
        }

        if (grid[i][j] == 2) {
            if (empty == 0) {
                numOfWalks++;
            }
            return;
        }

        grid[i][j] = -2;
        empty--;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        grid[i][j] = 0;
        empty++;
    }
}
