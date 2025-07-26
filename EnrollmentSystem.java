import java.io.*;
import javax.swing.JOptionPane;

public class EnrollmentSystem {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String courseName;
    private String studentName;
    private String studentID; // Changed from int to String
    private String[][] subjects;
    private int yearLevel;
    private boolean isEnrolled;
    private static int listNumber = 1;

    // Main constructor
    public EnrollmentSystem(String courseName, String studentName, String studentID, String[][] subjects, int yearLevel) {
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentID = studentID;
        this.subjects = subjects;
        this.yearLevel = yearLevel;
    }

    // ID generator
    private static String generateID(int yearLevel, int listNumber) {
        return String.format("241-%d-%03d", yearLevel, listNumber);
    }

    // Enroll method (interactive)
    public void enrollStudent() {
        String course = JOptionPane.showInputDialog("Enter Course Name:");
        this.courseName = course;

        String name = JOptionPane.showInputDialog("Enter Student Name:");
        this.studentName = name;

        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year Level:"));
        this.yearLevel = year;

        this.studentID = generateID(yearLevel, listNumber++);
        this.isEnrolled = true;
    }

    // Main Method
    public static void main(String[] args) {
        String[][] subjects = { { "Math", "CS101" }, { "Physics", "CS102" } };

        EnrollmentSystem enrollment = new EnrollmentSystem("", "", "", subjects, 0);
        enrollment.enrollStudent();

        JOptionPane.showMessageDialog(null, "Enrollment Successful!\n" +
                "Course: " + enrollment.courseName + "\n" +
                "Student Name: " + enrollment.studentName + "\n" +
                "Student ID: " + enrollment.studentID);
        
        //SAVE THE ENROLLED STUDENT TO A FILE
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("enrolledStudents.txt", true))) {
            writer.write("Course: " + enrollment.courseName + "\n");
            writer.write("Student Name: " + enrollment.studentName + "\n");
            writer.write("Student ID: " + enrollment.studentID + "\n");
            writer.write("Year Level: " + enrollment.yearLevel + "\n");
            writer.write("Subjects:\n");
            for (String[] subject : enrollment.subjects) {
                writer.write(subject[0] + " (" + subject[1] + ")\n");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
