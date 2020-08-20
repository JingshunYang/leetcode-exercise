class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int[] dir_x = {-1,  0,  1, -1, 1, -1, 0, 1};
        int[] dir_y = {-1, -1, -1,  0, 0,  1, 1, 1};
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dir_x[i], ty = y + dir_y[i];
            if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length && board[tx][ty] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = (char)(cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dir_x[i], ty = y + dir_y[i];
                if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length && board[tx][ty] == 'E') {
                    dfs(board, tx, ty);
                }
            }
        }
    }
}

