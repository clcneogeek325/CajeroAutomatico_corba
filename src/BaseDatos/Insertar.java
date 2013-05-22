package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertar {

    public Conexion db = new Conexion();
    ResultSet Resultados;
    Statement objetoDB;
    boolean ejecucion;

    public Insertar(String campos) {
        db.conectar();
        try {
            objetoDB = db.conexion.createStatement();
            ejecucion = objetoDB.execute(campos);
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
