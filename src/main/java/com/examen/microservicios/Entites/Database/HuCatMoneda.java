package com.examen.microservicios.Entites.Database;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "HU_CAT_MONEDA")
public class HuCatMoneda {
    @Id
    @Column(name="NUM_CIA")
    private Integer cia;
    @Column(name="CLAVE_MONEDA")
    private String cve;
    private String DESCRIPCION;
    private String SIMBOLO;
    private String ABREVIACION;
    @Column(name="MONEDA_CORRIENTE")
    private String monedaCorriente;
    private String STATUS;

    
}
