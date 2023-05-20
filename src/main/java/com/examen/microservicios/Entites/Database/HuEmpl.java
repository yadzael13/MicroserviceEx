package com.examen.microservicios.Entites.Database;


import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "HU_EMPLS")
public class HuEmpl {
    @Column(name = "NUM_CIA")
    private Integer CIA; 
    @Id
    @Column(name = "NUM_EMP")
    private Long numero_empleado; 

    @Column(name = "APELL_PAT")
    private String apellido_paterno;

    @Column(name = "APELL_MAT")
    private String apellido_materno;

    private String NOMBRE;
    private String SEXO;
    private BigDecimal PESO; 
    private BigDecimal ESTATURA;
    
    @Column(name = "GPO_SANGUINEO")
    private String grupo_sanguineo;

    private Timestamp FECHA_NAC;
    private String PAIS_NAC;
    private String PROVINCIA_NAC;
    private String LOCALIDAD_NAC;
    private String ESTADO_CIVIL;
    private String NACIONALIDAD;
    private String LICENCIA;
    private String PASAPORTE;
    private String EMAIL;
    private Integer CLAVE_PAIS_TEL;
    private Integer COD_AREA_TEL;
    private Integer TELEFONO;
    private Integer EXTENSION_TEL;
    private Timestamp FECHA_INGRESO;
    private Timestamp FECHA_ANTIGUEDAD;
    private Timestamp FECHA_ANTIGUEDAD_SUB;
    private Integer CONTRATO;
    private Integer ACTIVIDAD;
    private Timestamp FECHA_PROMOCION;
    private Timestamp FECHA_SUELDO;
    private Integer ZONA;
    private String AREA;
    private String CENTRO;
    private String LINEA;
    private String PUESTO;
    private Integer PLAZA;
    private String SUPERVISOR;
    private BigDecimal SUELDO;
    private String MONEDA;
    private String FORMATO_SUELDO;
    private Timestamp FECHA_CONTRATO;
    private Timestamp FECHA_TERMINACION;
    private Timestamp FECHA_BAJA;
    private String TIPO_EMPL;
    private String TIPO_CONTRATO;
    private String GRUPO_PRESTACION;
    private String GRUPO_PRESTACION_SUB;
    private Integer TURNO;
    private BigDecimal JORNADA_RED;
    private String BANCO;
    private String SUCURSAL;
    private String CUENTA;
    private String TIPO_CUENTA;
    private String CUENTA_CLAVE;
    private String CD_BANCO;
    private String EDO_BANCO;
    private String FORMA_PAGO;
    private String LUGAR_PAGO;
    private String BANCO2;
    private String SUCURSAL2;
    private String CUENTA2;
    private String TIPO_CUENTA2;
    private String CLAVE_PROVINCIA;
    private String CLAVE_LOCALIDAD;
    private String CUENTA_VALES;
    private String TARJETA_VAL;
    private String CUENTA_VALES_COMEDOR;
    private String TARJETA_VAL_COMEDOR;
    private String STATUS;
    private String CUENTA_VALES_GASOLINA;
    private String TARJETA_VAL_GASOLINA;
    private String CTA_DEUD;
    private String CTA_DEUD2;
    private String DECLARACION_IMP;
    private Integer NIP;
    private Timestamp VENCE_LICENCIA;
    private Timestamp VENCE_PASAPORTE;
    private Timestamp FECHA_MERITO;
    private String TIPO_LICENCIA;
    private String COD_ID_01;
    private String COD_ID_02;
    private String COD_ID_03;
    private String COD_ID_04;
    private String COD_ID_05;
    private String COD_ID_06;
    private String COD_ID_07;
    private String COD_ID_08;
    private String COD_ID_09;
    private String COD_ID_10;
    private String COD_ID_11;
    private String COD_ID_12;
    private String COD_ID_13;
    private String COD_ID_14;
    private String COD_ID_15;
    private String COD_ID_16;
    private String COD_ID_17;
    private String COD_ID_18;
    private String COD_ID_19;
    private String COD_ID_20;
    private String COD_ID_21;
    private String COD_ID_22;
    private String COD_ID_23;
    private String COD_ID_24;
    private String COD_ID_25;
    private String COD_ID_26;
    private String COD_ID_27;
    private String COD_ID_28;
    private String COD_ID_29;
    private String COD_ID_30;
    private String CVE_ETIME;
    private String VISIBLE_DIRECTORIO;
}
