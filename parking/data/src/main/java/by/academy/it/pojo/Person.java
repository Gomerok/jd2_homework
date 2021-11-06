package by.academy.it.pojo;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person implements Serializable {
    @Column(name = "name")
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Id
    @Column(name = "id")
    private Long id;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
