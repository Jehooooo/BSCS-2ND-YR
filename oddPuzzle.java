import java.util.Scanner;

public class oddPuzzle {

  // Method to generate the magic square
  public static int[][] displayNumbers(int[][] magicSquare, int position) {
    int n = magicSquare.length;
    int number = 1;
    int row = 0, col = n / 2;
    int currentRow, currentCol;

    // Set starting position based on user choice
    switch (position) {
      case 1: row = 0;        col = n / 2;      break; // Middle Top
      case 2: row = n - 1;    col = n / 2;      break; // Middle Bottom
      case 3: row = n / 2;    col = 0;          break; // Middle Left
      case 4: row = n / 2;    col = n - 1;      break; // Middle Right
      default:
        throw new IllegalArgumentException("Invalid position. Must be 1-4.");
    }

    while (number <= n * n) {
      magicSquare[row][col] = number++;
      currentRow = row;
      currentCol = col;

      // Move to next cell based on direction
      switch (position) {
        case 1: row = (row - 1 + n) % n; col = (col + 1) % n; break; // up-right
        case 2: row = (row + 1) % n; col = (col - 1 + n) % n; break; // down-left
        case 3: row = (row - 1 + n) % n; col = (col - 1 + n) % n; break; // up-left
        case 4: row = (row + 1) % n; col = (col + 1) % n; break; // down-right
        default:
          throw new IllegalArgumentException("Invalid position. Must be 1-4.");
      }

      // If cell is already filled, move based on fallback
      if (magicSquare[row][col] != 0) {
        switch (position) {
          case 1: row = (currentRow + 1) % n; col = currentCol; break;
          case 2: row = (currentRow - 1 + n) % n; col = currentCol; break;
          case 3: row = currentRow; col = (currentCol + 1) % n; break;
          case 4: row = currentRow; col = (currentCol - 1 + n) % n; break;
        }
      }
    }

    return magicSquare;
  }

  // Method to ask user if they want to try again
  public static boolean askToRepeat(Scanner scanner) {
    while (true) {
      System.out.print("\nDo you want to generate another magic square? (y/n): ");
      String input = scanner.next().trim().toLowerCase();
      if (input.equals("y")) return true;
      else if (input.equals("n")) return false;
      else System.out.println("Invalid input. Please enter 'y' or 'n'.");
    }
  }

  // Method to display diagonal numbers in a straight line and show the sum
  public static void showRightDiagonalLinear(int[][] magicSquare) {
    int n = magicSquare.length;
    int sum = 0;

    System.out.print("\nDiagonal (Top-Left to Bottom-Right): ");
    for (int i = 0; i < n; i++) {
      System.out.print(magicSquare[i][i] + " ");
      sum += magicSquare[i][i];
    }
    System.out.println("\nSum of Diagonal: " + sum);
  }

  // Main method
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    do {
      int n = 0;
      int choice = 0;

      // Get a valid odd number
      while (true) {
        System.out.print("Enter an odd number (1-99): ");
        if (scanner.hasNextInt()) {
          n = scanner.nextInt();
          if (n >= 1 && n <= 99 && n % 2 == 1) {
            break;
          } else {
            System.out.println("Invalid input. Please enter an odd number between 1 and 99.");
          }
        } else {
          System.out.println("Invalid input. Please enter a valid integer.");
          scanner.next(); // clear invalid input
        }
      }

      int[][] magicSquare = new int[n][n];

      // Choose position for number 1
      while (true) {
        System.out.println("Choose where to place number 1:");
        System.out.println("1. Middle top");
        System.out.println("2. Middle bottom");
        System.out.println("3. Middle left");
        System.out.println("4. Middle right");
        System.out.print("Enter your choice (1-4): ");
        if (scanner.hasNextInt()) {
          choice = scanner.nextInt();
          if (choice >= 1 && choice <= 4) {
            break;
          } else {
            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
          }
        } else {
          System.out.println("Invalid input. Please enter a valid integer.");
          scanner.next(); // clear invalid input
        }
      }

      // Generate and print the magic square
      System.out.println("\nGenerating magic square...\n");
      displayNumbers(magicSquare, choice);

      System.out.println("Magic Square:");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          System.out.printf("%4d", magicSquare[i][j]);
        }
        System.out.println();
      }

      // Display the right diagonal numbers in a line and their sum
      showRightDiagonalLinear(magicSquare);

    } while (askToRepeat(scanner)); // Loop if user wants to try again


    scanner.close();
  }
}