package com.examen.microservicios.Logic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.microservicios.Entites.Database.HuCatMoneda;
import com.examen.microservicios.Entites.Response.Response;
import com.examen.microservicios.Entites.Response.ResponseData;
import com.examen.microservicios.Repository.HuCatMonedaRepo;
import com.examen.microservicios.Tools.Loggers;

 /** --------- LOGICA CRUD PARA TABLA HU_CAT_MONEDA ------------ */
@Service
public class CatMonedaService {

    @Autowired
    Loggers log;
    
    @Autowired
    HuCatMonedaRepo monedaRepo;

    /** OBTENER TODOS LOS ELEMENTOS
     * @return Response del servicio
     */
    public Response getAll(){     
        try {
            ResponseData respData = new ResponseData();
            respData.setCode(200);
            respData.setResult("Exito");
            respData.setDescripcion("Se han obtenido los datos de CAT-Moneda exitosamente");
            respData.setListData(monedaRepo.findAll());
            return respData;
        } catch (Exception e) {
            Response resp = new Response();
            log.errorLogger("getAll() -- CatMonedaService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    }

     /** OBTENER POR FILTRO DE CIA, O CVE_MONEDA
     * @return Response del servicio
     */
    public Response getByFilter(Integer cia, String cve){
        Response resp = new Response();
        try {
            if(cia==0&&cve.replace(" ","").equals("")){
                resp.setCode(400);
                resp.setResult("Error de datos");
                resp.setDescripcion("Verifique datos ingresados");
                return resp;
            }else
            if(cia==0&&!cve.replace(" ","").equals("")){
                ResponseData respData = new ResponseData();
                respData.setListData(monedaRepo.findByCve(cve));
                if(respData.getCantidad_de_elementos()==0){
                    resp.setCode(200);
                    resp.setResult("Exito");
                    resp.setDescripcion("No se han encontrado elementos con CVE_MONEDA: "+cve);
                    return resp;               
                }
                respData.setCode(200);
                respData.setResult("Exito");
                respData.setDescripcion("Se han obtenido los datos de CAT-Moneda exitosamente");
                
                return respData;

            }else if(cia!=0&&cve.replace(" ","").equals("")){
                ResponseData respData = new ResponseData();
                respData.setListData(monedaRepo.findByCia(cia));
                if(respData.getCantidad_de_elementos() == 0){
                    resp.setCode(200);
                    resp.setResult("Exito");
                    resp.setDescripcion("No se han encontrado elementos con CIA: "+cia.toString());
                    return resp;
                }
                respData.setCode(200);
                respData.setResult("Exito");
                respData.setDescripcion("Se han obtenido los datos de CAT-Moneda exitosamente");
                
                return respData;
            }
                ResponseData respData = new ResponseData();
                respData.setListData(monedaRepo.findFilter(cia,cve));
                if(respData.getCantidad_de_elementos() == 0){
                    resp.setCode(200);
                    resp.setResult("Exito");
                    resp.setDescripcion("No se han encontrado elementos con la informacion Solicitada");
                    return resp;
                }
                respData.setCode(200);
                respData.setResult("Exito");
                respData.setDescripcion("Se han obtenido los datos de CAT-Moneda exitosamente");
                
                return respData;
                  
        } catch (Exception e) {
            log.errorLogger("getByFilter() -- CatMonedaService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    }

     /** INSERTAR UN NUEVO ELEMENTO
     * @return Response del servicio
     */
    public Response insertData(HuCatMoneda input){
        Response resp = new Response();
        try {
            monedaRepo.save(input);
            resp.setCode(200);
            resp.setResult("Exito");
            resp.setDescripcion("Se ha insertado correctamente el elemento");
            return resp;
        } catch (Exception e) {
            log.errorLogger("insertData() -- CatMonedaService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    }

     /** ACTUALIZAR UN ELEMENTO
     * @return Response del servicio
     */
    public Response updateData(HuCatMoneda input){
        Response resp = new Response();
        try {
            
            if(monedaRepo.findByCia(input.getCia()).size()==0){
                resp.setCode(400);
                resp.setResult("Error");
                resp.setDescripcion("No se ha encontrado elemento con CIA: "+input.getCia().toString());
                return resp;
            }
         
            monedaRepo.save(input);
            resp.setCode(200);
            resp.setResult("Exito");
            resp.setDescripcion("Se ha actualizado correctamente el elemento");
            return resp;
        } catch (Exception e) {
            log.errorLogger("UpdateData() -- CatMonedaService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    }

     /** ELIMINAR UN ELEMENTO
     * @return Response del servicio
     */
    public Response deleteData(Integer cia){
        Response resp = new Response();
        try {
            if(monedaRepo.findByCia(cia).size()==0){
                resp.setCode(400);
                resp.setResult("Error");
                resp.setDescripcion("No se ha encontrado elemento con CIA: "+cia.toString());
                return resp;
            }
            monedaRepo.deleteById(cia);
            resp.setCode(200);
            resp.setResult("Exito");
            resp.setDescripcion("Se ha eliminado correctamente el elemento");
            return resp;

        } catch (Exception e) {
            log.errorLogger("DeleteData() -- CatMonedaService", e.toString());
            resp.setCode(500);
            resp.setResult("Error");
            resp.setDescripcion("Ha ocurrido un error en el servidor");
            return resp;
        }
    
    }
}
