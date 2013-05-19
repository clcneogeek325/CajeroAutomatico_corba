/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LecturaDeArchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author neogeek
 */
public class LecturaDeARchivo {
 public String LecturaDeARchivo(String direccion) {

      String texto_retornado="";
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (direccion);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            texto_retornado+=linea;
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta
         // una excepcion.
         try{
            if( null != fr ){
               fr.close();
            }
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
    return texto_retornado;
 }
   
}
