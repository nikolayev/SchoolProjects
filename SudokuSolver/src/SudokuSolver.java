public class SudokuSolver {
    public static boolean solveSudoku(int[][] board) {
        return solveSudoku(board, 0, 0);
    }

    private static boolean solveSudoku(int[][] board, int row, int col) {
        if (row >= 8 && col > 8) return true;

        if (col == 9) {
            row++;
            col = 0;
        }

        if (board[row][col] > 0)
            return solveSudoku(board, row, col + 1);

        for (int i = 1; i <=9; i++) {
            if (isCorrect(board, row, col, i)) {
                board[row][col] = i;

                if (solveSudoku(board, row, col + 1))
                    return true;

                board[row][col] = 0;
            }
        }

        return false;
    }

    static boolean isCorrect(int[][] grid, int row, int col, int current)
    {
        for (int x = 0; x <= 8; x++)
            if (grid[row][x] == current)
                return false;

        for (int x = 0; x <= 8; x++)
            if (grid[x][col] == current)
                return false;

        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i + startRow][j + startCol] == current)
                    return false;

        return true;
    }
}
