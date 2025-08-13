package converters;
import java.io.BufferedReader;
public class MainConverter {
    private static final String PROGRAM_NAME = "Converter Program";
    private static final String PROGRAM_VERSION = "1.0";
    private static final String PROGRAM_AUTHOR = "Jeho";
    private static final String PROGRAM_DESCRIPTION = "A simple converter program for weight and BMI calculations.";


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));

        while (true) { 
            
        
        System.out.println("Welcome to the Converter Program!");
        System.out.println("Please select a conversion type:");
        System.out.println("1. BMI Calculator");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Kilograms to Pounds");
        System.out.println("Enter your choice (1-3):");
        try {
            String choice = reader.readLine();
            switch (choice) {
                case "1":
                    BmiCalculator bmiCalculator = new BmiCalculator(0, 0);
                    bmiCalculator.MainFunction();
                    break;
                case "2":
                    lbsTokgs lbsToKgsConverter = new lbsTokgs();
                    lbsToKgsConverter.MainFunction();
                    break;
                case "3":
                    kgsTolbs kgsToLbsConverter = new kgsTolbs();
                    kgsToLbsConverter.MainFunction();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println("Error closing the reader: " + e.getMessage());
            }
        }


    }
    }
    
}
