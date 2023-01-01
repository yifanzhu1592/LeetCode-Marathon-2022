class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }

    private boolean dfs(int[][] maze, int[] current, int[] destination) {
        int row = current[0];
        int col = current[1];
        if (row == destination[0] && col == destination[1]) {
            return true;
        }
        int rows = maze.length;
        int cols = maze[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || maze[row][col] == -1) {
            return false;
        }
        maze[row][col] = -1;

        for (int i = 0; i < directions.length; i++) {
            int currentRow = row;
            int currentCol = col;
            while (currentRow + directions[i][0] >= 0 && currentRow + directions[i][0] < rows && currentCol + directions[i][1] >= 0 && currentCol + directions[i][1] < cols && maze[currentRow + directions[i][0]][currentCol + directions[i][1]] != 1) {
                currentRow += directions[i][0];
                currentCol += directions[i][1];
            }
            if (dfs(maze, new int[]{currentRow, currentCol}, destination)) {
                return true;
            }
        }

        return false;
    }
}
