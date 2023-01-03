class Solution {
    public int numRookCaptures(char[][] board) {
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int count = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            for (int xNext = x + direction[0], yNext = y + direction[1]; xNext >= 0 && xNext < 8 && yNext >= 0 && yNext < 8; xNext += direction[0], yNext += direction[1]) {
                if (board[xNext][yNext] == 'p') {
                    count++;
                    break;
                }
                if (board[xNext][yNext] == 'B') {
                    break;
                }
            }
        }
        return count;
    }
}
