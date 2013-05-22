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
public class ObtHora {
    public String ObtHora() {
                      Consultar consultarHora = new Consultar();
    ResultSet resultadosDeConsulta = consultarHora.Consultar("select time(now())");
    String fecha="";
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
