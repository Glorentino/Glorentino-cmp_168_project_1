package src.PROJECT_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
}
