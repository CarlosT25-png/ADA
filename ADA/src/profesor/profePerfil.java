/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import alumno.PnlAjustes;
import java.awt.CardLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import login.Login;
import utilities.ScaleImage;

/**
 *
 * @author Usuario
 */
public class profePerfil extends javax.swing.JFrame {

    PnlPerfilProf pnlperfil = new PnlPerfilProf();
    PnlNotas pnlnotas = new PnlNotas();
    PnlHorario pnlhorario = new PnlHorario();
    PnlAjustes pnlajustes = new PnlAjustes();
    
    CardLayout vista;
    
    public profePerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        iconoFormulario();
        vista = (CardLayout) VistaPrincipal.getLayout();
        btnPerfil.setVisible(false);
        btnHorarioNeg.setVisible(false);
        btnNotasNeg.setVisible(false);
        btnAjustesNeg.setVisible(false);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlperfil, "Perfil Profesor");
        vista.show(VistaPrincipal, "Perfil Profesor");
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagesLogin/logoLoginXL.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        marcoAvatar = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        btnPerfilNeg = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnHorario = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnNotasNeg = new javax.swing.JButton();
        btnHorarioNeg = new javax.swing.JButton();
        btnAjustesNeg = new javax.swing.JButton();
        btnSalirNeg = new javax.swing.JButton();
        VistaPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/cerrar.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 6, -1, -1));

        jLabel1.setBackground(new java.awt.Color(248, 90, 27));
        jLabel1.setOpaque(true);
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        jPanel1.setBackground(new java.awt.Color(243, 242, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(154, 555));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        marcoAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/avatarMarco.png"))); // NOI18N
        jPanel1.add(marcoAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        avatar.setMaximumSize(new java.awt.Dimension(102, 102));
        avatar.setMinimumSize(new java.awt.Dimension(102, 102));
        avatar.setPreferredSize(new java.awt.Dimension(102, 102));
        jPanel1.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btnPerfilNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-perfil.png"))); // NOI18N
        btnPerfilNeg.setBorder(null);
        btnPerfilNeg.setBorderPainted(false);
        btnPerfilNeg.setContentAreaFilled(false);
        btnPerfilNeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilNegMouseClicked(evt);
            }
        });
        jPanel1.add(btnPerfilNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, -1, -1));

        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/notas.png"))); // NOI18N
        btnNotas.setBorder(null);
        btnNotas.setBorderPainted(false);
        btnNotas.setContentAreaFilled(false);
        btnNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotasMouseExited(evt);
            }
        });
        jPanel1.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/horario.png"))); // NOI18N
        btnHorario.setBorder(null);
        btnHorario.setBorderPainted(false);
        btnHorario.setContentAreaFilled(false);
        btnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHorarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHorarioMouseExited(evt);
            }
        });
        jPanel1.add(btnHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 220, -1, -1));

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/ajustes.png"))); // NOI18N
        btnAjustes.setBorder(null);
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAjustesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAjustesMouseExited(evt);
            }
        });
        jPanel1.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/salir.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 520, -1, -1));

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/perfil.png"))); // NOI18N
        btnPerfil.setBorder(null);
        btnPerfil.setBorderPainted(false);
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerfilMouseExited(evt);
            }
        });
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, -1, -1));

        btnNotasNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png"))); // NOI18N
        btnNotasNeg.setBorder(null);
        btnNotasNeg.setBorderPainted(false);
        btnNotasNeg.setContentAreaFilled(false);
        btnNotasNeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotasNegMouseClicked(evt);
            }
        });
        jPanel1.add(btnNotasNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnHorarioNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png"))); // NOI18N
        btnHorarioNeg.setBorder(null);
        btnHorarioNeg.setBorderPainted(false);
        btnHorarioNeg.setContentAreaFilled(false);
        btnHorarioNeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHorarioNegMouseClicked(evt);
            }
        });
        jPanel1.add(btnHorarioNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 220, -1, -1));

        btnAjustesNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"))); // NOI18N
        btnAjustesNeg.setBorder(null);
        btnAjustesNeg.setBorderPainted(false);
        btnAjustesNeg.setContentAreaFilled(false);
        btnAjustesNeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjustesNegMouseClicked(evt);
            }
        });
        jPanel1.add(btnAjustesNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        btnSalirNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png"))); // NOI18N
        btnSalirNeg.setBorder(null);
        btnSalirNeg.setBorderPainted(false);
        btnSalirNeg.setContentAreaFilled(false);
        btnSalirNeg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirNegMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalirNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 520, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 560));

        VistaPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        VistaPrincipal.setLayout(new java.awt.CardLayout());
        jPanel2.add(VistaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 680, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed
    
        int xx,xy;
    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void btnPerfilNegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilNegMouseClicked
        btnPerfilNeg.setVisible(true);
        btnPerfil.setVisible(false);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlperfil, "Perfil Profesor");
        vista.show(VistaPrincipal, "Perfil Profesor");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnPerfilNegMouseClicked

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        btnPerfil.setVisible(false);
        btnPerfilNeg.setVisible(true);
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        btnPerfil.setVisible(false);
        btnPerfilNeg.setVisible(true);
    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnHorarioNegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioNegMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnHorario.setVisible(false);
        btnHorarioNeg.setVisible(true);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlhorario,"Horario Profesor");
        vista.show(VistaPrincipal, "Horario Profesor");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnHorarioNegMouseClicked

    private void btnHorarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseEntered
        btnHorario.setVisible(false);
        btnHorarioNeg.setVisible(true);
    }//GEN-LAST:event_btnHorarioMouseEntered

    private void btnHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseExited
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
    }//GEN-LAST:event_btnHorarioMouseExited

    private void btnNotasNegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasNegMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnNotas.setVisible(false);
        btnNotasNeg.setVisible(true);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlnotas,"Notas Profesor");
        vista.show(VistaPrincipal,"Notas Profesor");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnNotasNegMouseClicked

    private void btnNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseEntered
        btnNotasNeg.setVisible(true);
        btnNotas.setVisible(false);
    }//GEN-LAST:event_btnNotasMouseEntered

    private void btnNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseExited
        btnNotasNeg.setVisible(false);
        btnNotas.setVisible(true);
    }//GEN-LAST:event_btnNotasMouseExited

    private void btnAjustesNegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesNegMouseClicked
        btnAjustesNeg.setVisible(true);
        btnAjustes.setVisible(false);
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlajustes,"Ajustes Profesor");
        vista.show(VistaPrincipal, "Ajustes Profesor");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnAjustesNegMouseClicked

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        btnAjustesNeg.setVisible(true);
        btnAjustes.setVisible(false);
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        btnAjustesNeg.setVisible(false);
        btnAjustes.setVisible(true);
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnSalirNegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirNegMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirNegMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalirNeg.setVisible(true);
        btnSalir.setVisible(false);
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalirNeg.setVisible(false);
        btnSalir.setVisible(true);
    }//GEN-LAST:event_btnSalirMouseExited

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
            java.util.logging.Logger.getLogger(profePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profePerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel VistaPrincipal;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAjustesNeg;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnHorarioNeg;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnNotasNeg;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnPerfilNeg;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirNeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
