import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class EnrollmentSystem {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String courseName;
    private String studentName;
    private String studentID;
    private String[] subjects; // Only the selected year-level subjects
    private int yearLevel;
    private boolean isEnrolled;

    // All subjects grouped by year level
    private static final String[][] allSubjects = {
        { // 1st Year
            "Introduction to Computing",
            "Computer Programming 1 (Fundamentals)",
            "Discrete Mathematics",
            "Computer Programming 2 (OOP)",
            "Introduction to Human-Computer Interaction",
            "Digital Logic Design"
        },
        { // 2nd Year
            "Data Structures and Algorithms",
            "Computer Organization and Architecture",
            "Object-Oriented Programming",
            "Operating Systems",
            "Software Engineering",
            "Web Systems and Technologies"
        },
        { // 3rd Year
            "Database Management Systems",
            "Automata and Formal Languages",
            "Computer Networks",
            "Artificial Intelligence",
            "Mobile Application Development",
            "Information Assurance and Security"
        },
        { // 4th Year
            "Capstone Project / Thesis Writing",
            "IT Project Management",
            "Professional Ethics and Social Issues in Computing",
            "Machine Learning or Data Science",
            "Internship / On-the-Job Training (OJT)"
        }
    };

    // Constructor
    public EnrollmentSystem(String courseName, String studentName, String studentID, String[] subjects, int yearLevel) {
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
        return random.nextInt(9999+1); // 000 to 999
    }

    // Enroll student
    public void enrollStudent() {
        this.courseName = JOptionPane.showInputDialog("Enter Course Name:");
        this.studentName = JOptionPane.showInputDialog("Enter Student Name:");
        
        // Get year level and validate
        int year = 0;
        while (year < 1 || year > 4) {
            try {
                year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year Level (1-4):"));
                if (year < 1 || year > 4) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid year level (1-4).");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }

        this.yearLevel = year;
        this.subjects = allSubjects[year - 1]; // Get only subjects of selected year
        this.studentID = generateID(yearLevel);
        this.isEnrolled = true;
    }

    // Save to File
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("enrolledStudents.txt", true))) {
            writer.write("Course: " + courseName.toUpperCase() + "\n");
            writer.write("Student Name: " + studentName.toUpperCase() + "\n");
            writer.write("Student ID: " + studentID + "\n");
            writer.write("Year Level: " + yearLevel + "\n");
            writer.write("Subjects:");
            for (String subject : subjects) {
                writer.newLine();
                writer.write("- " + subject);
            }
            writer.newLine();
            writer.newLine(); // Extra space between students
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main Method
    public static void main(String[] args) {
        EnrollmentSystem enrollment = new EnrollmentSystem("", "", "", null, 0);
        enrollment.enrollStudent();
        enrollment.saveToFile();
        enrollment.askAgain();
    }

    // Ask again
    public void askAgain() {
        String[] options = { "Yes", "No" };
        int choice = JOptionPane.showOptionDialog(null, "Do you want to enroll another student?", "Enrollment System",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            enrollStudent();
            saveToFile();
            askAgain();
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for using the Enrollment System!");
        }
    }
}
