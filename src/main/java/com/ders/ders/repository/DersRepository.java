package com.ders.ders.repository;

import com.ders.ders.model.Ders;
import com.ders.ders.model.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DersRepository extends JpaRepository<Ders,Long> {


}
