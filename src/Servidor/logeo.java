package Servidor;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * logeo.java
 *
 * Created on 14/05/2013, 10:04:00 AM
 */

/**
 *
 * @author Piscis
 */
public class logeo extends javax.swing.JFrame {

    /** Creates new form logeo */
    public logeo() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txtcontrasenia = new javax.swing.JPasswordField();
        cmdentrar = new javax.swing.JButton();
        cmdentrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel1.setText("Principal");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 10, 118, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 70, 140, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 130, 170, 30);

        txtusuario.setFont(new java.awt.Font("Tahoma", 3, 24));
        getContentPane().add(txtusuario);
        txtusuario.setBounds(240, 60, 230, 40);

        txtcontrasenia.setFont(new java.awt.Font("Tahoma", 3, 24));
        getContentPane().add(txtcontrasenia);
        txtcontrasenia.setBounds(240, 120, 230, 40);

        cmdentrar.setFont(new java.awt.Font("Tahoma", 3, 24));
        cmdentrar.setText("Entrar");
        getContentPane().add(cmdentrar);
        cmdentrar.setBounds(290, 200, 130, 60);

        cmdentrar1.setFont(new java.awt.Font("Tahoma", 3, 24));
        cmdentrar1.setText("Entrar");
        getContentPane().add(cmdentrar1);
        cmdentrar1.setBounds(120, 200, 130, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logeo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdentrar;
    private javax.swing.JButton cmdentrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtcontrasenia;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

}
