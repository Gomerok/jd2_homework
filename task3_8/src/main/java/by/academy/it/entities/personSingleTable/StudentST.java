package by.academy.it.entities.personSingleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_SINGLETABLE")
@DiscriminatorValue("S")
public class StudentST extends PersonST {
    private String faculty;
    private Double mark;

    public StudentST() {
    }

    public StudentST(String name, String email, String faculty, Double mark) {
        super(name, email);
        this.faculty = faculty;
        this.mark = mark;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}