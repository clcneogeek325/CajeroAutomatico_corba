
import BaseDatos.Consultar;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mackena91
 */
public class ejemolos {
    public static void main(String[] args) throws SQLException {
        ResultSet resultados = new Consultar().Consultar("select *from usuarios");
        while(resultados.next())
        {
            System.out.println(resultados.getObject(1));
             System.out.println(resultados.getObject(2));
              System.out.println(resultados.getObject(3));
        }
    }
}
