package com.ders.ders.controller;

import com.ders.ders.exception.ResourceNotFoundException;
import com.ders.ders.model.*;
import com.ders.ders.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class OgrenciController {

    private OgrenciRepository ogrenciRepository;
    private OgretmenRepository ogretmenRepository;
    private DersRepository dersRepository;
    private AlinanDersRepository alinanDersRepository;
    private VerilenDersRepository verilenDersRepository;

    public OgrenciController(OgrenciRepository ogrenciRepository, OgretmenRepository ogretmenRepository, DersRepository dersRepository, AlinanDersRepository alinanDersRepository, VerilenDersRepository verilenDersRepository) {
        this.ogrenciRepository = ogrenciRepository;
        this.ogretmenRepository = ogretmenRepository;
        this.dersRepository = dersRepository;
        this.alinanDersRepository = alinanDersRepository;
        this.verilenDersRepository = verilenDersRepository;
    }

    @GetMapping("/student/{ogrenciId}")
    public Ogrenci getOgrenci(@PathVariable Long ogrenciId)
    {
        Ogrenci ogrenci = ogrenciRepository.findById(ogrenciId).orElseThrow(()->new ResourceNotFoundException(" Ogrenci Bulunamadı", ogrenciId));
        System.out.println("ibrahiiiiim");
        return ogrenci;
    }

    @GetMapping("/student/{ogrenciId}/dersler")
    public Set<Ders> getOgrenciAldigiDersler(@PathVariable Long ogrenciId)
    {
        Ogrenci ogrenci = ogrenciRepository.findById(ogrenciId).orElseThrow(()->new ResourceNotFoundException(" Ogrenci Bulunamadı", ogrenciId));
        return ogrenci.getAlinanDersler();
    }

    @GetMapping("/student/{ogrenciId}/ogretmenler")
    public Set<Ogretmen> getOgrenciAldigiDerslerinOgretmenleri(@PathVariable Long ogrenciId)
    {
        Ogrenci ogrenci = ogrenciRepository.findById(ogrenciId).orElseThrow(()->new ResourceNotFoundException(" Ogrenci Bulunamadı", ogrenciId));
        Set<Ogretmen> ogretmenler = new HashSet<>();

        for(Ders ders: ogrenci.getAlinanDersler())
        {
            for (VerilenDers o:  verilenDersRepository.findAllByDersId(ders.getId()))
                ogretmenler.add(o.getOgretmen());
        }

        return ogretmenler;
    }

}
