package by.academy.it.entities.personJoined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_JOINED")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class StudentJ extends PersonJ {
    private String faculty;
    private Double mark;

    public StudentJ() {
    }

    public StudentJ(String name, String email, String faculty, Double mark) {
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