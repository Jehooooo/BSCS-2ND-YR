import java.util.*;
public class GradeCalculator {

  private static Scanner scanner = new Scanner(System.in);

  public static void personalInfo() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter First Name: ");
    String name = scanner.nextLine();

    while (name.isEmpty()) {
      System.out.println("First name cannot be empty. Please enter your first name: ");
      name = scanner.nextLine();
    }
    System.out.println("Enter Middle Name: ");
    String initial = scanner.nextLine();
    while (initial.isEmpty() || initial.length() > 1) {
      System.out.println("Middle name must be a single character. Please enter your middle name: ");
      initial = scanner.nextLine();
    }

    System.out.println("Enter Last Name: ");
    String last = scanner.nextLine();
    while (last.isEmpty()) {
      System.out.println("Last name cannot be empty. Please enter your last name: ");
      last = scanner.nextLine();
    }

    gradesCalculation();

    
    System.out.println("Full Name: " + name.toUpperCase() + " " + last.toUpperCase());
    System.out.println("Middle Initial: " + middleName(initial).toUpperCase());
    scanner.close();
  }
  public static void gradesCalculation(){ 
    double average = 0;

    for (int i = 0; i < 8; i++) {
      System.out.println("Enter Grade " + (i + 1) + ": ");
      int grade = scanner.nextInt();
      average += grade;
        
    }
    average /= 8;
    System.out.println("Average Grade: " + average);

  }
  public static String middleName(String initial) {
    char initialChar = initial.charAt(0);
    System.out.println("Initial: " + initialChar);
    return String.valueOf(initialChar);
  }
  public static void main(String[] args) {
    
    personalInfo();
    





  }
}
