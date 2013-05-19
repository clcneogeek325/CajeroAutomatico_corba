/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LecturaDeArchivos;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author neogeek
 */
public class ClaseEscribirArchivo {
 public ClaseEscribirArchivo(String direccion,String mensaje)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);

           
                pw.println(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
   
}
