package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {
    
   public  Conexion db = new Conexion();
    ResultSet Resultados;
    Statement objetoDB;

    public ResultSet Consultar(String consulta) {
        db.conectar();

        try {
            objetoDB = db.conexion.createStatement();
            Resultados = objetoDB.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return (Resultados);

    }

}
