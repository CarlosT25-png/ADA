
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
        }else if(panelActual==PnlAsignacion){
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
        }else if(panelActual==PnlGrupos){
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
        PnlAsignacion = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        PnlGrupos = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
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

        jLabel11.setText("Asignacion");

        javax.swing.GroupLayout PnlAsignacionLayout = new javax.swing.GroupLayout(PnlAsignacion);
        PnlAsignacion.setLayout(PnlAsignacionLayout);
        PnlAsignacionLayout.setHorizontalGroup(
            PnlAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAsignacionLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel11)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        PnlAsignacionLayout.setVerticalGroup(
            PnlAsignacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlAsignacionLayout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(319, 319, 319))
        );

        ParentPanel.add(PnlAsignacion, "card3");

        jLabel12.setText("Grupos");

        javax.swing.GroupLayout PnlGruposLayout = new javax.swing.GroupLayout(PnlGrupos);
        PnlGrupos.setLayout(PnlGruposLayout);
        PnlGruposLayout.setHorizontalGroup(
            PnlGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGruposLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel12)
                .addContainerGap(392, Short.MAX_VALUE))
        );
        PnlGruposLayout.setVerticalGroup(
            PnlGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlGruposLayout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(314, 314, 314))
        );

        ParentPanel.add(PnlGrupos, "card4");

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
                .addContainerGap(324, Short.MAX_VALUE))
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
        ParentPanel.add(PnlAsignacion);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnAsignacionMouseClicked

    private void btnGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlGrupos);
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
    private javax.swing.JPanel PnlAsignacion;
    private javax.swing.JPanel PnlEstudiantes;
    private javax.swing.JPanel PnlGrupos;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlProfesor;
    private javax.swing.JLabel avatar;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEstudiantes;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProfesor;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
