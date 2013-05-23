/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author neogeek
 */
public class RegistarNuevoUsuarioClase {
    static RegistrarNuevoUsuario gui_resgistro=new RegistrarNuevoUsuario();
    public static void main(final String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

        gui_resgistro.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));
         gui_resgistro.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
                String nombre,
                    apellidos,
                    direccion,
                    nombreCuenta,
                    saldoInicial,
                    nip;
             nombre = gui_resgistro.txtnombre.getText();
             apellidos=gui_resgistro.txtapellidos.getText();
             direccion=gui_resgistro.txtdireccion.getText();
             nombreCuenta=gui_resgistro.txtnombrecuenta.getText();
             saldoInicial=gui_resgistro.txtsaldo.getText();
             nip = gui_resgistro.txtnip.getText();
          String respuesta =  objeto.regristrar(nombre, apellidos, direccion, nombreCuenta, saldoInicial, nip);
          JOptionPane.showMessageDialog(null, respuesta);
             

            }
        });

        gui_resgistro.btn_regresar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    new Cliente().main(args);
                } catch (InvalidName ex) {
                    Logger.getLogger(RegistarNuevoUsuarioClase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotFound ex) {
                    Logger.getLogger(RegistarNuevoUsuarioClase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotProceed ex) {
                    Logger.getLogger(RegistarNuevoUsuarioClase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                    Logger.getLogger(RegistarNuevoUsuarioClase.class.getName()).log(Level.SEVERE, null, ex);
                }
           gui_resgistro.dispose();
            }

        });



    }

}
