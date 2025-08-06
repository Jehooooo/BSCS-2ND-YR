import javax.swing.JOptionPane;

public class Converter {

  public void Binary() {

  }

  public void Decimal() {

  }

  public void Octal() {

  }

  public void Hexadecimal() {

  }

  public void mainFunction() {

    String[] options = { "Binary(B)", "Decimal(D)", "Octal", "Hexadecimal(H)" };
    String choice = (String) JOptionPane.showInputDialog(null, "Choose conversion type:", "Converter",
        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    if (choice == null) {
      System.exit(0);
    }

    switch (choice) {
      case "Binary(B)":
        Binary();
        break;
      case "Decimal(D)":
        Decimal();
        break;
      case "Octal":
        Octal();
        break;
      case "Hexadecimal(H)":
        Hexadecimal();
        break;
      default:
        JOptionPane.showMessageDialog(null, "Invalid choice.");
    }

    String input = JOptionPane.showInputDialog("Enter a 4 series of numbers (e.g., 1234): ");
    if (input == null || input.trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Input cannot be empty.");
    } else if (!input.matches("\\d{4}")) {
      JOptionPane.showMessageDialog(null, "Input must be exactly 4 digits.");
    } else {
      JOptionPane.showMessageDialog(null, "You entered: " + input);
    }
    if (input == null) {
      System.exit(0);
    }
  } // Close mainFunction method

  public static void main(String[] args) {

    Converter converter = new Converter();
    converter.mainFunction();

  }

}
