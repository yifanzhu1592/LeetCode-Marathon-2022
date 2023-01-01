class Solution {
    Set<Integer> set;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        set = new HashSet<>();
        dfs(board, click[0], click[1]);

        return board;
    }

    private void dfs(char[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !set.contains(row * board[0].length + col)) {
            set.add(row * board[0].length + col);
            int count = checkNumber(board, row, col);
            if (count == 0) {
                board[row][col] = 'B';
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        dfs(board, row + i, col + j);
                    }
                }
            } else {
                board[row][col] = Character.forDigit(count, 10);
            }
        }
    }

    private int checkNumber(char[][] board, int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (row + i >= 0 && row + i < board.length && col + j >= 0 && col + j < board[0].length && board[row + i][col + j] == 'M') {
                    count++;
                }
            }
        }

        return count;
    }
}
