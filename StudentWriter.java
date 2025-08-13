import java.io.*;
import java.util.Scanner;

public class StudentWriter {

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static final Scanner scanner = new Scanner(System.in);

  public static void mainFunction() throws IOException {
    System.out.println("1. Insert Name " +
        "\n2. Read Names " +
        "\n3. Exit");
    char choice = scanner.next().charAt(0);

    switch (choice) {
      case '1':
        insertName();
        break;
      case '2':
        readNames();
        break;
      case '3':
        System.out.println("Exiting...");
        break;
      default:
        throw new AssertionError();
    }

  }

  public static void insertName() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));

      // Prompt the user to enter a name
      System.out.println("Enter student name: ");
      String name = br.readLine();
      System.out.println("Name entered: " + name);

      writer.write("Name: " + name);
      writer.newLine();
      writer.close();
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void readNames() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

      String line = reader.readLine();
      System.out.println("Enter The Name you want to read: ");
      String nameToRead = br.readLine().toLowerCase();
      boolean found = false;
      while ((line = reader.readLine()) != null) {
        if (line.contains(nameToRead)) {
          System.out.println("✔ Student Found: " + line);
          found = true;
          break; // optional: stop after finding
        }
      }

      if (!found) {
        System.out.println("✘ Student Not Found");
      }
      reader.close(); // don't forget to close
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) throws IOException {
    mainFunction();
    while (true) {

      System.out.println("Do you want to add more names? (yes/no)");
      try {
        String response = br.readLine();
        if (response.equalsIgnoreCase("yes")) {
          mainFunction();
        } else {
          System.out.println("Exiting...");
          break;
        }
      } catch (IOException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
