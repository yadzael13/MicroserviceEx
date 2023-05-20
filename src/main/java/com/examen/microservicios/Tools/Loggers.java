package com.examen.microservicios.Tools;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
/*
 *  Herramienta para loggers, monitoreo de errores y mensajes en consola
 */
@Service
public class Loggers {
        // -------- Loggers ---------
        private final Logger logger = LogManager.getLogger(Loggers.class);

        public void errorLogger(String ub, String issue) {
            String msj = "\n----------------------------------\n" +
                    "Error en : " + ub
                    + "\nDescripcion: " + issue
                    + "\n----------------------------------\n";
            logger.error(msj);
        }
    
}
