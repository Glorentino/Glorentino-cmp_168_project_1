package src.PROJECT_1;

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
    }
    public Student(boolean isGraduate) {
        super();
        numStudents++;
        studentID = numStudents;
        coursesTaken = new Course[50];
        numCoursesTaken = 0;
        this.isGraduate = isGraduate;
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
        coursesTaken[numCoursesTaken] = course;
        numCoursesTaken++;
    }

    public void addCoursesTaken(Course[] courses) {
        for (Course course : courses) {
            coursesTaken[numCoursesTaken] = course;
            numCoursesTaken++;
        }
    }

    public getCourseTaken(int index) {
        if (index < 0 || index >= numCoursesTaken) {
            return null;
        }
        return coursesTaken[index];
    }

    public getCourseTakenAsString(int index) {
        if (index < 0 || index >= numCoursesTaken) {
            return null;
        }
        // Must return courseDept-courseNum
        return coursesTaken[index].toString();
    }

    public String getAllCoursesTakenAsString() {
        String result = "";
        for (int i = 0; i < numCoursesTaken; i++) {
            result += getCourseTakenAsString() +", " + "\n";
        }
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student otherStudent = (Student) obj;

        return super.equals(obj) &&
                this.studentID == otherStudent.studentID &&
                this.numCoursesTaken == otherStudent.numCoursesTaken &&
                this.isGraduate == otherStudent.isGraduate &&
                this.major.equals(otherStudent.major);
    }
    @Override
    public String toString() {
        return String.format(
                "Student ID: %d\n" +
                "Name: %s\n" +
                "Birth Year: %d\n" +
                "Major: %s\n" +
                "Is Graduate: %b\n" +
                "Number of Courses Taken: %d\n" +
                "Courses Taken: %s\n",
                studentID, getName(), getBirthYear(), major, isGraduate, numCoursesTaken, getAllCoursesTakenAsString());
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.numCoursesTaken, numCoursesTaken);
    }
}
