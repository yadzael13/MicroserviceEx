package com.examen.microservicios.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.microservicios.Entites.Database.HuCatMoneda;
import com.examen.microservicios.Entites.Response.Response;
import com.examen.microservicios.Logic.CatMonedaService;

@RestController
@RequestMapping("/MONEDA-DATABASE/")
public class CatMonedaController {
     
    @Autowired
    CatMonedaService monedaService;

    @GetMapping("getAll")
    public ResponseEntity<Response> obtenerTodos(){
        Response resp = monedaService.getAll();
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);
    }

    @GetMapping("getCatMoneda")
    public ResponseEntity<Response> obtenerCatMoneda(
                            @RequestParam(value="cve_moneda", defaultValue = "") String moneda,
                            @RequestParam(value="cia", defaultValue = "0") Integer cia
                            ){
        Response resp = monedaService.getByFilter(cia, moneda);
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);
    }

    @PostMapping("insertData")
    public ResponseEntity<Response> insertarElemento(
                            @RequestBody HuCatMoneda input
                            ){
        Response resp = monedaService.insertData(input);
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);
    }

    @PutMapping("updateData")
    public ResponseEntity<Response> updateElemento(
                            @RequestBody HuCatMoneda input,
                            @RequestParam(value="cia", defaultValue = "0") Integer cia 
    ){
        input.setCia(cia);
        Response resp = monedaService.updateData(input);
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);
    }

    @DeleteMapping("deleteData")
    public ResponseEntity<Response> deleteElemento(      
                            @RequestParam(value="cia", defaultValue = "0") Integer cia 
    ){
        
        Response resp = monedaService.deleteData(cia);
        return ResponseEntity.status(HttpStatusCode.valueOf(resp.getCode())).body(resp);
    }
}
