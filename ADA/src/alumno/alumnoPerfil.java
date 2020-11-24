package alumno;

import java.awt.Component;
import java.net.URL;
import javax.swing.Icon;
import utilities.*;
import javax.swing.ImageIcon;
import login.Contraseña3;
import login.Login;

public final class alumnoPerfil extends javax.swing.JFrame {

    public alumnoPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        iconoFormulario();
        ParentPanel.removeAll();
        ParentPanel.add(PnlPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();

    }

    //Establecer el iconono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagesLogin/logoLoginXL.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage());
    }
    
    public void panelSelected(){
        Component panelActual = ParentPanel.getComponent(0);
        if(panelActual==PnlPerfil){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-perfil.png"));
            btnPerfil.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlMatricula){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-matricula.png"));
            btnMatricula.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlHorario){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png"));
            btnHorario.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlGestion){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-gestion.png"));
            btnGestion.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlNotas){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png"));
            btnNotas.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlAjustes){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
        }
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
        btnPerfil = new javax.swing.JButton();
        btnMatricula = new javax.swing.JButton();
        btnGestion = new javax.swing.JButton();
        btnNotas = new javax.swing.JButton();
        btnHorario = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        PnlPerfil = new javax.swing.JPanel();
        PnlPerfilAlumno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        PnlMatricula = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PnlGestion = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        PnlNotas = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        PnlHorario = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        PnlAjustes = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnEditar1 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

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

        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/perfil.png"))); // NOI18N
        btnPerfil.setBorder(null);
        btnPerfil.setBorderPainted(false);
        btnPerfil.setContentAreaFilled(false);
        btnPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPerfilMouseExited(evt);
            }
        });
        jPanel1.add(btnPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 160, -1, -1));

        btnMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/matricula.png"))); // NOI18N
        btnMatricula.setBorder(null);
        btnMatricula.setBorderPainted(false);
        btnMatricula.setContentAreaFilled(false);
        btnMatricula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMatriculaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMatriculaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMatriculaMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGestionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGestionMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNotasMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHorarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHorarioMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAjustesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAjustesMouseExited(evt);
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 520, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 560));

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        PnlPerfilAlumno.setBackground(new java.awt.Color(255, 255, 255));
        PnlPerfilAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Información Personal");
        PnlPerfilAlumno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setText("Nombre:");
        PnlPerfilAlumno.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        PnlPerfilAlumno.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setText("Apellidos: ");
        PnlPerfilAlumno.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        PnlPerfilAlumno.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));
        PnlPerfilAlumno.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setText("Fecha de nacimiento: ");
        PnlPerfilAlumno.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel8.setText("Email:");
        PnlPerfilAlumno.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setText("Cédula:");
        PnlPerfilAlumno.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        PnlPerfilAlumno.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setText("CIF:");
        PnlPerfilAlumno.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        PnlPerfilAlumno.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel9.setText("Dirección:");
        PnlPerfilAlumno.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        PnlPerfilAlumno.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 160, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfilAlumno.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlPerfilLayout = new javax.swing.GroupLayout(PnlPerfil);
        PnlPerfil.setLayout(PnlPerfilLayout);
        PnlPerfilLayout.setHorizontalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlPerfilLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnlPerfilAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PnlPerfilLayout.setVerticalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlPerfilLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnlPerfilAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ParentPanel.add(PnlPerfil, "card3");

        PnlMatricula.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("MATRICULA");

        javax.swing.GroupLayout PnlMatriculaLayout = new javax.swing.GroupLayout(PnlMatricula);
        PnlMatricula.setLayout(PnlMatriculaLayout);
        PnlMatriculaLayout.setHorizontalGroup(
            PnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMatriculaLayout.createSequentialGroup()
                .addGap(246, 246, 246)
                .addComponent(jLabel11)
                .addContainerGap(366, Short.MAX_VALUE))
        );
        PnlMatriculaLayout.setVerticalGroup(
            PnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlMatriculaLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel11)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        ParentPanel.add(PnlMatricula, "card3");

        jLabel12.setText("GESTION");

        javax.swing.GroupLayout PnlGestionLayout = new javax.swing.GroupLayout(PnlGestion);
        PnlGestion.setLayout(PnlGestionLayout);
        PnlGestionLayout.setHorizontalGroup(
            PnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGestionLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel12)
                .addContainerGap(478, Short.MAX_VALUE))
        );
        PnlGestionLayout.setVerticalGroup(
            PnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGestionLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jLabel12)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        ParentPanel.add(PnlGestion, "card4");

        jLabel13.setText("NOTAS");

        javax.swing.GroupLayout PnlNotasLayout = new javax.swing.GroupLayout(PnlNotas);
        PnlNotas.setLayout(PnlNotasLayout);
        PnlNotasLayout.setHorizontalGroup(
            PnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNotasLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel13)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        PnlNotasLayout.setVerticalGroup(
            PnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlNotasLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel13)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        ParentPanel.add(PnlNotas, "card5");

        jLabel14.setText("Horario");

        javax.swing.GroupLayout PnlHorarioLayout = new javax.swing.GroupLayout(PnlHorario);
        PnlHorario.setLayout(PnlHorarioLayout);
        PnlHorarioLayout.setHorizontalGroup(
            PnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHorarioLayout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel14)
                .addContainerGap(405, Short.MAX_VALUE))
        );
        PnlHorarioLayout.setVerticalGroup(
            PnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlHorarioLayout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jLabel14)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        ParentPanel.add(PnlHorario, "card6");

        PnlAjustes.setBackground(new java.awt.Color(255, 255, 255));
        PnlAjustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/llave.png"))); // NOI18N
        PnlAjustes.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel16.setText("Ajustes");
        PnlAjustes.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel17.setText("Cambio de contraseña");
        PnlAjustes.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel18.setText("Se recomienda usar una contraseña segura que no uses para ningún otro sitio");
        PnlAjustes.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 145, 380, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlAjustes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        btnEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/editar.png"))); // NOI18N
        btnEditar1.setBorder(null);
        btnEditar1.setBorderPainted(false);
        btnEditar1.setContentAreaFilled(false);
        btnEditar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditar1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditar1MouseExited(evt);
            }
        });
        PnlAjustes.add(btnEditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        btnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/editar.png"))); // NOI18N
        btnEditar2.setBorder(null);
        btnEditar2.setBorderPainted(false);
        btnEditar2.setContentAreaFilled(false);
        btnEditar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditar2MouseExited(evt);
            }
        });
        PnlAjustes.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/CuadroAjustes.png"))); // NOI18N
        PnlAjustes.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 420, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel21.setText("Cambio de la foto de perfil");
        PnlAjustes.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/ayuda.png"))); // NOI18N
        PnlAjustes.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/camara.png"))); // NOI18N
        PnlAjustes.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(106, 151, 197));
        jLabel24.setText("academicdesktopapplication@gmail.com");
        PnlAjustes.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 450, 200, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/CuadroAjustes.png"))); // NOI18N
        PnlAjustes.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 420, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel26.setText("Ayuda y asistencia");
        PnlAjustes.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel27.setText("Envia tus dudas o sugerencias a: ");
        PnlAjustes.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, 20));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/CuadroAjustes.png"))); // NOI18N
        PnlAjustes.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 420, -1));

        ParentPanel.add(PnlAjustes, "card8");

        jPanel2.add(ParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 680, 560));

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

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnEditar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseEntered
        btnEditar1.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar1MouseEntered

    private void btnEditar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseExited
        btnEditar1.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
    }//GEN-LAST:event_btnEditar1MouseExited

    private void btnEditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseEntered
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar2MouseEntered

    private void btnEditar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseExited
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
    }//GEN-LAST:event_btnEditar2MouseExited

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnMatriculaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlMatricula);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnMatriculaMouseClicked

    private void btnGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlGestion);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnGestionMouseClicked

    private void btnNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlNotas);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnNotasMouseClicked

    private void btnHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlHorario);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnHorarioMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAjustes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-perfil.png")));
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnMatriculaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseEntered
        btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-matricula.png")));
    }//GEN-LAST:event_btnMatriculaMouseEntered

    private void btnMatriculaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseExited
        btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
    }//GEN-LAST:event_btnMatriculaMouseExited

    private void btnGestionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseEntered
        btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-gestion.png")));
    }//GEN-LAST:event_btnGestionMouseEntered

    private void btnGestionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseExited
        btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
    }//GEN-LAST:event_btnGestionMouseExited

    private void btnNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseEntered
        btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png")));
    }//GEN-LAST:event_btnNotasMouseEntered

    private void btnNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseExited
        btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
    }//GEN-LAST:event_btnNotasMouseExited

    private void btnHorarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseEntered
        btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png")));
    }//GEN-LAST:event_btnHorarioMouseEntered

    private void btnHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseExited
        btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
    }//GEN-LAST:event_btnHorarioMouseExited

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png")));
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png")));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/salir.png")));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnEditar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseClicked
        Contraseña3 contra = new Contraseña3();
        contra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditar1MouseClicked

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
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel PnlAjustes;
    private javax.swing.JPanel PnlGestion;
    private javax.swing.JPanel PnlHorario;
    private javax.swing.JPanel PnlMatricula;
    private javax.swing.JPanel PnlNotas;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlPerfilAlumno;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
