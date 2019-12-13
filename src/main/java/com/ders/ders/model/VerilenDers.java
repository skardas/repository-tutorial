package com.ders.ders.model;

import javax.persistence.*;

@Entity
@Table(name = "ogretmen_ders")
public class VerilenDers extends ModelAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yil")
    private Integer yil;

    @Column(name = "donem")
    private String donem;

    @ManyToOne
    private Ders ders;

    @ManyToOne
    private Ogretmen ogretmen;

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {
        this.ders = ders;
    }

    public Ogretmen getOgretmen() {
        return ogretmen;
    }

    public void setOgretmen(Ogretmen ogretmen) {
        this.ogretmen = ogretmen;
    }

    public VerilenDers() {
    }

    public VerilenDers(Integer yil, String donem) {
        this.yil = yil;
        this.donem = donem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYil() {
        return yil;
    }

    public void setYil(Integer yil) {
        this.yil = yil;
    }

    public String getDonem() {
        return donem;
    }

    public void setDonem(String donem) {
        this.donem = donem;
    }
}
