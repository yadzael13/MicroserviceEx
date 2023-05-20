package com.examen.microservicios.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examen.microservicios.Entites.Database.HuEmpl;

/*
 * Repositorio JPA del objeto HuEmpl, de la tabla HU_EMPLS
 */
@Repository
public interface HuEmplsRepo extends JpaRepository<HuEmpl, Long>{
    List<HuEmpl> findByCIA(Integer cia);

    @Query(value = "SELECT * FROM HU_EMPLS hu WHERE hu.NUM_CIA = :cia AND hu.NUM_EMP = :emp AND hu.FECHA_INGRESO >= :ingreso AND hu.FECHA_TERMINACION <= :termino", nativeQuery = true)
    List<HuEmpl> findFilter(int cia, Long emp, String ingreso, String termino);

    @Query(value = "SELECT * FROM HU_EMPLS hu WHERE hu.NUM_CIA = :cia AND hu.FECHA_INGRESO >= :ingreso AND hu.FECHA_TERMINACION <= :termino", nativeQuery = true)
    List<HuEmpl> findFilterNoEmp(int cia, String ingreso, String termino);
}
