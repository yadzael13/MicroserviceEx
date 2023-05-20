package com.examen.microservicios.Entites.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {
    private int Code;
    private String Result;
    private String Descripcion;
}
