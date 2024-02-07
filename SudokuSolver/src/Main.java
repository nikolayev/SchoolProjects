public class Main {
    public static void main(String[] args) {
        int[][] puzzleArray = SudokuInput.getPuzzle();

        printSudoku("Input:", puzzleArray);

        if (SudokuSolver.solveSudoku(puzzleArray)) {
            printSudoku("Solution:", puzzleArray);
        } else {
            System.out.println("Cannot solve given sudoku");
        }
    }

    public static void printSudoku (String name, int[][] board){
        System.out.println(name);

        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
