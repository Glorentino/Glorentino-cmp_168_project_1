package src.PROJECT_1;

import java.util.Objects;
/*
 * Course class represents a course in the school database.
 * It contains information about the course such as whether it is a graduate course,
 * the course number, department, and number of credits.
 * It also implements Comparable interface to allow sorting based on course number.
 * The class overrides equals, hashCode, and toString methods for proper comparison
 * and representation of Course objects.
 */

public class Course implements Comparable<Course> {
    private boolean isGraduateCourse;
    private int courseNum;
    private String courseDept;
    private int numCredits;

    public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
        this.isGraduateCourse = isGraduateCourse;
        this.courseNum = courseNum;
        this.courseDept = courseDept;
        this.numCredits = numCredits;
    }

    public boolean isGraduateCourse(){
        return isGraduateCourse;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public String getCourseDept() {
        return courseDept;
    }

    public int getNumCredits() {
        return numCredits;
    }

    public String getCourseName() {
        String level = isGraduateCourse ? "G" : "U";
        return level + courseDept + courseNum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Course otherCourse = (Course) obj;

        return this.isGraduateCourse == otherCourse.isGraduateCourse &&
               this.courseNum == otherCourse.courseNum &&
               this.numCredits == otherCourse.numCredits &&
               Objects.equals(this.courseDept, otherCourse.courseDept);
    }

    @Override
    public int hashCode() {
        int result = Boolean.hashCode(isGraduateCourse);
        result = 31 * result + Integer.hashCode(courseNum);
        result = 31 * result + (courseDept == null ? 0 : courseDept.hashCode());
        result = 31 * result + Integer.hashCode(numCredits);
        return result;
    }
    
    @Override
    public String toString() {
        String level = isGraduateCourse ? "G" : "U";
        return String.format(
            "Course: %3s-%3d | Number of Credits: %02d | %s",
                courseDept, courseNum, numCredits, level);
    }

    @Override
    public int compareTo(Course c) {
        return Integer.compare(this.courseNum, c.courseNum);
    }
}
