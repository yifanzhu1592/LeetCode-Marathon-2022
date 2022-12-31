class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int top = Math.max(0, row - 1);
                int bottom = Math.min(rows - 1, row + 1);
                int left = Math.max(0, col - 1);
                int right = Math.min(cols - 1, col + 1);

                int liveNeighbors = 0;
                for (int i = top; i <= bottom; i++) {
                    for (int j = left; j <= right; j++) {
                        if (!(i == row && j == col) && Math.abs(board[i][j]) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                if (board[row][col] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[row][col] = -1;
                    }
                }
                if (board[row][col] == 0) {
                    if (liveNeighbors == 3) {
                        board[row][col]= 2;
                    }
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == -1) {
                    board[row][col] = 0;
                } else if (board[row][col] == 2) {
                    board[row][col] = 1;
                }
            }
        }
    }
}
