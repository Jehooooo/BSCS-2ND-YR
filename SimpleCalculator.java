import java.util.Scanner;

public class SimpleCalculator {

  public static int add(int a, int b) {
    return a + b;
  }
    public static int min(int a, int b) {
    return a - b;
  }
    public static int mult(int a, int b) {
    return a * b;
  }
    public static int div(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return 0; // Return 0 or handle as needed
        }
    return a / b;
      

  }


  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {


    System.out.println("Enter first number: ");
    int fnum = scanner.nextInt();
    System.out.println("Enter second number: ");
    int snum = scanner.nextInt();

    System.out.println("Choose an operation: ");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");
    char operation = scanner.next().charAt(0);

    double result = 0;
    switch (operation) {
        case '1':
              result = add(fnum, snum);
            break;
        case '2':
              result = min(fnum, snum);
            break;
        case '3':
              result = mult(fnum, snum);
            break;
        case '4':
              result = div(fnum, snum);
            break;
        default:
            throw new AssertionError();
    }
    System.out.println("Result: " + result);

    System.out.println("Do you want to perform another calculation? (yes/no)");
    char choice = scanner.next().charAt(0);
    if (choice == 'y' || choice == 'Y') {
        main(args); // Restart the calculator
    }else if (choice == 'n' || choice == 'N') {
        System.out.println("Exiting the calculator. Goodbye!");
    }else {
        System.out.println("Thank you for using the Simple Calculator!");
    }




  }
}
