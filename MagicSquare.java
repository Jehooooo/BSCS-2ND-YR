import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        // Step 1: Ask for odd number between 1 and 99
        while (true) {
            System.out.print("Enter an odd number between 1 and 99: ");
            n = scanner.nextInt();

            if (n >= 1 && n <= 99 && n % 2 == 1) {
                break;
            } else {
                System.out.println("Invalid input. Please enter an odd number between 1 and 99.");
            }
        }

        // Step 2: Ask user where to place 1
        System.out.println("\nChoose where to place number 1:");
        System.out.println("1 - Middle Top");
        System.out.println("2 - Middle Bottom");
        System.out.println("3 - Middle Left");
        System.out.println("4 - Middle Right");
        System.out.print("Enter your choice (1-4): ");
        int positionChoice = scanner.nextInt();

        int[][] magicSquare = generateMagicSquare(n, positionChoice);

        System.out.println("\nMagic Square of size " + n + "x" + n + ":");
        printSquare(magicSquare);
    }

    // Generate the magic square based on the position of 1
    public static int[][] generateMagicSquare(int n, int position) {
        int[][] magic = new int[n][n];
        int number = 1;
        int row, col;

        // Set starting point based on user choice
        switch (position) {
            case 1: // Middle Top
                row = 0;
                col = n / 2;
                break;
            case 2: // Middle Bottom
                row = n - 1;
                col = n / 2;
                break;
            case 3: // Middle Left
                row = n / 2;
                col = 0;
                break;
            case 4: // Middle Right
                row = n / 2;
                col = n - 1;
                break;
            default: // default to Middle Top
                row = 0;
                col = n / 2;
        }

        int currentRow, currentCol;

        while (number <= n * n) {
            magic[row][col] = number++;
            currentRow = row;
            currentCol = col;

            // Move based on the starting position
            switch (position) {
                case 1: // Middle Top – standard Siamese: up-right
                    row -= 1;
                    col += 1;
                    break;
                case 2: // Middle Bottom – down-left
                    row += 1;
                    col -= 1;
                    break;
                case 3: // Middle Left – up-left
                    row -= 1;
                    col -= 1;
                    break;
                case 4: // Middle Right – down-right
                    row += 1;
                    col += 1;
                    break;
            }

            // Wrap around
            if (row < 0) row = n - 1;
            if (row >= n) row = 0;
            if (col < 0) col = n - 1;
            if (col >= n) col = 0;

            if (magic[row][col] != 0) {
                // Move down (or appropriate direction) from last filled cell
                switch (position) {
                    case 1:
                        row = currentRow + 1;
                        col = currentCol;
                        break;
                    case 2:
                        row = currentRow - 1;
                        col = currentCol;
                        break;
                    case 3:
                        row = currentRow;
                        col = currentCol + 1;
                        break;
                    case 4:
                        row = currentRow;
                        col = currentCol - 1;
                        break;
                }

                if (row < 0) row = n - 1;
                if (row >= n) row = 0;
                if (col < 0) col = n - 1;
                if (col >= n) col = 0;
            }
        }

        return magic;
    }

    // Print the magic square (only first 10 rows if large)
    public static void printSquare(int[][] square) {
        int n = square.length;
        int magicSum = n * (n * n + 1) / 2;

        if (n <= 11) {
            for (int[] row : square) {
                for (int val : row) {
                    System.out.printf("%5d", val);
                }
                System.out.println();
            }
        } else {
            System.out.println("Showing only first 10 rows (square too large):");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%5d", square[i][j]);
                }
                System.out.println();
            }
        }

        System.out.println("\nMagic constant (sum of each row, column, and diagonal): " + magicSum);
    }
}