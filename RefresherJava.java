
import java.io.*;

public class RefresherJava {
  private String name;
  private int studID;

  public void inputNameString(String name1) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter your name: ");
    this.name = br.readLine();
  }

  public void inputStudID(int id) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter your student ID: ");
    this.studID = Integer.parseInt(br.readLine());
  }

  // changes the name of the student
  public void setName(String name1) {
    name = name1;

  }

  // returns the name of the student
  public String getName() {
    return name;
  }

  // changes the ID of the student
  public void setStudID(int passID) {
    studID = passID;
  }

  // returns the ID of the student
  public int getID() {
    return studID;
  }
  // end of class StudentRecord

  public static void main(String[] args) throws IOException {
    // create two objects for Student record
    RefresherJava annaRecord = new RefresherJava();
    RefresherJava beaRecord = new RefresherJava();
    // input name and ID
    annaRecord.inputNameString(null);
    annaRecord.inputStudID(0);
    // input name and ID
    beaRecord.inputNameString(null);
    beaRecord.inputStudID(0);

    // print the name and ID
    System.out.println("Student 1: " + annaRecord.getName() + ", ID: " + annaRecord.getID());
    System.out.println("Student 2: " + beaRecord.getName() + ", ID: " + beaRecord.getID());

  }
}
//THIS IS AN EXAMPLE PROGRAM THAT MAKES THE USER INPUT INTO PRIVATE USING THE 'private' CLASS
/*
 import java.io.*;

public class RefresherJava {
  private String name;
  private int studID;

  public void inputNameString(String name1) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter your name: ");
    this.name = br.readLine();
  }

  public void inputStudID(int id) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter your student ID: ");
    this.studID = Integer.parseInt(br.readLine());
  }

  // changes the name of the student
  public void setName(String name1) {
    name = name1;

  }

  // returns the name of the student
  public String getName() {
    return name;
  }

  // changes the ID of the student
  public void setStudID(int passID) {
    studID = passID;
  }

  // returns the ID of the student
  public int getID() {
    return studID;
  }
  // end of class StudentRecord

  public static void main(String[] args) throws IOException {
    // create two objects for Student record
    RefresherJava annaRecord = new RefresherJava();
    RefresherJava beaRecord = new RefresherJava();
    // input name and ID
    annaRecord.inputNameString(null);
    annaRecord.inputStudID(0);
    // input name and ID
    beaRecord.inputNameString(null);
    beaRecord.inputStudID(0);

    // print the name and ID
    System.out.println("Student 1: " + annaRecord.getName() + ", ID: " + annaRecord.getID());
    System.out.println("Student 2: " + beaRecord.getName() + ", ID: " + beaRecord.getID());

  }
}
 */


/*
 * System.out.println("Welcome to the Refresher Java Program!");
 * System.out.println("This program will help you practice basic Java concepts."
 * );
 * 
 * 
 * try {
 * System.out.println("Enter your email: ");
 * String name = br.readLine();
 * String domain = name.substring(name.indexOf('@'));
 * String email = name.substring(0, name.indexOf('@'));
 * if (domain.isEmpty()) {
 * System.out.println("Invalid email format. Please include '@' in your email."
 * );
 * return;
 * }
 * System.out.println("Your email is: " + email);
 * System.out.println("Your email domain is: " + domain);
 * 
 * } catch (IOException e) {
 * System.out.println("An error occurred while reading input: " +
 * e.getMessage());
 * }
 */