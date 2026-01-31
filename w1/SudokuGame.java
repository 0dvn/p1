import java.util.Scanner;
import java.util.Random;

/**
 * A complete, console-based Sudoku game.
 * Features: Puzzle generation, difficulty levels, move validation, and an auto-solver.
 */
public class SudokuGame {
    private static final int SIZE = 9;
    private static final int EMPTY = 0;
    private int[][] board;
    private int[][] solution;
    private boolean[][] isOriginal;
    private final Scanner scanner;
    private final Random random;

    public SudokuGame() {
        board = new int[SIZE][SIZE];
        solution = new int[SIZE][SIZE];
        isOriginal = new boolean[SIZE][SIZE];
        scanner = new Scanner(System.in);
        random = new Random();
    }

    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        game.run();
    }

    /**
     * Main game loop.
     */
    public void run() {
        System.out.println("Welcome to Java Console Sudoku!");
        
        while (true) {
            setupGame();
            playLoop();
            
            System.out.print("\nGame Over! Play again? (y/n): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("y")) break;
        }
        System.out.println("Thanks for playing!");
    }

    private void setupGame() {
        System.out.println("\nSelect Difficulty:");
        System.out.println("1. Easy (40 clues)");
        System.out.println("2. Medium (30 clues)");
        System.out.println("3. Hard (20 clues)");
        System.out.print("Choice: ");
        
        int choice = scanner.nextInt();
        int clues;
        
        // Fixed: Using a traditional switch statement for compatibility with older Java versions
        switch (choice) {
            case 1:
                clues = 40;
                break;
            case 3:
                clues = 20;
                break;
            default:
                clues = 30;
                break;
        }

        generateSudoku(clues);
    }

    /**
     * Generates a new Sudoku board by creating a full valid board 
     * and then removing numbers.
     */
    private void generateSudoku(int clues) {
        // Clear boards
        board = new int[SIZE][SIZE];
        solution = new int[SIZE][SIZE];
        isOriginal = new boolean[SIZE][SIZE];

        // 1. Fill the board using backtracking
        fillBoard(solution);

        // 2. Copy solution to current board
        for (int r = 0; r < SIZE; r++) {
            System.arraycopy(solution[r], 0, board[r], 0, SIZE);
        }

        // 3. Remove elements to reach desired clue count
        int attempts = SIZE * SIZE - clues;
        while (attempts > 0) {
            int r = random.nextInt(SIZE);
            int c = random.nextInt(SIZE);
            if (board[r][c] != EMPTY) {
                board[r][c] = EMPTY;
                attempts--;
            }
        }

        // 4. Mark remaining cells as original (cannot be edited)
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] != EMPTY) {
                    isOriginal[r][c] = true;
                }
            }
        }
    }

    /**
     * Recursive backtracking algorithm to fill a board completely.
     */
    private boolean fillBoard(int[][] b) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (b[row][col] == EMPTY) {
                    // Try numbers in random order for variety
                    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                    shuffleArray(nums);
                    
                    for (int num : nums) {
                        if (isValid(b, row, col, num)) {
                            b[row][col] = num;
                            if (fillBoard(b)) return true;
                            b[row][col] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void shuffleArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    private boolean isValid(int[][] b, int row, int col, int num) {
        // Check row and column
        for (int i = 0; i < SIZE; i++) {
            if (b[row][i] == num || b[i][col] == num) return false;
        }

        // Check 3x3 box
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[boxRow + i][boxCol + j] == num) return false;
            }
        }
        return true;
    }

    private void playLoop() {
        while (!isComplete()) {
            printBoard();
            System.out.println("\nEnter your move (row[1-9] col[1-9] value[1-9])");
            System.out.println("Or enter '0 0 0' to give up and see solution.");
            System.out.print("> ");

            try {
                int r = scanner.nextInt() - 1;
                int c = scanner.nextInt() - 1;
                int v = scanner.nextInt();

                if (r == -1 && c == -1 && v == 0) {
                    System.out.println("\nGiving up? Here is the solution:");
                    board = solution;
                    printBoard();
                    return;
                }

                if (r < 0 || r >= SIZE || c < 0 || c >= SIZE || v < 1 || v > 9) {
                    System.out.println("Invalid input! Use range 1-9.");
                    continue;
                }

                if (isOriginal[r][c]) {
                    System.out.println("You cannot change the original puzzle clues!");
                    continue;
                }

                if (isValid(board, r, c, v)) {
                    board[r][c] = v;
                } else {
                    System.out.println("Illegal move! That number violates Sudoku rules.");
                }
            } catch (Exception e) {
                System.out.println("Please enter three integers.");
                scanner.nextLine(); // Clear buffer
            }
        }
        printBoard();
        System.out.println("\nCongratulations! You solved the puzzle!");
    }

    private boolean isComplete() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == EMPTY) return false;
            }
        }
        return true;
    }

    private void printBoard() {
        System.out.println("\n    1 2 3   4 5 6   7 8 9");
        System.out.println("  +-------+-------+-------+");
        for (int r = 0; r < SIZE; r++) {
            if (r > 0 && r % 3 == 0) {
                System.out.println("  +-------+-------+-------+");
            }
            System.out.print((r + 1) + " | ");
            for (int c = 0; c < SIZE; c++) {
                if (c > 0 && c % 3 == 0) System.out.print("| ");
                String val = (board[r][c] == EMPTY) ? "." : String.valueOf(board[r][c]);
                // Highlight original clues with bold or different marking if possible
                // In console we just print the value
                System.out.print(val + " ");
            }
            System.out.println("|");
        }
        System.out.println("  +-------+-------+-------+");
    }
}