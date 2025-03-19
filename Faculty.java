package src.PROJECT_1;

import java.util.Objects;

public class Faculty extends Employee {
    private Course[] coursesTaught; // max 100 courses
    private int numCoursesTaught;
    private boolean isTenured;

    public Faculty() {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = false;
    }

    public Faculty(boolean isTenured) {
        super();
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String deptName, boolean isTenured) {
        super(deptName);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    }

    public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
        super(name, birthYear, deptName);
        coursesTaught = new Course[100];
        numCoursesTaught = 0;
        this.isTenured = isTenured;
    } 

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
        if (numCoursesTaught >= 100 || course == null) {
            return;
        }
        coursesTaught[numCoursesTaught] = course;
        numCoursesTaught++;
    }

    public void addCoursesTaught(Course[] courses) {
        if (courses == null) {
            return;
        }
        for (int i = 0; i < courses.length; i++) {
            if (numCoursesTaught >= 100 || courses[i] == null) {
                continue;
            }
            coursesTaught[numCoursesTaught] = courses[i];
            numCoursesTaught++;
        }
    }

    public Course getCourseTaught(int index) {
        if (index < 0 || index >= numCoursesTaught) {
            return null;
        }
        return coursesTaught[index];
    } 

    public String getCourseTaughtAsString(int index) {
        Course course = getCourseTaught(index);
        if (course == null) {
            return "";
        }
        return course.getCourseDept() + "-" + course.getCourseNum();
    }

    public String getAllCoursesTaughtAsString() {
        if (numCoursesTaught == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCoursesTaught; i++) {
            sb.append(getCourseTaughtAsString(i));
            if (i < numCoursesTaught - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
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

        if (!super.equals(otherFaculty)) {
            return false;
        }

        if (this.isTenured != otherFaculty.isTenured ||
            this.numCoursesTaught != otherFaculty.numCoursesTaught) {
            return false;
        }

        for (int i = 0; i < numCoursesTaught; i++) {
            if (!Objects.equals(this.coursesTaught[i], otherFaculty.coursesTaught[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(isTenured);
        result = 31 * result + Integer.hashCode(numCoursesTaught);
        
        for (int i = 0; i < numCoursesTaught; i++) {
            result = 31 * result + Objects.hashCode(coursesTaught[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        String tenureStatus = isTenured ? "Is Tenured" : "Not Tenured";
        return super.toString() + String.format(
            " Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",
            tenureStatus, numCoursesTaught, getAllCoursesTaughtAsString());
    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Faculty) {
            Faculty otherFaculty = (Faculty) p;
            return Integer.compare(this.numCoursesTaught, otherFaculty.numCoursesTaught);
        }
        return super.compareTo(p);
    }

}
