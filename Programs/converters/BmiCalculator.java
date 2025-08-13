package converters;
import java.io.BufferedReader;
class BmiCalculator {
    private static final String PROGRAM_NAME = "BMI Calculator";

    private double weight;
    private double height;

    public BmiCalculator(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public void MainFunction() {
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        
        try {
        System.out.println("Please enter your weight in kilograms:");
            String weightInput = reader.readLine();
            double weight = Double.parseDouble(weightInput);
            
            System.out.println("Please enter your height in meters:");
            String heightInput = reader.readLine();
            double height = Double.parseDouble(heightInput);
            
            double bmi = weight / (height * height);
            System.out.printf("Your BMI is: %.2f%n", bmi);
            
            if (bmi < 18.5) {
                System.out.println("You are underweight.");
            } else if (bmi < 24.9) {
                System.out.println("You have a normal weight.");
            } else if (bmi < 29.9) {
                System.out.println("You are overweight.");
            } else {
                System.out.println("You are obese.");
            }

        System.out.println("Please enter your height in meters:");
        this.weight = weight;
        this.height = height;
            
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

    public double getWeightHeight() {
        return weight + height;
    }


}