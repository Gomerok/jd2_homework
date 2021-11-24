package by.academy.it.entities.personTablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TABLEPERCLASS")
public class EmployeeTPC extends PersonTPC {
    private String company;
    private Double salary;

    public EmployeeTPC() {
    }

    public EmployeeTPC(String name, String email, String company, Double salary) {
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