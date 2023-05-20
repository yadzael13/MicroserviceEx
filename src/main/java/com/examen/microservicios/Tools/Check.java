package com.examen.microservicios.Tools;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Check {
    /** FUNCION PARA CHECAR EL FORMATO DE UN STRING PARA UNA FECHA USANDO REGEX
     * @param date -- STRING a evaluar
     * @return True/False
     */
    public boolean checkDateFormat(String date){
        String regex = "^(0[1-9]|1\\d|2\\d|3[01])-(0[1-9]|1[0-2])-(\\d{4})$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        

        return (matcher.matches())? true : false;
    }

    /** FUNCION PARA VALIDAR SI UN OBJETO ES UN STRING VACIO O ES NULL
     * @param ob
     * @return TRUE/FALSE
     */
    public boolean checkIsNullOrBlanck(Object ob){
        if(ob.equals(null)){
            return true;
        }
        String s = ob.toString();
        s.replace(" ", "");
        if(s.equals("")){
            return true;
        }
        return false;
        
    }
}
