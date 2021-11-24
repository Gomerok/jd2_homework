package by.academy.it.entities.personTablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_TABLEPERCLASS")
public class StudentTPC extends PersonTPC {
    private String faculty;
    private Double mark;

    public StudentTPC() {
    }

    public StudentTPC(String name, String email, String faculty, Double mark) {
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