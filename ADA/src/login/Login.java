/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;

/**
 *
 * @author Carlos Torres
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //btnIngresar.setBackground(new Color(248,90,27));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnIngresar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblFakePass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnOlvidar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(450, 500));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/btnIngresar.png"))); // NOI18N
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/cerrar.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(222, 221, 221));
        txtCorreo.setText("Correo electronico");
        txtCorreo.setBorder(null);
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCorreoMouseClicked(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 230, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 230, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 230, 10));

        lblFakePass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        lblFakePass.setForeground(new java.awt.Color(222, 221, 221));
        lblFakePass.setText("Contraseña");
        lblFakePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFakePassMouseClicked(evt);
            }
        });
        jPanel1.add(lblFakePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 230, 30));

        txtPass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtPass.setForeground(new java.awt.Color(56, 51, 51));
        txtPass.setBorder(null);
        txtPass.setEchoChar('\u2022');
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 230, 30));

        btnOlvidar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOlvidar.setForeground(new java.awt.Color(249, 106, 49));
        btnOlvidar.setText("He olvidado mi contraseña");
        btnOlvidar.setBorder(null);
        btnOlvidar.setContentAreaFilled(false);
        jPanel1.add(btnOlvidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel1.setText("Iniciar sesión");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/logoLoginXL.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Evento para el boton de cerrar
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed
    //Este evento es para cuando le des el txtCorreo se elimine el texto Correo electronico automaticamente
    private void txtCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMouseClicked
        if(txtCorreo.getText().equals("Correo electronico")){
            txtCorreo.setText("");
            txtCorreo.setForeground(new Color(56,51,51));   //Aqui cambiamos el color de la fuente de gris a negro
        }
        //Esto es para que el label que dice contraseña se ponga automaticamente si detecta que no ha escrito nada
        char[] pass = txtPass.getPassword();
        String password = new String(pass);
        if(password.equals("")){
            lblFakePass.setVisible(true);
        }
    }//GEN-LAST:event_txtCorreoMouseClicked

   //Aqui verifica que si pierde el foco y el txtCorreo esta vacio se le vuelva a poner Correo Electronico
    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if(txtCorreo.getText().equals("")){
            txtCorreo.setText("Correo electronico");
            txtCorreo.setForeground(new Color(222,221,221));
        }
    }//GEN-LAST:event_txtCorreoFocusLost
    //Esto es para que el label que dice contraseña se ponga automaticamente si detecta que no ha escrito nada
    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        char[] pass = txtPass.getPassword();
        String password = new String(pass);
        if(password.equals("")){
            lblFakePass.setVisible(true);
        }
        
    }//GEN-LAST:event_txtPassFocusLost
    //Mover el frame
    int xx,xy;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed
    
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged
    //Esto es para que el label que dice contraseña se ponga automaticamente si detecta que no ha escrito nada
    private void lblFakePassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFakePassMouseClicked
        if(lblFakePass.getText().equals("Contraseña")){
            lblFakePass.setVisible(false);
            txtPass.requestFocus();
        }
    }//GEN-LAST:event_lblFakePassMouseClicked
    //Esto es para que el label que dice contraseña se ponga automaticamente si detecta que no ha escrito nada
    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        char[] pass = txtPass.getPassword();
        String password = new String(pass);
        if(password.equals("")){
            lblFakePass.setVisible(true);
        }
    }//GEN-LAST:event_jPanel1FocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnOlvidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFakePass;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
