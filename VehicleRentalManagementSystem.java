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
    public double getLicensePlate() {
        Random  random = new Random();
        return random.nextInt(10000);
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
    
    public static void main(String[] args) {
        VehicleRentalManagementSystem system = new VehicleRentalManagementSystem();
        system.MainFunctions();
        // Additional functionality can be added here
    }
    
}
