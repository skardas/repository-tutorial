package com.ders.ders.repository;

import com.ders.ders.model.Ogrenci;
import com.ders.ders.model.Ogretmen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OgretmenRepository extends JpaRepository<Ogretmen,Long> {

}