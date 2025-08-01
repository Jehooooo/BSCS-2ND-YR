//I STARTED THIS CODE 6DAYS BEFORE(Commits on Jul 24, 2025) THE ACTIVITY WAS GIVEN, AND I FINISHED IT 1 DAY BEFORE THE ACTIVITY DEADLINE
//I SPENT 8 DAYS EDITING THE CODE
//I GIVE MY SELF 3 WEEKS DEADLINE TO FINISH THIS PROJECT OF MINE BUT I FINISHED IT IN 8 DAYS
//THIS WAS SUPPOSED TO BE IN A GUI, BUT I DECIDED TO USE A CONSOLE APPLICATION INSTEAD. BECAUSE I AM NOT GOOD AT GUI YET
//I AM USING JOptionPane FOR THE INPUTS AND OUTPUTS, AND BufferedReader FOR RE

//I AM JEHOSUE BISCARRA, A 2ND YEAR COMPUTER SCIENCE STUDENT ASPIRING TO BE A SOFTWARE ENGINEER
//THIS IS MY ENROLLMENT SYSTEM PERSONAL PROJECT, AND I HOPE YOU LIKE IT🫶🫶💛

import java.io.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class EnrollmentSystemBiscarraJehosue {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); //This has no part in the code, but it is used to read input from the console
    private String courseName;
    private String studentName;
    private String studentID;
    private String[] subjects; // Only the selected year-level subjects
    private int yearLevel;
    private boolean isEnrolled = false; // Track if the student is already enrolled

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
                    "Software Engineering 1",
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
                    "Thesis Writing",
                    "IT Project Management",
                    "Professional Ethics and Social Issues in Computing",
                    "Machine Learning",
                    "OJT"
            }
    };

    // Constructor
    public EnrollmentSystemBiscarraJehosue(String courseName, String studentName, String studentID, String[] subjects, int yearLevel) {
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentID = studentID;
        this.subjects = subjects;
        this.yearLevel = yearLevel;
    }

    // ID number generator
    private static String generateID(int yearLevel) {
        //Gagamit sana ako ng HashSet to prevent duplication sa Unique ID number, pero hindi naman ata mag duduplicate kapag kunti lang studyante hehe
        return String.format("241-%d-%03d", yearLevel, generateListNumber(yearLevel));
    }

    public static int generateListNumber(int yearLevel) {
        Random random = new Random();
        return random.nextInt(9999 + 1); // 0000 to 9999
    }

    // Enroll student
    public void enrollStudent() {
        if (isEnrolled) {
            JOptionPane.showMessageDialog(null, "This student is already enrolled.");
            return;
        }

        String[] validCourses = { "BSCS", "BSIT", "BSCE", "BSBA" };
        while (true) {
            this.courseName = JOptionPane.showInputDialog("Enter Course Name (BSCS, BSIT, BSCE, BSBA):");
            if (courseName == null || courseName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Course name cannot be empty.");
            } else if (!java.util.Arrays.asList(validCourses).contains(courseName.toUpperCase())) {
                JOptionPane.showMessageDialog(null, "Invalid course. Please enter a valid course name.");
            } else {
                break;
            }
            if (courseName == null) {
                System.exit(0); 
            }
        }

        while (true) {
            this.studentName = JOptionPane.showInputDialog("Enter Student Name:");
            if (studentName == null || studentName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Student name cannot be empty.");
            } else if (!studentName.matches("[a-zA-Z\\s]+")) {
                JOptionPane.showMessageDialog(null, "Name should only contain letters and spaces.");
            } else if (studentName.length() > 30) {
                JOptionPane.showMessageDialog(null, "Name is too long. Max 30 characters allowed.");
            } else {
                break;
            }
            if (studentName == null) {
                System.exit(0); 
            }
        }
        int year = 0;
        while (year < 1 || year > 4) {
            String input = JOptionPane.showInputDialog("Enter Year Level (1-4):");
            if (input == null) {
                System.exit(0); 
            }
            try {
                year = Integer.parseInt(input);
                if (year < 1 || year > 4) {
                    JOptionPane.showMessageDialog(null, "Invalid year level. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid year level.");
            }

        }

        // Assign fields
        this.yearLevel = year;
        this.subjects = allSubjects[year - 1]; // Assign only subjects of selected year
        this.studentID = generateID(yearLevel);
        this.isEnrolled = true;

        JOptionPane.showMessageDialog(null, "Enrollment successful!\nStudent ID: " + studentID);
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
            writer.write(isEnrolled ? "\nStatus: Enrolled" : "\nStatus: Not Enrolled");
            writer.newLine();
            writer.newLine(); // Extra space between students
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving to file: " + e.getMessage());
        }
    }

    // Main Method
    public static void main(String[] args) {
        EnrollmentSystemBiscarraJehosue enrollment = new EnrollmentSystemBiscarraJehosue("", "", "", null, 0);
        enrollment.enrollStudent();
        enrollment.saveToFile();
        enrollment.askAgain(); // Ask if the user wants to enroll another student

    }

    // Ask again
    public void askAgain() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to enroll another student?",
                "Enrollment System", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            // Create a new instance each time
            EnrollmentSystemBiscarraJehosue newEnrollment = new EnrollmentSystemBiscarraJehosue("", "", "", null, 0);
            newEnrollment.enrollStudent();
            newEnrollment.saveToFile();
            newEnrollment.askAgain(); // Recursive call try langs hehehehe
        } else {
            System.out.println("Enrollment completed. Check enrolledStudents.txt for details.");
            System.exit(0);
        }
    }

}