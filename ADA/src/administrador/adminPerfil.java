
package administrador;

import java.awt.Component;
import java.net.URL;
import utilities.*;
import javax.swing.ImageIcon;
import login.Contraseña3;
import login.Login;

public final class adminPerfil extends javax.swing.JFrame {

    /**
     * Creates new form adminPerfil
     */
    public adminPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        iconoFormulario();
        panelSelected();
    }
    
    //Establecer el icono
    public void iconoFormulario() {
        URL url = getClass().getResource("/imagesLogin/logoLoginXL.png");
        ImageIcon icono_formulario = new ImageIcon(url);
        setIconImage(icono_formulario.getImage()); 
    }
    public void panelSelected(){
        Component panelActual = ParentPanel.getComponent(0);
        if(panelActual==PnlPerfil){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-perfil.png"));
            btnPerfil.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlAsignacionCrear){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-asignacion.png"));
            btnAsignacion.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource ("/imagesEst/perfil.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlEstudiantes){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-estudiantes.png"));
            btnEstudiantes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlGruposCrear){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-grupos.png"));
            btnGrupos.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlProfesor){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-profesor.png"));
            btnProfesor.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        }else if(panelActual==PnlAjustes){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
        }
    }
    
    public void asignacion(){
        Component panelActual = ParentPanel.getComponent(0);
        if(panelActual == PnlAsignacionCrear){
            btnCrear1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearAsignatura.png")));
            btnCambio1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
            btnRetiro1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));

        }else if(panelActual == PnlAsignacionCambio){
            btnCambio2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CambioAsignatura.png")));
            btnRetiro2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));
            btnCrear2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        }else if(panelActual == PnlAsignacionRetiro){
            btnCambio3.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
            btnRetiro3.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-RetiroAsignatura.png")));
            btnCrear3.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        }
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
        marcoAvatar = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JButton();
        btnAsignacion = new javax.swing.JButton();
        btnGrupos = new javax.swing.JButton();
        btnEstudiantes = new javax.swing.JButton();
        btnProfesor = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ParentPanel = new javax.swing.JPanel();
        PnlPerfil = new javax.swing.JPanel();
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
        PnlAsignacionCrear = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnCrear1 = new javax.swing.JButton();
        btnCambio1 = new javax.swing.JButton();
        btnRetiro1 = new javax.swing.JButton();
        btnCrearAsignacion = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel59 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jComboBox14 = new javax.swing.JComboBox<>();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        PnlAsignacionCambio = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnCrear2 = new javax.swing.JButton();
        btnRetiro2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        btnCambio2 = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        PnlAsignacionRetiro = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCrear3 = new javax.swing.JButton();
        btnRetiro3 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnCambio3 = new javax.swing.JButton();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jButton15 = new javax.swing.JButton();
        PnlGruposCrear = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnCrear6 = new javax.swing.JButton();
        btnCambio6 = new javax.swing.JButton();
        btnRetiro6 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel73 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel74 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        PnlEstudiantes = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        PnlProfesor = new javax.swing.JPanel();
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
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        btnAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png"))); // NOI18N
        btnAsignacion.setBorder(null);
        btnAsignacion.setBorderPainted(false);
        btnAsignacion.setContentAreaFilled(false);
        btnAsignacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAsignacionMouseExited(evt);
            }
        });
        jPanel1.add(btnAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 220, -1, -1));

        btnGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/grupos.png"))); // NOI18N
        btnGrupos.setBorder(null);
        btnGrupos.setBorderPainted(false);
        btnGrupos.setContentAreaFilled(false);
        btnGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGruposMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGruposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGruposMouseExited(evt);
            }
        });
        jPanel1.add(btnGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnEstudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png"))); // NOI18N
        btnEstudiantes.setBorder(null);
        btnEstudiantes.setBorderPainted(false);
        btnEstudiantes.setContentAreaFilled(false);
        btnEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstudiantesMouseExited(evt);
            }
        });
        jPanel1.add(btnEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        btnProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/profesor.png"))); // NOI18N
        btnProfesor.setBorder(null);
        btnProfesor.setBorderPainted(false);
        btnProfesor.setContentAreaFilled(false);
        btnProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfesorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfesorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfesorMouseExited(evt);
            }
        });
        jPanel1.add(btnProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 400, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 560));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/cerrar.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 5, -1, -1));

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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 40));

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        PnlPerfil.setBackground(new java.awt.Color(255, 255, 255));
        PnlPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setText("Información Personal");
        PnlPerfil.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel3.setText("Nombre:");
        PnlPerfil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        PnlPerfil.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setText("Apellidos: ");
        PnlPerfil.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        PnlPerfil.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));
        PnlPerfil.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setText("Fecha de nacimiento: ");
        PnlPerfil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel8.setText("Email:");
        PnlPerfil.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setText("Cédula:");
        PnlPerfil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        PnlPerfil.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setText("CIF:");
        PnlPerfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        PnlPerfil.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel9.setText("Dirección:");
        PnlPerfil.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        PnlPerfil.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 160, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        ParentPanel.add(PnlPerfil, "card2");

        PnlAsignacionCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png"))); // NOI18N
        btnCrear1.setBorder(null);
        btnCrear1.setBorderPainted(false);
        btnCrear1.setContentAreaFilled(false);
        jPanel6.add(btnCrear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnCambio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png"))); // NOI18N
        btnCambio1.setBorder(null);
        btnCambio1.setBorderPainted(false);
        btnCambio1.setContentAreaFilled(false);
        btnCambio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambio1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambio1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambio1MouseExited(evt);
            }
        });
        jPanel6.add(btnCambio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnRetiro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png"))); // NOI18N
        btnRetiro1.setBorder(null);
        btnRetiro1.setBorderPainted(false);
        btnRetiro1.setContentAreaFilled(false);
        btnRetiro1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiro1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiro1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiro1MouseExited(evt);
            }
        });
        jPanel6.add(btnRetiro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        btnCrearAsignacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignacion.png"))); // NOI18N
        btnCrearAsignacion.setBorder(null);
        btnCrearAsignacion.setBorderPainted(false);
        btnCrearAsignacion.setContentAreaFilled(false);
        jPanel6.add(btnCrearAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel56.setText("Asignación");
        jPanel6.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel57.setText("Nombre:");
        jPanel6.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel6.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel59.setText("Descripción:");
        jPanel6.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        jPanel6.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 140, -1));
        jPanel6.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 130, -1));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel60.setText("Semestre:");
        jPanel6.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel64.setText("Horas totales:");
        jPanel6.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel65.setText("ID Asignatura:");
        jPanel6.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));
        jPanel6.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 120, 10));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel66.setText("Facultad:");
        jPanel6.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel67.setText("Carrera:");
        jPanel6.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        jPanel6.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 150, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        jPanel6.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, -1));

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        jPanel6.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 170, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel6.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PnlAsignacionCrear.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 560));

        ParentPanel.add(PnlAsignacionCrear, "card10");

        PnlAsignacionCambio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png"))); // NOI18N
        btnCrear2.setBorder(null);
        btnCrear2.setBorderPainted(false);
        btnCrear2.setContentAreaFilled(false);
        btnCrear2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrear2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrear2MouseExited(evt);
            }
        });
        jPanel5.add(btnCrear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnRetiro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png"))); // NOI18N
        btnRetiro2.setBorder(null);
        btnRetiro2.setBorderPainted(false);
        btnRetiro2.setContentAreaFilled(false);
        btnRetiro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiro2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiro2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiro2MouseExited(evt);
            }
        });
        jPanel5.add(btnRetiro2, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jPanel5.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel46.setText("Asignación");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel47.setText("Nombre:");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel5.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel48.setText("Descripción:");
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));
        jPanel5.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 140, -1));
        jPanel5.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 130, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel49.setText("Semestre:");
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel50.setText("Horas totales:");
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel51.setText("ID Asignatura:");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));
        jPanel5.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 120, 10));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel52.setText("Facultad:");
        jPanel5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, -1, -1));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel53.setText("Carrera:");
        jPanel5.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, -1));

        btnCambio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png"))); // NOI18N
        btnCambio2.setBorder(null);
        btnCambio2.setBorderPainted(false);
        btnCambio2.setContentAreaFilled(false);
        jPanel5.add(btnCambio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        jPanel5.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 150, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        jPanel5.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        jPanel5.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 170, -1));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        PnlAsignacionCambio.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 560));

        ParentPanel.add(PnlAsignacionCambio, "card9");

        PnlAsignacionRetiro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrear3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png"))); // NOI18N
        btnCrear3.setBorder(null);
        btnCrear3.setBorderPainted(false);
        btnCrear3.setContentAreaFilled(false);
        btnCrear3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrear3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear3MouseEntered(evt);
            }
        });
        jPanel4.add(btnCrear3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnRetiro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png"))); // NOI18N
        btnRetiro3.setBorder(null);
        btnRetiro3.setBorderPainted(false);
        btnRetiro3.setContentAreaFilled(false);
        jPanel4.add(btnRetiro3, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel55.setText("Asignación");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setText("Semestre");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel61.setText("Facultad");
        jPanel4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel62.setText("Carrera");
        jPanel4.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        btnCambio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png"))); // NOI18N
        btnCambio3.setBorder(null);
        btnCambio3.setBorderPainted(false);
        btnCambio3.setContentAreaFilled(false);
        btnCambio3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambio3MouseClicked(evt);
            }
        });
        jPanel4.add(btnCambio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        jPanel4.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 170, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        jPanel4.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        jPanel4.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 170, -1));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        jPanel4.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

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
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 310, 330));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jPanel4.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

        PnlAsignacionRetiro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 560));

        ParentPanel.add(PnlAsignacionRetiro, "card3");

        PnlGruposCrear.setBackground(new java.awt.Color(255, 255, 255));
        PnlGruposCrear.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel29.setText("Grupos");
        PnlGruposCrear.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrear6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png"))); // NOI18N
        btnCrear6.setBorder(null);
        btnCrear6.setBorderPainted(false);
        btnCrear6.setContentAreaFilled(false);
        btnCrear6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrear6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrear6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrear6MouseExited(evt);
            }
        });
        PnlGruposCrear.add(btnCrear6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnCambio6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/ModificacionGrupo.png"))); // NOI18N
        btnCambio6.setBorder(null);
        btnCambio6.setBorderPainted(false);
        btnCambio6.setContentAreaFilled(false);
        PnlGruposCrear.add(btnCambio6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnRetiro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/EliminarGrupo.png"))); // NOI18N
        btnRetiro6.setBorder(null);
        btnRetiro6.setBorderPainted(false);
        btnRetiro6.setContentAreaFilled(false);
        btnRetiro6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiro6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiro6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiro6MouseExited(evt);
            }
        });
        PnlGruposCrear.add(btnRetiro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlGruposCrear.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel30.setText("Docente:");
        PnlGruposCrear.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel31.setText("ID Grupo:");
        PnlGruposCrear.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, -1));
        PnlGruposCrear.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 170, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iván Arguello", "Elmara Camaño" }));
        PnlGruposCrear.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel32.setText("Aula 1:");
        PnlGruposCrear.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-201", "A-202" }));
        PnlGruposCrear.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel33.setText("Aula 2:");
        PnlGruposCrear.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B-301", "B-302" }));
        PnlGruposCrear.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 100, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel34.setText("Aula 3:");
        PnlGruposCrear.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, -1, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C-401", "C-402", " " }));
        PnlGruposCrear.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 100, -1));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel72.setText("Facultad:");
        PnlGruposCrear.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlGruposCrear.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel73.setText("Carrera:");
        PnlGruposCrear.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlGruposCrear.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 170, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel74.setText("Asignatura:");
        PnlGruposCrear.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, -1, -1));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Vectorial", "Base de Datos", "Calculo II" }));
        PnlGruposCrear.add(jComboBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 170, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Horario", "AV101 - Análisis Vectorial" }));
        PnlGruposCrear.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 260, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnCrearGrupo.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        PnlGruposCrear.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, -1, -1));

        ParentPanel.add(PnlGruposCrear, "card4");

        jLabel13.setText("Estudiantes");

        javax.swing.GroupLayout PnlEstudiantesLayout = new javax.swing.GroupLayout(PnlEstudiantes);
        PnlEstudiantes.setLayout(PnlEstudiantesLayout);
        PnlEstudiantesLayout.setHorizontalGroup(
            PnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEstudiantesLayout.createSequentialGroup()
                .addContainerGap(338, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(277, 277, 277))
        );
        PnlEstudiantesLayout.setVerticalGroup(
            PnlEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlEstudiantesLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(244, 244, 244))
        );

        ParentPanel.add(PnlEstudiantes, "card5");

        jLabel14.setText("Profesor");

        javax.swing.GroupLayout PnlProfesorLayout = new javax.swing.GroupLayout(PnlProfesor);
        PnlProfesor.setLayout(PnlProfesorLayout);
        PnlProfesorLayout.setHorizontalGroup(
            PnlProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlProfesorLayout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel14)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        PnlProfesorLayout.setVerticalGroup(
            PnlProfesorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlProfesorLayout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel14)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        ParentPanel.add(PnlProfesor, "card6");

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

        getContentPane().add(ParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 680, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed
    
    //Mover el Frame
    int xx,xy;
    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed
    
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnAsignacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionCrear);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        asignacion();
    }//GEN-LAST:event_btnAsignacionMouseClicked

    private void btnGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlGruposCrear);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnGruposMouseClicked

    private void btnEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlEstudiantes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnEstudiantesMouseClicked

    private void btnProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlProfesor);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnProfesorMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAjustes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnEditar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseClicked
        Contraseña3 contra = new Contraseña3();
        contra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditar1MouseClicked

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

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-perfil.png")));
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/perfil.png")));
        panelSelected();
    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnAsignacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseEntered
        btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-asignacion.png")));
    }//GEN-LAST:event_btnAsignacionMouseEntered

    private void btnAsignacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsignacionMouseExited
        btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
        panelSelected();
    }//GEN-LAST:event_btnAsignacionMouseExited

    private void btnGruposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseEntered
        btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-grupos.png")));
    }//GEN-LAST:event_btnGruposMouseEntered

    private void btnGruposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseExited
        btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
        panelSelected();
    }//GEN-LAST:event_btnGruposMouseExited

    private void btnEstudiantesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseEntered
        btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-estudiantes.png")));
    }//GEN-LAST:event_btnEstudiantesMouseEntered

    private void btnEstudiantesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseExited
        btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
        panelSelected();
    }//GEN-LAST:event_btnEstudiantesMouseExited

    private void btnProfesorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseEntered
        btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-profesor.png")));
    }//GEN-LAST:event_btnProfesorMouseEntered

    private void btnProfesorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseExited
        btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
        panelSelected();
    }//GEN-LAST:event_btnProfesorMouseExited

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ajustes.png")));
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ajustes.png")));
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png")));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/salir.png")));
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnCambio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambio1MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionCambio);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        asignacion();
    }//GEN-LAST:event_btnCambio1MouseClicked

    private void btnRetiro1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro1MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionRetiro);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        asignacion();
    }//GEN-LAST:event_btnRetiro1MouseClicked

    private void btnCambio1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambio1MouseEntered
        btnCambio1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CambioAsignatura.png")));
    }//GEN-LAST:event_btnCambio1MouseEntered

    private void btnCambio1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambio1MouseExited
        btnCambio1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnCambio1MouseExited

    private void btnRetiro1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro1MouseEntered
        btnRetiro1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-RetiroAsignatura.png")));
    }//GEN-LAST:event_btnRetiro1MouseEntered

    private void btnRetiro1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro1MouseExited
        btnRetiro1.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnRetiro1MouseExited

    private void btnCrear2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionCrear);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        asignacion();
    }//GEN-LAST:event_btnCrear2MouseClicked

    private void btnRetiro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionRetiro);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        asignacion();
    }//GEN-LAST:event_btnRetiro2MouseClicked

    private void btnCrear2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear2MouseEntered
        btnCrear2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearAsignatura.png")));
    }//GEN-LAST:event_btnCrear2MouseEntered

    private void btnCrear2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear2MouseExited
        btnCrear2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnCrear2MouseExited

    private void btnRetiro2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro2MouseEntered
        btnRetiro2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-RetiroAsignatura.png")));
    }//GEN-LAST:event_btnRetiro2MouseEntered

    private void btnRetiro2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro2MouseExited
        btnRetiro2.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnRetiro2MouseExited

    private void btnCambio3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambio3MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionCambio);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        asignacion();
    }//GEN-LAST:event_btnCambio3MouseClicked

    private void btnCrear3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear3MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAsignacionCrear);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        asignacion();
    }//GEN-LAST:event_btnCrear3MouseClicked

    private void btnCrear3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear3MouseEntered
        btnCrear3.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearAsignatura.png")));
    }//GEN-LAST:event_btnCrear3MouseEntered

    private void btnCrear6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrear6MouseClicked

    private void btnCrear6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrear6MouseEntered

    private void btnCrear6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrear6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrear6MouseExited

    private void btnRetiro6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiro6MouseClicked

    private void btnRetiro6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiro6MouseEntered

    private void btnRetiro6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiro6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiro6MouseExited

    /**
     * @param args the command line arguments
     *
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
            java.util.logging.Logger.getLogger(adminPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel PnlAjustes;
    private javax.swing.JPanel PnlAsignacionCambio;
    private javax.swing.JPanel PnlAsignacionCrear;
    private javax.swing.JPanel PnlAsignacionRetiro;
    private javax.swing.JPanel PnlEstudiantes;
    private javax.swing.JPanel PnlGruposCrear;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlProfesor;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnCambio1;
    private javax.swing.JButton btnCambio2;
    private javax.swing.JButton btnCambio3;
    private javax.swing.JButton btnCambio6;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrear1;
    private javax.swing.JButton btnCrear2;
    private javax.swing.JButton btnCrear3;
    private javax.swing.JButton btnCrear6;
    private javax.swing.JButton btnCrearAsignacion;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEstudiantes;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JButton btnRetiro1;
    private javax.swing.JButton btnRetiro2;
    private javax.swing.JButton btnRetiro3;
    private javax.swing.JButton btnRetiro6;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
