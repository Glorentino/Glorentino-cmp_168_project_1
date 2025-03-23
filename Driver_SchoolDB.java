package src.PROJECT_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Driver_SchoolDB class serves as the main entry point for the school database application.
 * It contains methods to create courses, faculty, general staff, and students,
 * as well as methods to manage and display the records of these entities.
 * The class also provides a menu-driven interface for user interaction.    
 */
public class Driver_SchoolDB {
    private static final Scanner scnr = new Scanner(System.in);
    private static final List<Course> courses = new ArrayList<>();
    private static final List<Faculty> faculties = new ArrayList<>();
    private static final List<GeneralStaff> generalStaffs = new ArrayList<>();
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

    }

    private static void printMenu() {
        System.out.println("********** SCHOOL DATABASE MENU **********");
        System.out.println("1. Create 3 Courses");
        System.out.println("2. Create 3 Faculty");
        System.out.println("3. Create 3 General Staff");
        System.out.println("4. Create 3 Students");
        System.out.println("5. Add 2 Courses to a Faculty");
        System.out.println("6. Add 2 Courses to a Student");
        System.out.println("7. Add array of 2 Courses to a Faculty");
        System.out.println("8. Add array of 2 Courses to a Student");
        System.out.println("9. Get Course at index from Faculty");
        System.out.println("10. Get Course at index from Student");
        System.out.println("11. Check if Faculty teaches a Course");
        System.out.println("12. Find Faculty teaching most/least courses");
        System.out.println("13. Find Course min/max");
        System.out.println("14. Find Student with most/least credits");
        System.out.println("15. Display all records");
        System.out.println("16. Write all records to file");
        System.out.println("0. Exit");
        System.out.println("Choose an option: ");
    }   

    private static void createCourses() {
        // Implementation for creating courses
        for (int i = 0; i < 3 ; i++) {

            System.out.println("Is coutse graduate? (true/false): ");
            boolean isGraduate = scnr.nextBoolean();
            while(!scnr.hasNextBoolean()) {
                System.out.println("Invalid input. Please enter true or false: ");
                scnr.next(); 
            }

            System.out.println("Enter course number: ");
            int courseNum = scnr.nextInt();
            while(!scnr.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid course number: ");
                scnr.next(); 
            }

            System.out.println("Enter the course department name: ");
            String courseDept = scnr.nextLine().trim();
            while(courseDept.isEmpty()) { 
                System.out.println("Invalid input. Please enter a valid department name: ");
                scnr.nextLine().trim();    
            }
            
            System.out.println("Enter the number of credits: ");
            int numCredits = scnr.nextInt();
            while(!scnr.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number of credits: ");
                scnr.next();    
            }
            
            Course course = new Course(isGraduate, courseNum, courseDept, numCredits);
            courses.add(course);
            System.out.println("Course created: " + course.getCourseName());
        }
    }

    private static void createFaculty() {
        // Implementation for creating faculty
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter faculty name: ");
            String name = scnr.nextLine().trim();
            while(name.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid name: ");
                scnr.nextLine().trim();    
            }

            System.out.print("Enter faculty's birth year: ");
            int birthYear = scnr.nextInt();
            while(!scnr.hasNextInt()) {
                System.out.println("Invalid input. Please enter valid birth year: ");
                scnr.next();
            }

            System.out.println("Enter Faculty's depantment name: ");
            String deptName = scnr.nextLine().trim();
            while(deptName.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid department name: ");
                scnr.nextLine().trim();    
            }

            System.out.println("Is faculty tenured? true or false: ");
            boolean isTenured = scnr.nextBoolean();
            while (!scnr.hasNextBoolean()) {
                System.out.println("Invalid input. Is faculty tenured? true or false: ");
                scnr.next();
            }
            Faculty faculty = new Faculty(name, birthYear, deptName, isTenured);
            faculties.add(faculty);
            System.out.println("Faculty created: " + faculty.getName());
        }


    }
    private static void createGeneralStaff() {
        // Implementation for creating general staff
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter general staff name: ");
            String name = scnr.nextLine().trim();
            while(name.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid name: ");
                scnr.nextLine().trim();    
            }

            System.out.print("Enter general staff's birth year: ");
            int birthYear = scnr.nextInt();
            while(!scnr.hasNextInt()) {
                System.out.println("Invalid input. Please enter valid birth year: ");
                scnr.next();
            }

            System.out.println("Enter general staff's depantment name: ");
            String deptName = scnr.nextLine().trim();
            while(deptName.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid department name: ");
                scnr.nextLine().trim();    
            }

            System.out.println("Enter general staff's duty: ");
            String duty = scnr.nextLine().trim();
            while(duty.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid duty: ");
                scnr.nextLine().trim();
            }
            GeneralStaff generalStaff = new GeneralStaff(name, birthYear, deptName, duty);
            generalStaffs.add(generalStaff);
            System.out.println("General Staff created: " + generalStaff.getName());
        }

    }
    private static void createStudents() {
        // Implementation for creating students
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter student's name: ");
            String name = scnr.nextLine().trim();
            while(name.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid name: ");
                scnr.nextLine().trim();    
            }

            System.out.print("Enter student's birth year: ");
            int birthYear = scnr.nextInt();
            while(!scnr.hasNextInt()) {
                System.out.println("Invalid input. Please enter valid birth year: ");
                scnr.next();
            }
            
            System.out.println("Enter student's major: ");
            String major = scnr.nextLine().trim();
            while(major.isEmpty()) {
                System.out.println("Invalid input. Please enter a valid major: ");
                scnr.nextLine().trim();    
            }

            System.out.println("Is student graduate? true or false: ");
            boolean isGraduate = scnr.nextBoolean();
            while (!scnr.hasNextBoolean()) {
                System.out.println("Invalid input. Is student graduate? true or false: ");
                scnr.next();
            }

            Student student = new Student(name, birthYear, major, isGraduate);
            students.add(student);
            System.out.println("Student created: " + student.getName());
        }
    }
}
