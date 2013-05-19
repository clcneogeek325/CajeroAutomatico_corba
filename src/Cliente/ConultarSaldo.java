/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;


import Cliente.consulta;
import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;

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
public class ConultarSaldo {
   public static String nombreUsuario="";
    static consulta gui_consulta;
    

    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
        gui_consulta = new consulta();
        gui_consulta.setVisible(true);

        ORB orb=ORB.init(args, null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         String nombre = "cajero";
        
          Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));
          int saldoObtenido = objeto.consultar(nombreUsuario);
          gui_consulta.txtsaldo.setText(saldoObtenido+"");
         
          
         
    }

}
