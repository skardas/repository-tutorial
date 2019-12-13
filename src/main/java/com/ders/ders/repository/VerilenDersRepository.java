package com.ders.ders.repository;

import com.ders.ders.model.VerilenDers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerilenDersRepository extends JpaRepository<VerilenDers,Long> {

    List<VerilenDers> findAllByDersId(Long id);

}
