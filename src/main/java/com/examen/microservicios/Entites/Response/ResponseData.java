package com.examen.microservicios.Entites.Response;

import java.util.List;

import lombok.Getter;

  /**
     * Objeto de Respuesta con datos, Hereda de Response
  */
@Getter
public class ResponseData extends Response{
    private List<?> listData;
    private int cantidad_de_elementos;

  
    public void setListData(List<?> list){
        listData= list;
        cantidad_de_elementos = list.size();
    }


   

}
