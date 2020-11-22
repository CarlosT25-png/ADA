package alumno;

import java.awt.CardLayout;
import java.net.URL;
import utilities.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import login.Login;

public class alumnoPerfil extends javax.swing.JFrame {

    PnlPerfilAlumno pnlperfil = new PnlPerfilAlumno();
    PnlMatricula pnlmatricula = new PnlMatricula();
    PnlGestion pnlgestion = new PnlGestion();
    PnlNotas pnlnotas = new PnlNotas();
    PnlHorario pnlhorario = new PnlHorario();
    PnlAjustes pnlajustes = new PnlAjustes();
    
    CardLayout vista;

    public alumnoPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        iconoFormulario();
        vista = (CardLayout) VistaPrincipal.getLayout();
        btnPerfil.setVisible(false);
        btnMatriculaNeg.setVisible(false);
        btnHorarioNeg.setVisible(false);
        btnGestionNeg.setVisible(false);
        btnNotasNeg.setVisible(false);
        btnAjustesNeg.setVisible(false);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlperfil, "Perfil Alumno");
        vista.show(VistaPrincipal, "Perfil Alumno");
        SwingUtilities.updateComponentTreeUI(this);

    }

    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagesLogin/logoLoginXL.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }

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
        btnMatricula = new javax.swing.JButton();
        btnGestion = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnHorario = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnMatriculaNeg = new javax.swing.JButton();
        btnGestionNeg = new javax.swing.JButton();
        btnNotasNeg = new javax.swing.JButton();
        btnHorarioNeg = new javax.swing.JButton();
        btnAjustesNeg = new javax.swing.JButton();
        btnSalirNeg = new javax.swing.JButton();
        VistaPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));

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
        jPanel1.add(btnPerfilNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, -1, -1));

        btnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/matricula.png"))); // NOI18N
        btnMatricula.setBorder(null);
        btnMatricula.setBorderPainted(false);
        btnMatricula.setContentAreaFilled(false);
        btnMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMatriculaMouseClicked(evt);
            }
        });
        jPanel1.add(btnMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 220, -1, -1));

        btnGestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/gestion.png"))); // NOI18N
        btnGestion.setBorder(null);
        btnGestion.setBorderPainted(false);
        btnGestion.setContentAreaFilled(false);
        btnGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionMouseClicked(evt);
            }
        });
        jPanel1.add(btnGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/notas.png"))); // NOI18N
        btnNotas.setBorder(null);
        btnNotas.setBorderPainted(false);
        btnNotas.setContentAreaFilled(false);
        btnNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNotasMouseClicked(evt);
            }
        });
        jPanel1.add(btnNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        btnHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/horario.png"))); // NOI18N
        btnHorario.setBorder(null);
        btnHorario.setBorderPainted(false);
        btnHorario.setContentAreaFilled(false);
        btnHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHorarioMouseClicked(evt);
            }
        });
        jPanel1.add(btnHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 400, -1, -1));

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/ajustes.png"))); // NOI18N
        btnAjustes.setBorder(null);
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjustesMouseClicked(evt);
            }
        });
        jPanel1.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 460, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/salir.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 520, -1, -1));

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/perfil.png"))); // NOI18N
        btnPerfil.setBorder(null);
        btnPerfil.setBorderPainted(false);
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
        });
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, -1, -1));

        btnMatriculaNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-matricula.png"))); // NOI18N
        btnMatriculaNeg.setBorder(null);
        btnMatriculaNeg.setBorderPainted(false);
        btnMatriculaNeg.setContentAreaFilled(false);
        jPanel1.add(btnMatriculaNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 220, -1, -1));

        btnGestionNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-gestion.png"))); // NOI18N
        btnGestionNeg.setBorder(null);
        btnGestionNeg.setBorderPainted(false);
        btnGestionNeg.setContentAreaFilled(false);
        jPanel1.add(btnGestionNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnNotasNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png"))); // NOI18N
        btnNotasNeg.setBorder(null);
        btnNotasNeg.setBorderPainted(false);
        btnNotasNeg.setContentAreaFilled(false);
        jPanel1.add(btnNotasNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        btnHorarioNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png"))); // NOI18N
        btnHorarioNeg.setBorder(null);
        btnHorarioNeg.setBorderPainted(false);
        btnHorarioNeg.setContentAreaFilled(false);
        jPanel1.add(btnHorarioNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 400, -1, -1));

        btnAjustesNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"))); // NOI18N
        btnAjustesNeg.setBorder(null);
        btnAjustesNeg.setBorderPainted(false);
        btnAjustesNeg.setContentAreaFilled(false);
        jPanel1.add(btnAjustesNeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 460, -1, -1));

        btnSalirNeg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png"))); // NOI18N
        btnSalirNeg.setBorder(null);
        btnSalirNeg.setBorderPainted(false);
        btnSalirNeg.setContentAreaFilled(false);
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

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnMatriculaNeg.setVisible(true);
        btnMatricula.setVisible(false);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnGestion.setVisible(true);
        btnGestionNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlmatricula, "Matricula Alumno");
        vista.show(VistaPrincipal, "Matricula Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnMatriculaMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        btnPerfilNeg.setVisible(true);
        btnPerfil.setVisible(false);
        btnMatriculaNeg.setVisible(false);
        btnMatricula.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnGestion.setVisible(true);
        btnGestionNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlperfil, "Perfil Alumno");
        vista.show(VistaPrincipal, "Perfil Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnMatriculaNeg.setVisible(false);
        btnMatricula.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnGestion.setVisible(false);
        btnGestionNeg.setVisible(true);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlgestion, "Gestion Alumno");
        vista.show(VistaPrincipal, "Gestion Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnGestionMouseClicked

    private void btnNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnMatriculaNeg.setVisible(false);
        btnMatricula.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnGestion.setVisible(true);
        btnGestionNeg.setVisible(false);
        btnNotas.setVisible(false);
        btnNotasNeg.setVisible(true);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlnotas,"Notas Alumno");
        vista.show(VistaPrincipal,"Notas Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnNotasMouseClicked

    private void btnHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnMatriculaNeg.setVisible(false);
        btnMatricula.setVisible(true);
        btnHorario.setVisible(false);
        btnHorarioNeg.setVisible(true);
        btnGestion.setVisible(true);
        btnGestionNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(true);
        btnAjustesNeg.setVisible(false);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlhorario,"Horario Alumno");
        vista.show(VistaPrincipal, "Horario Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnHorarioMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        btnPerfilNeg.setVisible(false);
        btnPerfil.setVisible(true);
        btnMatriculaNeg.setVisible(false);
        btnMatricula.setVisible(true);
        btnHorario.setVisible(true);
        btnHorarioNeg.setVisible(false);
        btnGestion.setVisible(true);
        btnGestionNeg.setVisible(false);
        btnNotas.setVisible(true);
        btnNotasNeg.setVisible(false);
        btnAjustes.setVisible(false);
        btnAjustesNeg.setVisible(true);
        btnSalir.setVisible(true);
        btnSalirNeg.setVisible(false);
        VistaPrincipal.add(pnlajustes,"Ajustes Alumno");
        vista.show(VistaPrincipal, "Ajustes Alumno");
        SwingUtilities.updateComponentTreeUI(this);
        this.repaint();
    }//GEN-LAST:event_btnAjustesMouseClicked

    //Mover el Frame
    int xx, xy;

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
            java.util.logging.Logger.getLogger(alumnoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumnoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumnoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumnoPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alumnoPerfil().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel VistaPrincipal;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAjustesNeg;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnGestionNeg;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnHorarioNeg;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnMatriculaNeg;
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
