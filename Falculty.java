package src.PROJECT_1;

public class Falculty extends Employee {
    private Course[] coursesTaught; // max 100 courses
    private int numCoursesTaught;
    private boolean isTenured;

    public Faculty() {
        // super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(boolean isTenured) {
        // super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Falculty(String deptName, boolean isTenured) {
        // super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Falculty(String name, int birthYear, String deptName, boolean isTenured) {
        // super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    } // Unfinished

    public boolean isTenured() {
        return isTenured;
    }

    public int getNumCoursesTaught() {
        return numCoursesTaught;
    }

    public void setIsTenured(boolean inputIsTenured) {
        isTenured = inputIsTenured;
    }

    public void addCourseTaught(Course course) {
        coursesTaught[numCoursesTaught] = course;
        numCoursesTaught++;
    }

    public void addCourseTaught(Course [] courses) {
        for (int i = 0; i < courses.length; i++) {
            coursesTaught[numCoursesTaught] = courses[i];
            numCoursesTaught++;
        }
    }

    public Course[] getCoursesTaught(int index) {
        if (index < 0 || index >= numCoursesTaught) {
            return null;
        }
        return coursesTaught[index];
    } 

    public String getCourseTaughtAsString(int index) {
        if (index < 0 || index >= numCoursesTaught) {
            return "";
        }
        return String.format(
            "Person: Employee: Department: %20s | Employee Number: %3d", deptName, employeeID
        ); // must return courseDpt-courseNum
    }

    public String getAllCoursesTaughtAsString() {
        String result = "";
        for (int i = 0; i < numCoursesTaught; i++) {
            result += getCourseTaughtAsString(i) + "\n";
        } // need to make this comma seperated and remove the last comma
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Faculty otherFaculty = (Faculty) obj;

        return super.equals(obj) && 
                this.isTenured == otherFaculty.isTenured &&
                this.numCoursesTaught == otherFaculty.numCoursesTaught;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(isTenured);
        result = 31 * result + Integer.hashCode(numCoursesTaught);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
            "Person: Employee: Faculty: %11s | Number of Courses Taught: %3d | Course Taught: %s", isTenured, numCoursesTaught, getAllCoursesTaughtAsString()
        ); // Not finished
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.numCoursesTaught, p.numCoursesTaught);
    }

}
