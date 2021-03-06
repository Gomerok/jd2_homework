package by.academy.it.entities.personJoined;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "PERSON_JOINED")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonJ {
    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    public PersonJ() {
    }

    public PersonJ(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
