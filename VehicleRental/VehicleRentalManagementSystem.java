import java.util.Random;
import javax.swing.*;

public abstract class VehicleRentalManagementSystem {
    private String licensePlate;
    private String brand;
    private String model;
    private double calculateRentalCost;

    public abstract void licensePlate();

    public abstract void brand();

    public abstract void model();

    public abstract void calculateRentalCost(int days);
    public String getLicensePlate() {
        Random random = new Random();
        // Generate three random uppercase letters
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letter = (char) ('A' + random.nextInt(26));
            letters.append(letter);
        }
        // Generate a random 4-digit number
        int number = 1000 + random.nextInt(9000);
        // Combine to form plate number
        String plate = letters.toString() + " " + number;
        return plate;
    }




    public VehicleRentalManagementSystem(String licensePlate, String brand, String model, double calculateRentalCost) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.calculateRentalCost = calculateRentalCost;
    }





    public void MainFunctions(){
        JOptionPane.showMessageDialog(null, "Welcome to the Vehicle Rental Management System!");
        String[] options = {"1. Rent a Vehicle", "2. Return a Vehicle", "3. View Available Vehicles", "4. Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Vehicle Rental Management",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 1:
                // Logic for renting a vehicle can be added here
                break;
            case 2:
                // Logic for viewing available vehicles can be added here
                break;
            case 3:
                // Logic for viewing available vehicles can be added here
                break;
            case 4:
                // Logic for viewing available vehicles can be added here
                break;
            default:
                JOptionPane.showMessageDialog(null, "Exiting the system. Thank you!");
                System.exit(0);
        }
    }
    
}




    /*public VehicleRentalManagementSystem(String licensePlate, String brand, String model, double rentalPricePerDay) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }*/



    public void MainFunctions() {
        JOptionPane.showMessageDialog(null, "Welcome to the Vehicle Rental Management System!");
        String[] options = {"1. Rent a Vehicle", "2. Return a Vehicle", "3. View Available Vehicles", "4. Exit"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Vehicle Rental Management",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 1:
                // Logic for renting a vehicle can be added here
                break;
            case 2:
                // Logic for viewing available vehicles can be added here
                break;
            case 3:
                // Logic for viewing available vehicles can be added here
                break;
            case 4:
                // Logic for viewing available vehicles can be added here
                break;
            default:
                JOptionPane.showMessageDialog(null, "Exiting the system. Thank you!");
        }
    }

    public static void main(String[] args) {


    }


