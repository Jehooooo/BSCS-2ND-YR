package converters;
class kgsTolbs {
    private static final double KILOGRAMS_TO_POUNDS = 2.20462;

    private double kilograms;
    private double pounds;
    public double kilogramsConvert(double kilograms) {
        this.kilograms = kilograms;
        this.pounds = kilograms * KILOGRAMS_TO_POUNDS;
        return pounds;
    }
    public double poundsConvert(double pounds) {
        this.pounds = pounds;
        this.kilograms = pounds / KILOGRAMS_TO_POUNDS;
        return kilograms;
    }
    public void MainFunction() {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        
        try {
            System.out.println("Please enter weight in kilograms:");
            String kilogramsInput = reader.readLine();
            double kilograms = Double.parseDouble(kilogramsInput);
            double pounds = kilogramsConvert(kilograms);
            System.out.printf("Weight in pounds: %.2f lbs%n", pounds);

            System.out.println("Please enter weight in pounds:");
            String poundsInput = reader.readLine();
            double lbs = Double.parseDouble(poundsInput);
            double kg = poundsConvert(lbs);
            System.out.printf("Weight in kilograms: %.2f kg%n", kg);

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