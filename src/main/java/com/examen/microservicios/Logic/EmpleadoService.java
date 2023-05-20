package com.examen.microservicios.Logic;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.microservicios.Repository.HuEmplsRepo;
import com.examen.microservicios.Tools.Check;
import com.examen.microservicios.Tools.Loggers;

import com.examen.microservicios.Entites.Database.HuEmpl;
import com.examen.microservicios.Entites.Inputs.InputEmpQuery;
import com.examen.microservicios.Entites.Response.Response;
import com.examen.microservicios.Entites.Response.ResponseData;


@Service
public class EmpleadoService {
    //Loggers
    @Autowired Loggers log;

    // Funciones Repo
    @Autowired HuEmplsRepo emps;


    /** Filtra la información de la tabla HU_EMPS con e
     * @param input -- Objeto de consulta
     * @return - Response -- Objeto de Respuesta con o Sin Data
     */
    public Response getFilter(InputEmpQuery input, Integer cia){
        Response resp = new Response();
        try {
            //Clase Check dentro de Tools
            Check check = new Check();
            //Si no existe el campo CIA en el input
            if(check.checkIsNullOrBlanck(cia)){
                resp.setCode(400);
                resp.setResult("Error al obtener data");
                resp.setDescripcion("Datos de CIA incorrecto");
                return resp;
            }
            //Si esta mal el formato de la fecha de inicio en el input
            if(!check.checkDateFormat(input.getFechaInicio())){
                resp.setCode(400);
                resp.setResult("Error al obtener data");
                resp.setDescripcion("Formato de fecha de inicio incorrecto");
                return resp;
            }
            //Si esta mal el formato de la fecha de termino en el input
              if(!check.checkDateFormat(input.getFechaTermino())){
                resp.setCode(400);
                resp.setResult("Error al obtener data");
                resp.setDescripcion("Formato de fecha de termino incorrecto");
                return resp;
            }

            ResponseData respData = new ResponseData();
            List<HuEmpl> listaEmps = new ArrayList<>();

            //Si no existe el campo empleado, filtra solo con CIA
            if(input.getEmpleado() == null){
                listaEmps = emps.findFilterNoEmp(cia, input.getFechaInicio(), input.getFechaTermino());
            }else{
                listaEmps = emps.findFilter(cia, input.getEmpleado(), input.getFechaInicio(), input.getFechaTermino());
            }
        
            respData.setListData(listaEmps);

            respData.setCode(200);
            respData.setResult("Datos consultados correctamente");
            respData.setDescripcion("Se han filtrado los datos correctamente");  
            
            return respData;
        } catch (Exception e) {
            log.errorLogger("getFilter -- EmpleadoService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    }
}
