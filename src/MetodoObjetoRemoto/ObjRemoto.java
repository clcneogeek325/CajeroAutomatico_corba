/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MetodoObjetoRemoto;

import Cliente.LogeoAministardor;
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
static Operaciones  objeto;

    public static Operaciones getObj() {
      return objeto;
    }

    public static Operaciones ObjRemoto(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

        LogeoAministardor lo=new LogeoAministardor();
        lo.setVisible(true);
        System.out.println("fdssrs");
        ORB orb=ORB.init(args,null);
        org.omg.CORBA.Object objRef=orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
        
          Operaciones objeto2=OperacionesHelper.narrow(ncRef.resolve_str("cajero"));

          return objeto2;
    }

    public static void main(String[] args) throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

        objeto=ObjRemoto(args);
        System.out.println(objeto.consultarAdmin("admin", "admin"));
 objeto.mensaje("admin");
    }

}
