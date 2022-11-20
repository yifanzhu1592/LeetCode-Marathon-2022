class Solution {
    
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    private boolean dfs(int[][] maze, int[] current, int[] destination, boolean[][] visited) {
        if (current[0] == destination[0] && current[1] == destination[1]) {
            return true;
        }
        int row = current[0], col = current[1];
        if (row < 0 || row > maze.length || col < 0 || col > maze[0].length || visited[row][col])  {
            return false;
        }
        visited[row][col] = true;
        for (int i = 0; i < directions.length; i++) {
            int currentRow = row, currentCol = col;
            while (currentRow + directions[i][0] >= 0 && currentRow + directions[i][0] < maze.length && currentCol + directions[i][1] >= 0 && currentCol + directions[i][1] < maze[0].length && maze[currentRow + directions[i][0]][currentCol + directions[i][1]] == 0) {
                currentRow += directions[i][0];
                currentCol += directions[i][1];
            }
            if (dfs(maze, new int[]{currentRow, currentCol}, destination, visited)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 && maze[0].length == 0) {
            return false;
        }
        return dfs(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }
}
