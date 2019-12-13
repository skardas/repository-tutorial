package com.ders.ders.model;

import javax.persistence.*;

@Entity
@Table(name = "verilenders")
public class VerilenDers extends ModelAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int yil;

    private String donem;

    public VerilenDers() {
    }

    public VerilenDers(int yil,String donem) {
        this.yil = yil;
        this.donem = donem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getDonem() {
        return donem;
    }

    public void setDonem(String donem) {
        this.donem = donem;
    }
}
