package src.PROJECT_1;

import java.util.Objects;

public class Employee extends Person {
    private String deptName;
    private static int numEmployees;
    private int employeeID;

    public Employee() {
        super();
        this.deptName = "";
        numEmployees++;
        this.employeeID = numEmployees;
    }
    public Employee(String deptName) {
        super();
        this.deptName = deptName;
        numEmployees++;
        this.employeeID = numEmployees;
    }
    public Employee(String name, int birthYear, String deptName) {
        super(name, birthYear);
        this.deptName = deptName;
        numEmployees++;
        this.employeeID = numEmployees;
    }

    public String getDeptName() {
        return deptName; 
    }

    public static getNumEmployees() {
        return numEmployees;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setDeptName(String inputDeptName) {
        deptName = inputDeptName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee otherEmployee = (Employee) obj;

        return super.equals(otherEmployee) &&
               Objects.equals(this.deptName, otherEmployee.deptName) &&
               this.employeeID == otherEmployee.employeeID;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + deptName.hashCode();
        result = 31 * result + Integer.hashCode(employeeID);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
            "Employee: Department: %20s | Employee Number: %3d", deptName, employeeID
        ); 
    }

    @Override
    public int compareTo(Person p) {
        if (p instanceof Employee) {
            Employee otherEmployee = (Employee) p;
            return Integer.compare(this.employeeID, otherEmployee.employeeID);
        } else {
            return super.compareTo(p);
        }
    }
}
