package alumno;

import java.awt.Component;
import java.net.URL;
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

    public void panelSelected() {
        Component panelActual = ParentPanel.getComponent(0);
        if (panelActual == PnlPerfil) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-perfil.png"));
            btnPerfil.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlMatricula) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-matricula.png"));
            btnMatricula.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlHorario) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png"));
            btnHorario.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlGestion) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-gestion.png"));
            btnGestion.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlNotas) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png"));
            btnNotas.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
            btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
            btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlAjustes) {
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
    
    public void gestion(){
        Component panelActual = ParentPanel.getComponent(0);
        if(panelActual == PnlGestion){
            btnRetiroAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-retiro.png")));
            btnCambioAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/cambio.png")));
        }else if(panelActual == PnlGestionCambio){
            btnRetiroAsignatura2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/retiro.png")));
            btnCambioAsignatura2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-cambio.png")));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jCheckBox4 = new javax.swing.JCheckBox();
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
        PnlPerfilAlumno1 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel50 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();
        PnlMatricula = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        PnlGestion = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        btnRetiroAsignatura = new javax.swing.JButton();
        btnCambioAsignatura = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel67 = new javax.swing.JLabel();
        PnlGestionCambio = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        btnRetiroAsignatura2 = new javax.swing.JButton();
        btnCambioAsignatura2 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jLabel69 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel70 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel71 = new javax.swing.JLabel();
        PnlNotas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        PnlHorario = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("Gestión");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 44, -1, -1));

        jCheckBox4.setContentAreaFilled(false);

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

        PnlPerfilAlumno1.setBackground(new java.awt.Color(255, 255, 255));
        PnlPerfilAlumno1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel32.setText("Información Personal");
        PnlPerfilAlumno1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel33.setText("Nombre:");
        PnlPerfilAlumno1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        PnlPerfilAlumno1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel34.setText("Apellidos: ");
        PnlPerfilAlumno1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        PnlPerfilAlumno1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));
        PnlPerfilAlumno1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 200, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel35.setText("Fecha de nacimiento: ");
        PnlPerfilAlumno1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel42.setText("Email:");
        PnlPerfilAlumno1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel48.setText("Cédula:");
        PnlPerfilAlumno1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        PnlPerfilAlumno1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel49.setText("CIF:");
        PnlPerfilAlumno1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        PnlPerfilAlumno1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel50.setText("Dirección:");
        PnlPerfilAlumno1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        PnlPerfilAlumno1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 160, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfilAlumno1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlPerfilLayout = new javax.swing.GroupLayout(PnlPerfil);
        PnlPerfil.setLayout(PnlPerfilLayout);
        PnlPerfilLayout.setHorizontalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlPerfilLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnlPerfilAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PnlPerfilLayout.setVerticalGroup(
            PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(PnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlPerfilLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PnlPerfilAlumno1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ParentPanel.add(PnlPerfil, "card9");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setText("Carrera:");
        jPanel16.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 87, -1, -1));

        jComboBox11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox11.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel16.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel62.setText("Matricula");
        jPanel16.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel63.setText("Mostrar clases del:");
        jPanel16.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 87, -1, -1));

        jComboBox12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox12.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel16.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 150, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel64.setText("Inscribir para:");
        jPanel16.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 87, -1, -1));

        jComboBox13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox13.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel16.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 150, -1));

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));

        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setText("AV101 - Análisis Vectorial");
        jButton16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton16.setContentAreaFilled(false);

        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setText("BD102 - Base De Datos");
        jButton17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton17.setContentAreaFilled(false);

        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setText("EN302 - Inglés Comunicativo");
        jButton18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18.setContentAreaFilled(false);

        jButton19.setBackground(new java.awt.Color(255, 255, 255));
        jButton19.setText("ES104 - Estadística II");
        jButton19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton19.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 280, 360));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel16.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlMatriculaLayout = new javax.swing.GroupLayout(PnlMatricula);
        PnlMatricula.setLayout(PnlMatriculaLayout);
        PnlMatriculaLayout.setHorizontalGroup(
            PnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlMatriculaLayout.setVerticalGroup(
            PnlMatriculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ParentPanel.add(PnlMatricula, "card10");

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel66.setText("Gestión");
        jPanel18.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnRetiroAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/retiro.png"))); // NOI18N
        btnRetiroAsignatura.setBorder(null);
        btnRetiroAsignatura.setBorderPainted(false);
        btnRetiroAsignatura.setContentAreaFilled(false);
        jPanel18.add(btnRetiroAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnCambioAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/cambio.png"))); // NOI18N
        btnCambioAsignatura.setBorder(null);
        btnCambioAsignatura.setBorderPainted(false);
        btnCambioAsignatura.setContentAreaFilled(false);
        btnCambioAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambioAsignaturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambioAsignaturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambioAsignaturaMouseExited(evt);
            }
        });
        jPanel18.add(btnCambioAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/btnGuardarCambios.png"))); // NOI18N
        jButton20.setBorder(null);
        jButton20.setBorderPainted(false);
        jButton20.setContentAreaFilled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        jPanel19.setBackground(new java.awt.Color(204, 204, 204));

        jButton21.setBackground(new java.awt.Color(255, 255, 255));
        jButton21.setText("AV101 - Análisis Vectorial");
        jButton21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton21.setContentAreaFilled(false);

        jButton22.setBackground(new java.awt.Color(255, 255, 255));
        jButton22.setText("BD102 - Base De Datos");
        jButton22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton22.setContentAreaFilled(false);

        jButton28.setBackground(new java.awt.Color(255, 255, 255));
        jButton28.setText("EN302 - Inglés Comunicativo");
        jButton28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton28.setContentAreaFilled(false);

        jButton29.setBackground(new java.awt.Color(255, 255, 255));
        jButton29.setText("ES104 - Estadística II");
        jButton29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton29.setContentAreaFilled(false);

        jCheckBox6.setContentAreaFilled(false);

        jCheckBox7.setContentAreaFilled(false);

        jCheckBox8.setContentAreaFilled(false);

        jCheckBox9.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 310, 360));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel18.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlGestionLayout = new javax.swing.GroupLayout(PnlGestion);
        PnlGestion.setLayout(PnlGestionLayout);
        PnlGestionLayout.setHorizontalGroup(
            PnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlGestionLayout.setVerticalGroup(
            PnlGestionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ParentPanel.add(PnlGestion, "card11");

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel68.setText("Gestión");
        jPanel21.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnRetiroAsignatura2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/retiro.png"))); // NOI18N
        btnRetiroAsignatura2.setBorder(null);
        btnRetiroAsignatura2.setBorderPainted(false);
        btnRetiroAsignatura2.setContentAreaFilled(false);
        btnRetiroAsignatura2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiroAsignatura2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiroAsignatura2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiroAsignatura2MouseExited(evt);
            }
        });
        jPanel21.add(btnRetiroAsignatura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnCambioAsignatura2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/cambio.png"))); // NOI18N
        btnCambioAsignatura2.setBorder(null);
        btnCambioAsignatura2.setBorderPainted(false);
        btnCambioAsignatura2.setContentAreaFilled(false);
        jPanel21.add(btnCambioAsignatura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/btnGuardarCambios.png"))); // NOI18N
        jButton30.setBorder(null);
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jPanel21.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        jPanel22.setBackground(new java.awt.Color(204, 204, 204));

        jButton31.setBackground(new java.awt.Color(255, 255, 255));
        jButton31.setText("AV101 - Análisis Vectorial");
        jButton31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton31.setContentAreaFilled(false);

        jButton32.setBackground(new java.awt.Color(255, 255, 255));
        jButton32.setText("BD102 - Base De Datos");
        jButton32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton32.setContentAreaFilled(false);

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setText("EN302 - Inglés Comunicativo");
        jButton33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton33.setContentAreaFilled(false);

        jButton34.setBackground(new java.awt.Color(255, 255, 255));
        jButton34.setText("ES104 - Estadística II");
        jButton34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton34.setContentAreaFilled(false);

        jCheckBox14.setContentAreaFilled(false);

        jCheckBox15.setContentAreaFilled(false);

        jCheckBox16.setContentAreaFilled(false);

        jCheckBox17.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 310, 330));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setText("Carrera:");
        jPanel21.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jComboBox14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox14.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel21.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 150, -1));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel70.setText("Mostrar clases del:");
        jPanel21.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jComboBox15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox15.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel21.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 150, -1));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel21.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlGestionCambioLayout = new javax.swing.GroupLayout(PnlGestionCambio);
        PnlGestionCambio.setLayout(PnlGestionCambioLayout);
        PnlGestionCambioLayout.setHorizontalGroup(
            PnlGestionCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlGestionCambioLayout.setVerticalGroup(
            PnlGestionCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ParentPanel.add(PnlGestionCambio, "card12");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("Notas");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Mostrar clases del:");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 87, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel4.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre Clase", "I Corte", "II Corte", "III Corte", "Nota Final"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 600, 150));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/imprimir.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlNotasLayout = new javax.swing.GroupLayout(PnlNotas);
        PnlNotas.setLayout(PnlNotasLayout);
        PnlNotasLayout.setHorizontalGroup(
            PnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlNotasLayout.setVerticalGroup(
            PnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ParentPanel.add(PnlNotas, "card4");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("Horario");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Mostrar horario del:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 87, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Grupo", "Nombre de la clase", "Horario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 590, 150));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/imprimir.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout PnlHorarioLayout = new javax.swing.GroupLayout(PnlHorario);
        PnlHorario.setLayout(PnlHorarioLayout);
        PnlHorarioLayout.setHorizontalGroup(
            PnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PnlHorarioLayout.setVerticalGroup(
            PnlHorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ParentPanel.add(PnlHorario, "card3");

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
        gestion();
        
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
        panelSelected();
    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnMatriculaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseEntered
        btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-matricula.png")));
    }//GEN-LAST:event_btnMatriculaMouseEntered

    private void btnMatriculaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMatriculaMouseExited
        btnMatricula.setIcon(new ImageIcon(getClass().getResource("/imagesEst/matricula.png")));
        panelSelected();
    }//GEN-LAST:event_btnMatriculaMouseExited

    private void btnGestionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseEntered
        btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-gestion.png")));
    }//GEN-LAST:event_btnGestionMouseEntered

    private void btnGestionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionMouseExited
        btnGestion.setIcon(new ImageIcon(getClass().getResource("/imagesEst/gestion.png")));
        panelSelected();
    }//GEN-LAST:event_btnGestionMouseExited

    private void btnNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseEntered
        btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-notas.png")));
    }//GEN-LAST:event_btnNotasMouseEntered

    private void btnNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNotasMouseExited
        btnNotas.setIcon(new ImageIcon(getClass().getResource("/imagesEst/notas.png")));
        panelSelected();
    }//GEN-LAST:event_btnNotasMouseExited

    private void btnHorarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseEntered
        btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-horario.png")));
    }//GEN-LAST:event_btnHorarioMouseEntered

    private void btnHorarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHorarioMouseExited
        btnHorario.setIcon(new ImageIcon(getClass().getResource("/imagesEst/horario.png")));
        panelSelected();
    }//GEN-LAST:event_btnHorarioMouseExited

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png")));
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png")));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/salir.png")));
        panelSelected();
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnEditar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseClicked
        Contraseña3 contra = new Contraseña3();
        contra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditar1MouseClicked

    private void btnCambioAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambioAsignaturaMouseClicked

    private void btnCambioAsignaturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambioAsignaturaMouseEntered

    private void btnCambioAsignaturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCambioAsignaturaMouseExited

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void btnRetiroAsignatura2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignatura2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroAsignatura2MouseClicked

    private void btnRetiroAsignatura2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignatura2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroAsignatura2MouseEntered

    private void btnRetiroAsignatura2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignatura2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroAsignatura2MouseExited

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
    private javax.swing.JPanel PnlGestionCambio;
    private javax.swing.JPanel PnlHorario;
    private javax.swing.JPanel PnlMatricula;
    private javax.swing.JPanel PnlNotas;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlPerfilAlumno1;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnCambioAsignatura;
    private javax.swing.JButton btnCambioAsignatura2;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnRetiroAsignatura;
    private javax.swing.JButton btnRetiroAsignatura2;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
