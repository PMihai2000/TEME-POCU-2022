package Collections.Objects;

import java.util.Objects;

public class StudentWithID extends Student {
    private int personalCode;


    public StudentWithID(int personalCode, String lastname, String firstname, double grade) {
        super(lastname,firstname,grade);
        this.personalCode = personalCode;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(int personalCode) {
        this.personalCode = personalCode;
    }

    @Override
    public String toString() {
        return "StudentWithID{" +
                "personalCode=" + personalCode +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentWithID student = (StudentWithID) o;
        return personalCode == student.personalCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalCode);
    }
}
