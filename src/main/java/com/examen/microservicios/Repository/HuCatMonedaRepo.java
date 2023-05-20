package com.examen.microservicios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examen.microservicios.Entites.Database.HuCatMoneda;


@Repository
public interface HuCatMonedaRepo extends JpaRepository<HuCatMoneda, Integer>{
    List<HuCatMoneda> findByCve(String cve);
    List<HuCatMoneda> findByCia(Integer cia);

    @Query(value = "SELECT * FROM HU_CAT_MONEDA hu WHERE hu.NUM_CIA = :cia AND hu.CLAVE_MONEDA = :cve", nativeQuery = true)
    List<HuCatMoneda> findFilter(Integer cia, String cve);
    
}
