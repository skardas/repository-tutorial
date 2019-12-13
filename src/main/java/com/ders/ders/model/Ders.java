package com.ders.ders.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ders")
public class Ders extends ModelAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ders_name", unique = true)
    private String dersName;

    @Column(name = "icerik")
    private String icerik;

    public Ders(){

    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ogrenci_ders",
            joinColumns = {@JoinColumn(name = "ders_id")},
            inverseJoinColumns = {@JoinColumn(name = "ogrenci_id")}
    )
    private Set<Ogrenci> ogrenciler;

    public Set<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(Set<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
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
