/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AgregandoSaldo;

import Cliente.AniadirEfectivo;
import Cliente.MenuPrincipal;
import Cliente.VariablesGlobales;
import LecturaDeArchivos.LecturaDeARchivo;
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
 * @author neogeek
 */
public class Aniadir {
    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        final AniadirEfectivo x = new AniadirEfectivo();
        x.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));
        x.txt_sisguinte.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              int cantidad = Integer.parseInt(x.txt_cantidadAniadir.getText());
              objeto.depositar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), cantidad);
              JOptionPane.showMessageDialog(null, "Usted ha depositado "+cantidad+"  pesos a su cuenta");
              x.setVisible(false);
              MenuPrincipal y = new MenuPrincipal();
              y.setVisible(true);

            }
        });

    }

}
