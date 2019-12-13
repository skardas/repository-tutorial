package com.ders.ders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ogrenci")
public class Ogrenci extends ModelAudit{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    @Size(min = 2, max = 50)
    private String lastName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ogrenci_ders",
            joinColumns = {@JoinColumn(name = "ogrenci_id")},
            inverseJoinColumns = {@JoinColumn(name = "ders_id")}
    )
    Set<Ders> dersList;

    public Ogrenci(){


    }
    public Ogrenci(@Size(min = 2, max = 50) String firstName, @Size(min = 2, max = 50) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Ders> getDersList() {
        return dersList;
    }

    public void setDersList(Set<Ders> dersList) {
        this.dersList = dersList;
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
