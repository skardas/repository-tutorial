package com.ders.ders.controller;

import com.ders.ders.exception.ResourceNotFoundException;
import com.ders.ders.model.Ogrenci;
import com.ders.ders.repository.DersRepository;
import com.ders.ders.repository.OgrenciRepository;
import com.ders.ders.repository.OgretmenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class OgrenciController {

    private OgrenciRepository ogrenciRepository;
    private OgretmenRepository ogretmenRepository;
    private DersRepository dersRepository;

    public OgrenciController(OgrenciRepository ogrenciRepository, OgretmenRepository ogretmenRepository, DersRepository dersRepository) {
        this.ogrenciRepository = ogrenciRepository;
        this.ogretmenRepository = ogretmenRepository;
        this.dersRepository = dersRepository;
    }

    @GetMapping("/student/{ogrenciId}")
    public Ogrenci getOgrenci(@PathVariable Long ogrenciId)
    {
        Ogrenci ogrenci = ogrenciRepository.findById(ogrenciId).orElseThrow(()->new ResourceNotFoundException(" Ogrenci Bulunamadı", ogrenciId));
        System.out.println("ibrahiiiiim");
        return ogrenci;
    }

}
