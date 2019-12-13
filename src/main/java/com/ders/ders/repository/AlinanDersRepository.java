package com.ders.ders.repository;

import com.ders.ders.model.AlinanDers;
import com.ders.ders.model.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlinanDersRepository extends JpaRepository<AlinanDers,Long> {

}
