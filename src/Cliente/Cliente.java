/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import Cliente.logeocuenta;
import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
   




    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        logeocuenta = new logeocuenta();
        logeocuenta.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));

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
