/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MetodoObjetoRemoto;

import OperacionesCajero.Operaciones;
import OperacionesCajero.OperacionesHelper;
import org.omg.CORBA.ARG_IN;
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
public class ObjRemoto {

    public Operaciones ObjRemoto(String nombre,String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
    
        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
          Operaciones  objeto=OperacionesHelper.narrow(ncRef.resolve_str(nombre));

          return objeto;
    }

    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

        System.out.println(new ObjRemoto().ObjRemoto("admin",args));
        
    }

}
