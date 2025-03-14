package src.PROJECT_1;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int birthYear;

    public Person() {
        name = "";
        birthYear = 0;
    }

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void setBirthYear(int inputBirthYear) {
        birthYear = inputBirthYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person otherPerson = (Person) obj;
        
        return Objects.equals(this.name, otherPerson.name) && 
                this.birthYear == otherPerson.birthYear;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(birthYear);
        return result;
    }

    @Override
    public String toString() {
        return String.format(
            "Person: Name: %30s | Birth Year: %4d", name, birthYear
        );
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.birthYear, p.birthYear);
    }
}
