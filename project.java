
import java.util.Scanner;

public class project {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter a number (1-99): ");
    int num = scanner.nextInt();

    if (num >= 1 && num <= 99 && num % 2 == 1) {
      System.out.print("Number " + num + " is odd");
   
      int[][] square = new int[num][num];
      int number = 1;
      int row = num - 1;
      int col = num / 2;

      while (number <= num * num) {
        square[row][col] = number;
        number++;

        int nextRow = (row + 1) % num;
        int nextCol = (col + 1) % num;

        if (square[nextRow][nextCol] !=0) {
          row = (row - 1 + num) % num;
        } else { 
          row = nextRow;
          col = nextCol;
        }
      }
      System.out.println("Magic Square Pattern: ");
       for (int i=0; i<num; i++) {
          for(int j =0; j<num; j++) {
            System.out.printf("%4d", square[i][j]);
          }
          System.out.println();
        }
        } else {
          System.out.println("Invalid input");
        }
       }
      }
      