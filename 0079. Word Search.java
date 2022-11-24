class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (exist(board, visited, x, y, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, int x, int y, char[] word, int i) {
        if (i == word.length) {
            return true;
        }
        if (x < 0 || y < 0 || x == board.length || y == board[x].length || visited[x][y] || board[x][y] != word[i]) {
            return false;
        }
        visited[x][y] = true;
        boolean exist = exist(board, visited, x, y + 1, word, i + 1)
            || exist(board, visited, x, y - 1, word, i + 1)
            || exist(board, visited, x + 1, y, word, i + 1)
            || exist(board, visited, x - 1, y, word, i + 1);
        visited[x][y] = false;
        return exist;
    }
}
