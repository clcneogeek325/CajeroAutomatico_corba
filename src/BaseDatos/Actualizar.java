package BaseDatos;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Actualizar {

    Conexion db = new Conexion();
    ResultSet Resultados;
    Statement objetoDB;
    boolean ejecucion;

    public Actualizar(String campos) {
        db.conectar();
        try {
            objetoDB = db.conexion.createStatement();
            ejecucion = objetoDB.execute(campos);
            JOptionPane.showMessageDialog(null, "El registro ha sido actualizado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se ha producido el siguiente error  " + ex);
        }
    }
}
