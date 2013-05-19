package BaseDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Eliminar {

    public Conexion db = new Conexion();
    ResultSet Resultados;
    Statement objetoDB;
    boolean ejecucion;

    public Eliminar(String campos) {
        db.conectar();
        try {
            objetoDB = db.conexion.createStatement();
            ejecucion = objetoDB.execute(campos);
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado correctamente");
        } catch (SQLException ex) {
            System.out.println("Este es el error "+ex);
        }
    }
}
