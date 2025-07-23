import java.io.*;
import java.util.*;

class Student {
    String name;
    int[] grades;
    double average;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
        this.average = calculateAverage();
    }

    
    private double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return Math.round((sum / (double) grades.length) * 100.0) / 100.0;
    }

    public double getAverage() {
        return average;
    }

    public String toString() {
        return String.format("%-5s | %-8s | %.2f", "", name, average);
    }
}

public class StudentRankingSystem {

    public static void main(String[] args) {
        List<Student> students = readStudentsFromFile("students.txt");
        sortStudentsByAverage(students);
        displayRankedStudents(students);
        writeRankedToFile(students, "ranked_students.txt");
    }

    // ✅ Method 1: Read from file
    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                Student student = parseStudent(line);
                if (student != null) students.add(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return students;
    }

    // ✅ Method 2: Parse a student
    public static Student parseStudent(String line) {
        try {
            String[] parts = line.split(",");
            String name = parts[0].trim();
            int[] grades = new int[parts.length - 1];
            for (int i = 1; i < parts.length; i++) {
                grades[i - 1] = Integer.parseInt(parts[i].trim());
            }
            return new Student(name, grades);
        } catch (Exception e) {
            System.out.println("Error parsing line: " + line);
            return null;
        }
    }

    // ✅ Method 3: Sort students
    public static void sortStudentsByAverage(List<Student> students) {
        students.sort((a, b) -> Double.compare(b.getAverage(), a.getAverage()));
    }

    // ✅ Method 4: Display ranked list
    public static void displayRankedStudents(List<Student> students) {
        System.out.println("Rank | Name     | Average");
        System.out.println("---------------------------");
        int rank = 1;
        for (Student student : students) {
            System.out.printf("%-5d%s\n", rank++, student.toString());
        }
    }

    // ✅ Method 5: Save ranked list to file
    public static void writeRankedToFile(List<Student> students, String outputFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("Rank | Name     | Average");
            writer.println("---------------------------");
            int rank = 1;
            for (Student student : students) {
                writer.printf("%-5d%s\n", rank++, student.toString());
            }
            System.out.println("\n✅ Ranked students saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
