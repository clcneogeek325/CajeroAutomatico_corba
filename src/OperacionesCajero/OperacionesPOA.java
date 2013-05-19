package OperacionesCajero;


/**
* OperacionesCajero/OperacionesPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OperacionesCajero.idl
* domingo 19 de mayo de 2013 12:11:41 PM CDT
*/

public abstract class OperacionesPOA extends org.omg.PortableServer.Servant
 implements OperacionesCajero.OperacionesOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("respuesta", new java.lang.Integer (0));
    _methods.put ("retirar", new java.lang.Integer (1));
    _methods.put ("depositar", new java.lang.Integer (2));
    _methods.put ("consultar", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // OperacionesCajero/Operaciones/respuesta
       {
         String usuario = in.read_string ();
         String contrasenia = in.read_string ();
         boolean $result = false;
         $result = this.respuesta (usuario, contrasenia);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // OperacionesCajero/Operaciones/retirar
       {
         String id_usuario = in.read_string ();
         int cantidad = in.read_long ();
         String $result = null;
         $result = this.retirar (id_usuario, cantidad);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // OperacionesCajero/Operaciones/depositar
       {
         String id_usuario = in.read_string ();
         int cantidad = in.read_long ();
         this.depositar (id_usuario, cantidad);
         out = $rh.createReply();
         break;
       }

       case 3:  // OperacionesCajero/Operaciones/consultar
       {
         String id_usuario = in.read_string ();
         int $result = (int)0;
         $result = this.consultar (id_usuario);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:OperacionesCajero/Operaciones:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Operaciones _this() 
  {
    return OperacionesHelper.narrow(
    super._this_object());
  }

  public Operaciones _this(org.omg.CORBA.ORB orb) 
  {
    return OperacionesHelper.narrow(
    super._this_object(orb));
  }


} // class OperacionesPOA
