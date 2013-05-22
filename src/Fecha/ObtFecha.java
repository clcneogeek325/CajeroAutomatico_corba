/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fecha;

import BaseDatos.Consultar;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author neogeek
 */
public class ObtFecha {
    String fecha="";
    public String ObtFecha() {
                      Consultar consultarHora = new Consultar();
    ResultSet resultadosDeConsulta = consultarHora.Consultar("select date(now())");
   
    try {
            while (resultadosDeConsulta.next()) {
                fecha=resultadosDeConsulta.getObject(1)+"";
            }
        } catch (SQLException ex) {
        System.out.println("Error"+ex);
        }
    return fecha;
    }
  
}
