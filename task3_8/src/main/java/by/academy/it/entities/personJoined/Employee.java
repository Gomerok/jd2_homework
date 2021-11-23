package by.academy.it.entities.personJoined;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Employee extends Person {
    private String company;
    private Double salary;

    public Employee() {
    }

    public Employee(String name, String email, String company, Double salary) {
        super(name, email);
        this.company = company;
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}