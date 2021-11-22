package by.academy.it.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    @Embedded
    private Address address;

    public Customer() {
    }

    public Customer(String name, String email, Address address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public int getId() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
