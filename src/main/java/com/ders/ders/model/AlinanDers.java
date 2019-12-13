package com.ders.ders.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "ogrenci_ders")
public class AlinanDers extends ModelAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "donem", nullable = false)
    private String donem;

    @Column(name = "yil", nullable = false)
    private int yil;

    @Column(name = "ortalama", nullable = false)
    private Double ortalama;


    @ManyToOne(fetch = FetchType.LAZY)
    private Ders ders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("alinanDersler")
    private Ogrenci ogrenci;

    public  AlinanDers(){

    }

    public Ders getDers() {
        return ders;
    }

    public void setDers(Ders ders) {
        this.ders = ders;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public AlinanDers(int yil, String donem, int not) {
        this.yil = yil;
        this.donem = donem;

    }


    public Double getOrtalama() {
        return ortalama;
    }

    public void setOrtalama(Double ortalama) {
        this.ortalama = ortalama;
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
