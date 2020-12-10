
package administrador;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import utilities.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import login.Contraseña3;
import login.Login;
import profesor.Profesor;
import sql.Conexion;

public final class adminPerfil extends javax.swing.JFrame {

    /**
     * Creates new form adminPerfil
     */
    private static int limp=0;
    private int id_pensum;
    private String cif_mp="-1";
    private DefaultTableModel tablag;
    
    public adminPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        ScaleImage.setScaleImage(avatar1, imagen);
        iconoFormulario();
        panelSelected();
        
        tablag= new DefaultTableModel();
        tablag.addColumn("ID_Tiempo");
        tablag.addColumn("Dia");
        tablag.addColumn("Hora");
        jtGrupo.setModel(tablag);
        
        cmbCarrera.setEnabled(false);
        agregarFacultades(cmbFacultad);
        agregarFacultades(cmbFacultadE);
        agregarFacultades(cmbFacultadP);
        agregarFacultades(cmbEliminarP);
        agregarFacultades(cmbFacultadA);
        agregarFacultades(cmbFacultadAR);
        agregarFacultades(cmbFacultadPC);
        agregarFacultades(cmbFacultadPB);
        agregarFacultades(cmbFacultadMP);
        agregarFacultades(cmbFacultadesMPN);
        agregarFacultades(cmbFacultadPS);
        agregarFacultades(cmbFacultadG);
        agregarFacultades(cmbFacultadGP);
        setCIF(id_max("CIF","PERSONAL"), lblCIF);
        setCIF(id_max("CIF","PERSONAL"), lblCifP);
        setCIF(id_max("ID_GRUPO", "GRUPO"), lblIDG);
        lblIDA.setText(id_max("ID_ASIGNATURA","ASIGNATURA")+"");
    }
    
    private void exeLimpiar(){
        txtNombreA.setText("");
        txtDescripcionA.setText("");
        lblIDA.setText(id_max("ID_ASIGNATURA","ASIGNATURA")+"");
        cmbSemestreA.setSelectedIndex(0);
        cmbFacultadA.setSelectedIndex(0);
        
        txtNombre.setText("");
        txtNombreP.setText("");
        txtApellido.setText("");
        txtApellidosP.setText("");
        txtCedula.setText("");
        txtCedulaP.setText("");
        txtDireccion.setText("");
        txtDireccionP.setText("");
        lblCIF.setText(id_max("CIF","PERSONAL") + "");
        lblCifP.setText(id_max("CIF","PERSONAL") + "");
        cmbFacultad.setSelectedIndex(0);
        cmbFacultadP.setSelectedIndex(0);

        if (cmbFacultad.getSelectedIndex() != 0) {
            cmbCarrera.setEnabled(true);
            String item = cmbFacultad.getSelectedItem().toString();
            consultaComboCarrera(item,cmbCarrera);
        } else {
            cmbCarrera.setEnabled(false);
        }
        
        jdtIngreso.setCalendar(null);
        jdtNacimientoP.setCalendar(null);
        jdtNacimiento.setCalendar(null);
        cmbCarrera.removeAllItems();
    }
    
    private int getID_CARRERA(){
        int id=0;
        try {
            Statement sql = Conexion.getConnection().createStatement();
            String consulta = "SELECT * FROM CARRERA WHERE NOMBRE_CARRERA='" + cmbCarrera.getSelectedItem().toString() + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            if(resultado.next()){
                id = resultado.getInt(1);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + " hola");
        }
        return id;
    }
    
    public static void agregarFacultades(JComboBox cmb){
        ArrayList<String> Lista = new ArrayList<>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT * FROM FACULTAD";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(1));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        cmb.addItem("Elegir Facultad");
        for(int i=0; i<Lista.size();i++){
            cmb.addItem(Lista.get(i));
        }
    }
    
    public void setCIF(int n_CIF, JLabel lbl){
        lbl.setText(n_CIF + "");
    }
    
    public int id_max (String atributo, String tabla){
        int id=1;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT MAX(" + atributo +") FROM " + tabla;
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                id = resultado.getInt(1) + 1;
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        return id;
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
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlAsignacion){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-asignacion.png"));
            btnAsignacion.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource ("/imagesEst/perfil.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlEstudiantes){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-estudiantes.png"));
            btnEstudiantes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlGrupos){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-grupos.png"));
            btnGrupos.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlProfesor){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-profesor.png"));
            btnProfesor.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlAjustes){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlCambioFotoPerfil){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        }else if(panelActual==PnlPensum){
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesAdmin/Neg-pensum.png"));
            btnPensum.setIcon(imagen);
            
            //Aqui es para que los demas botones esten grises
            btnAsignacion.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/asignacion.png")));
            btnGrupos.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/grupos.png")));
            btnEstudiantes.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/estudiantes.png")));
            btnProfesor.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/profesor.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        marcoAvatar = new javax.swing.JLabel();
        avatar = new javax.swing.JLabel();
        btnPerfil = new javax.swing.JButton();
        btnAsignacion = new javax.swing.JButton();
        btnGrupos = new javax.swing.JButton();
        btnEstudiantes = new javax.swing.JButton();
        btnProfesor = new javax.swing.JButton();
        btnPensum = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ParentPanel = new javax.swing.JPanel();
        PnlPerfil = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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
        jSeparator23 = new javax.swing.JSeparator();
        jLabel76 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel77 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel80 = new javax.swing.JLabel();
        btnCrearA = new javax.swing.JButton();
        cmbSemestreA = new javax.swing.JComboBox<>();
        cmbFacultadA = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JTextField();
        txtDescripcionA = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        lblIDA = new javax.swing.JLabel();
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
        jLabel82 = new javax.swing.JLabel();
        cmbFacultadAR = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        btnEliminarAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtElminarAR = new javax.swing.JTable();
        txtBuscarAR = new javax.swing.JTextField();
        btnBuscarAR = new javax.swing.JButton();
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
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        cmbFacultad = new javax.swing.JComboBox<>();
        cmbCarrera = new javax.swing.JComboBox<>();
        jdtNacimiento = new com.toedter.calendar.JDateChooser();
        jdtIngreso = new com.toedter.calendar.JDateChooser();
        lblCIF = new javax.swing.JLabel();
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
        cmbFacultadE = new javax.swing.JComboBox<>();
        jLabel155 = new javax.swing.JLabel();
        cmbCarreraE = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEliminar = new javax.swing.JTable();
        jLabel156 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        jLabel159 = new javax.swing.JLabel();
        jSeparator77 = new javax.swing.JSeparator();
        jLabel160 = new javax.swing.JLabel();
        jSeparator78 = new javax.swing.JSeparator();
        jLabel161 = new javax.swing.JLabel();
        jSeparator79 = new javax.swing.JSeparator();
        btnCrearProfesor = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jSeparator80 = new javax.swing.JSeparator();
        jLabel164 = new javax.swing.JLabel();
        cmbEstadoP = new javax.swing.JComboBox<>();
        txtNombreP = new javax.swing.JTextField();
        txtApellidosP = new javax.swing.JTextField();
        txtEspecialidadP = new javax.swing.JTextField();
        txtCedulaP = new javax.swing.JTextField();
        txtDireccionP = new javax.swing.JTextField();
        jdtNacimientoP = new com.toedter.calendar.JDateChooser();
        lblCifP = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbFacultadP = new javax.swing.JComboBox<>();
        jLabel139 = new javax.swing.JLabel();
        PnlModificacionProf = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jSeparator55 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        jSeparator56 = new javax.swing.JSeparator();
        jLabel129 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jSeparator58 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jSeparator60 = new javax.swing.JSeparator();
        btnGuardarCambiosMP = new javax.swing.JButton();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jSeparator61 = new javax.swing.JSeparator();
        jLabel136 = new javax.swing.JLabel();
        cmbEstadoMP = new javax.swing.JComboBox<>();
        txtNombreMP = new javax.swing.JTextField();
        txtEmailMP = new javax.swing.JTextField();
        txtEspecialidadMP = new javax.swing.JTextField();
        txtCedulaMP = new javax.swing.JTextField();
        txtDireccionMP = new javax.swing.JTextField();
        cmbFacultadMP = new javax.swing.JComboBox<>();
        cmbFacultadesMPN = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtProfesorM = new javax.swing.JTable();
        btnSeleccionarProfe = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jdtNacimientoMP = new com.toedter.calendar.JDateChooser();
        PnlEliminarProf = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        cmbEliminarP = new javax.swing.JComboBox<>();
        btnEliminarP = new javax.swing.JButton();
        jLabel158 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtEliminarP = new javax.swing.JTable();
        PnlGrupos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        btnCrearG = new javax.swing.JButton();
        btnModificacionG = new javax.swing.JButton();
        btnRetiroG = new javax.swing.JButton();
        ParentPanelGrupos = new javax.swing.JPanel();
        PnlCrearGrupos = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel86 = new javax.swing.JLabel();
        cmbFacultadG = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        cmbAsignaturaG = new javax.swing.JComboBox<>();
        btnCrearGrupo = new javax.swing.JButton();
        jLabel166 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        cmbSemestreG = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtGrupo = new javax.swing.JTable();
        cmbDia = new javax.swing.JComboBox<>();
        jsHoraI = new javax.swing.JSpinner();
        jsHoraF = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btnAgregarH = new javax.swing.JButton();
        jycAnio = new com.toedter.calendar.JYearChooser();
        lblIDG = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        cmbFacultadGP = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        cmbDocenteG = new javax.swing.JComboBox<>();
        PnlModificacionGrupos = new javax.swing.JPanel();
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
        jLabel169 = new javax.swing.JLabel();
        PnlEliminarGrupos = new javax.swing.JPanel();
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
        jLabel170 = new javax.swing.JLabel();
        PnlCambioFotoPerfil = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        avatar1 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btnSubirFoto = new javax.swing.JButton();
        btnGuardarFoto = new javax.swing.JButton();
        PnlPensum = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        ParentPanelPensum = new javax.swing.JPanel();
        cmbFacultadPC = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmbCarreraPC = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        btnCrearPensum = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        cmbSemestreP = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        cmbFacultadPB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtAsigNoIns = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtAsigIns = new javax.swing.JTable();
        btnPasarA = new javax.swing.JButton();
        cmbFacultadPS = new javax.swing.JComboBox<>();
        cmbCarreraPS = new javax.swing.JComboBox<>();
        btnEliminarPI = new javax.swing.JButton();
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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

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

        btnPensum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/pensum.png"))); // NOI18N
        btnPensum.setBorder(null);
        btnPensum.setBorderPainted(false);
        btnPensum.setContentAreaFilled(false);
        btnPensum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPensumMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPensumMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPensumMouseExited(evt);
            }
        });
        jPanel1.add(btnPensum, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 520, -1, -1));

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
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 580, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 640));

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
        PnlPerfil.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel4.setText("Cédula:");
        PnlPerfil.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));
        PnlPerfil.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 170, -1));
        PnlPerfil.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel5.setText("CIF:");
        PnlPerfil.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, -1, -1));
        PnlPerfil.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 200, -1));
        PnlPerfil.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel6.setText("Apellidos: ");
        PnlPerfil.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        PnlPerfil.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel7.setText("Fecha de nacimiento: ");
        PnlPerfil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel8.setText("Email:");
        PnlPerfil.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel9.setText("Dirección:");
        PnlPerfil.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));
        PnlPerfil.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 160, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

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
        PnlCrearAsignatura.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel76.setText("Descripción:");
        PnlCrearAsignatura.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));
        PnlCrearAsignatura.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel77.setText("Semestre:");
        PnlCrearAsignatura.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel79.setText("ID Asignatura:");
        PnlCrearAsignatura.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));
        PnlCrearAsignatura.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 120, 10));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel80.setText("Facultad:");
        PnlCrearAsignatura.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        btnCrearA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearAsignacion.png"))); // NOI18N
        btnCrearA.setBorder(null);
        btnCrearA.setBorderPainted(false);
        btnCrearA.setContentAreaFilled(false);
        btnCrearA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAActionPerformed(evt);
            }
        });
        PnlCrearAsignatura.add(btnCrearA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        cmbSemestreA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV", "Semestre V", "Semestre VI", "Semestre VII", "Semestre VIII", "Semestre IX", "Semestre X" }));
        PnlCrearAsignatura.add(cmbSemestreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 150, -1));

        cmbFacultadA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadAActionPerformed(evt);
            }
        });
        PnlCrearAsignatura.add(cmbFacultadA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 160, -1));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearAsignatura.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        txtNombreA.setBorder(null);
        PnlCrearAsignatura.add(txtNombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 30));

        txtDescripcionA.setBorder(null);
        PnlCrearAsignatura.add(txtDescripcionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 140, 30));

        jTextField8.setBorder(null);
        PnlCrearAsignatura.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 140, -1));

        lblIDA.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PnlCrearAsignatura.add(lblIDA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 120, 30));

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
        PnlCambioAsignatura.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, -1, -1));

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV" }));
        PnlCambioAsignatura.add(jComboBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, -1));

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlCambioAsignatura.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlCambioAsignatura.add(jComboBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 170, -1));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCambioAsignatura.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

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

        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel82.setText("Facultad");
        PnlRetiroAsignatura.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        cmbFacultadAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadARActionPerformed(evt);
            }
        });
        PnlRetiroAsignatura.add(cmbFacultadAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 170, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlRetiroAsignatura.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        btnEliminarAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnEliminarAR.setBorder(null);
        btnEliminarAR.setBorderPainted(false);
        btnEliminarAR.setContentAreaFilled(false);
        btnEliminarAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarARActionPerformed(evt);
            }
        });
        PnlRetiroAsignatura.add(btnEliminarAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jtElminarAR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ASIGNATURA", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(jtElminarAR);

        PnlRetiroAsignatura.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 400, 170));

        txtBuscarAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarARActionPerformed(evt);
            }
        });
        PnlRetiroAsignatura.add(txtBuscarAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 40));

        btnBuscarAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Lupa.png"))); // NOI18N
        btnBuscarAR.setBorderPainted(false);
        btnBuscarAR.setContentAreaFilled(false);
        btnBuscarAR.setFocusable(false);
        btnBuscarAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarARActionPerformed(evt);
            }
        });
        PnlRetiroAsignatura.add(btnBuscarAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 40, 40));

        ParentPanelAsignacion.add(PnlRetiroAsignatura, "card4");

        PnlAsignacion.add(ParentPanelAsignacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 147, 680, 460));

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

        PnlEstudiantes.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 150));

        ParentPanelEst.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelEst.setLayout(new java.awt.CardLayout());

        PnlCrearEst.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearEst.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel61.setText("Nombre:");
        PnlCrearEst.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));
        PnlCrearEst.add(jSeparator62, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel74.setText("Apellidos: ");
        PnlCrearEst.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        PnlCrearEst.add(jSeparator63, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));
        PnlCrearEst.add(jSeparator64, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 200, -1));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel138.setText("Fecha ingreso:");
        PnlCrearEst.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel140.setText("Email:");
        PnlCrearEst.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel141.setText("Cédula:");
        PnlCrearEst.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));
        PnlCrearEst.add(jSeparator65, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel142.setText("CIF:");
        PnlCrearEst.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));
        PnlCrearEst.add(jSeparator66, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 200, -1));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel143.setText("Dirección:");
        PnlCrearEst.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));
        PnlCrearEst.add(jSeparator67, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 160, -1));

        btnCrearEst12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnCrearEstudiante.png"))); // NOI18N
        btnCrearEst12.setBorder(null);
        btnCrearEst12.setBorderPainted(false);
        btnCrearEst12.setContentAreaFilled(false);
        btnCrearEst12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEst12ActionPerformed(evt);
            }
        });
        PnlCrearEst.add(btnCrearEst12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearEst.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        txtApellido.setBorder(null);
        PnlCrearEst.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 170, 20));

        txtDireccion.setBorder(null);
        PnlCrearEst.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 160, 20));

        txtNombre.setAutoscrolls(false);
        txtNombre.setBorder(null);
        PnlCrearEst.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, 20));

        jTextField42.setBorder(null);
        PnlCrearEst.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 210, -1));

        txtCedula.setBorder(null);
        PnlCrearEst.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, 20));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel49.setText("Carrera:");
        PnlCrearEst.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel50.setText("Facultad:");
        PnlCrearEst.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 90, -1));

        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel165.setText("Fecha de nacimiento: ");
        PnlCrearEst.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        cmbFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadActionPerformed(evt);
            }
        });
        PnlCrearEst.add(cmbFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 190, 30));

        PnlCrearEst.add(cmbCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 170, 30));

        jdtNacimiento.setDateFormatString("dd/MM/yyyy");
        PnlCrearEst.add(jdtNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        jdtIngreso.setDateFormatString("dd/MM/yyyy");
        PnlCrearEst.add(jdtIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));
        PnlCrearEst.add(lblCIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 190, 20));

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
        PnlModificacionEst.add(btnCrearEst13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionEst.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

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
        PnlEliminarEst.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        cmbFacultadE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadEActionPerformed(evt);
            }
        });
        PnlEliminarEst.add(cmbFacultadE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 170, -1));

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel155.setText("Carrera");
        PnlEliminarEst.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        cmbCarreraE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraEActionPerformed(evt);
            }
        });
        PnlEliminarEst.add(cmbCarreraE, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 170, -1));

        jtEliminar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre", "Cedula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtEliminar);

        PnlEliminarEst.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 320, 140));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarEst.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/EliminarEst.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PnlEliminarEst.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));
        PnlEliminarEst.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 220, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Lupa.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PnlEliminarEst.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 36, 40, 40));

        ParentPanelEst.add(PnlEliminarEst, "card4");

        PnlEstudiantes.add(ParentPanelEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 680, 450));

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
        PnlCrearProf.add(jSeparator74, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, 10));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel98.setText("Apellidos: ");
        PnlCrearProf.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        PnlCrearProf.add(jSeparator75, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, 10));

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

        btnCrearProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/btnCrearProf.png"))); // NOI18N
        btnCrearProfesor.setBorder(null);
        btnCrearProfesor.setBorderPainted(false);
        btnCrearProfesor.setContentAreaFilled(false);
        btnCrearProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProfesorActionPerformed(evt);
            }
        });
        PnlCrearProf.add(btnCrearProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearProf.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel163.setText("Especialidad:");
        PnlCrearProf.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        PnlCrearProf.add(jSeparator80, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 150, 10));

        jLabel164.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel164.setText("Estado:");
        PnlCrearProf.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        cmbEstadoP.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        cmbEstadoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        PnlCrearProf.add(cmbEstadoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, 150, -1));

        txtNombreP.setBorder(null);
        PnlCrearProf.add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, -1));

        txtApellidosP.setBorder(null);
        PnlCrearProf.add(txtApellidosP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, -1));

        txtEspecialidadP.setBorder(null);
        PnlCrearProf.add(txtEspecialidadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 150, -1));

        txtCedulaP.setBorder(null);
        PnlCrearProf.add(txtCedulaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));

        txtDireccionP.setBorder(null);
        PnlCrearProf.add(txtDireccionP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 160, -1));

        jdtNacimientoP.setDateFormatString("dd/MM/yyyy");
        PnlCrearProf.add(jdtNacimientoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 90, -1));
        PnlCrearProf.add(lblCifP, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 190, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel13.setText("Facultad: ");
        PnlCrearProf.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        cmbFacultadP.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        PnlCrearProf.add(cmbFacultadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 170, -1));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel139.setText("Fecha de nacimiento: ");
        PnlCrearProf.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        ParentPanelProf.add(PnlCrearProf, "card4");

        PnlModificacionProf.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificacionProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel58.setText("Nombre:");
        PnlModificacionProf.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        PnlModificacionProf.add(jSeparator55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel73.setText("Email:");
        PnlModificacionProf.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));
        PnlModificacionProf.add(jSeparator56, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 190, 10));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel129.setText("Fecha de nacimiento: ");
        PnlModificacionProf.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel131.setText("Cédula:");
        PnlModificacionProf.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));
        PnlModificacionProf.add(jSeparator58, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 170, -1));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel132.setText("Facultad: ");
        PnlModificacionProf.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel133.setText("Dirección:");
        PnlModificacionProf.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));
        PnlModificacionProf.add(jSeparator60, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 160, -1));

        btnGuardarCambiosMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnGuardarCambiosMP.setBorder(null);
        btnGuardarCambiosMP.setBorderPainted(false);
        btnGuardarCambiosMP.setContentAreaFilled(false);
        btnGuardarCambiosMP.setEnabled(false);
        btnGuardarCambiosMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosMPActionPerformed(evt);
            }
        });
        PnlModificacionProf.add(btnGuardarCambiosMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionProf.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel135.setText("Especialidad:");
        PnlModificacionProf.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));
        PnlModificacionProf.add(jSeparator61, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 130, -1));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel136.setText("Estado:");
        PnlModificacionProf.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        cmbEstadoMP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVO", "INACTIVO" }));
        cmbEstadoMP.setEnabled(false);
        PnlModificacionProf.add(cmbEstadoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 150, -1));

        txtNombreMP.setBorder(null);
        txtNombreMP.setEnabled(false);
        PnlModificacionProf.add(txtNombreMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 20));

        txtEmailMP.setBorder(null);
        txtEmailMP.setEnabled(false);
        PnlModificacionProf.add(txtEmailMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, 20));

        txtEspecialidadMP.setBorder(null);
        txtEspecialidadMP.setEnabled(false);
        PnlModificacionProf.add(txtEspecialidadMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, 20));

        txtCedulaMP.setBorder(null);
        txtCedulaMP.setEnabled(false);
        PnlModificacionProf.add(txtCedulaMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 170, 20));

        txtDireccionMP.setBorder(null);
        txtDireccionMP.setEnabled(false);
        PnlModificacionProf.add(txtDireccionMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 160, 20));

        cmbFacultadMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadMPActionPerformed(evt);
            }
        });
        PnlModificacionProf.add(cmbFacultadMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 120, -1));

        cmbFacultadesMPN.setEnabled(false);
        PnlModificacionProf.add(cmbFacultadesMPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 160, -1));

        jtProfesorM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre"
            }
        ));
        jScrollPane6.setViewportView(jtProfesorM);

        PnlModificacionProf.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 210, 100));

        btnSeleccionarProfe.setText("Seleccionar");
        btnSeleccionarProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProfeActionPerformed(evt);
            }
        });
        PnlModificacionProf.add(btnSeleccionarProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setText("Facultad");
        PnlModificacionProf.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jdtNacimientoMP.setDateFormatString("dd/MM/yyyy");
        jdtNacimientoMP.setEnabled(false);
        PnlModificacionProf.add(jdtNacimientoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 80, -1));

        ParentPanelProf.add(PnlModificacionProf, "card2");

        PnlEliminarProf.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarProf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel157.setText("Facultad");
        PnlEliminarProf.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        cmbEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEliminarPActionPerformed(evt);
            }
        });
        PnlEliminarProf.add(cmbEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, -1));

        btnEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnEliminarP.setBorder(null);
        btnEliminarP.setBorderPainted(false);
        btnEliminarP.setContentAreaFilled(false);
        btnEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPActionPerformed(evt);
            }
        });
        PnlEliminarProf.add(btnEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarProf.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jtEliminarP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre", "Cedula", "Especialidad"
            }
        ));
        jScrollPane5.setViewportView(jtEliminarP);

        PnlEliminarProf.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 380, 180));

        ParentPanelProf.add(PnlEliminarProf, "card3");

        PnlProfesor.add(ParentPanelProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 680, 460));

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
        ParentPanelGrupos.setLayout(new java.awt.CardLayout());

        PnlCrearGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearGrupos.setMinimumSize(new java.awt.Dimension(676, 506));
        PnlCrearGrupos.setPreferredSize(new java.awt.Dimension(676, 506));
        PnlCrearGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel37.setText("Año:");
        PnlCrearGrupos.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));
        PnlCrearGrupos.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 170, -1));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel86.setText("Docente:");
        PnlCrearGrupos.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        cmbFacultadG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadGActionPerformed(evt);
            }
        });
        PnlCrearGrupos.add(cmbFacultadG, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 190, -1));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel88.setText("Asignatura:");
        PnlCrearGrupos.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        cmbAsignaturaG.setEnabled(false);
        cmbAsignaturaG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsignaturaGActionPerformed(evt);
            }
        });
        PnlCrearGrupos.add(cmbAsignaturaG, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 190, -1));

        btnCrearGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/CrearGrupo.png"))); // NOI18N
        btnCrearGrupo.setBorder(null);
        btnCrearGrupo.setBorderPainted(false);
        btnCrearGrupo.setContentAreaFilled(false);
        btnCrearGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGrupoActionPerformed(evt);
            }
        });
        PnlCrearGrupos.add(btnCrearGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, -1, -1));

        jLabel166.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearGrupos.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 540, -1, -1));

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearGrupos.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        cmbSemestreG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II" }));
        cmbSemestreG.setEnabled(false);
        PnlCrearGrupos.add(cmbSemestreG, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 170, -1));

        jtGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Tiempo", "Dia", "Hora"
            }
        ));
        jScrollPane7.setViewportView(jtGrupo);

        PnlCrearGrupos.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 240, 100));

        cmbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO" }));
        cmbDia.setEnabled(false);
        PnlCrearGrupos.add(cmbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 170, -1));

        jsHoraI.setModel(new javax.swing.SpinnerNumberModel(7, 1, 23, 1));
        jsHoraI.setEnabled(false);
        PnlCrearGrupos.add(jsHoraI, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 50, 30));

        jsHoraF.setModel(new javax.swing.SpinnerNumberModel(9, 1, 23, 1));
        jsHoraF.setEnabled(false);
        PnlCrearGrupos.add(jsHoraF, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 50, 30));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Dia:");
        PnlCrearGrupos.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, 20));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setText("Fin:");
        PnlCrearGrupos.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 323, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setText("Hora");
        PnlCrearGrupos.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setText("Hora");
        PnlCrearGrupos.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, -1, -1));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel51.setText("Inicio:");
        PnlCrearGrupos.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 323, -1, -1));

        btnAgregarH.setText("Agregar");
        btnAgregarH.setEnabled(false);
        btnAgregarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHActionPerformed(evt);
            }
        });
        PnlCrearGrupos.add(btnAgregarH, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, -1, -1));

        jycAnio.setEnabled(false);
        PnlCrearGrupos.add(jycAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));
        PnlCrearGrupos.add(lblIDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 140, 20));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel53.setText("ID Grupo:");
        PnlCrearGrupos.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel54.setText("Semestre:");
        PnlCrearGrupos.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, -1, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel87.setText("Facultad:");
        PnlCrearGrupos.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        cmbFacultadGP.setEnabled(false);
        cmbFacultadGP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadGPActionPerformed(evt);
            }
        });
        PnlCrearGrupos.add(cmbFacultadGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, -1));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel89.setText("Facultad:");
        PnlCrearGrupos.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        cmbDocenteG.setEnabled(false);
        PnlCrearGrupos.add(cmbDocenteG, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, -1));

        ParentPanelGrupos.add(PnlCrearGrupos, "card2");

        PnlModificacionGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificacionGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PnlModificacionGrupos.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jTextField3.setBorder(null);
        PnlModificacionGrupos.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));

        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificacionGrupos.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        ParentPanelGrupos.add(PnlModificacionGrupos, "card3");

        PnlEliminarGrupos.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarGrupos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        PnlEliminarGrupos.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jComboBox35.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingenieria y Arquitectura", "Medicina", "Administración" }));
        PnlEliminarGrupos.add(jComboBox35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel95.setText("Carrera:");
        PnlEliminarGrupos.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jComboBox36.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economía", "Ingeniería Civil", "Computación", "Diseño" }));
        PnlEliminarGrupos.add(jComboBox36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 170, -1));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel96.setText("Asignatura:");
        PnlEliminarGrupos.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        jComboBox37.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Análisis Vectorial", "Base de Datos", "Calculo II" }));
        PnlEliminarGrupos.add(jComboBox37, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 170, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        PnlEliminarGrupos.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel97.setText("Grupo:");
        PnlEliminarGrupos.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        jComboBox39.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grupo 1", "Grupo 2", "Grupo 3" }));
        PnlEliminarGrupos.add(jComboBox39, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 170, -1));

        jTextField4.setBorder(null);
        PnlEliminarGrupos.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 170, -1));

        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarGrupos.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, -1, -1));

        ParentPanelGrupos.add(PnlEliminarGrupos, "card4");

        PnlGrupos.add(ParentPanelGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 680, 470));

        ParentPanel.add(PnlGrupos, "card8");

        PnlCambioFotoPerfil.setBackground(new java.awt.Color(255, 255, 255));
        PnlCambioFotoPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel32.setText("Cambiar Foto de Perfil");
        PnlCambioFotoPerfil.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        avatar1.setMaximumSize(new java.awt.Dimension(102, 102));
        avatar1.setMinimumSize(new java.awt.Dimension(102, 102));
        avatar1.setPreferredSize(new java.awt.Dimension(102, 102));
        PnlCambioFotoPerfil.add(avatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 220, 220));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCambioFotoPerfil.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

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

        ParentPanel.add(PnlCambioFotoPerfil, "card9");

        PnlPensum.setBackground(new java.awt.Color(255, 255, 255));
        PnlPensum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel14.setText("Pensum");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        PnlPensum.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 80));

        ParentPanelPensum.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelPensum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbFacultadPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadPCActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbFacultadPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Facultad");
        ParentPanelPensum.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        cmbCarreraPC.setEnabled(false);
        cmbCarreraPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraPCActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbCarreraPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 160, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Carrera");
        ParentPanelPensum.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        btnCrearPensum.setText("Crear pensum");
        btnCrearPensum.setEnabled(false);
        btnCrearPensum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPensumActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(btnCrearPensum, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 130, 40));

        jLabel33.setText("Seleccionar Semestre:");
        ParentPanelPensum.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        cmbSemestreP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semestre I", "Semestre II", "Semestre III", "Semestre IV", "Semestre V", "Semestre VI", "Semestre VII", "Semestre VIII", "Semestre IX", "Semestre X" }));
        cmbSemestreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSemestrePActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbSemestreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 120, 40));

        jLabel34.setText("Seleccionar Asignatura");
        ParentPanelPensum.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        cmbFacultadPB.setEnabled(false);
        cmbFacultadPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadPBActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbFacultadPB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 140, -1));

        jtAsigNoIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ASIGNATURA", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(jtAsigNoIns);

        ParentPanelPensum.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 220, 130));

        jtAsigIns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_ASIGNATURA", "Nombre"
            }
        ));
        jScrollPane3.setViewportView(jtAsigIns);

        ParentPanelPensum.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 230, 130));

        btnPasarA.setText("->");
        btnPasarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarAActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(btnPasarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        cmbFacultadPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadPSActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbFacultadPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, -1));

        cmbCarreraPS.setEnabled(false);
        cmbCarreraPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarreraPSActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(cmbCarreraPS, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 130, -1));

        btnEliminarPI.setText("Eliminar");
        btnEliminarPI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPIActionPerformed(evt);
            }
        });
        ParentPanelPensum.add(btnEliminarPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        PnlPensum.add(ParentPanelPensum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 680, 520));

        ParentPanel.add(PnlPensum, "card9");

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
        PnlAjustes.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 540, -1, -1));

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

        getContentPane().add(ParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 680, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        this.dispose();
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

    private void btnPensumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPensumMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlPensum);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnPensumMouseClicked

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

    private void btnPensumMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPensumMouseEntered
        btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/Neg-pensum.png")));
    }//GEN-LAST:event_btnPensumMouseEntered

    private void btnPensumMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPensumMouseExited
        btnPensum.setIcon(new ImageIcon(getClass().getResource("/imagesAdmin/pensum.png")));
        panelSelected();
    }//GEN-LAST:event_btnPensumMouseExited

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
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseExited

    private void btnEditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseEntered
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar2MouseEntered

    private void btnEditar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar1MouseExited
        btnEditar1.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
        panelSelected();
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

    private void btnEditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlCambioFotoPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseClicked
    
    private BufferedImage bi;
    private int contador=0;
    
    private void btnSubirFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubirFotoMouseClicked

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
    
            }
        }
    }//GEN-LAST:event_btnGuardarFotoMouseClicked

    private void cmbFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadActionPerformed
        if(cmbFacultad.getSelectedIndex()!=0){
            cmbCarrera.setEnabled(true);
            String item = cmbFacultad.getSelectedItem().toString();
            consultaComboCarrera(item,cmbCarrera);
        }else{
            cmbCarrera.removeAllItems();
            cmbCarrera.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacultadActionPerformed

    private void btnCrearEst12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEst12ActionPerformed
        //Aqui extraemos las fechas de los JDateChooser
        Date nacimiento = jdtNacimiento.getDate();
        Date ingreso = jdtIngreso.getDate();
        
        //Aqui validamos que todo los campos esten llenos
        if((!txtNombre.getText().equals("") && (!txtApellido.getText().equals("")) && (!txtCedula.getText().equals("")) && (!txtDireccion.getText().equals("")) && (cmbFacultad.getSelectedIndex()!=0) && (cmbCarrera.getSelectedIndex()!=0)) && (nacimiento!= null) && (ingreso!=null)){
            long dn = nacimiento.getTime();
            long di = ingreso.getTime();
            
            //Aqui convertimos las Date de Java a Date de SQL
            java.sql.Date snacimiento = new java.sql.Date(dn);
            java.sql.Date singreso = new java.sql.Date(di);
            
            //Aqui creamos objetos de tipo Alumno
            alumno.Alumno est = new alumno.Alumno(id_max("CIF","PERSONAL"), cmbFacultad.getSelectedItem().toString(), (txtNombre.getText() + " " + txtApellido.getText()), txtCedula.getText(), txtDireccion.getText(), snacimiento, singreso, getID_CARRERA());
            GuardarEst ventanaE = new GuardarEst(est);
            ventanaE.setVisible(true);
            exeLimpiar();
        }else{
            JOptionPane.showMessageDialog(null, "LLene todo los campos");
        }
    }//GEN-LAST:event_btnCrearEst12ActionPerformed

    private void cmbFacultadEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadEActionPerformed
        if(cmbFacultadE.getSelectedIndex()!=0){
            consultaTabla(cmbFacultadE);
            cmbCarreraE.setEnabled(true);
            String item = cmbFacultadE.getSelectedItem().toString();
            consultaComboCarrera(item,cmbCarreraE);
        }else{
            cmbCarreraE.removeAllItems();
            cmbCarreraE.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacultadEActionPerformed

    private void cmbCarreraEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraEActionPerformed
        if(cmbCarreraE.getSelectedIndex()!=0){
            consultaTabla(cmbFacultadE, cmbCarreraE);
        }
    }//GEN-LAST:event_cmbCarreraEActionPerformed

    private void btnCrearProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProfesorActionPerformed
        if((!txtNombreP.getText().equals("")) && (!txtApellidosP.getText().equals("")) && (!txtCedulaP.getText().equals("")) && (!txtDireccionP.getText().equals("")) && (!txtEspecialidadP.getText().equals("")) && (jdtNacimientoP!=null) && (cmbFacultadP.getSelectedIndex()!=0)){
            Date nacimientoP = jdtNacimientoP.getDate();
            
            long dnP = nacimientoP.getTime();
            //Aqui convertimos las Date de Java a Date de SQL
            java.sql.Date snacimientoP = new java.sql.Date(dnP);
            
            System.out.println(cmbEstadoP.getSelectedItem().toString());
            Profesor profe = new Profesor(id_max("CIF","PERSONAL"), cmbFacultadP.getSelectedItem().toString(), txtNombreP.getText() + " " + txtApellidosP.getText(), txtCedulaP.getText(), txtDireccionP.getText(), snacimientoP, txtEspecialidadP.getText(), cmbEstadoP.getSelectedItem().toString());
            GuardarEst ventana = new GuardarEst(profe);
            ventana.setVisible(true);
            exeLimpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_btnCrearProfesorActionPerformed

    private void cmbEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEliminarPActionPerformed
        if(cmbEliminarP.getSelectedIndex()!=0){
            consultaTabla(cmbEliminarP, 1);
        }else{
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarP.setModel(model);
        }
    }//GEN-LAST:event_cmbEliminarPActionPerformed

    private void btnEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPActionPerformed
        int row=jtEliminarP.getSelectedRow();
        String cif = jtEliminarP.getModel().getValueAt(row, 0).toString();
        
        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE PERSONAL WHERE CIF=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha elminado correctamente");
            jtEliminarP.removeAll();
            cmbEliminarP.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarPActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row=jtEliminar.getSelectedRow();
        String cif = jtEliminar.getModel().getValueAt(row, 0).toString();

        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE PERSONAL WHERE CIF=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha elminado correctamente");
            jtEliminar.removeAll();
            cmbCarreraE.removeAllItems();
            cmbCarreraE.setEnabled(false);
            cmbFacultadE.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbFacultadAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadAActionPerformed

    }//GEN-LAST:event_cmbFacultadAActionPerformed

    private void btnCrearAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAActionPerformed
        if ((!txtNombreA.getText().equals("")) && (!txtDescripcionA.getText().equals("")) && (cmbFacultadA.getSelectedIndex() != 0) && (cmbCarrera.getSelectedIndex() != 0)) {

            try {
                String consulta = "INSERT INTO ASIGNATURA VALUES(" + id_max("ID_ASIGNATURA","ASIGNATURA") + ",'" + cmbFacultadA.getSelectedItem().toString() + "','" + txtNombreA.getText() + "','" + txtDescripcionA.getText() + "','" + cmbSemestreA.getSelectedItem().toString() +"')";

                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "La asignatura se ha creado correctamente");
                exeLimpiar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_btnCrearAActionPerformed

    private void cmbFacultadARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadARActionPerformed
        if(cmbFacultadAR.getSelectedIndex()!=0){
            String item = cmbFacultadAR.getSelectedItem().toString();
            consultaTablaAR(1);
        }
    }//GEN-LAST:event_cmbFacultadARActionPerformed

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnEliminarARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarARActionPerformed
        int row=jtElminarAR.getSelectedRow();
        String cif = jtElminarAR.getModel().getValueAt(row, 0).toString();

        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE ASIGNATURA WHERE ID_ASIGNATURA=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha elminado correctamente");
            jtElminarAR.removeAll();
            cmbFacultadAR.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarARActionPerformed

    private void txtBuscarARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarARActionPerformed

    private void btnBuscarARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarARActionPerformed
        consultarTablaAR(txtBuscarAR.getText());
    }//GEN-LAST:event_btnBuscarARActionPerformed

    private void cmbFacultadPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadPCActionPerformed
        if(cmbFacultadPC.getSelectedIndex()!=0){
            cmbCarreraPC.setEnabled(true);
            consultaComboCarreraPC(cmbFacultadPC.getSelectedItem().toString());
        }else{
            cmbCarreraPC.setEnabled(false);
            cmbCarreraPC.removeAllItems();
        }
    }//GEN-LAST:event_cmbFacultadPCActionPerformed

    private void cmbCarreraPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraPCActionPerformed
        if(cmbFacultadPC.getSelectedIndex()!=0  && cmbCarreraPC.getSelectedIndex()!=0){
            btnCrearPensum.setEnabled(true);
        }
    }//GEN-LAST:event_cmbCarreraPCActionPerformed

    private void btnCrearPensumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPensumActionPerformed
        try {
            int id_pensum = id_max("ID_PENSUM", "PENSUM");
            String consulta = "INSERT INTO PENSUM VALUES(" + id_pensum +",'" + cmbFacultadPC.getSelectedItem().toString()+"'," + getIDCarrera(cmbCarreraPC.getSelectedItem().toString(), cmbFacultadPC.getSelectedItem().toString()) +")";

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pensum de la carrera de " + cmbCarreraPC.getSelectedItem().toString() + ", ha sido creado correctamente");
            cmbCarreraPC.removeAllItems();;
            cmbFacultadPC.setSelectedIndex(0);
            cmbCarreraPC.setEnabled(false);
            btnCrearPensum.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnCrearPensumActionPerformed


    private void cmbFacultadPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadPBActionPerformed
        if(cmbFacultadPB.getSelectedIndex()!=0){
            consultaTablaPB(cmbFacultadPB);
        }else{
            jtAsigNoIns.removeAll();
        }
    }//GEN-LAST:event_cmbFacultadPBActionPerformed

    private void consultaTablaPB(JComboBox cmb){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtAsigNoIns.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.ID_ASIGNATURA, A.NOMBRE FROM ASIGNATURA_PENSUM AS AP RIGHT JOIN ASIGNATURA AS A ON AP.ID_ASIGNATURA=A.ID_ASIGNATURA WHERE AP.ID_ASIGNATURA IS NULL AND A.COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("ID_Asignatura");
            model.addColumn("Nombre");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private void cmbFacultadPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadPSActionPerformed
        if(cmbFacultadPS.getSelectedIndex()!=0){
            cmbCarreraPS.setEnabled(true);
            consultaComboCarreraPS(cmbFacultadPS.getSelectedItem().toString());
            
        }else{
            cmbCarreraPS.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacultadPSActionPerformed

    private void cmbCarreraPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarreraPSActionPerformed
        if(cmbCarreraPS.getSelectedIndex()!=0){
            cmbFacultadPB.setEnabled(true);
            setID_PENSUM(cmbCarreraPS.getSelectedItem().toString());
            consultaTablaPI();
        }else{
            cmbFacultadPB.setEnabled(false);
        }
    }//GEN-LAST:event_cmbCarreraPSActionPerformed

    private void btnPasarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarAActionPerformed
        int row = jtAsigNoIns.getSelectedRow();
        String id_asignatura = jtAsigNoIns.getModel().getValueAt(row, 0).toString();

        if (jtAsigNoIns.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione una asignatura");
        } else {
            try {
                String consulta = "INSERT INTO ASIGNATURA_PENSUM VALUES(" +id_asignatura+","+id_pensum+",'" +cmbSemestreP.getSelectedItem().toString()+"')";

                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "La asignatura se ha asignado correctamente");
                consultaTablaPI();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }//GEN-LAST:event_btnPasarAActionPerformed

    private void cmbSemestrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSemestrePActionPerformed
        consultaTablaPI();
    }//GEN-LAST:event_cmbSemestrePActionPerformed

    private void btnEliminarPIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPIActionPerformed
        if(jtAsigIns.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }else{
            int row = jtAsigIns.getSelectedRow();
            String id_delete = jtAsigIns.getModel().getValueAt(row, 0).toString();
            
            try {
                String consulta = "DELETE FROM ASIGNATURA_PENSUM WHERE ID_PENSUM=" + id_delete;
                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

                sql.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "La asignatura se ha eliminado correctamente");
                consultaTablaPI();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnEliminarPIActionPerformed

    private void cmbFacultadMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadMPActionPerformed
        if(cmbFacultadMP.getSelectedIndex()!=0){
            try {
            DefaultTableModel model = new DefaultTableModel();
            jtProfesorM.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.CIF, P.NOMBRE FROM PERSONAL AS P INNER JOIN DOCENTE AS D ON P.CIF=D.ID_DOCENTE";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("CIF");
            model.addColumn("Nombre");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        }
    }//GEN-LAST:event_cmbFacultadMPActionPerformed

    private void btnSeleccionarProfeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProfeActionPerformed
        if(jtProfesorM.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }else{
            int row = jtProfesorM.getSelectedRow();
            cif_mp = jtProfesorM.getModel().getValueAt(row, 0).toString();
            
            rellenarMP(0,cif_mp);
            rellenarMP(1,cif_mp);  
        }
    }//GEN-LAST:event_btnSeleccionarProfeActionPerformed

    private void btnGuardarCambiosMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMPActionPerformed
        boolean personal=false, docente=false;
        
        try {
            java.util.Date df = jdtNacimientoMP.getDate();
            
            long b = df.getTime();
            
            java.sql.Date fecha = new java.sql.Date(b);
            
            String consulta = "UPDATE PERSONAL SET NOMBRE='" + txtNombreMP.getText() + "', COD_FACULTAD='" + cmbFacultadesMPN.getSelectedItem().toString() + "', CEDULA='" + txtCedulaMP.getText() + "', DIRECCION='" + txtDireccionMP.getText() +"', EMAIL_INSTITUCION='" + txtEmailMP.getText() + "', FECHA_NACIMIENTO='" + fecha + "' WHERE CIF=" + cif_mp;

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            personal = true;
            consultaTablaPI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        try {
            java.util.Date df = jdtNacimientoMP.getDate();
            
            long b = df.getTime();
            
            java.sql.Date fecha = new java.sql.Date(b);
            
            String consulta = "UPDATE DOCENTE SET ESTADO='" + cmbEstadoMP.getSelectedItem().toString()+ "', ESPECIALIDAD='" + txtEspecialidadMP.getText() + "' WHERE ID_DOCENTE=" + cif_mp;

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            docente = true;
            consultaTablaPI();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        if(docente && personal){
            JOptionPane.showMessageDialog(null, "Se han realizado los cambios correctamente");
            rellenarMP(1, cif_mp);
        }else{
            JOptionPane.showMessageDialog(null, "Error!!!");
        }
    }//GEN-LAST:event_btnGuardarCambiosMPActionPerformed

    private void cmbFacultadGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadGActionPerformed
        if(cmbFacultadG.getSelectedIndex()!=0){
            cmbAsignaturaG.setEnabled(true);
            llenarAsignaturaG(cmbAsignaturaG, cmbFacultadG.getSelectedItem().toString());
        }else{
            DefaultComboBoxModel d=(DefaultComboBoxModel) cmbAsignaturaG.getModel();
            d.removeAllElements();
            cmbAsignaturaG.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacultadGActionPerformed
    
    private int getTiempoID(String dia, int hora){
        int id_t=0;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT T.ID_TIEMPO FROM TIEMPO_EJECUCION AS T WHERE T.DIA='" + dia + "' AND T.HORA=" + hora;
            ResultSet resultado = sql.executeQuery(consulta);
            

            while (resultado.next()) {                
                id_t=resultado.getInt(1);
            }
                        

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() +"Hola");
        }
        
        return id_t;
    }
    private void cmbAsignaturaGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsignaturaGActionPerformed
        if(cmbAsignaturaG.getSelectedIndex()!=0){
            cmbSemestreG.setEnabled(true);
            jycAnio.setEnabled(true);
            cmbDia.setEnabled(true);
            jsHoraI.setEnabled(true);
            jsHoraF.setEnabled(true);
            btnAgregarH.setEnabled(true);
            cmbFacultadGP.setEnabled(true);
        }else{
            cmbSemestreG.setEnabled(false);
            jycAnio.setEnabled(false);
            cmbDia.setEnabled(false);
            jsHoraI.setEnabled(false);
            jsHoraF.setEnabled(false);
            btnAgregarH.setEnabled(false);
            cmbFacultadGP.setEnabled(false);
            cmbDocenteG.setEnabled(false);
        }
    }//GEN-LAST:event_cmbAsignaturaGActionPerformed

    private void btnAgregarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHActionPerformed
        
        int horaInicio=(Integer)jsHoraI.getValue();
        int horaFin=(Integer)jsHoraF.getValue();
        
        if(horaInicio<horaFin){
            int cant = horaFin-horaInicio;
            int id_tiempo = getTiempoID(cmbDia.getSelectedItem().toString(), horaInicio);
            
            String info[] = new String[3];
            id_tiempo--;
            horaInicio--;
            for(int i=0;i<cant+1;i++){
                id_tiempo++;
                horaInicio++;
                info[0]=id_tiempo+"";
                info[1]=cmbDia.getSelectedItem().toString();
                info[2] = horaInicio+"";
                tablag.addRow(info);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Error al seleccionar la hora");
        }
    }//GEN-LAST:event_btnAgregarHActionPerformed

    private void cmbFacultadGPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadGPActionPerformed
        if(cmbFacultadGP.getSelectedIndex()!=0){
            cmbDocenteG.setEnabled(true);
            getDocentes(cmbDocenteG, cmbFacultadGP.getSelectedItem().toString());
        }else{
            cmbDocenteG.setEnabled(false);
        }
    }//GEN-LAST:event_cmbFacultadGPActionPerformed

    private int getID_Docente(String name){
        int id_doc=0;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT D.ID_DOCENTE FROM PERSONAL AS P INNER JOIN DOCENTE AS D ON P.CIF=D.ID_DOCENTE WHERE P.NOMBRE='" + name + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                id_doc=resultado.getInt(1);
            }
        } catch (Exception e) {
        }
        return id_doc;
    }
    
    private int getID_Asignatura(String name){
        int id_doc=0;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.ID_ASIGNATURA FROM ASIGNATURA AS A WHERE A.NOMBRE='" + name + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                id_doc=resultado.getInt(1);
            }
        } catch (Exception e) {
        }
        return id_doc;
    }
    private void btnCrearGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGrupoActionPerformed
        boolean grupob=false, relacion=false;
        int id_gr =id_max("ID_GRUPO", "GRUPO");
        
        try {
            String consulta = "INSERT INTO GRUPO VALUES(" + id_max("ID_GRUPO", "GRUPO") + "," + getID_Asignatura(cmbAsignaturaG.getSelectedItem().toString()) + ",'" + "ACTIVO" + "','" + cmbSemestreG.getSelectedItem().toString() + "','" + jycAnio.getValue() + "'," + getID_Docente(cmbDocenteG.getSelectedItem().toString()) + ")";

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            grupob =true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "123");
        }
        try {
            
            int cant = jtGrupo.getRowCount();
            String num,consulta;
            
            for (int i=0;i<cant;i++){
                num = jtGrupo.getValueAt(i, 0).toString();
                
                consulta = "INSERT INTO TIEMPO_EJECUCION_GRUPO VALUES(" + num + "," + id_gr + ")";
                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);
                sql.executeUpdate();
            }
            relacion =true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        if(grupob && relacion){
            JOptionPane.showMessageDialog(null, "Grupo creado correctamente");
            for(int i=0; i<jtGrupo.getRowCount();i++){
                tablag.removeRow(i);
            }
            cmbFacultadG.setSelectedIndex(0);
            cmbAsignaturaG.setEnabled(false);
            cmbFacultadGP.setEnabled(false);
            cmbDocenteG.setEnabled(false);
            cmbSemestreG.setEnabled(false);
            jycAnio.setEnabled(false);
            cmbDia.setEnabled(false);
            btnAgregarH.setEnabled(false);
            jsHoraF.setEnabled(false);
            jsHoraI.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnCrearGrupoActionPerformed
    private void getDocentes(JComboBox cmb, String item){
        ArrayList<String> Lista = new ArrayList<String>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.NOMBRE FROM DOCENTE AS D INNER JOIN PERSONAL AS P ON D.ID_DOCENTE=P.CIF WHERE COD_FACULTAD='" + item + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(1));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        DefaultComboBoxModel d=(DefaultComboBoxModel) cmb.getModel();
        d.removeAllElements();
        for(int i=0; i<Lista.size();i++){
            cmb.addItem(Lista.get(i));
        }
    }
    private void llenarAsignaturaG(JComboBox cmb, String item){
        ArrayList<String> Lista = new ArrayList<String>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.NOMBRE FROM ASIGNATURA AS A WHERE A.COD_FACULTAD='" + item + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(1));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        DefaultComboBoxModel d=(DefaultComboBoxModel) cmb.getModel();
        d.removeAllElements();
        cmb.addItem("Elegir Asignatura");
        for(int i=0; i<Lista.size();i++){
            cmb.addItem(Lista.get(i));
        }
    }
    private void rellenarMP(int tipo, String cif){
        if(tipo==1){
            try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.NOMBRE,P.CEDULA,P.EMAIL_INSTITUCION,P.COD_FACULTAD,P.DIRECCION,P.FECHA_NACIMIENTO,D.ESTADO,D.ESPECIALIDAD FROM PERSONAL AS P INNER JOIN DOCENTE AS D ON P.CIF=D.ID_DOCENTE WHERE P.CIF="+ cif;
            ResultSet resultado = sql.executeQuery(consulta);
            

            while (resultado.next()) {                
                txtNombreMP.setText(resultado.getString(1));
                txtCedulaMP.setText(resultado.getString(2));
                txtEmailMP.setText(resultado.getString(3));
                cmbFacultadesMPN.setSelectedIndex(getIndex(cmbFacultadesMPN, resultado.getString(4)));
                txtDireccionMP.setText(resultado.getString(5));
                Date dt = resultado.getDate(6);
                jdtNacimientoMP.setDate(dt);
                cmbEstadoMP.setSelectedIndex(getIndex(cmbEstadoMP, resultado.getString(7)));
                txtEspecialidadMP.setText(resultado.getString(8));
            }
                 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        }else{
            txtNombreMP.setEnabled(true);
            txtCedulaMP.setEnabled(true);
            txtEmailMP.setEnabled(true);
            cmbFacultadesMPN.setEnabled(true);
            txtDireccionMP.setEnabled(true);
            jdtNacimientoMP.setEnabled(true);
            cmbEstadoMP.setEnabled(true);
            txtEspecialidadMP.setEnabled(true);
            btnGuardarCambiosMP.setEnabled(true);
        }
    }
    
    private int getIndex(JComboBox cmb, String item){
        int row=-1;
         for(int i=0; i<cmb.getItemCount();i++){
             if(cmb.getItemAt(i).toString().equals(item)){
                 row=i;
             }
         }
        
        return row;
    }
    private void consultaTablaPI(){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtAsigIns.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.ID_ASIGNATURA, A.NOMBRE FROM ASIGNATURA AS A INNER JOIN ASIGNATURA_PENSUM AS AP ON A.ID_ASIGNATURA=AP.ID_ASIGNATURA WHERE AP.ID_PENSUM=" + id_pensum +" AND AP.SEMESTRE='" + cmbSemestreP.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("ID_Asignatura");
            model.addColumn("Nombre");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    private void setID_PENSUM(String Nombre_Carrera){
        int id=0;
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.ID_PENSUM FROM CARRERA AS C INNER JOIN PENSUM AS P ON C.ID_CARRERA=P.ID_CARRERA WHERE C.NOMBRE_CARRERA='" + Nombre_Carrera + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            

            while (resultado.next()) {                
                id=resultado.getInt(1);
            }
                 
            id_pensum=id;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    private int getIDCarrera(String Nombre_Carrera){
        int id=0;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT ID_CARRERA FROM CARRERA WHERE NOMBRE_CARRERA='" + Nombre_Carrera + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            

            while (resultado.next()) {                
                id=resultado.getInt(1);
            }
                        

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        return id;
    }
    
    private int getIDCarrera(String Nombre_Carrera, String COD_Facultad){
        int id=0;
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT ID_CARRERA FROM CARRERA WHERE NOMBRE_CARRERA='" + Nombre_Carrera + "' AND ID_FACULTAD='" + COD_Facultad + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while (resultado.next()) {                
                id=resultado.getInt(1);
            }
                        

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return id;
    }
    
    private void consultaTabla(JComboBox cmb){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminar.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.CIF,P.NOMBRE,P.CEDULA FROM PERSONAL AS P INNER JOIN ESTUDIANTE AS E ON P.CIF=E.CIF WHERE P.COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("CIF");
            model.addColumn("Nombre");
            model.addColumn("Cedula");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void consultaTablaAR(int tipo){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtElminarAR.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.ID_ASIGNATURA,A.NOMBRE FROM ASIGNATURA AS A WHERE COD_FACULTAD='" + cmbFacultadAR.getSelectedItem().toString()+"'";
                     
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("ID_Asignatura");
            model.addColumn("Nombre");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
    }
    
    private void consultarTablaAR(String id){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtElminarAR.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT A.ID_ASIGNATURA,A.NOMBRE FROM ASIGNATURA AS A WHERE ID_ASIGNATURA=" + id;
                     
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("ID_Asignatura");
            model.addColumn("Nombre");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
    }
    
    private void consultaTabla(JComboBox  cmb, int tipo){
       try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarP.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.CIF,P.NOMBRE,P.CEDULA,E.ESPECIALIDAD FROM PERSONAL AS P INNER JOIN DOCENTE AS E ON P.CIF=E.ID_DOCENTE WHERE P.COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("CIF");
            model.addColumn("Nombre");
            model.addColumn("Cedula");
            model.addColumn("Especialidad");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
    }
    
    private void consultaTabla(JComboBox cmb, JComboBox cmb1){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminar.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.CIF,P.NOMBRE,P.CEDULA FROM PERSONAL AS P JOIN ESTUDIANTE AS E ON P.CIF=E.CIF JOIN CARRERA AS C ON E.CARRERA=C.ID_CARRERA WHERE P.COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'"
                    + " AND C.NOMBRE_CARRERA='" + cmb1.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("CIF");
            model.addColumn("Nombre");
            model.addColumn("Cedula");
            
            while(resultado.next()){
                Object[] filas = new Object[cantCol];
                
                for(int i=0;i<cantCol;i++){
                    filas[i] = resultado.getObject(i+1);
                    
                }
                model.addRow(filas);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    
    private void consultaComboCarrera(String item, JComboBox cmb){
        ArrayList<String> Lista = new ArrayList<String>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT * FROM CARRERA WHERE ID_FACULTAD='" + item + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(3));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        cmb.removeAllItems();
        cmb.addItem("Elegir Carrera");
        for(int i=0; i<Lista.size();i++){
            cmb.addItem(Lista.get(i));
        }
    }
    
    private void consultaComboCarreraPC(String item){
        ArrayList<String> Lista = new ArrayList<String>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT C.NOMBRE_CARRERA FROM CARRERA AS C LEFT JOIN PENSUM AS P ON C.ID_CARRERA=P.ID_CARRERA WHERE P.ID_CARRERA IS NULL AND C.ID_FACULTAD='" + item + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(1));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        cmbCarreraPC.removeAllItems();
        cmbCarreraPC.addItem("Elegir Carrera");
        for(int i=0; i<Lista.size();i++){
            cmbCarreraPC.addItem(Lista.get(i));
        }
    }
    
    private void consultaComboCarreraPS(String item){
        ArrayList<String> Lista = new ArrayList<String>();
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT C.NOMBRE_CARRERA FROM CARRERA AS C INNER JOIN PENSUM AS P ON C.ID_CARRERA=P.ID_CARRERA WHERE COD_FACULTAD='" + item + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                Lista.add(resultado.getString(1));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        cmbCarreraPS.removeAllItems();
        cmbCarreraPS.addItem("Elegir Carrera");
        for(int i=0; i<Lista.size();i++){
            cmbCarreraPS.addItem(Lista.get(i));
        }
    }
    /**
     * @param args the command line arguments
     *
     */
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

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
    private javax.swing.JPanel ParentPanelPensum;
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
    private javax.swing.JPanel PnlPensum;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JPanel PnlProfesor;
    private javax.swing.JPanel PnlRetiroAsignatura;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel avatar1;
    private javax.swing.JButton btnAgregarH;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsignacion;
    private javax.swing.JButton btnBuscarAR;
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnCrearA;
    private javax.swing.JButton btnCrearEst;
    private javax.swing.JButton btnCrearEst12;
    private javax.swing.JButton btnCrearEst13;
    private javax.swing.JButton btnCrearG;
    private javax.swing.JButton btnCrearGrupo;
    private javax.swing.JButton btnCrearPensum;
    private javax.swing.JButton btnCrearProf;
    private javax.swing.JButton btnCrearProfesor;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarAR;
    private javax.swing.JButton btnEliminarEst;
    private javax.swing.JButton btnEliminarP;
    private javax.swing.JButton btnEliminarPI;
    private javax.swing.JButton btnEliminarProf;
    private javax.swing.JButton btnEstudiantes;
    private javax.swing.JButton btnGrupos;
    private javax.swing.JButton btnGuardarCambiosMP;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnModificacionEst;
    private javax.swing.JButton btnModificacionG;
    private javax.swing.JButton btnModificacionProf;
    private javax.swing.JButton btnPasarA;
    private javax.swing.JButton btnPensum;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnProfesor;
    private javax.swing.JButton btnRetiro;
    private javax.swing.JButton btnRetiroG;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionarProfe;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cmbAsignaturaG;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JComboBox<String> cmbCarreraE;
    private javax.swing.JComboBox<String> cmbCarreraPC;
    private javax.swing.JComboBox<String> cmbCarreraPS;
    private javax.swing.JComboBox<String> cmbDia;
    private javax.swing.JComboBox<String> cmbDocenteG;
    private javax.swing.JComboBox<String> cmbEliminarP;
    private javax.swing.JComboBox<String> cmbEstadoMP;
    private javax.swing.JComboBox<String> cmbEstadoP;
    private javax.swing.JComboBox<String> cmbFacultad;
    private javax.swing.JComboBox<String> cmbFacultadA;
    private javax.swing.JComboBox<String> cmbFacultadAR;
    private javax.swing.JComboBox<String> cmbFacultadE;
    private javax.swing.JComboBox<String> cmbFacultadG;
    private javax.swing.JComboBox<String> cmbFacultadGP;
    private javax.swing.JComboBox<String> cmbFacultadMP;
    private javax.swing.JComboBox<String> cmbFacultadP;
    private javax.swing.JComboBox<String> cmbFacultadPB;
    private javax.swing.JComboBox<String> cmbFacultadPC;
    private javax.swing.JComboBox<String> cmbFacultadPS;
    private javax.swing.JComboBox<String> cmbFacultadesMPN;
    private javax.swing.JComboBox<String> cmbSemestreA;
    private javax.swing.JComboBox<String> cmbSemestreG;
    private javax.swing.JComboBox<String> cmbSemestreP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JComboBox<String> jComboBox29;
    private javax.swing.JComboBox<String> jComboBox30;
    private javax.swing.JComboBox<String> jComboBox31;
    private javax.swing.JComboBox<String> jComboBox32;
    private javax.swing.JComboBox<String> jComboBox35;
    private javax.swing.JComboBox<String> jComboBox36;
    private javax.swing.JComboBox<String> jComboBox37;
    private javax.swing.JComboBox<String> jComboBox39;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
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
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
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
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator58;
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
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JDateChooser jdtIngreso;
    private com.toedter.calendar.JDateChooser jdtNacimiento;
    private com.toedter.calendar.JDateChooser jdtNacimientoMP;
    private com.toedter.calendar.JDateChooser jdtNacimientoP;
    private javax.swing.JSpinner jsHoraF;
    private javax.swing.JSpinner jsHoraI;
    private javax.swing.JTable jtAsigIns;
    private javax.swing.JTable jtAsigNoIns;
    private javax.swing.JTable jtEliminar;
    private javax.swing.JTable jtEliminarP;
    private javax.swing.JTable jtElminarAR;
    private javax.swing.JTable jtGrupo;
    private javax.swing.JTable jtProfesorM;
    private com.toedter.calendar.JYearChooser jycAnio;
    private javax.swing.JLabel lblCIF;
    private javax.swing.JLabel lblCifP;
    private javax.swing.JLabel lblIDA;
    private javax.swing.JLabel lblIDG;
    private javax.swing.JLabel marcoAvatar;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidosP;
    private javax.swing.JTextField txtBuscarAR;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedulaMP;
    private javax.swing.JTextField txtCedulaP;
    private javax.swing.JTextField txtDescripcionA;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionMP;
    private javax.swing.JTextField txtDireccionP;
    private javax.swing.JTextField txtEmailMP;
    private javax.swing.JTextField txtEspecialidadMP;
    private javax.swing.JTextField txtEspecialidadP;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtNombreMP;
    private javax.swing.JTextField txtNombreP;
    // End of variables declaration//GEN-END:variables
}
