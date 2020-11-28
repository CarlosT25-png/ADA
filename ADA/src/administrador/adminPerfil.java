
package administrador;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import utilities.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        ScaleImage.setScaleImage(avatar1, imagen);
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
    
    public void asignacion(){
        Component panelActual = ParentPanelAsignacion.getComponent(0);
        if(panelActual == PnlCrearAsignatura){
            btnCrear.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearAsignatura.png")));
            btnCambio.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
            btnRetiro.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));

        }else if(panelActual == PnlCambioAsignatura){
            btnCambio.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CambioAsignatura.png")));
            btnRetiro.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));
            btnCrear.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        }else if(panelActual == PnlRetiroAsignatura){
            btnCambio.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
            btnRetiro.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-RetiroAsignatura.png")));
            btnCrear.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        }
    }
        
       public void grupo(){
        Component panelActual = ParentPanelGrupos.getComponent(0);
        if(panelActual == PnlCrearGrupos){
            btnCrearG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearGrupo.png")));
            btnModificacionG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionGrupo.png")));
            btnRetiroG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarGrupo.png")));

        }else if(panelActual == PnlModificacionGrupos){
            btnModificacionG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionGrupo.png")));
            btnRetiroG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarGrupo.png")));
            btnCrearG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png")));
        }else if(panelActual == PnlEliminarGrupos){
            btnModificacionG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionGrupo.png")));
            btnRetiroG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarGrupo.png")));
            btnCrearG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png")));
        }
    }
       
       public void estudiante(){
           Component panelActual = ParentPanelEst.getComponent(0);
        if(panelActual == PnlCrearEst){
            btnCrearEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearEstudiante.png")));
            btnModificacionEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionEstudiante.png")));
            btnEliminarEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarEstudiante.png")));

        }else if(panelActual == PnlModificacionEst){
            btnModificacionEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionEstudiante.png")));
            btnEliminarEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarEstudiante.png")));
            btnCrearEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearEstudiante.png")));
        }else if(panelActual == PnlEliminarEst){
            btnModificacionEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionEstudiante.png")));
            btnEliminarEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarEstudiante.png")));
            btnCrearEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearEstudiante.png")));
        }
       }
       
       public void profesor(){
           Component panelActual = ParentPanelProf.getComponent(0);
        if(panelActual == PnlCrearProf){
            btnCrearProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearProf.png")));
            btnModificacionProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionProf.png")));
            btnEliminarProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarProf.png")));

        }else if(panelActual == PnlModificacionProf){
            btnModificacionProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionProf.png")));
            btnEliminarProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarProf.png")));
            btnCrearProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearProf.png")));
        }else if(panelActual == PnlEliminarProf){
            btnModificacionProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionProf.png")));
            btnEliminarProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarProf.png")));
            btnCrearProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearProf.png")));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnCambio = new javax.swing.JButton();
        btnRetiro = new javax.swing.JButton();
        ParentPanelAsignacion = new javax.swing.JPanel();
        PnlCrearAsignatura = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel76 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel80 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jComboBox19 = new javax.swing.JComboBox<>();
        jComboBox20 = new javax.swing.JComboBox<>();
        jComboBox21 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        PnlCambioAsignatura = new javax.swing.JPanel();
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
        jButton13 = new javax.swing.JButton();
        jComboBox13 = new javax.swing.JComboBox<>();
        jComboBox14 = new javax.swing.JComboBox<>();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        PnlRetiroAsignatura = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jComboBox22 = new javax.swing.JComboBox<>();
        jComboBox23 = new javax.swing.JComboBox<>();
        jComboBox24 = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jButton16 = new javax.swing.JButton();
        PnlEstudiantes = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnEliminarEst = new javax.swing.JButton();
        btnModificacionEst = new javax.swing.JButton();
        btnCrearEst = new javax.swing.JButton();
        ParentPanelEst = new javax.swing.JPanel();
        PnlCrearEst = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jSeparator62 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jSeparator63 = new javax.swing.JSeparator();
        jSeparator64 = new javax.swing.JSeparator();
        jLabel138 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jSeparator65 = new javax.swing.JSeparator();
        jLabel142 = new javax.swing.JLabel();
        jSeparator66 = new javax.swing.JSeparator();
        jLabel143 = new javax.swing.JLabel();
        jSeparator67 = new javax.swing.JSeparator();
        btnCrearEst12 = new javax.swing.JButton();
        jLabel144 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        PnlModificacionEst = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jSeparator68 = new javax.swing.JSeparator();
        jLabel146 = new javax.swing.JLabel();
        jSeparator69 = new javax.swing.JSeparator();
        jSeparator70 = new javax.swing.JSeparator();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jSeparator71 = new javax.swing.JSeparator();
        jLabel150 = new javax.swing.JLabel();
        jSeparator72 = new javax.swing.JSeparator();
        jLabel151 = new javax.swing.JLabel();
        jSeparator73 = new javax.swing.JSeparator();
        btnCrearEst13 = new javax.swing.JButton();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jComboBox32 = new javax.swing.JComboBox<>();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        PnlEliminarEst = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jComboBox41 = new javax.swing.JComboBox<>();
        jLabel155 = new javax.swing.JLabel();
        jComboBox42 = new javax.swing.JComboBox<>();
        btnCrearEst14 = new javax.swing.JButton();
        jLabel156 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        PnlProfesor = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnCrearProf = new javax.swing.JButton();
        btnModificacionProf = new javax.swing.JButton();
        btnEliminarProf = new javax.swing.JButton();
        ParentPanelProf = new javax.swing.JPanel();
        PnlCrearProf = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jSeparator74 = new javax.swing.JSeparator();
        jLabel98 = new javax.swing.JLabel();
        jSeparator75 = new javax.swing.JSeparator();
        jSeparator76 = new javax.swing.JSeparator();
        jLabel137 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jSeparator77 = new javax.swing.JSeparator();
        jLabel160 = new javax.swing.JLabel();
        jSeparator78 = new javax.swing.JSeparator();
        jLabel161 = new javax.swing.JLabel();
        jSeparator79 = new javax.swing.JSeparator();
        btnCrearEst11 = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jSeparator80 = new javax.swing.JSeparator();
        jLabel164 = new javax.swing.JLabel();
        jComboBox33 = new javax.swing.JComboBox<>();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        PnlModificacionProf = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator55 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        jSeparator56 = new javax.swing.JSeparator();
        jSeparator57 = new javax.swing.JSeparator();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jSeparator58 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        jSeparator59 = new javax.swing.JSeparator();
        jLabel133 = new javax.swing.JLabel();
        jSeparator60 = new javax.swing.JSeparator();
        btnCrearEst10 = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jSeparator61 = new javax.swing.JSeparator();
        jLabel136 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        PnlEliminarProf = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jComboBox43 = new javax.swing.JComboBox<>();
        btnCrearEst15 = new javax.swing.JButton();
        jLabel158 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        PnlGrupos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        btnCrearG = new javax.swing.JButton();
        btnModificacionG = new javax.swing.JButton();
        btnRetiroG = new javax.swing.JButton();
        ParentPanelGrupos = new javax.swing.JPanel();
        PnlCrearGrupos = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        jComboBox25 = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox<>();
        jComboBox10 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        PnlModificacionGrupos = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel90 = new javax.swing.JLabel();
        jComboBox28 = new javax.swing.JComboBox<>();
        jLabel91 = new javax.swing.JLabel();
        jComboBox29 = new javax.swing.JComboBox<>();
        jLabel92 = new javax.swing.JLabel();
        jComboBox30 = new javax.swing.JComboBox<>();
        jComboBox18 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        PnlEliminarGrupos = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jComboBox31 = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        jComboBox35 = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jComboBox36 = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        jComboBox37 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel97 = new javax.swing.JLabel();
        jComboBox39 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
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
        jLabel32 = new javax.swing.JLabel();
        avatar1 = new javax.swing.JLabel();
        btnImportarFoto = new javax.swing.JButton();

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

        PnlAsignacion.setBackground(new java.awt.Color(255, 255, 255));
        PnlAsignacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel69.setText("Asignación");
        jPanel2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png"))); // NOI18N
        btnCrear.setBorder(null);
        btnCrear.setBorderPainted(false);
        btnCrear.setContentAreaFilled(false);
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        jPanel2.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png"))); // NOI18N
        btnCambio.setBorder(null);
        btnCambio.setBorderPainted(false);
        btnCambio.setContentAreaFilled(false);
        btnCambio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCambioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambioMouseExited(evt);
            }
        });
        jPanel2.add(btnCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnRetiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png"))); // NOI18N
        btnRetiro.setBorder(null);
        btnRetiro.setBorderPainted(false);
        btnRetiro.setContentAreaFilled(false);
        btnRetiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiroMouseExited(evt);
            }
        });
        jPanel2.add(btnRetiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        PnlAsignacion.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

        ParentPanelAsignacion.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelAsignacion.setLayout(new java.awt.CardLayout());

        PnlCrearAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel70.setText("Nombre:");
        PnlCrearAsignatura.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel75.setText("Carrera:");
        PnlCrearAsignatura.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));
        PnlCrearAsignatura.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel76.setText("Descripción:");
        PnlCrearAsignatura.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        PnlCrearAsignatura.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));
        PnlCrearAsignatura.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, -1));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel77.setText("Semestre:");
        PnlCrearAsignatura.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel78.setText("Horas totales:");
        PnlCrearAsignatura.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel79.setText("ID Asignatura:");
        PnlCrearAsignatura.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
        PnlCrearAsignatura.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, 10));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel80.setText("Facultad:");
        PnlCrearAsignatura.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignacion.png"))); // NOI18N
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        PnlCrearAsignatura.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        PnlCrearAsignatura.add(jComboBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, -1));

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlCrearAsignatura.add(jComboBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlCrearAsignatura.add(jComboBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 170, -1));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearAsignatura.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 343, -1, -1));

        jTextField2.setBorder(null);
        PnlCrearAsignatura.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 120, -1));

        jTextField6.setBorder(null);
        PnlCrearAsignatura.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        jTextField7.setBorder(null);
        PnlCrearAsignatura.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, -1));

        jTextField8.setBorder(null);
        PnlCrearAsignatura.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, -1));

        jTextField9.setBorder(null);
        PnlCrearAsignatura.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));

        ParentPanelAsignacion.add(PnlCrearAsignatura, "card2");

        PnlCambioAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        PnlCambioAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel56.setText("Nombre:");
        PnlCambioAsignatura.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel57.setText("Carrera:");
        PnlCambioAsignatura.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));
        PnlCambioAsignatura.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel59.setText("Descripción:");
        PnlCambioAsignatura.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        PnlCambioAsignatura.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));
        PnlCambioAsignatura.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, -1));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel60.setText("Semestre:");
        PnlCambioAsignatura.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel64.setText("Horas totales:");
        PnlCambioAsignatura.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel65.setText("ID Asignatura:");
        PnlCambioAsignatura.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
        PnlCambioAsignatura.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, 10));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel66.setText("Facultad:");
        PnlCambioAsignatura.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton13.setBorder(null);
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        PnlCambioAsignatura.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        PnlCambioAsignatura.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlCambioAsignatura.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlCambioAsignatura.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 170, -1));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCambioAsignatura.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 343, -1, -1));

        jTextField5.setBorder(null);
        PnlCambioAsignatura.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 120, -1));

        jTextField10.setBorder(null);
        PnlCambioAsignatura.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        jTextField11.setBorder(null);
        PnlCambioAsignatura.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, -1));

        jTextField12.setBorder(null);
        PnlCambioAsignatura.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 130, -1));

        ParentPanelAsignacion.add(PnlCambioAsignatura, "card3");

        PnlRetiroAsignatura.setBackground(new java.awt.Color(255, 255, 255));
        PnlRetiroAsignatura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel68.setText("Semestre");
        PnlRetiroAsignatura.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setText("Facultad");
        PnlRetiroAsignatura.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel83.setText("Carrera");
        PnlRetiroAsignatura.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        PnlRetiroAsignatura.add(jComboBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, -1));

        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlRetiroAsignatura.add(jComboBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlRetiroAsignatura.add(jComboBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 170, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlRetiroAsignatura.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 343, -1, -1));

        jPanel20.setBackground(new java.awt.Color(204, 204, 204));

        jButton23.setBackground(new java.awt.Color(255, 255, 255));
        jButton23.setText("AV101 - Análisis Vectorial");
        jButton23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton23.setContentAreaFilled(false);

        jButton24.setBackground(new java.awt.Color(255, 255, 255));
        jButton24.setText("BD102 - Base De Datos");
        jButton24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton24.setContentAreaFilled(false);

        jButton30.setBackground(new java.awt.Color(255, 255, 255));
        jButton30.setText("EN302 - Inglés Comunicativo");
        jButton30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton30.setContentAreaFilled(false);

        jButton31.setBackground(new java.awt.Color(255, 255, 255));
        jButton31.setText("ES104 - Estadística II");
        jButton31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton31.setContentAreaFilled(false);

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
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCheckBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCheckBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        PnlRetiroAsignatura.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 310, 330));

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton16.setBorder(null);
        jButton16.setBorderPainted(false);
        jButton16.setContentAreaFilled(false);
        PnlRetiroAsignatura.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        ParentPanelAsignacion.add(PnlRetiroAsignatura, "card4");

        PnlAsignacion.add(ParentPanelAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 147, 680, 410));

        ParentPanel.add(PnlAsignacion, "card10");

        PnlEstudiantes.setBackground(new java.awt.Color(255, 255, 255));
        PnlEstudiantes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel11.setText("Estudiantes");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnEliminarEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/EliminarEstudiante.png"))); // NOI18N
        btnEliminarEst.setBorder(null);
        btnEliminarEst.setBorderPainted(false);
        btnEliminarEst.setContentAreaFilled(false);
        btnEliminarEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarEstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarEstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarEstMouseExited(evt);
            }
        });
        jPanel4.add(btnEliminarEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        btnModificacionEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/ModificacionEstudiante.png"))); // NOI18N
        btnModificacionEst.setBorder(null);
        btnModificacionEst.setBorderPainted(false);
        btnModificacionEst.setContentAreaFilled(false);
        btnModificacionEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificacionEstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificacionEstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificacionEstMouseExited(evt);
            }
        });
        jPanel4.add(btnModificacionEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnCrearEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearEstudiante.png"))); // NOI18N
        btnCrearEst.setBorder(null);
        btnCrearEst.setBorderPainted(false);
        btnCrearEst.setContentAreaFilled(false);
        btnCrearEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearEstMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearEstMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearEstMouseExited(evt);
            }
        });
        jPanel4.add(btnCrearEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        PnlEstudiantes.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 160));

        ParentPanelEst.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelEst.setLayout(new java.awt.CardLayout());

        PnlCrearEst.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearEst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel61.setText("Nombre:");
        PnlCrearEst.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        PnlCrearEst.add(jSeparator62, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel74.setText("Apellidos: ");
        PnlCrearEst.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        PnlCrearEst.add(jSeparator63, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 170, -1));
        PnlCrearEst.add(jSeparator64, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 200, -1));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel138.setText("Fecha de nacimiento: ");
        PnlCrearEst.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel140.setText("Email:");
        PnlCrearEst.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel141.setText("Cédula:");
        PnlCrearEst.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        PnlCrearEst.add(jSeparator65, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 170, -1));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel142.setText("CIF:");
        PnlCrearEst.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));
        PnlCrearEst.add(jSeparator66, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, -1));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel143.setText("Dirección:");
        PnlCrearEst.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));
        PnlCrearEst.add(jSeparator67, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 160, -1));

        btnCrearEst12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnCrearEstudiante.png"))); // NOI18N
        btnCrearEst12.setBorder(null);
        btnCrearEst12.setBorderPainted(false);
        btnCrearEst12.setContentAreaFilled(false);
        PnlCrearEst.add(btnCrearEst12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearEst.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        jTextField25.setBorder(null);
        PnlCrearEst.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        jTextField40.setBorder(null);
        PnlCrearEst.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 160, -1));

        jTextField41.setBorder(null);
        PnlCrearEst.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 170, -1));

        jTextField42.setBorder(null);
        PnlCrearEst.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 200, -1));

        jTextField43.setBorder(null);
        PnlCrearEst.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 170, -1));

        jTextField44.setBorder(null);
        PnlCrearEst.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 200, -1));

        ParentPanelEst.add(PnlCrearEst, "card2");

        PnlModificacionEst.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificacionEst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel145.setText("Nombre:");
        PnlModificacionEst.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        PnlModificacionEst.add(jSeparator68, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 170, -1));

        jLabel146.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel146.setText("Apellidos: ");
        PnlModificacionEst.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));
        PnlModificacionEst.add(jSeparator69, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 170, -1));
        PnlModificacionEst.add(jSeparator70, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 200, -1));

        jLabel147.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel147.setText("Fecha de nacimiento: ");
        PnlModificacionEst.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel148.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel148.setText("Email:");
        PnlModificacionEst.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel149.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel149.setText("Cédula:");
        PnlModificacionEst.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        PnlModificacionEst.add(jSeparator71, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 170, -1));

        jLabel150.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel150.setText("CIF:");
        PnlModificacionEst.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));
        PnlModificacionEst.add(jSeparator72, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 200, -1));

        jLabel151.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel151.setText("Estado:");
        PnlModificacionEst.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));
        PnlModificacionEst.add(jSeparator73, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 160, -1));

        btnCrearEst13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnCrearEst13.setBorder(null);
        btnCrearEst13.setBorderPainted(false);
        btnCrearEst13.setContentAreaFilled(false);
        PnlModificacionEst.add(btnCrearEst13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionEst.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        jLabel153.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel153.setText("Dirección:");
        PnlModificacionEst.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jComboBox32.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        PnlModificacionEst.add(jComboBox32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 150, -1));

        jTextField45.setBorder(null);
        PnlModificacionEst.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 200, -1));

        jTextField46.setBorder(null);
        PnlModificacionEst.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 160, -1));

        jTextField47.setBorder(null);
        PnlModificacionEst.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 200, -1));

        jTextField48.setBorder(null);
        PnlModificacionEst.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 170, -1));

        jTextField49.setBorder(null);
        PnlModificacionEst.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 170, -1));

        jTextField50.setBorder(null);
        PnlModificacionEst.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        ParentPanelEst.add(PnlModificacionEst, "card3");

        PnlEliminarEst.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarEst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel154.setText("Facultad");
        PnlEliminarEst.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jComboBox41.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlEliminarEst.add(jComboBox41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel155.setText("Carrera");
        PnlEliminarEst.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jComboBox42.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlEliminarEst.add(jComboBox42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, -1));

        btnCrearEst14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnCrearEst14.setBorder(null);
        btnCrearEst14.setBorderPainted(false);
        btnCrearEst14.setContentAreaFilled(false);
        PnlEliminarEst.add(btnCrearEst14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarEst.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, -1, -1));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Michelle Prado", null},
                {"Carlos Torres", null},
                {"Ismael Castillo", null}
            },
            new String [] {
                "Nombre del Estudiante", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        PnlEliminarEst.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 320, 140));

        ParentPanelEst.add(PnlEliminarEst, "card4");

        PnlEstudiantes.add(ParentPanelEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 680, 400));

        ParentPanel.add(PnlEstudiantes, "card5");

        PnlProfesor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel12.setText("Profesor");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrearProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearProf.png"))); // NOI18N
        btnCrearProf.setBorder(null);
        btnCrearProf.setBorderPainted(false);
        btnCrearProf.setContentAreaFilled(false);
        btnCrearProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearProfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearProfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearProfMouseExited(evt);
            }
        });
        jPanel5.add(btnCrearProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnModificacionProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/ModificacionProf.png"))); // NOI18N
        btnModificacionProf.setBorder(null);
        btnModificacionProf.setBorderPainted(false);
        btnModificacionProf.setContentAreaFilled(false);
        btnModificacionProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificacionProfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificacionProfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificacionProfMouseExited(evt);
            }
        });
        jPanel5.add(btnModificacionProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnEliminarProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/EliminarProf.png"))); // NOI18N
        btnEliminarProf.setBorder(null);
        btnEliminarProf.setBorderPainted(false);
        btnEliminarProf.setContentAreaFilled(false);
        btnEliminarProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarProfMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarProfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarProfMouseExited(evt);
            }
        });
        jPanel5.add(btnEliminarProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        PnlProfesor.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 150));

        ParentPanelProf.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelProf.setLayout(new java.awt.CardLayout());

        PnlCrearProf.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel62.setText("Nombre:");
        PnlCrearProf.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        PnlCrearProf.add(jSeparator74, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel98.setText("Apellidos: ");
        PnlCrearProf.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        PnlCrearProf.add(jSeparator75, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));
        PnlCrearProf.add(jSeparator76, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 200, -1));

        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel137.setText("Fecha de nacimiento: ");
        PnlCrearProf.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel139.setText("Email:");
        PnlCrearProf.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel159.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel159.setText("Cédula:");
        PnlCrearProf.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));
        PnlCrearProf.add(jSeparator77, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 170, -1));

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel160.setText("CIF:");
        PnlCrearProf.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));
        PnlCrearProf.add(jSeparator78, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 200, -1));

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel161.setText("Dirección:");
        PnlCrearProf.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));
        PnlCrearProf.add(jSeparator79, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 160, -1));

        btnCrearEst11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnCrearProf.png"))); // NOI18N
        btnCrearEst11.setBorder(null);
        btnCrearEst11.setBorderPainted(false);
        btnCrearEst11.setContentAreaFilled(false);
        PnlCrearProf.add(btnCrearEst11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearProf.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel163.setText("Especialidad:");
        PnlCrearProf.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));
        PnlCrearProf.add(jSeparator80, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 130, -1));

        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel164.setText("Estado:");
        PnlCrearProf.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jComboBox33.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        PnlCrearProf.add(jComboBox33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 150, -1));

        jTextField51.setBorder(null);
        PnlCrearProf.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 96, 200, 20));

        jTextField52.setBorder(null);
        PnlCrearProf.add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, -1));

        jTextField53.setBorder(null);
        PnlCrearProf.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));

        jTextField54.setBorder(null);
        PnlCrearProf.add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, -1));

        jTextField55.setBorder(null);
        PnlCrearProf.add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 130, -1));

        jTextField56.setBorder(null);
        PnlCrearProf.add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));

        jTextField57.setBorder(null);
        PnlCrearProf.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 160, -1));

        ParentPanelProf.add(PnlCrearProf, "card4");

        PnlModificacionProf.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificacionProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel58.setText("Nombre:");
        PnlModificacionProf.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        PnlModificacionProf.add(jSeparator55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel73.setText("Apellidos: ");
        PnlModificacionProf.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        PnlModificacionProf.add(jSeparator56, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));
        PnlModificacionProf.add(jSeparator57, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 200, -1));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel129.setText("Fecha de nacimiento: ");
        PnlModificacionProf.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel130.setText("Email:");
        PnlModificacionProf.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel131.setText("Cédula:");
        PnlModificacionProf.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));
        PnlModificacionProf.add(jSeparator58, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 170, -1));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel132.setText("CIF:");
        PnlModificacionProf.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));
        PnlModificacionProf.add(jSeparator59, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 200, -1));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel133.setText("Dirección:");
        PnlModificacionProf.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));
        PnlModificacionProf.add(jSeparator60, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 160, -1));

        btnCrearEst10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnCrearEst10.setBorder(null);
        btnCrearEst10.setBorderPainted(false);
        btnCrearEst10.setContentAreaFilled(false);
        PnlModificacionProf.add(btnCrearEst10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionProf.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel135.setText("Especialidad:");
        PnlModificacionProf.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));
        PnlModificacionProf.add(jSeparator61, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 130, -1));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel136.setText("Estado:");
        PnlModificacionProf.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        PnlModificacionProf.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 150, -1));

        jTextField33.setBorder(null);
        PnlModificacionProf.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 96, 200, 20));

        jTextField34.setBorder(null);
        PnlModificacionProf.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, -1));

        jTextField35.setBorder(null);
        PnlModificacionProf.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));

        jTextField36.setBorder(null);
        PnlModificacionProf.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, -1));

        jTextField37.setBorder(null);
        PnlModificacionProf.add(jTextField37, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 130, -1));

        jTextField38.setBorder(null);
        PnlModificacionProf.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));

        jTextField39.setBorder(null);
        PnlModificacionProf.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 160, -1));

        ParentPanelProf.add(PnlModificacionProf, "card2");

        PnlEliminarProf.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel157.setText("Facultad");
        PnlEliminarProf.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jComboBox43.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlEliminarProf.add(jComboBox43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        btnCrearEst15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnCrearEst15.setBorder(null);
        btnCrearEst15.setBorderPainted(false);
        btnCrearEst15.setContentAreaFilled(false);
        PnlEliminarProf.add(btnCrearEst15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarProf.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Elmara Camaño", null},
                {"Karla Largaespada", null},
                {"Carlos Iván Arguello", null}
            },
            new String [] {
                "Nombre del Profesor", "Eliminar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        PnlEliminarProf.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 320, 80));

        ParentPanelProf.add(PnlEliminarProf, "card3");

        PnlProfesor.add(ParentPanelProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 680, 410));

        ParentPanel.add(PnlProfesor, "card6");

        PnlGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel35.setText("Grupos");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrearG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png"))); // NOI18N
        btnCrearG.setBorder(null);
        btnCrearG.setBorderPainted(false);
        btnCrearG.setContentAreaFilled(false);
        btnCrearG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearGMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearGMouseExited(evt);
            }
        });
        jPanel3.add(btnCrearG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnModificacionG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/ModificacionGrupo.png"))); // NOI18N
        btnModificacionG.setBorder(null);
        btnModificacionG.setBorderPainted(false);
        btnModificacionG.setContentAreaFilled(false);
        btnModificacionG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificacionGMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificacionGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificacionGMouseExited(evt);
            }
        });
        jPanel3.add(btnModificacionG, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnRetiroG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/EliminarGrupo.png"))); // NOI18N
        btnRetiroG.setBorder(null);
        btnRetiroG.setBorderPainted(false);
        btnRetiroG.setContentAreaFilled(false);
        btnRetiroG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRetiroGMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRetiroGMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRetiroGMouseExited(evt);
            }
        });
        jPanel3.add(btnRetiroG, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 90, -1, -1));

        PnlGrupos.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 140));

        ParentPanelGrupos.setBackground(new java.awt.Color(255, 255, 255));

        PnlCrearGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearGrupos.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel36.setText("Docente:");
        PnlCrearGrupos.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel37.setText("ID Grupo:");
        PnlCrearGrupos.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        PnlCrearGrupos.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 170, -1));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iván Arguello", "Elmara Camaño" }));
        PnlCrearGrupos.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 180, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel38.setText("Aula 1:");
        PnlCrearGrupos.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-201", "A-202" }));
        PnlCrearGrupos.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel39.setText("Aula 2:");
        PnlCrearGrupos.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B-301", "B-302" }));
        PnlCrearGrupos.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 100, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel40.setText("Aula 3:");
        PnlCrearGrupos.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C-401", "C-402", " " }));
        PnlCrearGrupos.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel86.setText("Facultad:");
        PnlCrearGrupos.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlCrearGrupos.add(jComboBox25, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel87.setText("Carrera:");
        PnlCrearGrupos.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlCrearGrupos.add(jComboBox26, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 170, -1));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel88.setText("Asignatura:");
        PnlCrearGrupos.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Vectorial", "Base de Datos", "Calculo II" }));
        PnlCrearGrupos.add(jComboBox27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 170, -1));

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Horario", "AV101 - Análisis Vectorial" }));
        PnlCrearGrupos.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 260, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        PnlCrearGrupos.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jTextField1.setBorder(null);
        PnlCrearGrupos.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));

        PnlModificacionGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificacionGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionGrupos.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel41.setText("Docente:");
        PnlModificacionGrupos.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel42.setText("ID Grupo:");
        PnlModificacionGrupos.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        PnlModificacionGrupos.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 170, -1));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iván Arguello", "Elmara Camaño" }));
        PnlModificacionGrupos.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 180, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel43.setText("Aula 1:");
        PnlModificacionGrupos.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A-201", "A-202" }));
        PnlModificacionGrupos.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel44.setText("Aula 2:");
        PnlModificacionGrupos.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B-301", "B-302" }));
        PnlModificacionGrupos.add(jComboBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 100, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel45.setText("Aula 3:");
        PnlModificacionGrupos.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C-401", "C-402", " " }));
        PnlModificacionGrupos.add(jComboBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, -1));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel90.setText("Facultad:");
        PnlModificacionGrupos.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlModificacionGrupos.add(jComboBox28, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel91.setText("Carrera:");
        PnlModificacionGrupos.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jComboBox29.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlModificacionGrupos.add(jComboBox29, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 170, -1));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel92.setText("Asignatura:");
        PnlModificacionGrupos.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, -1, -1));

        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Vectorial", "Base de Datos", "Calculo II" }));
        PnlModificacionGrupos.add(jComboBox30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 170, -1));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Horario", "AV101 - Análisis Vectorial" }));
        PnlModificacionGrupos.add(jComboBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 260, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnModificarGrupo.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        PnlModificacionGrupos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jTextField3.setBorder(null);
        PnlModificacionGrupos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));

        PnlEliminarGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarGrupos.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel46.setText("Docente:");
        PnlEliminarGrupos.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel47.setText("ID Grupo:");
        PnlEliminarGrupos.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, -1, -1));
        PnlEliminarGrupos.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 170, -1));

        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iván Arguello", "Elmara Camaño" }));
        PnlEliminarGrupos.add(jComboBox31, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 180, -1));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel94.setText("Facultad:");
        PnlEliminarGrupos.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jComboBox35.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlEliminarGrupos.add(jComboBox35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, -1));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel95.setText("Carrera:");
        PnlEliminarGrupos.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jComboBox36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlEliminarGrupos.add(jComboBox36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 170, -1));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel96.setText("Asignatura:");
        PnlEliminarGrupos.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        jComboBox37.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Vectorial", "Base de Datos", "Calculo II" }));
        PnlEliminarGrupos.add(jComboBox37, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 170, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        PnlEliminarGrupos.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel97.setText("Grupo:");
        PnlEliminarGrupos.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        jComboBox39.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grupo 1", "Grupo 2", "Grupo 3" }));
        PnlEliminarGrupos.add(jComboBox39, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 170, -1));

        jTextField4.setBorder(null);
        PnlEliminarGrupos.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));

        javax.swing.GroupLayout ParentPanelGruposLayout = new javax.swing.GroupLayout(ParentPanelGrupos);
        ParentPanelGrupos.setLayout(ParentPanelGruposLayout);
        ParentPanelGruposLayout.setHorizontalGroup(
            ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlCrearGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addGroup(ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PnlModificacionGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
            .addGroup(ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PnlEliminarGrupos, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
        );
        ParentPanelGruposLayout.setVerticalGroup(
            ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParentPanelGruposLayout.createSequentialGroup()
                .addComponent(PnlCrearGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
            .addGroup(ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PnlModificacionGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 420, Short.MAX_VALUE))
            .addGroup(ParentPanelGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ParentPanelGruposLayout.createSequentialGroup()
                    .addComponent(PnlEliminarGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PnlGrupos.add(ParentPanelGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 680, 420));

        ParentPanel.add(PnlGrupos, "card8");

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

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel32.setText("Cambiar Foto de Perfil");
        PnlCambioFotoPerfil.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        avatar1.setMaximumSize(new java.awt.Dimension(102, 102));
        avatar1.setMinimumSize(new java.awt.Dimension(102, 102));
        avatar1.setPreferredSize(new java.awt.Dimension(102, 102));
        PnlCambioFotoPerfil.add(avatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 220, 220));

        btnImportarFoto.setBackground(new java.awt.Color(255, 255, 255));
        btnImportarFoto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImportarFoto.setText("Importar Foto de Perfil");
        btnImportarFoto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnImportarFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImportarFotoMouseClicked(evt);
            }
        });
        PnlCambioFotoPerfil.add(btnImportarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 310, 50));

        ParentPanel.add(PnlCambioFotoPerfil, "card9");

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
        asignacion();
    }//GEN-LAST:event_btnAsignacionMouseClicked

    private void btnGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGruposMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlGrupos);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        grupo();
    }//GEN-LAST:event_btnGruposMouseClicked

    private void btnEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstudiantesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlEstudiantes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        estudiante();
    }//GEN-LAST:event_btnEstudiantesMouseClicked

    private void btnProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfesorMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlProfesor);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        profesor();
    }//GEN-LAST:event_btnProfesorMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAjustes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseClicked

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

    private void btnCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseClicked
        ParentPanelAsignacion.removeAll();
        ParentPanelAsignacion.add(PnlCrearAsignatura);
        ParentPanelAsignacion.revalidate();
        ParentPanelAsignacion.repaint();
        panelSelected();
        asignacion();
    }//GEN-LAST:event_btnCrearMouseClicked

    private void btnCrearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseEntered
         btnCrear.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearAsignatura.png")));
    }//GEN-LAST:event_btnCrearMouseEntered

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnCrearMouseExited

    private void btnRetiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroMouseClicked
        ParentPanelAsignacion.removeAll();
        ParentPanelAsignacion.add(PnlRetiroAsignatura);
        ParentPanelAsignacion.revalidate();
        ParentPanelAsignacion.repaint();
        panelSelected();
        asignacion();
    }//GEN-LAST:event_btnRetiroMouseClicked

    private void btnRetiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroMouseEntered
        btnRetiro.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-RetiroAsignatura.png")));
    }//GEN-LAST:event_btnRetiroMouseEntered

    private void btnRetiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroMouseExited
        btnRetiro.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/RetiroAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnRetiroMouseExited

    private void btnCambioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioMouseClicked
        ParentPanelAsignacion.removeAll();
        ParentPanelAsignacion.add(PnlCambioAsignatura);
        ParentPanelAsignacion.revalidate();
        ParentPanelAsignacion.repaint();
        panelSelected();
        asignacion();
    }//GEN-LAST:event_btnCambioMouseClicked

    private void btnCambioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioMouseEntered
        btnCambio.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CambioAsignatura.png")));
    }//GEN-LAST:event_btnCambioMouseEntered

    private void btnCambioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambioMouseExited
        btnCambio.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CambioAsignatura.png")));
        asignacion();
    }//GEN-LAST:event_btnCambioMouseExited

    private void btnCrearGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearGMouseClicked
        ParentPanelGrupos.removeAll();
        ParentPanelGrupos.add(PnlCrearGrupos);
        ParentPanelGrupos.revalidate();
        ParentPanelGrupos.repaint();
        grupo();
    }//GEN-LAST:event_btnCrearGMouseClicked

    private void btnCrearGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearGMouseEntered
        btnCrearG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearGrupo.png")));
    }//GEN-LAST:event_btnCrearGMouseEntered

    private void btnCrearGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearGMouseExited
        btnCrearG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png")));
        grupo();
    }//GEN-LAST:event_btnCrearGMouseExited

    private void btnRetiroGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroGMouseClicked
        ParentPanelGrupos.removeAll();
        ParentPanelGrupos.add(PnlEliminarGrupos);
        ParentPanelGrupos.revalidate();
        ParentPanelGrupos.repaint();
        grupo();
    }//GEN-LAST:event_btnRetiroGMouseClicked

    private void btnRetiroGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroGMouseEntered
        btnRetiroG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarGrupo.png")));
    }//GEN-LAST:event_btnRetiroGMouseEntered

    private void btnRetiroGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroGMouseExited
        btnRetiroG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarGrupo.png")));
        grupo();
    }//GEN-LAST:event_btnRetiroGMouseExited

    private void btnEditar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseExited
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
    }//GEN-LAST:event_btnEditar2MouseExited

    private void btnEditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseEntered
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar2MouseEntered

    private void btnEditar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseExited
        btnEditar1.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
    }//GEN-LAST:event_btnEditar1MouseExited

    private void btnEditar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseEntered
        btnEditar1.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar1MouseEntered

    private void btnEditar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseClicked
        Contraseña3 contra = new Contraseña3();
        contra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditar1MouseClicked

    private void btnModificacionGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionGMouseClicked
        ParentPanelGrupos.removeAll();
        ParentPanelGrupos.add(PnlModificacionGrupos);
        ParentPanelGrupos.revalidate();
        ParentPanelGrupos.repaint();
        grupo();
    }//GEN-LAST:event_btnModificacionGMouseClicked

    private void btnModificacionGMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionGMouseEntered
        btnModificacionG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionGrupo.png")));
    }//GEN-LAST:event_btnModificacionGMouseEntered

    private void btnModificacionGMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionGMouseExited
        btnModificacionG.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionGrupo.png")));
        grupo();
    }//GEN-LAST:event_btnModificacionGMouseExited

    private void btnCrearEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearEstMouseClicked
        ParentPanelEst.removeAll();
        ParentPanelEst.add(PnlCrearEst);
        ParentPanelEst.revalidate();
        ParentPanelEst.repaint();
        estudiante();
    }//GEN-LAST:event_btnCrearEstMouseClicked

    private void btnCrearEstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearEstMouseEntered
        btnCrearEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearEstudiante.png")));
    }//GEN-LAST:event_btnCrearEstMouseEntered

    private void btnCrearEstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearEstMouseExited
        btnCrearEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearEstudiante.png")));
        estudiante();
    }//GEN-LAST:event_btnCrearEstMouseExited

    private void btnModificacionEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionEstMouseClicked
        ParentPanelEst.removeAll();
        ParentPanelEst.add(PnlModificacionEst);
        ParentPanelEst.revalidate();
        ParentPanelEst.repaint();
        estudiante();
    }//GEN-LAST:event_btnModificacionEstMouseClicked

    private void btnModificacionEstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionEstMouseEntered
        btnModificacionEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionEstudiante.png")));
    }//GEN-LAST:event_btnModificacionEstMouseEntered

    private void btnModificacionEstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionEstMouseExited
        btnModificacionEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionEstudiante.png")));
        estudiante();
    }//GEN-LAST:event_btnModificacionEstMouseExited

    private void btnEliminarEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEstMouseClicked
        ParentPanelEst.removeAll();
        ParentPanelEst.add(PnlEliminarEst);
        ParentPanelEst.revalidate();
        ParentPanelEst.repaint();
        estudiante();
    }//GEN-LAST:event_btnEliminarEstMouseClicked

    private void btnEliminarEstMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEstMouseEntered
        btnEliminarEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarEstudiante.png")));
    }//GEN-LAST:event_btnEliminarEstMouseEntered

    private void btnEliminarEstMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarEstMouseExited
        btnEliminarEst.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarEstudiante.png")));
        estudiante();
    }//GEN-LAST:event_btnEliminarEstMouseExited

    private void btnEliminarProfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProfMouseExited
         btnEliminarProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/EliminarProf.png")));
         profesor();
    }//GEN-LAST:event_btnEliminarProfMouseExited

    private void btnEliminarProfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProfMouseEntered
        btnEliminarProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-EliminarProf.png")));
    }//GEN-LAST:event_btnEliminarProfMouseEntered

    private void btnEliminarProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarProfMouseClicked
        ParentPanelProf.removeAll();
        ParentPanelProf.add(PnlEliminarProf);
        ParentPanelProf.revalidate();
        ParentPanelProf.repaint();
        profesor();
    }//GEN-LAST:event_btnEliminarProfMouseClicked

    private void btnModificacionProfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionProfMouseExited
        btnModificacionProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/ModificacionProf.png")));
        profesor();
    }//GEN-LAST:event_btnModificacionProfMouseExited

    private void btnModificacionProfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionProfMouseEntered
        btnModificacionProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-ModificacionProf.png")));
    }//GEN-LAST:event_btnModificacionProfMouseEntered

    private void btnModificacionProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionProfMouseClicked
        ParentPanelProf.removeAll();
        ParentPanelProf.add(PnlModificacionProf);
        ParentPanelProf.revalidate();
        ParentPanelProf.repaint();
        profesor();
    }//GEN-LAST:event_btnModificacionProfMouseClicked

    private void btnCrearProfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProfMouseExited
        btnCrearProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-CrearProf.png")));
    }//GEN-LAST:event_btnCrearProfMouseExited

    private void btnCrearProfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProfMouseEntered
        btnCrearProf.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/CrearProf.png")));
        profesor();
    }//GEN-LAST:event_btnCrearProfMouseEntered

    private void btnCrearProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearProfMouseClicked
        ParentPanelProf.removeAll();
        ParentPanelProf.add(PnlCrearProf);
        ParentPanelProf.revalidate();
        ParentPanelProf.repaint();
        profesor();
    }//GEN-LAST:event_btnCrearProfMouseClicked

    private void btnImportarFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImportarFotoMouseClicked
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Elige la imagen");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
        filechooser.setFileFilter(filter);
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION)
        {
            File file = filechooser.getSelectedFile();
            BufferedImage bi;
            try {

                bi = ImageIO.read(file);
                avatar.setIcon(new ImageIcon(bi));
                avatar1.setIcon(new ImageIcon(bi));
                ScaleImage.setScaleImage(avatar, new ImageIcon(bi));
                ScaleImage.setScaleImage(avatar1, new ImageIcon(bi));

            } catch(IOException e) {
                e.printStackTrace();
            }
            this.pack();
        }
    }//GEN-LAST:event_btnImportarFotoMouseClicked

    private void btnEditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlCambioFotoPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseClicked

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
    private javax.swing.JPanel ParentPanelAsignacion;
    private javax.swing.JPanel ParentPanelEst;
    private javax.swing.JPanel ParentPanelGrupos;
    private javax.swing.JPanel ParentPanelProf;
    private javax.swing.JPanel PnlAjustes;
    private javax.swing.JPanel PnlAsignacion;
    private javax.swing.JPanel PnlCambioAsignatura;
    private javax.swing.JPanel PnlCambioFotoPerfil;
    private javax.swing.JPanel PnlCrearAsignatura;
    private javax.swing.JPanel PnlCrearEst;
    private javax.swing.JPanel PnlCrearGrupos;
    private javax.swing.JPanel PnlCrearProf;
    private javax.swing.JPanel PnlEliminarEst;
    private javax.swing.JPanel PnlEliminarGrupos;
    private javax.swing.JPanel PnlEliminarProf;
    private javax.swing.JPanel PnlEstudiantes;
    private javax.swing.JPanel PnlGrupos;
    private javax.swing.JPanel PnlModificacionEst;
    private javax.swing.JPanel PnlModificacionGrupos;
    private javax.swing.JPanel PnlModificacionProf;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlProfesor;
    private javax.swing.JPanel PnlRetiroAsignatura;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel avatar1;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearEst;
    private javax.swing.JButton btnCrearEst10;
    private javax.swing.JButton btnCrearEst11;
    private javax.swing.JButton btnCrearEst12;
    private javax.swing.JButton btnCrearEst13;
    private javax.swing.JButton btnCrearEst14;
    private javax.swing.JButton btnCrearEst15;
    private javax.swing.JButton btnCrearG;
    private javax.swing.JButton btnCrearProf;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEliminarEst;
    private javax.swing.JButton btnEliminarProf;
    private javax.swing.JButton btnEstudiantes;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton btnImportarFoto;
    private javax.swing.JButton btnModificacionEst;
    private javax.swing.JButton btnModificacionG;
    private javax.swing.JButton btnModificacionProf;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnRetiroG;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox21;
    private javax.swing.JComboBox<String> jComboBox22;
    private javax.swing.JComboBox<String> jComboBox23;
    private javax.swing.JComboBox<String> jComboBox24;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox30;
    private javax.swing.JComboBox<String> jComboBox31;
    private javax.swing.JComboBox<String> jComboBox32;
    private javax.swing.JComboBox<String> jComboBox33;
    private javax.swing.JComboBox<String> jComboBox35;
    private javax.swing.JComboBox<String> jComboBox36;
    private javax.swing.JComboBox<String> jComboBox37;
    private javax.swing.JComboBox<String> jComboBox39;
    private javax.swing.JComboBox<String> jComboBox41;
    private javax.swing.JComboBox<String> jComboBox42;
    private javax.swing.JComboBox<String> jComboBox43;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
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
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator57;
    private javax.swing.JSeparator jSeparator58;
    private javax.swing.JSeparator jSeparator59;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator60;
    private javax.swing.JSeparator jSeparator61;
    private javax.swing.JSeparator jSeparator62;
    private javax.swing.JSeparator jSeparator63;
    private javax.swing.JSeparator jSeparator64;
    private javax.swing.JSeparator jSeparator65;
    private javax.swing.JSeparator jSeparator66;
    private javax.swing.JSeparator jSeparator67;
    private javax.swing.JSeparator jSeparator68;
    private javax.swing.JSeparator jSeparator69;
    private javax.swing.JSeparator jSeparator70;
    private javax.swing.JSeparator jSeparator71;
    private javax.swing.JSeparator jSeparator72;
    private javax.swing.JSeparator jSeparator73;
    private javax.swing.JSeparator jSeparator74;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel marcoAvatar;
    // End of variables declaration//GEN-END:variables
}
