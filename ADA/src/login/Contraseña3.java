
package login;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.UIManager;

/**
 *
 * @author Usuario
 */
public final class Contraseña3 extends javax.swing.JFrame {

    /**
     * Creates new form Contraseña3
     */
    public Contraseña3() {
        initComponents();
        this.setLocationRelativeTo(null);
        iconoFormulario();
        btnOjoAbierto1.setVisible(false);
        btnOjoAbierto1.setEnabled(false);
        btnOjoAbierto.setVisible(false);
        btnOjoAbierto.setEnabled(false);
        Pass1.setEchoChar(('•'));
        Pass2.setEchoChar(('•'));

      

    }
    

    //Establecer el icono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagesLogin/logoLoginXL.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnOjoAbierto1 = new javax.swing.JButton();
        btnOjoCerrado1 = new javax.swing.JButton();
        btnOjoAbierto = new javax.swing.JButton();
        btnOjoCerrado = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblContra1 = new javax.swing.JLabel();
        lblContra2 = new javax.swing.JLabel();
        Pass2 = new javax.swing.JPasswordField();
        Pass1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/cerrar.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 321, 290, 10));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/btnCancelar.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Actualiza tu cuenta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 13, 190, -1));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/btnGuardar.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 196, 280, 10));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("8 caracteres como mínimo, distingue mayúsculas de minúsculas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 200, -1, -1));

        btnOjoAbierto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/ojo_abierto.png"))); // NOI18N
        btnOjoAbierto1.setBorderPainted(false);
        btnOjoAbierto1.setContentAreaFilled(false);
        btnOjoAbierto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoAbierto1MouseClicked(evt);
            }
        });
        jPanel1.add(btnOjoAbierto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        btnOjoCerrado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/ojo_cerrado.png"))); // NOI18N
        btnOjoCerrado1.setBorderPainted(false);
        btnOjoCerrado1.setContentAreaFilled(false);
        btnOjoCerrado1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoCerrado1MouseClicked(evt);
            }
        });
        jPanel1.add(btnOjoCerrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        btnOjoAbierto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/ojo_abierto.png"))); // NOI18N
        btnOjoAbierto.setBorderPainted(false);
        btnOjoAbierto.setContentAreaFilled(false);
        btnOjoAbierto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoAbiertoMouseClicked(evt);
            }
        });
        jPanel1.add(btnOjoAbierto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        btnOjoCerrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/ojo_cerrado.png"))); // NOI18N
        btnOjoCerrado.setBorderPainted(false);
        btnOjoCerrado.setContentAreaFilled(false);
        btnOjoCerrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOjoCerradoMouseClicked(evt);
            }
        });
        jPanel1.add(btnOjoCerrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setText("Ingrese tu nueva contraseña:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 114, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setText("Vuelva a ingresar la contraseña:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 245, -1, -1));

        lblContra1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblContra1.setForeground(new java.awt.Color(222, 221, 221));
        lblContra1.setText("Nueva contraseña");
        jPanel1.add(lblContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 281, 260, 40));

        lblContra2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        lblContra2.setForeground(new java.awt.Color(222, 221, 221));
        lblContra2.setText("Nueva contraseña");
        jPanel1.add(lblContra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 151, 270, 50));

        Pass2.setBorder(null);
        Pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Pass2FocusGained(evt);
            }
        });
        Pass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pass2MouseClicked(evt);
            }
        });
        jPanel1.add(Pass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 280, 40));

        Pass1.setBorder(null);
        Pass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Pass1MouseClicked(evt);
            }
        });
        jPanel1.add(Pass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 280, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Cerrar el programa
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    //Evento para regresar al Login al darle Cancelar
    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        Login regresar = new Login();
        regresar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    //Eventos para poder mover el frame
    int xx, yy;
    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - yy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx = evt.getX();
        yy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    //Validacion de la contraseña
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        char password[] = Pass1.getPassword();
        char password2[] = Pass2.getPassword();
        int cont = 0, mayus = 0;
        int cont1 = 0, mayus1 = 0;

        if (Pass1.getText().equals("") || Pass2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los dos campos contraseña deben de ser rellenados.\nIntentalo de nuevo.", "ERROR", JOptionPane.PLAIN_MESSAGE,icono("/imagesLogin/lg2.png",40,40));
        } else {
            for (int i = 0; i < password.length; i++) {
                cont++;
                if (password[i] >= 65 && password[i] <= 90) {
                    mayus++;
                }
            }

            for (int i = 0; i < password2.length; i++) {
                cont1++;
                if (password2[i] >= 65 && password2[i] <= 90) {
                    mayus1++;
                }
            }

            if (cont < 8 || mayus < 1 || cont1 < 8 || mayus1 < 1) {
                JOptionPane.showMessageDialog(null, "La contraseña debe de tener 8 caracteres y 1 letra mayúscula como mínimo.\nIntentalo de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (Pass1.getText().equals(Pass2.getText())) {
                    JOptionPane.showMessageDialog(null, "La nueva contraseña se ha restablecido con exito!", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
                    Login guardar = new Login();
                    guardar.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, inténtelo de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    // Configuracion de la imagen del ojo
    private void btnOjoAbierto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoAbierto1MouseClicked
        btnOjoAbierto1.setEnabled(false);
        btnOjoCerrado1.setEnabled(true);
        btnOjoCerrado1.setVisible(true);
        btnOjoAbierto1.setVisible(false);

        Pass2.setEchoChar(('•'));
    }//GEN-LAST:event_btnOjoAbierto1MouseClicked

    private void btnOjoCerrado1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoCerrado1MouseClicked
        btnOjoAbierto1.setEnabled(true);
        btnOjoCerrado1.setEnabled(false);
        btnOjoAbierto1.setVisible(true);
        btnOjoCerrado1.setVisible(false);

        Pass2.setEchoChar((char) 0);

    }//GEN-LAST:event_btnOjoCerrado1MouseClicked

    private void btnOjoAbiertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoAbiertoMouseClicked
        btnOjoAbierto.setEnabled(false);
        btnOjoCerrado.setEnabled(true);
        btnOjoCerrado.setVisible(true);
        btnOjoAbierto.setVisible(false);

        Pass1.setEchoChar(('•'));
    }//GEN-LAST:event_btnOjoAbiertoMouseClicked

    private void btnOjoCerradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOjoCerradoMouseClicked
        btnOjoAbierto.setEnabled(true);
        btnOjoCerrado.setEnabled(false);
        btnOjoAbierto.setVisible(true);
        btnOjoCerrado.setVisible(false);

        Pass1.setEchoChar((char) 0);
    }//GEN-LAST:event_btnOjoCerradoMouseClicked

    //Eventos para que se borre el texto del label cuando se escriba la contraseña
    private void Pass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pass2MouseClicked
        lblContra2.setVisible(false);
        if (Pass1.getText().equals("")) {
            lblContra1.setText("Nueva contraseña");
            lblContra1.setVisible(true);
        }
    }//GEN-LAST:event_Pass2MouseClicked

    private void Pass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Pass1MouseClicked
        lblContra1.setVisible(false);
        if (Pass2.getText().equals("")) {
            lblContra2.setText("Nueva contraseña");
            lblContra2.setVisible(true);
        }
    }//GEN-LAST:event_Pass1MouseClicked

    private void Pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Pass2FocusGained
        if (Pass1.getText().equals("")) {
            lblContra1.setText("Nueva contraseña");
            lblContra1.setVisible(true);
        }
    }//GEN-LAST:event_Pass2FocusGained

    public Icon icono(String path, int width, int height){
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
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
            java.util.logging.Logger.getLogger(Contraseña3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contraseña3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contraseña3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contraseña3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contraseña3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnOjoAbierto;
    private javax.swing.JButton btnOjoAbierto1;
    private javax.swing.JButton btnOjoCerrado;
    private javax.swing.JButton btnOjoCerrado1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblContra1;
    private javax.swing.JLabel lblContra2;
    // End of variables declaration//GEN-END:variables
}
