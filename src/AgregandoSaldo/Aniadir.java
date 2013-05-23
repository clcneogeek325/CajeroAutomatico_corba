/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AgregandoSaldo;

import Cliente.AniadirEfectivo;
import Cliente.Cliente;
import Cliente.MenuPrincipal;
import Cliente.VariablesGlobales;
import LecturaDeArchivos.LecturaDeARchivo;
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
public class Aniadir {
    public static void main(final String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        final AniadirEfectivo x = new AniadirEfectivo();
        x.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));
        x.txt_Depositar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              int cantidad = Integer.parseInt(x.txt_cantidadAniadir.getText());
              objeto.depositar(x.txt_nombreUsario.getText(), cantidad);
              JOptionPane.showMessageDialog(null, "Usted ha depositado "+cantidad+"  pesos a la cuenta de "+x.txt_nombreUsario.getText());
              x.setVisible(false);
                try {
                    new Cliente().main(args);
                } catch (InvalidName ex) {
                    Logger.getLogger(Aniadir.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotFound ex) {
                    Logger.getLogger(Aniadir.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CannotProceed ex) {
                    Logger.getLogger(Aniadir.class.getName()).log(Level.SEVERE, null, ex);
                } catch (org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
                    Logger.getLogger(Aniadir.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
