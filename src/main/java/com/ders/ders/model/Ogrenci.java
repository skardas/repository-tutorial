package com.ders.ders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ogrenci_ders",
            joinColumns = {@JoinColumn(name = "ogrenci_id")},
            inverseJoinColumns = {@JoinColumn(name = "ders_id")}
    )
    @JsonIgnoreProperties({"ogretmenler", "ogrenciler"})
    private Set<Ders> alinanDersler;

    public Ogrenci(){


    }
    public Ogrenci(@Size(min = 2, max = 50) String firstName, @Size(min = 2, max = 50) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Ders> getAlinanDersler() {
        return alinanDersler;
    }

    public void setAlinanDersler(Set<Ders> dersList) {
        this.alinanDersler = dersList;
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
