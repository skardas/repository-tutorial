package com.ders.ders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "ogretmen")
public class Ogretmen extends ModelAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 2, max = 50)
    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Size(min = 2, max = 50)
    @Column(name = "last_name",nullable = false)
    private String lastName;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ogretmen_ders",
            joinColumns = {@JoinColumn(name = "ogretmen_id")},
            inverseJoinColumns = {@JoinColumn(name = "ders_id")}
    )
    Set<Ders> dersList;

    public Ogretmen(){

    }

    public Ogretmen(@Size(min = 2, max = 50) String firstName, @Size(min = 2, max = 50) String lastName) {
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
