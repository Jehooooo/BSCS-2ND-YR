
import javax.swing.JOptionPane;

public class EnrollmentSystem {
    private String courseName;
    private String studentName;
    private int studentID;
    private String  [][] subjects;
    private int yearLevel;
    private boolean isEnrolled;

    public EnrollmentSystem(String courseName, String studentName, int studentID, String[][] subjects, int yearLevel) {
        this.courseName = courseName;
        this.studentName = studentName;
        this.studentID = studentID;
        this.subjects = subjects;
        this.yearLevel = yearLevel;
    } 

    public void enrollStudent(String courseName, String studentName, int studentID) {
        String course = JOptionPane.showInputDialog( "Enter Course Name: ");
        this.courseName = course;

        String name = JOptionPane.showInputDialog("Enter Student Name To Enroll: ");
        this.studentName = name;

        int yearLevel1 = Integer.parseInt(JOptionPane.showInputDialog("Enter Year Level: "));
        this.yearLevel = yearLevel1;


        this.studentID = studentID;
    }
    public static int generateStudID() {
        return (int) (Math.random() * 10000); // Generates a random student ID
    }

    public EnrollmentSystem(String courseName, int maxStudents) {
        this.courseName = courseName;
    }

    public static void main(String[] args) {
        String courseName = "";
        String studentName = "";
        int studentID = generateStudID();
        String[][] subjects = {{"Math", "CS101"}, {"Physics", "CS102"}};
        int yearLevel = 2;

        EnrollmentSystem enrollment = new EnrollmentSystem(courseName, studentName, studentID, subjects, yearLevel);
        enrollment.enrollStudent(courseName, studentName, studentID);

        JOptionPane.showMessageDialog(null, "Enrollment Successful!\n" +
                "Course: " + enrollment.courseName + "\n" +
                "Student Name: " + enrollment.studentName + "\n" +
                "Student ID: " + enrollment.studentID);

    }

    /*public boolean enrollStudent() {
        if (enrolledStudents < maxStudents) {
            enrolledStudents++;
            return true; // Enrollment successful
        } else {
            return false; // Enrollment failed, class is full
        }
    }*/


}
