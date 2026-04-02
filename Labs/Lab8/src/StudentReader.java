import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentReader {

  private static final String FILE_NAME = "Lab8/students.txt";

  public static ArrayList<Student> readStudentsFromFile(String fileName) {
    ArrayList<Student> students = new ArrayList<>();

    try {
      File file = new File(fileName);
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine().trim();

        if (line.isEmpty()) {
          continue;
        }

        String[] parts = line.split("\\s+");

        if (parts.length >= 4) {
          String firstName = parts[0];
          String lastName = parts[1];
          String studentId = parts[2];
          String email = parts[3];

          Student student = new Student(firstName, lastName, studentId, email);
          students.add(student);
        }
      }

      fileScanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: could not find file " + fileName);
    }

    return students;
  }

  public static void printStudents(ArrayList<Student> students) {
    System.out.println("\nStudent List:");
    for (int i = 0; i < students.size(); i++) {
      System.out.println((i + 1) + ". " + students.get(i));
    }
  }

  public static void writeStudentsToFile(String fileName, ArrayList<Student> students) {
    try {
      PrintWriter writer = new PrintWriter(fileName);

      for (Student student : students) {
        writer.println(student.getFirstName() + " "
            + student.getLastName() + " "
            + student.getStudentId() + " "
            + student.getEmail());
      }

      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Error: could not write to file " + fileName);
    }
  }

  public static void addStudent(ArrayList<Student> students, Scanner input) {
    System.out.print("Enter first name: ");
    String firstName = input.next();

    System.out.print("Enter last name: ");
    String lastName = input.next();

    System.out.print("Enter student ID: ");
    String studentId = input.next();

    System.out.print("Enter email: ");
    String email = input.next();

    Student newStudent = new Student(firstName, lastName, studentId, email);
    students.add(newStudent);

    writeStudentsToFile(FILE_NAME, students);
    System.out.println("Student added successfully.");
    printStudents(students);
  }

  public static void removeStudentById(ArrayList<Student> students, Scanner input) {
    System.out.print("Enter the student ID to remove: ");
    String idToRemove = input.next();

    boolean removed = false;

    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getStudentId().equals(idToRemove)) {
        students.remove(i);
        removed = true;
        break;
      }
    }

    if (removed) {
      writeStudentsToFile(FILE_NAME, students);
      System.out.println("Student removed successfully.");
      printStudents(students);
    } else {
      System.out.println("Error: student with ID " + idToRemove + " does not exist.");
    }
  }

  public static void searchStudentById(ArrayList<Student> students, Scanner input) {
    System.out.print("Enter the student ID to search: ");
    String idToSearch = input.next();

    boolean found = false;

    for (Student student : students) {
      if (student.getStudentId().equals(idToSearch)) {
        System.out.println("Student found:");
        System.out.println(student);
        found = true;
        break;
      }
    }

    if (!found) {
      System.out.println("Error: student with ID " + idToSearch + " does not exist.");
    }
  }

  public static void main(String[] args) {
    ArrayList<Student> students = readStudentsFromFile(FILE_NAME);
    Scanner input = new Scanner(System.in);

    printStudents(students);

    boolean running = true;

    while (running) {
      System.out.println("\nMenu:");
      System.out.println("1. Add a student");
      System.out.println("2. Remove a student by ID");
      System.out.println("3. Search for a student by ID");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      int choice = input.nextInt();

      switch (choice) {
        case 1:
          addStudent(students, input);
          break;
        case 2:
          removeStudentById(students, input);
          break;
        case 3:
          searchStudentById(students, input);
          break;
        case 4:
          running = false;
          System.out.println("Program ended.");
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }

    input.close();
  }
}
