import java.util.Scanner;

public class SudokuInput {
    public static int[][] getPuzzle() {
        int[][] puzzleArray = new int[9][9];
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the string of sudoku.");
        String puzzle = console.nextLine();
        char[] c = puzzle.toCharArray();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzleArray[i][j] = Character.getNumericValue(c[i * 9 + j]);
            }
        }
        return puzzleArray;
    }
}
