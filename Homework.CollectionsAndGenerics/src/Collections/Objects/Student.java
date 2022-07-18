package Collections.Objects;

import java.util.Objects;

public class Student implements Comparable {
    protected String lastname;
    protected String firstname;
    protected double grade;

    public Student(String lastname, String firstname, double grade) {
        this.lastname = lastname;
        this.firstname = firstname;
        setGrade(grade);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if(grade>0 && grade <=10f) {
            this.grade = grade;
        }else{
            this.grade = 0.01f;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return Double.compare(Math.floor(this.grade), Math.floor(grade)) == 0 && Objects.equals(lastname, that.lastname) && Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastname, firstname, grade);
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(Math.floor(this.grade), Math.floor(grade));
    }
}
