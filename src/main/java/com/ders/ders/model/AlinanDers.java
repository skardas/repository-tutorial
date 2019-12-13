package com.ders.ders.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "alinanders")
public class AlinanDers extends ModelAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String donem;
    private int yil;
    private Double nort;





    public  AlinanDers(){

    }

    public AlinanDers(int yil,String donem,int not) {
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

    public Double getNort() {
        return nort;
    }

    public void setNort(Double nort) {
        this.nort = nort;
    }
}
