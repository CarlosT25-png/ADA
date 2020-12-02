package alumno;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utilities.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import login.Contraseña3;
import login.Login;

public final class alumnoPerfil extends javax.swing.JFrame {

    public alumnoPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        ScaleImage.setScaleImage(avatar1, imagen);
        panelSelected();
        iconoFormulario();
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
        }else if (panelActual == PnlCambioFotoPerfil) {
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
        Component panelActual = ParentPanelGestion.getComponent(0);
        if(panelActual == PnlGestionRetiro){
            btnRetiroAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-retiro.png")));
            btnCambioAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/cambio.png")));
        }else if(panelActual == PnlGestionCambio){
            btnRetiroAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/retiro.png")));
            btnCambioAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-cambio.png")));
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
        jLabel52 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
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
        jPanel6 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        btnRetiroAsignatura = new javax.swing.JButton();
        btnCambioAsignatura = new javax.swing.JButton();
        ParentPanelGestion = new javax.swing.JPanel();
        PnlGestionRetiro = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel73 = new javax.swing.JLabel();
        PnlGestionCambio = new javax.swing.JPanel();
        jButton37 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel74 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel76 = new javax.swing.JLabel();
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
        PnlCambioFotoPerfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        avatar1 = new javax.swing.JLabel();
        btnGuardarFoto = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        btnSubirFoto = new javax.swing.JButton();

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
        jLabel49.setText("Carrera:");
        PnlPerfilAlumno1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));
        PnlPerfilAlumno1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel50.setText("Dirección:");
        PnlPerfilAlumno1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        PnlPerfilAlumno1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 160, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfilAlumno1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel52.setText("CIF:");
        PnlPerfilAlumno1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        PnlPerfilAlumno1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 170, 10));

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

        PnlGestion.setBackground(new java.awt.Color(255, 255, 255));
        PnlGestion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel72.setText("Gestión");
        jPanel6.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnRetiroAsignatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/retiro.png"))); // NOI18N
        btnRetiroAsignatura.setBorder(null);
        btnRetiroAsignatura.setBorderPainted(false);
        btnRetiroAsignatura.setContentAreaFilled(false);
        btnRetiroAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiroAsignaturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiroAsignaturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiroAsignaturaMouseExited(evt);
            }
        });
        jPanel6.add(btnRetiroAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

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
        jPanel6.add(btnCambioAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        PnlGestion.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 140));

        ParentPanelGestion.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelGestion.setLayout(new java.awt.CardLayout());

        PnlGestionRetiro.setBackground(new java.awt.Color(255, 255, 255));
        PnlGestionRetiro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/btnGuardarCambios.png"))); // NOI18N
        jButton23.setBorder(null);
        jButton23.setBorderPainted(false);
        jButton23.setContentAreaFilled(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        PnlGestionRetiro.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setText("AV101 - Análisis Vectorial");
        jButton24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton24.setContentAreaFilled(false);

        jButton25.setBackground(new java.awt.Color(255, 255, 255));
        jButton25.setText("BD102 - Base De Datos");
        jButton25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton25.setContentAreaFilled(false);

        jButton35.setBackground(new java.awt.Color(255, 255, 255));
        jButton35.setText("EN302 - Inglés Comunicativo");
        jButton35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton35.setContentAreaFilled(false);

        jButton36.setBackground(new java.awt.Color(255, 255, 255));
        jButton36.setText("ES104 - Estadística II");
        jButton36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton36.setContentAreaFilled(false);

        jCheckBox10.setContentAreaFilled(false);

        jCheckBox11.setContentAreaFilled(false);

        jCheckBox12.setContentAreaFilled(false);

        jCheckBox13.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        PnlGestionRetiro.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 310, 360));

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlGestionRetiro.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        ParentPanelGestion.add(PnlGestionRetiro, "card2");

        PnlGestionCambio.setBackground(new java.awt.Color(255, 255, 255));
        PnlGestionCambio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesProf/btnGuardarCambios.png"))); // NOI18N
        jButton37.setBorder(null);
        jButton37.setBorderPainted(false);
        jButton37.setContentAreaFilled(false);
        PnlGestionCambio.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));

        jButton38.setBackground(new java.awt.Color(255, 255, 255));
        jButton38.setText("AV101 - Análisis Vectorial");
        jButton38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton38.setContentAreaFilled(false);

        jButton39.setBackground(new java.awt.Color(255, 255, 255));
        jButton39.setText("BD102 - Base De Datos");
        jButton39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton39.setContentAreaFilled(false);

        jButton40.setBackground(new java.awt.Color(255, 255, 255));
        jButton40.setText("EN302 - Inglés Comunicativo");
        jButton40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton40.setContentAreaFilled(false);

        jButton41.setBackground(new java.awt.Color(255, 255, 255));
        jButton41.setText("ES104 - Estadística II");
        jButton41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton41.setContentAreaFilled(false);

        jCheckBox18.setContentAreaFilled(false);

        jCheckBox19.setContentAreaFilled(false);

        jCheckBox20.setContentAreaFilled(false);

        jCheckBox21.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox19, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox20, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox21, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        PnlGestionCambio.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 310, 330));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setText("Carrera:");
        PnlGestionCambio.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, -1));

        jComboBox16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox16.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        PnlGestionCambio.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setText("Mostrar clases del:");
        PnlGestionCambio.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, -1, -1));

        jComboBox17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I Semestre", "II Semestre", "III Semestre" }));
        jComboBox17.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        PnlGestionCambio.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 150, -1));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlGestionCambio.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        ParentPanelGestion.add(PnlGestionCambio, "card3");

        PnlGestion.add(ParentPanelGestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 680, 420));

        ParentPanel.add(PnlGestion, "card10");

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditar2MouseClicked(evt);
            }
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

        PnlCambioFotoPerfil.setBackground(new java.awt.Color(255, 255, 255));
        PnlCambioFotoPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Cambiar Foto de Perfil");
        PnlCambioFotoPerfil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        avatar1.setMaximumSize(new java.awt.Dimension(102, 102));
        avatar1.setMinimumSize(new java.awt.Dimension(102, 102));
        avatar1.setPreferredSize(new java.awt.Dimension(102, 102));
        PnlCambioFotoPerfil.add(avatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 220, 220));

        btnGuardarFoto.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardarFoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnGuardarFoto.setBorder(null);
        btnGuardarFoto.setBorderPainted(false);
        btnGuardarFoto.setContentAreaFilled(false);
        btnGuardarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarFotoMouseClicked(evt);
            }
        });
        PnlCambioFotoPerfil.add(btnGuardarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 140, 50));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCambioFotoPerfil.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        btnSubirFoto.setBackground(new java.awt.Color(255, 255, 255));
        btnSubirFoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSubirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/subirfoto.png"))); // NOI18N
        btnSubirFoto.setBorder(null);
        btnSubirFoto.setBorderPainted(false);
        btnSubirFoto.setContentAreaFilled(false);
        btnSubirFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubirFotoMouseClicked(evt);
            }
        });
        PnlCambioFotoPerfil.add(btnSubirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 110, 50));

        ParentPanel.add(PnlCambioFotoPerfil, "card9");

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
        panelSelected();
    }//GEN-LAST:event_btnEditar1MouseExited

    private void btnEditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseEntered
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar2MouseEntered

    private void btnEditar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseExited
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
        panelSelected();
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

    private void btnEditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlCambioFotoPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseClicked

    private void btnCambioAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseClicked
        ParentPanelGestion.removeAll();
        ParentPanelGestion.add(PnlGestionCambio);
        ParentPanelGestion.revalidate();
        ParentPanelGestion.repaint();
        gestion();
    }//GEN-LAST:event_btnCambioAsignaturaMouseClicked

    private void btnCambioAsignaturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseEntered
       btnCambioAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-cambio.png")));
    }//GEN-LAST:event_btnCambioAsignaturaMouseEntered

    private void btnCambioAsignaturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioAsignaturaMouseExited
        btnCambioAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/cambio.png")));
        gestion();
    }//GEN-LAST:event_btnCambioAsignaturaMouseExited

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void btnRetiroAsignaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignaturaMouseClicked
        ParentPanelGestion.removeAll();
        ParentPanelGestion.add(PnlGestionRetiro);
        ParentPanelGestion.revalidate();
        ParentPanelGestion.repaint();
        gestion();
    }//GEN-LAST:event_btnRetiroAsignaturaMouseClicked

    private void btnRetiroAsignaturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignaturaMouseEntered
        btnRetiroAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-retiro.png")));
    }//GEN-LAST:event_btnRetiroAsignaturaMouseEntered

    private void btnRetiroAsignaturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroAsignaturaMouseExited
        btnRetiroAsignatura.setIcon(new ImageIcon(getClass().getResource("/imagesEst/retiro.png")));
        gestion();
    }//GEN-LAST:event_btnRetiroAsignaturaMouseExited
    
    private BufferedImage bi;
    private int contador=0;
    
    private void btnGuardarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarFotoMouseClicked
        panelSelected();
        if(contador==0){
            JOptionPane.showMessageDialog(null,"Error.\nNo ha seleccionado ninguna foto","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            File path = new File("src/imagesEst/avatarDef.png");
            avatar.setIcon(new ImageIcon(bi));
            ScaleImage.setScaleImage(avatar, new ImageIcon(bi));
            try {
                ImageIO.write(bi,"PNG",path);
            } catch (IOException ex) {
                Logger.getLogger(alumnoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_btnGuardarFotoMouseClicked

    private void btnSubirFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirFotoMouseClicked
        panelSelected();
        contador++;
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Elige la imagen");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        filechooser.setFileFilter(filter);
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION){
            File file = filechooser.getSelectedFile();
            
            try {
            bi = ImageIO.read(file);
            ScaleImage.setScaleImage(avatar1, new ImageIcon(bi));
     
            } catch(IOException e) {
              
            }
        }
    }//GEN-LAST:event_btnSubirFotoMouseClicked

    //Mover el Frame
    int xx, xy;

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(alumnoPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(alumnoPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(alumnoPerfil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(alumnoPerfil.class.getName()).log(Level.SEVERE, null, ex);
                }
                new alumnoPerfil().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel ParentPanelGestion;
    private javax.swing.JPanel PnlAjustes;
    private javax.swing.JPanel PnlCambioFotoPerfil;
    private javax.swing.JPanel PnlGestion;
    private javax.swing.JPanel PnlGestionCambio;
    private javax.swing.JPanel PnlGestionRetiro;
    private javax.swing.JPanel PnlHorario;
    private javax.swing.JPanel PnlMatricula;
    private javax.swing.JPanel PnlNotas;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlPerfilAlumno1;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel avatar1;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnCambioAsignatura;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnGestion;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnHorario;
    private javax.swing.JButton btnMatricula;
    private javax.swing.JButton btnNotas;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnRetiroAsignatura;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
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
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
