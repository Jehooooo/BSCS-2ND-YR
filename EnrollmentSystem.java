import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class EnrollmentSystem {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String courseName;
    private String studentName;
    private String studentID; // Changed from int to String
    private String[][] subjects;
    private int yearLevel;
    private boolean isEnrolled;

    // Main constructor
    public EnrollmentSystem(String courseName, String studentName, String studentID, String[][] subjects,
            int yearLevel) {
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentID = studentID;
        this.subjects = subjects;
        this.yearLevel = yearLevel;
    }

    // ID generator
    private static String generateID(int yearLevel) {

        return String.format("241-%d-%03d", yearLevel, generateListNumber(yearLevel));
    }

    public static int generateListNumber(int yearLevel) {
        Random random = new Random();
        int listNumber = random.nextInt(9999 + 1); // Generates a random number between
        return listNumber; // Placeholder for actual logic
    }

    // Enroll method (interactive)
    public void enrollStudent() {
        String course = JOptionPane.showInputDialog("Enter Course Name:");
        this.courseName = course;

        String name = JOptionPane.showInputDialog("Enter Student Name:");
        this.studentName = name;

        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year Level:"));
        this.yearLevel = year;

        this.studentID = generateID(yearLevel); // Assuming listNumber starts at 0 for simplicity
        this.isEnrolled = true;
    }

    //Save to File
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("enrolledStudents.txt", true))) {
            writer.write("Course: " + this.courseName.toUpperCase()+"\n");
            writer.write("Student Name: " + this.studentName.toUpperCase()+"\n");
            writer.write("Student ID: " + this.studentID+"\n");
            writer.write("Year Level: " + this.yearLevel+"\n");
            writer.write("Subjects:");
            for (String[] subject : subjects) {
                writer.newLine();
                writer.write(subject[0] + " (" + subject[1] + ")");
            }
            writer.newLine();
            writer.newLine(); // Add an extra line for separation
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Main Method
    public static void main(String[] args) {

        String[][] subjects = { { "Math", "CS101" }, { "Physics", "CS102" } };

        EnrollmentSystem enrollment = new EnrollmentSystem("", "", "", subjects, 0);
        enrollment.enrollStudent();


        enrollment.saveToFile();
        enrollment.askAgain(); // Ask if the user wants to enroll another student


    }
    //ask again
    public void askAgain() {
            String [] options = { "Yes", "No" };
            int choice = JOptionPane.showOptionDialog(null, "Do you want to enroll another student?", "Enrollment System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                    if (choice == 0) {
                        enrollStudent();
                        saveToFile();
                        askAgain(); // Recursively ask again
                    } else {
                        JOptionPane.showMessageDialog(null, "Thank you for using the Enrollment System!");
                    }
    }
}

