package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conexion;
    public String driver = "com.mysql.jdbc.Driver";
    public String URL = "jdbc:mysql://localhost/db_corba?user=root&password=";

    public void conectar() {
        try {
            Class.forName(driver);

            conexion   = DriverManager.getConnection(URL);


        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }catch (SQLException e){

            System.out.println(e);
        }

    }

}
