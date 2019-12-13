package com.ders.ders.model;

import javax.persistence.*;

@Entity
@Table(name = "ders")
public class Ders extends ModelAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dersName;
    private String icerik;

    public Ders(){


    }

    public Ders(String dersName, String icerik) {
        this.dersName = dersName;
        this.icerik = icerik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDersName() {
        return dersName;
    }

    public void setDersName(String dersName) {
        this.dersName = dersName;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
