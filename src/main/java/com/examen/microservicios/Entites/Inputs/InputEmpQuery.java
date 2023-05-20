package com.examen.microservicios.Entites.Inputs;



import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * Input del servicio de filtrado
 */
@Data
@NoArgsConstructor
public class InputEmpQuery {
    private Long empleado;
    private String fechaInicio;
    private String fechaTermino;  
}
