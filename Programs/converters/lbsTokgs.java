package converters;
class lbsTokgs {
    private static final double LBS_TO_KGS_CONVERSION_FACTOR = 0.45359237;

    private double pounds;
    private double kilograms;

    public double poundsConvert(double pounds) {
        this.pounds = pounds;
        this.kilograms = pounds * LBS_TO_KGS_CONVERSION_FACTOR;
        return kilograms;
    }
    public double kilogramsConvert(double kilograms) {
        this.kilograms = kilograms;
        this.pounds = kilograms / LBS_TO_KGS_CONVERSION_FACTOR;
        return pounds;
    }
    public void MainFunction(){
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        
        try {
            System.out.println("Please enter weight in pounds:");
            String poundsInput = reader.readLine();
            double pounds = Double.parseDouble(poundsInput);
            double kilograms = poundsConvert(pounds);
            System.out.printf("Weight in kilograms: %.2f kg%n", kilograms);

            System.out.println("Please enter weight in kilograms:");
            String kilogramsInput = reader.readLine();
            double kg = Double.parseDouble(kilogramsInput);
            double lbs = kilogramsConvert(kg);
            System.out.printf("Weight in pounds: %.2f lbs%n", lbs);

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
