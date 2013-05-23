/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import BaseDatos.Actualizar;
import BaseDatos.Consultar;
import BaseDatos.Insertar;
import Fecha.ObtFecha;
import Fecha.ObtHora;
import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import OperacionesCajero.OperacionesPOA;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author mackena91
 */
public class Servidor extends OperacionesPOA {
 static pantallaadmin gui_admin = new pantallaadmin();

DefaultTableModel modeloTabla = (DefaultTableModel) gui_admin.tablaEntradas.getModel();

Object datos[]=new Object[4];

public boolean respuesta(String usuario, String contrasenia) {
        boolean resutlado = false;
        ResultSet resultadosUsuarios = null;
        Consultar consultandoUusarios = new Consultar();
        resultadosUsuarios = consultandoUusarios.Consultar("select usuario,contrasenia from usuarios where usuario='" + usuario + "'");
        String usuarioObtendo = "nada";
        String passwdObtendo = "nada";
        try {
            while (resultadosUsuarios.next()) {
                usuarioObtendo = resultadosUsuarios.getString(1);
                passwdObtendo = resultadosUsuarios.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

      
            if (usuarioObtendo.equals(usuario) && passwdObtendo.equals(contrasenia)  ) {
                resutlado = true;
            }
        


        return resutlado;
    }

    public static void main(String[] args) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {

  gui_admin.setVisible(true);

  
        System.out.println("Servidor Iniciado");
        ORB orb = ORB.init(args, null);
        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(new Servidor());
        Operaciones href = OperacionesHelper.narrow(ref);
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        String nombre = "cajero";
        NameComponent path[] = ncRef.to_name(nombre);
        ncRef.rebind(path, href);
        orb.run();

    }

    public String retirar(String nombre_usuario, int cantidad) {
       ResultSet resultadoSaldo = null;
        Consultar consultaSQL = new Consultar();
        resultadoSaldo = consultaSQL.Consultar("select capital from usuarios where usuario = 'admin'");
        int saldo =0;
        try {
            while (resultadoSaldo.next()) {
                saldo  = resultadoSaldo.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String mensaje="";
        if (saldo - cantidad < 0) {
            mensaje="No se puede retirar efectivo por que su saldo es insuficiente";
            
        }else{
            new Actualizar("update usuarios set capital=capital-"+cantidad+" where usuario='"+nombre_usuario+"'");
            mensaje ="la transaccion se ha llevado acabo correctamente , de su cuenta se ha retirado "+cantidad+" pesos a tu cuenta";
        }

        return mensaje;
    }

    public void depositar(String nombre_usuario, int cantidad) {
           new Actualizar("update usuarios set capital=capital+"+cantidad+" where usuario='"+nombre_usuario+"'");

    }

    public int consultar(String nombre_usuario){

        ResultSet resultadoSaldo = null;
        Consultar consultaSQL = new Consultar();
        resultadoSaldo = consultaSQL.Consultar("select capital from usuarios where usuario = '"+nombre_usuario+"'");
        int saldo =0;
        try {
            while (resultadoSaldo.next()) {
                saldo  = resultadoSaldo.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return saldo;
    }

    public void mensaje(String nombreUsuario) {
        System.out.println(nombreUsuario);
        ResultSet resultados  = new Consultar().Consultar("select id from usuarios where usuario='"+nombreUsuario+"'");
        try {
            while (resultados.next()) {
                datos[0]=resultados.getObject(1)+"";
            }
 

        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
      datos[1]=nombreUsuario;

      ObtFecha fecha = new ObtFecha();
      datos[2]=fecha.ObtFecha();

      ObtHora hora = new ObtHora();
      datos[3]=hora.ObtHora();

      modeloTabla.addRow(datos);

    }

    public boolean consultarAdmin(String nombre_usuario,String contrasenia) {
        ResultSet resultadoSaldo = null;
        Consultar consultaSQL = new Consultar();
        resultadoSaldo = consultaSQL.Consultar("select usuario from usuarios where contrasenia = '"+contrasenia+"'");
       boolean respuesta=false;
        String admin ="";
        try {
            while (resultadoSaldo.next()) {
                admin  = resultadoSaldo.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!admin.equals("")) {
            respuesta=true;
        }


        return true;
    }

    public String regristrar(String nombre, String apellidos, String direccion, String nombreCuenta, String saldoInicial, String nip) {
        new Insertar("insert into usuarios (usuario,contrasenia,capital,apellidos,nombre,direccion) values ('"
                +nombreCuenta+"','"+nip+"',1000,'"+apellidos+"','"+nombreCuenta+"','"+direccion+"')");

        return "El registro se llevo a cabo correctamente";
    }

   
}
