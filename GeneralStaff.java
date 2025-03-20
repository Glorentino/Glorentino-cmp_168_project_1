package src.PROJECT_1;

public class GeneralStaff extends Employee {
    private String duty;

    public GeneralStaff() {
        super();
        this.duty = "";
    }

    public GeneralStaff(String duty) {
        super();
        this.duty = duty;
    }

    public GeneralStaff(String deptName, String duty) {
        super(deptName);
        this.duty = duty;
    }

    public GeneralStaff(String name, int birthYear, String deptName, String duty) {
        super(name, birthYear, deptName);
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        GeneralStaff generalStaff = (GeneralStaff) obj;
        return super.equals(generalStaff) && duty.equals(generalStaff.duty);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + duty.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" GeneralStaff: Duty: %10s", duty);
    }
}
