class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && isValid(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    private boolean isValid(char[][] board, int i, int j, String word, int k) {
        if(k == word.length()) return true;
        if(i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;

        char temp = board[i][j];
        board[i][j] = '*';

        boolean res = isValid(board, i + 1, j, word, k + 1) ||
        isValid(board, i, j + 1, word, k + 1) ||
        isValid(board, i - 1, j, word, k + 1) ||
        isValid(board, i, j - 1, word, k + 1);

        board[i][j] = temp;
        return res;
    }
}