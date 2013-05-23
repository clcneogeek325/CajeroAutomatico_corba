/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import MetodoObjetoRemoto.ObjRemoto;
import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
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
public class LogeoAdministradorClase {
   static LogeoAministardor gui_milogeoAdmin = new LogeoAministardor();


    public static void main(final String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));


        gui_milogeoAdmin.setVisible(true);
       gui_milogeoAdmin.btn_aceptar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              String usuario ,contrasenia;
              usuario = gui_milogeoAdmin.txt_usuario.getText();
              contrasenia = gui_milogeoAdmin.txt_contrasenia.getText();
                System.out.println(objeto.consultarAdmin(usuario, contrasenia));
                if (objeto.consultarAdmin(usuario, contrasenia)) {
                    try {
                        new RegistarNuevoUsuarioClase().main(args);
                        gui_milogeoAdmin.setVisible(false);
                    } catch (InvalidName ex) {
                        Logger.getLogger(LogeoAdministradorClase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NotFound ex) {
                        Logger.getLogger(LogeoAdministradorClase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (CannotProceed ex) {
                        Logger.getLogger(LogeoAdministradorClase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                        Logger.getLogger(LogeoAdministradorClase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                }




            }
        });




    }

}
