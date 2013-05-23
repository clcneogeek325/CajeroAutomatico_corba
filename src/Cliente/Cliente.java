/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import AgregandoSaldo.Aniadir;
import Cliente.logeocuenta;
import LecturaDeArchivos.ClaseEscribirArchivo;
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
 * @author mackena91
 */
public class Cliente {
    static logeocuenta logeocuenta;
   




    public static void main(final String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        logeocuenta = new logeocuenta();
        logeocuenta.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));


        logeocuenta.btn_depositar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                logeocuenta.setVisible(false);
                
                try {
                    new Aniadir().main(args);
                } catch (InvalidName ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotFound ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotProceed ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        logeocuenta.cmdGerente.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    new LogeoAdministradorClase().main(args);
                } catch (InvalidName ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotFound ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotProceed ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                logeocuenta.dispose();
            }
        });

        logeocuenta.cmdentrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

        String datoUsuario = logeocuenta.txtcuenta.getText();
        String datoContrasenia = logeocuenta.txtnip.getText();
        System.out.println(datoUsuario+ " "+datoContrasenia);

                if (datoUsuario.equals("") || datoContrasenia.equals("")) {
                    JOptionPane.showMessageDialog(null, "Por fabor ingresa tu usuario y tu contraseña");
                }else{
              if (objeto.respuesta(datoUsuario,datoContrasenia)) {
            MenuPrincipal x = new MenuPrincipal();
            x.setVisible(true);
            logeocuenta.setVisible(false);
            objeto.mensaje(datoUsuario);
            new ClaseEscribirArchivo(new VariablesGlobales().direccionArchivo, datoUsuario);
        }else{
               JOptionPane.showMessageDialog(null, "La contraseá es incorrecta");
               logeocuenta.txtcuenta.setText("");
               logeocuenta.txtnip.setText("");
               logeocuenta.txtcuenta.requestFocus();
        }
                }
      

            }
        });



    }

}
