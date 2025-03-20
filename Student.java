package src.PROJECT_1;

import java.util.Objects;

public class Student extends Person {
    private static int numStudents;
    private int studentID;
    private Course[] coursesTaken;
    private int numCoursesTaken;
    private boolean isGraduate;
    private String major;

    public Student() {
        super();
        numStudents++;
        studentID = numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        isGraduate = false;
        major = "undeclared";
    }
    public Student(boolean isGraduate) {
        super();
        numStudents++;
        studentID = numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.isGraduate = isGraduate;
        major = "undeclared";
    }

    public Student(String major, boolean isGraduate) {
        super();
        numStudents++;
        studentID = numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.major = major;
        this.isGraduate = isGraduate;
    }

    public Student(String name, int birthYear, String major, boolean isGraduate) {
        super(name, birthYear);
        numStudents++;
        studentID = numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.major = major;
        this.isGraduate = isGraduate;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public int getNumCoursesTaken() {
        return numCoursesTaken;
    }

    public static int getNumStudents() {
        return numStudents;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setIsGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addCoursesTaken(Course course) {
        if (numCoursesTaken >= 50 || course == null) {
            return;
        }
        coursesTaken[numCoursesTaken] = course;
        numCoursesTaken++;
    }

    public void addCoursesTaken(Course[] courses) {
        if (courses == null) {
            return;
        }
        for (Course course : courses) {
            addCoursesTaken(course);
        }
    }

    public getCourseTaken(int index) {
        if (index < 0 || index >= numCoursesTaken) {
            return null;
        }
        return coursesTaken[index];
    }

    public getCourseTakenAsString(int index) {
        Course course = getCourseTaken(index);
        if (course == null) {
            return "";
        }
        
        return course.getCourseDept() + "-" + course.getCourseNum();
    }

    public String getAllCoursesTakenAsString() {
        if (numCoursesTaken == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCoursesTaken; i++) {
            sb.append(getCourseTakenAsString(i));
            if (i < numCoursesTaken - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Student otherStudent = (Student) obj;

        if (!super.equals(otherStudent)) return false;

        if (this.studentID != otherStudent.studentID ||
            this.numCoursesTaken != otherStudent.numCoursesTaken ||
            this.isGraduate != otherStudent.isGraduate ||
            !Objects.equals(this.major, otherStudent.major)) {
            return false;
        }

        for (int i = 0; i < numCoursesTaken; i++) {
            if (!Objects.equals(this.coursesTaken[i], otherStudent.coursesTaken[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), studentID, numCoursesTaken, isGraduate, major);
        for (int i = 0; i < numCoursesTaken; i++) {
            result = 31 * result + Objects.hashCode(coursesTaken[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        String gradStatus = isGraduate ? "Graduate" : "Undergraduate";
        return super.toString() + String.format(
            " Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",
            studentID, major, gradStatus, numCoursesTaken, getAllCoursesTakenAsString());
    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Student) {
            Student otherStudent = (Student) p;
            int thisCredits = 0;
            int otherCredits = 0;

            for (int i = 0; i < this.numCoursesTaken; i++) {
                thisCredits += this.coursesTaken[i].getNumCredits();
            }

            for (int i = 0; i < otherStudent.numCoursesTaken; i++) {
                otherCredits += otherStudent.coursesTaken[i].getNumCredits();
            }

            return Integer.compare(thisCredits, otherCredits);
        }

        return super.compareTo(p);
    }
}
