/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package RetirandoEfectivo;

import Cliente.MenuPrincipal;
import Cliente.VariablesGlobales;
import Cliente.retiro_Efectivo;
import LecturaDeArchivos.LecturaDeARchivo;
import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
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
public class RetirandoDinero {

    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        final retiro_Efectivo x = new retiro_Efectivo();
        x.setVisible(true);

        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        final Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));

        x.btn_100.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 100);
               JOptionPane.showMessageDialog(null, mensaje);
               x.setVisible(false);
             new MenuPrincipal().setVisible(true);

            }
        });

        x.btn_300.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 300);
                JOptionPane.showMessageDialog(null, mensaje);
            x.setVisible(false);
             new MenuPrincipal().setVisible(true);
             
            }
        });

        x.btn_500.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 500);
             JOptionPane.showMessageDialog(null, mensaje);
            x.setVisible(false);
             new MenuPrincipal().setVisible(true);

            }
        });



        x.btn_1000.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 1000);
             JOptionPane.showMessageDialog(null, mensaje);
            x.setVisible(false);
             new MenuPrincipal().setVisible(true);

            }
        });


        x.btn_1500.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 1500);
            JOptionPane.showMessageDialog(null, mensaje);
            x.setVisible(false);
             new MenuPrincipal().setVisible(true);

            }
        });


        x.btn_3000.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
              String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), 3000);
             JOptionPane.showMessageDialog(null, mensaje);
             x.setVisible(false);
             new MenuPrincipal().setVisible(true);


            }
        });

         x.txt_siguinte.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            int cantidad = Integer.parseInt(x.txt_otracantidad.getText());
              String mensaje=objeto.retirar(new LecturaDeARchivo().LecturaDeARchivo(new VariablesGlobales().direccionArchivo), cantidad);
             JOptionPane.showMessageDialog(null, mensaje);
             x.setVisible(false);
             new MenuPrincipal().setVisible(true);
            }
        });

        
    }
}
