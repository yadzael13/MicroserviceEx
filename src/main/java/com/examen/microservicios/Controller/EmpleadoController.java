package com.examen.microservicios.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.microservicios.Entites.Inputs.InputEmpQuery;
import com.examen.microservicios.Entites.Response.Response;
import com.examen.microservicios.Logic.EmpleadoService;

@RestController
@RequestMapping("/HUMAN-DATABASE/")
public class EmpleadoController {

    @Autowired EmpleadoService empservice;


    @PostMapping("filter")
    public ResponseEntity<Response> get_filter(
                    @RequestBody InputEmpQuery input,
                    @RequestParam(value = "cia", required = true) Integer cia
                    ){
        Response resp = empservice.getFilter(input,cia);
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);

    }

}
