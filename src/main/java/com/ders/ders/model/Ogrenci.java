package com.ders.ders.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ogrenci")
public class Ogrenci extends ModelAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String lastName;

    public Ogrenci(){


    }
    public Ogrenci(@Size(min = 2, max = 50) String firstName, @Size(min = 2, max = 50) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
