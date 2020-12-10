
package decano;


import administrador.Administrador;
import administrador.Guardar;
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
import sql.Conexion;
import utilities.ScaleImage;


public final class decanoPerfil extends javax.swing.JFrame {
    
    private static int limp=0;
    private int id_pensum;
    private String cif_mp="-1";
    
    public decanoPerfil() {
        initComponents();
        ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/avatarDef.png"));
        ScaleImage.setScaleImage(avatar, imagen);
        ScaleImage.setScaleImage(avatar1, imagen);
        panelSelected();
        iconoFormulario();
        agregarFacultades(cmbFacultadA);
        agregarFacultades(cmbFacultad);
        agregarFacultades(cmbFacultadMP);
        agregarFacultades(cmbFacultadC);
        agregarFacultades(cmbEliminarC);
        agregarFacultades(cmbEliminarF);
        agregarFacultades(cmbFacultadesMPN);
        
        setCIF(id_max("CIF","PERSONAL"), lblCifA);
        setCIF(id_max("CIF","PERSONAL"), lblCifC);
        lblCifC.setText(id_max("ID_CARRERA","CARRERA")+"");
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
            btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
            btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
            btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlAdmin) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesDecano/Neg-admin.png"));
            btnAdmin.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
            btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlCarrera) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesDecano/Neg-carrera.png"));
            btnCarrera.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlFacultad) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesDecano/Neg-facultad.png"));
            btnFacultad.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
            btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
            btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
            btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        } else if (panelActual == PnlAjustes) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
            btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
            btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
        }else if (panelActual == PnlCambioFotoPerfil) {
            ImageIcon imagen = new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png"));
            btnAjustes.setIcon(imagen);

            //Aqui es para que los demas botones esten grises
            btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
            btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
            btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
            btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
        }
    }
    
    public void admin(){
        Component panelActual = ParentPanelAdmin.getComponent(0);
        if(panelActual == PnlCrearAdmin){
            btnCrearAd.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearAdmin.png")));
            btnModificacionAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/ModificarAdmin.png")));
            btnEliminarAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarAdmin.png")));

        }else if(panelActual == PnlModificarAdmin){
            btnCrearAd.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearAdmin.png")));
            btnModificacionAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-ModificarAdmin.png")));
            btnEliminarAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarAdmin.png")));
        }else if(panelActual == PnlEliminarAdmin){
            btnCrearAd.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearAdmin.png")));
            btnModificacionAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/ModificarAdmin.png")));
            btnEliminarAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarAdmin.png")));
        }
    }
    
    public void carrera(){
        Component panelActual = ParentPanelCarrera.getComponent(0);
        if(panelActual == PnlCrearCarrera){
            btnCrearCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearCarrera.png")));
            btnEliminarCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarCarrera.png")));
        }else if(panelActual == PnlEliminarCarrera){
            btnCrearCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearCarrera.png")));
            btnEliminarCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarCarrera.png")));
        }
    }
    
    public void facultad(){
        Component panelActual = ParentPanelFacultad.getComponent(0);
        if(panelActual == PnlCrearFacultad){
            btnCrearFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearFacultad.png")));
            btnEliminarFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarFacultad.png")));
        }else if(panelActual == PnlEliminarFacultad){
            btnCrearFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearFacultad.png")));
            btnEliminarFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarFacultad.png")));
        }
    }
    
     private void exeLimpiar(){
        txtNombreA.setText("");
        txtNombreF.setText("");
        txtIDFacultad.setText("");
        txtDecanaF.setText("");
        txtEdificio.setText("");
        txtNombreC.setText("");
        txtNombreMP.setText("");
        txtApellidosA.setText("");
        txtCedulaA.setText("");
        txtCedulaMP.setText("");
        txtDireccionA.setText("");
        txtDireccionMP.setText("");
        lblCifA.setText(id_max("CIF","PERSONAL") + "");
        lblCifC.setText(id_max("ID_CARRERA","CARRERA") + "");
        cmbFacultadA.setSelectedIndex(0);
        cmbFacultadC.setSelectedIndex(0);
        cmbEliminarC.setSelectedIndex(0);
        cmbEliminarF.setSelectedIndex(0);
        cmbFacultadMP.setSelectedIndex(0);
        txtSalarioA.setText("");
        txtSalarioMP.setText("");
        txtCargoA.setText(""); 
        txtCargoMP.setText("");  
        txtEmailMP.setText("");
        
        jdtNacimientoA.setCalendar(null);
        jdtNacimientoMP.setCalendar(null);
        
        DefaultTableModel model = new DefaultTableModel();
        jtAdminM.setModel(model);
        jtEliminarC.setModel(model);
        jtEliminarF.setModel(model);
        
    }
    
     private void consultaTabla(JComboBox cmb){
        try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminar.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.CIF,P.NOMBRE,P.CEDULA FROM PERSONAL AS P INNER JOIN PERSONAL_ADMINISTRATIVO AS E ON P.CIF=E.CIF WHERE P.COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
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
    
    public void setCIF(int n_CIF, JLabel lbl){
        lbl.setText(n_CIF + "");
    }
    
     public void setCIFCARRERA(int n_CIF, JLabel lbl){
        lbl.setText(n_CIF + "");
    }
    
    
    private void agregarFacultades(JComboBox cmb){
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
    
    private void rellenarMP(int tipo, String cif){
        if(tipo==1){
            try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT P.NOMBRE,P.CEDULA,P.EMAIL_INSTITUCION,P.COD_FACULTAD,P.DIRECCION,P.FECHA_NACIMIENTO,D.CARGO,D.SALARIO FROM PERSONAL AS P INNER JOIN PERSONAL_ADMINISTRATIVO AS D ON P.CIF=D.CIF WHERE P.CIF="+ cif;
            ResultSet resultado = sql.executeQuery(consulta);
            

            while (resultado.next()) {                
                txtNombreMP.setText(resultado.getString(1));
                txtCedulaMP.setText(resultado.getString(2));
                txtEmailMP.setText(resultado.getString(3));
                cmbFacultadesMPN.setSelectedIndex(getIndex(cmbFacultadesMPN, resultado.getString(4)));
                txtDireccionMP.setText(resultado.getString(5));
                Date dt = resultado.getDate(6);
                jdtNacimientoMP.setDate(dt);
                txtCargoMP.setText(resultado.getString(7));
                txtSalarioMP.setText(resultado.getString(8));
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
            txtCargoMP.setEnabled(true);
            txtSalarioMP.setEnabled(true);
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
    
    private void consultaTabla(JComboBox  cmb, int tipo){
       
        if(tipo==3){
            try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarF.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT COD_FACULTAD,NOMBRE,DECANA,EDIFICIO FROM FACULTAD WHERE COD_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("COD_FACULTAD");
            model.addColumn("NOMBRE");
            model.addColumn("DECANA");
            model.addColumn("EDIFICIO");
            
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
        }else{
            try {
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarC.setModel(model);
            
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT ID_CARRERA,ID_FACULTAD,NOMBRE_CARRERA FROM CARRERA WHERE ID_FACULTAD='" + cmb.getSelectedItem().toString()+"'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            ResultSetMetaData rsMd = resultado.getMetaData();
            int cantCol = rsMd.getColumnCount();
            
            model.addColumn("ID_CARRERA");
            model.addColumn("ID_FACULTAD");
            model.addColumn("NOMBRE_CARRERA");
            
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
        btnAjustes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnAdmin = new javax.swing.JButton();
        btnCarrera = new javax.swing.JButton();
        btnFacultad = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        PnlPerfil = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jSeparator21 = new javax.swing.JSeparator();
        jLabel44 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jSeparator23 = new javax.swing.JSeparator();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel60 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        PnlAdmin = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearAd = new javax.swing.JButton();
        btnModificacionAdmin = new javax.swing.JButton();
        btnEliminarAdmin = new javax.swing.JButton();
        ParentPanelAdmin = new javax.swing.JPanel();
        PnlCrearAdmin = new javax.swing.JPanel();
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
        btnCrearAdmin = new javax.swing.JButton();
        jLabel162 = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JTextField();
        txtApellidosA = new javax.swing.JTextField();
        txtSalarioA = new javax.swing.JTextField();
        txtCedulaA = new javax.swing.JTextField();
        txtDireccionA = new javax.swing.JTextField();
        lblCifA = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbFacultadA = new javax.swing.JComboBox<>();
        jLabel163 = new javax.swing.JLabel();
        jSeparator80 = new javax.swing.JSeparator();
        jLabel165 = new javax.swing.JLabel();
        jSeparator81 = new javax.swing.JSeparator();
        txtDireccionA1 = new javax.swing.JTextField();
        txtCargoA = new javax.swing.JTextField();
        jdtNacimientoA = new com.toedter.calendar.JDateChooser();
        PnlModificarAdmin = new javax.swing.JPanel();
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
        jLabel135 = new javax.swing.JLabel();
        jSeparator61 = new javax.swing.JSeparator();
        txtNombreMP = new javax.swing.JTextField();
        txtEmailMP = new javax.swing.JTextField();
        txtCargoMP = new javax.swing.JTextField();
        txtCedulaMP = new javax.swing.JTextField();
        txtDireccionMP = new javax.swing.JTextField();
        cmbFacultadMP = new javax.swing.JComboBox<>();
        cmbFacultadesMPN = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtAdminM = new javax.swing.JTable();
        btnSeleccionarProfe = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        btnGuardarCambiosMP = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        txtSalarioMP = new javax.swing.JTextField();
        jSeparator62 = new javax.swing.JSeparator();
        jdtNacimientoMP = new com.toedter.calendar.JDateChooser();
        PnlEliminarAdmin = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        cmbFacultad = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtEliminar = new javax.swing.JTable();
        jLabel156 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        PnlCarrera = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnCrearCarrera = new javax.swing.JButton();
        btnEliminarCarrera = new javax.swing.JButton();
        ParentPanelCarrera = new javax.swing.JPanel();
        PnlCrearCarrera = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jSeparator76 = new javax.swing.JSeparator();
        jLabel166 = new javax.swing.JLabel();
        jSeparator84 = new javax.swing.JSeparator();
        txtNombreC = new javax.swing.JTextField();
        lblCifC = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbFacultadC = new javax.swing.JComboBox<>();
        CrearCarrera = new javax.swing.JButton();
        jLabel168 = new javax.swing.JLabel();
        PnlEliminarCarrera = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        cmbEliminarC = new javax.swing.JComboBox<>();
        btnEliminarC = new javax.swing.JButton();
        jLabel158 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtEliminarC = new javax.swing.JTable();
        PnlFacultad = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnCrearFacultad = new javax.swing.JButton();
        btnEliminarFacultad = new javax.swing.JButton();
        ParentPanelFacultad = new javax.swing.JPanel();
        PnlCrearFacultad = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jSeparator82 = new javax.swing.JSeparator();
        txtNombreF = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        CrearFacultad = new javax.swing.JButton();
        jLabel169 = new javax.swing.JLabel();
        jSeparator83 = new javax.swing.JSeparator();
        jLabel67 = new javax.swing.JLabel();
        txtDecanaF = new javax.swing.JTextField();
        jSeparator86 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        txtEdificio = new javax.swing.JTextField();
        jSeparator87 = new javax.swing.JSeparator();
        txtIDFacultad = new javax.swing.JTextField();
        PnlEliminarFacultad = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        cmbEliminarF = new javax.swing.JComboBox<>();
        btnEliminarC1 = new javax.swing.JButton();
        jLabel170 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtEliminarF = new javax.swing.JTable();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/cerrar.png"))); // NOI18N
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setFocusable(false);
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
        btnPerfil.setFocusable(false);
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

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/ajustes.png"))); // NOI18N
        btnAjustes.setBorder(null);
        btnAjustes.setBorderPainted(false);
        btnAjustes.setContentAreaFilled(false);
        btnAjustes.setFocusable(false);
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
        jPanel1.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/salir.png"))); // NOI18N
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusable(false);
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

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/admin.png"))); // NOI18N
        btnAdmin.setBorder(null);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setDefaultCapable(false);
        btnAdmin.setFocusable(false);
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminMouseExited(evt);
            }
        });
        jPanel1.add(btnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        btnCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/carrera.png"))); // NOI18N
        btnCarrera.setBorder(null);
        btnCarrera.setBorderPainted(false);
        btnCarrera.setContentAreaFilled(false);
        btnCarrera.setFocusable(false);
        btnCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarreraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCarreraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCarreraMouseExited(evt);
            }
        });
        jPanel1.add(btnCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 280, -1, -1));

        btnFacultad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/facultad.png"))); // NOI18N
        btnFacultad.setBorder(null);
        btnFacultad.setBorderPainted(false);
        btnFacultad.setContentAreaFilled(false);
        btnFacultad.setFocusable(false);
        btnFacultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacultadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFacultadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFacultadMouseExited(evt);
            }
        });
        jPanel1.add(btnFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 340, -1, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 220, 560));

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        PnlPerfil.setBackground(new java.awt.Color(255, 255, 255));
        PnlPerfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel40.setText("Información Personal");
        PnlPerfil.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel41.setText("Nombre:");
        PnlPerfil.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));
        PnlPerfil.add(jSeparator21, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 170, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel44.setText("Apellidos: ");
        PnlPerfil.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));
        PnlPerfil.add(jSeparator22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));
        PnlPerfil.add(jSeparator23, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 270, 200, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel45.setText("Fecha de nacimiento: ");
        PnlPerfil.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel46.setText("Email:");
        PnlPerfil.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel59.setText("Cédula:");
        PnlPerfil.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        PnlPerfil.add(jSeparator24, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 170, -1));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel60.setText("Carrera:");
        PnlPerfil.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));
        PnlPerfil.add(jSeparator25, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 200, -1));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel61.setText("Dirección:");
        PnlPerfil.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));
        PnlPerfil.add(jSeparator26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 160, -1));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlPerfil.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, -1));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel64.setText("CIF:");
        PnlPerfil.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));
        PnlPerfil.add(jSeparator27, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 170, 10));

        ParentPanel.add(PnlPerfil, "card9");

        PnlAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PnlAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setText("Administrador");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrearAd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/CrearAdmin.png"))); // NOI18N
        btnCrearAd.setBorder(null);
        btnCrearAd.setBorderPainted(false);
        btnCrearAd.setContentAreaFilled(false);
        btnCrearAd.setFocusable(false);
        btnCrearAd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearAdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearAdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearAdMouseExited(evt);
            }
        });
        jPanel3.add(btnCrearAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnModificacionAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/ModificarAdmin.png"))); // NOI18N
        btnModificacionAdmin.setBorder(null);
        btnModificacionAdmin.setBorderPainted(false);
        btnModificacionAdmin.setContentAreaFilled(false);
        btnModificacionAdmin.setFocusable(false);
        btnModificacionAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificacionAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModificacionAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModificacionAdminMouseExited(evt);
            }
        });
        jPanel3.add(btnModificacionAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        btnEliminarAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/EliminarAdmin.png"))); // NOI18N
        btnEliminarAdmin.setBorder(null);
        btnEliminarAdmin.setBorderPainted(false);
        btnEliminarAdmin.setContentAreaFilled(false);
        btnEliminarAdmin.setFocusable(false);
        btnEliminarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarAdminMouseExited(evt);
            }
        });
        jPanel3.add(btnEliminarAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        PnlAdmin.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 150));

        ParentPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelAdmin.setLayout(new java.awt.CardLayout());

        PnlCrearAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel62.setText("Nombre:");
        PnlCrearAdmin.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        PnlCrearAdmin.add(jSeparator74, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, 10));

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel98.setText("Apellidos: ");
        PnlCrearAdmin.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));
        PnlCrearAdmin.add(jSeparator75, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 180, 10));

        jLabel159.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel159.setText("Cédula:");
        PnlCrearAdmin.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));
        PnlCrearAdmin.add(jSeparator77, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 170, -1));

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel160.setText("CIF:");
        PnlCrearAdmin.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));
        PnlCrearAdmin.add(jSeparator78, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 200, -1));

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel161.setText("Dirección:");
        PnlCrearAdmin.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        PnlCrearAdmin.add(jSeparator79, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 160, -1));

        btnCrearAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/btnCrearAdmin.png"))); // NOI18N
        btnCrearAdmin.setBorder(null);
        btnCrearAdmin.setBorderPainted(false);
        btnCrearAdmin.setContentAreaFilled(false);
        btnCrearAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAdminActionPerformed(evt);
            }
        });
        PnlCrearAdmin.add(btnCrearAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, -1, -1));

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearAdmin.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        txtNombreA.setBorder(null);
        PnlCrearAdmin.add(txtNombreA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 180, -1));

        txtApellidosA.setBorder(null);
        PnlCrearAdmin.add(txtApellidosA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, -1));

        txtSalarioA.setBorder(null);
        PnlCrearAdmin.add(txtSalarioA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 100, -1));

        txtCedulaA.setBorder(null);
        PnlCrearAdmin.add(txtCedulaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 170, -1));

        txtDireccionA.setBorder(null);
        PnlCrearAdmin.add(txtDireccionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 160, -1));
        PnlCrearAdmin.add(lblCifA, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 190, 20));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel139.setText("Fecha de nacimiento: ");
        PnlCrearAdmin.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel13.setText("Facultad: ");
        PnlCrearAdmin.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        cmbFacultadA.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        PnlCrearAdmin.add(cmbFacultadA, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 170, -1));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel163.setText("Cargo:");
        PnlCrearAdmin.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));
        PnlCrearAdmin.add(jSeparator80, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 180, -1));

        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel165.setText("Salario:");
        PnlCrearAdmin.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));
        PnlCrearAdmin.add(jSeparator81, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 110, -1));

        txtDireccionA1.setBorder(null);
        PnlCrearAdmin.add(txtDireccionA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 150, -1));

        txtCargoA.setBorder(null);
        PnlCrearAdmin.add(txtCargoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 180, -1));

        jdtNacimientoA.setDateFormatString("dd/MM/yyyy");
        PnlCrearAdmin.add(jdtNacimientoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 130, -1));

        ParentPanelAdmin.add(PnlCrearAdmin, "card4");

        PnlModificarAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PnlModificarAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel58.setText("Nombre:");
        PnlModificarAdmin.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        PnlModificarAdmin.add(jSeparator55, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel73.setText("Email:");
        PnlModificarAdmin.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        PnlModificarAdmin.add(jSeparator56, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 190, 10));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel129.setText("Fecha de nacimiento: ");
        PnlModificarAdmin.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel131.setText("Cédula:");
        PnlModificarAdmin.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));
        PnlModificarAdmin.add(jSeparator58, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 170, -1));

        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel132.setText("Facultad: ");
        PnlModificarAdmin.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel133.setText("Dirección:");
        PnlModificarAdmin.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));
        PnlModificarAdmin.add(jSeparator60, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 160, -1));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel135.setText("Cargo:");
        PnlModificarAdmin.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));
        PnlModificarAdmin.add(jSeparator61, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 130, -1));

        txtNombreMP.setBorder(null);
        txtNombreMP.setEnabled(false);
        PnlModificarAdmin.add(txtNombreMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 20));

        txtEmailMP.setBorder(null);
        txtEmailMP.setEnabled(false);
        PnlModificarAdmin.add(txtEmailMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, 20));

        txtCargoMP.setBorder(null);
        txtCargoMP.setEnabled(false);
        PnlModificarAdmin.add(txtCargoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 130, 20));

        txtCedulaMP.setBorder(null);
        txtCedulaMP.setEnabled(false);
        PnlModificarAdmin.add(txtCedulaMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 170, 20));

        txtDireccionMP.setBorder(null);
        txtDireccionMP.setEnabled(false);
        PnlModificarAdmin.add(txtDireccionMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 160, 20));

        cmbFacultadMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadMPActionPerformed(evt);
            }
        });
        PnlModificarAdmin.add(cmbFacultadMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 120, -1));

        cmbFacultadesMPN.setEnabled(false);
        PnlModificarAdmin.add(cmbFacultadesMPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 160, -1));

        jtAdminM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CIF", "Nombre"
            }
        ));
        jScrollPane6.setViewportView(jtAdminM);

        PnlModificarAdmin.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 210, 100));

        btnSeleccionarProfe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/seleccionar.png"))); // NOI18N
        btnSeleccionarProfe.setBorder(null);
        btnSeleccionarProfe.setBorderPainted(false);
        btnSeleccionarProfe.setContentAreaFilled(false);
        btnSeleccionarProfe.setFocusable(false);
        btnSeleccionarProfe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProfeActionPerformed(evt);
            }
        });
        PnlModificarAdmin.add(btnSeleccionarProfe, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setText("Facultad");
        PnlModificarAdmin.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlModificarAdmin.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        btnGuardarCambiosMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAdmin/GuardarCambios.png"))); // NOI18N
        btnGuardarCambiosMP.setBorder(null);
        btnGuardarCambiosMP.setBorderPainted(false);
        btnGuardarCambiosMP.setContentAreaFilled(false);
        btnGuardarCambiosMP.setEnabled(false);
        btnGuardarCambiosMP.setFocusable(false);
        btnGuardarCambiosMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosMPActionPerformed(evt);
            }
        });
        PnlModificarAdmin.add(btnGuardarCambiosMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, -1));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel136.setText("Salario:");
        PnlModificarAdmin.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txtSalarioMP.setBorder(null);
        txtSalarioMP.setEnabled(false);
        txtSalarioMP.setFocusable(false);
        PnlModificarAdmin.add(txtSalarioMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 180, 20));
        PnlModificarAdmin.add(jSeparator62, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 180, -1));
        PnlModificarAdmin.add(jdtNacimientoMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 140, -1));

        ParentPanelAdmin.add(PnlModificarAdmin, "card3");

        PnlEliminarAdmin.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel154.setText("Facultad");
        PnlEliminarAdmin.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        cmbFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFacultadActionPerformed(evt);
            }
        });
        PnlEliminarAdmin.add(cmbFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 170, -1));

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

        PnlEliminarAdmin.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 320, 140));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarAdmin.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/eliminar.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        PnlEliminarAdmin.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, -1, -1));
        PnlEliminarAdmin.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 220, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/Lupa.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PnlEliminarAdmin.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 36, 40, 40));

        ParentPanelAdmin.add(PnlEliminarAdmin, "card4");

        PnlAdmin.add(ParentPanelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 680, 410));

        ParentPanel.add(PnlAdmin, "card4");

        PnlCarrera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setText("Carrera");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrearCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/CrearCarrera.png"))); // NOI18N
        btnCrearCarrera.setBorder(null);
        btnCrearCarrera.setBorderPainted(false);
        btnCrearCarrera.setContentAreaFilled(false);
        btnCrearCarrera.setFocusable(false);
        btnCrearCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearCarreraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearCarreraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearCarreraMouseExited(evt);
            }
        });
        jPanel4.add(btnCrearCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnEliminarCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/EliminarCarrera.png"))); // NOI18N
        btnEliminarCarrera.setBorder(null);
        btnEliminarCarrera.setBorderPainted(false);
        btnEliminarCarrera.setContentAreaFilled(false);
        btnEliminarCarrera.setFocusable(false);
        btnEliminarCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarCarreraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarCarreraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarCarreraMouseExited(evt);
            }
        });
        jPanel4.add(btnEliminarCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        PnlCarrera.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 150));

        ParentPanelCarrera.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelCarrera.setLayout(new java.awt.CardLayout());

        PnlCrearCarrera.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearCarrera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel65.setText("Nombre:");
        PnlCrearCarrera.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        PnlCrearCarrera.add(jSeparator76, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 10));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel166.setText("ID Carrera:");
        PnlCrearCarrera.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));
        PnlCrearCarrera.add(jSeparator84, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 140, 10));

        txtNombreC.setBorder(null);
        PnlCrearCarrera.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 180, -1));
        PnlCrearCarrera.add(lblCifC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 130, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel14.setText("Facultad: ");
        PnlCrearCarrera.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        cmbFacultadC.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cmbFacultadC.setFocusable(false);
        PnlCrearCarrera.add(cmbFacultadC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 170, -1));

        CrearCarrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/btnCrearCarrera.png"))); // NOI18N
        CrearCarrera.setBorder(null);
        CrearCarrera.setBorderPainted(false);
        CrearCarrera.setContentAreaFilled(false);
        CrearCarrera.setFocusable(false);
        CrearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearCarreraActionPerformed(evt);
            }
        });
        PnlCrearCarrera.add(CrearCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, -1, -1));

        jLabel168.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearCarrera.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        ParentPanelCarrera.add(PnlCrearCarrera, "card2");

        PnlEliminarCarrera.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarCarrera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel157.setText("Facultad");
        PnlEliminarCarrera.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        cmbEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEliminarCActionPerformed(evt);
            }
        });
        PnlEliminarCarrera.add(cmbEliminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 180, -1));

        btnEliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/eliminar.png"))); // NOI18N
        btnEliminarC.setBorder(null);
        btnEliminarC.setBorderPainted(false);
        btnEliminarC.setContentAreaFilled(false);
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });
        PnlEliminarCarrera.add(btnEliminarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarCarrera.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        jtEliminarC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_CARRERA", "ID_FACULTAD", "NOMBRE_CARRERA"
            }
        ));
        jScrollPane5.setViewportView(jtEliminarC);

        PnlEliminarCarrera.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 380, 180));

        ParentPanelCarrera.add(PnlEliminarCarrera, "card3");

        PnlCarrera.add(ParentPanelCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 680, 410));

        ParentPanel.add(PnlCarrera, "card5");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setText("Facultad");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        btnCrearFacultad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/CrearFacultad.png"))); // NOI18N
        btnCrearFacultad.setBorder(null);
        btnCrearFacultad.setBorderPainted(false);
        btnCrearFacultad.setContentAreaFilled(false);
        btnCrearFacultad.setFocusable(false);
        btnCrearFacultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearFacultadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearFacultadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearFacultadMouseExited(evt);
            }
        });
        jPanel5.add(btnCrearFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        btnEliminarFacultad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/EliminarFacultad.png"))); // NOI18N
        btnEliminarFacultad.setBorder(null);
        btnEliminarFacultad.setBorderPainted(false);
        btnEliminarFacultad.setContentAreaFilled(false);
        btnEliminarFacultad.setFocusable(false);
        btnEliminarFacultad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarFacultadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarFacultadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarFacultadMouseExited(evt);
            }
        });
        jPanel5.add(btnEliminarFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, -1));

        ParentPanelFacultad.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanelFacultad.setLayout(new java.awt.CardLayout());

        PnlCrearFacultad.setBackground(new java.awt.Color(255, 255, 255));
        PnlCrearFacultad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel66.setText("Nombre:");
        PnlCrearFacultad.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));
        PnlCrearFacultad.add(jSeparator82, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 10));

        txtNombreF.setBorder(null);
        PnlCrearFacultad.add(txtNombreF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 180, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel29.setText("ID Facultad:");
        PnlCrearFacultad.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        CrearFacultad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/btnCrearFacultad.png"))); // NOI18N
        CrearFacultad.setBorder(null);
        CrearFacultad.setBorderPainted(false);
        CrearFacultad.setContentAreaFilled(false);
        CrearFacultad.setFocusable(false);
        CrearFacultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearFacultadActionPerformed(evt);
            }
        });
        PnlCrearFacultad.add(CrearFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jLabel169.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlCrearFacultad.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));
        PnlCrearFacultad.add(jSeparator83, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 10));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel67.setText("Decana:");
        PnlCrearFacultad.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        txtDecanaF.setBorder(null);
        PnlCrearFacultad.add(txtDecanaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 180, -1));
        PnlCrearFacultad.add(jSeparator86, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 140, 10));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel68.setText("Edificio:");
        PnlCrearFacultad.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        txtEdificio.setBorder(null);
        PnlCrearFacultad.add(txtEdificio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 140, -1));
        PnlCrearFacultad.add(jSeparator87, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 110, 10));

        txtIDFacultad.setBorder(null);
        PnlCrearFacultad.add(txtIDFacultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 110, -1));

        ParentPanelFacultad.add(PnlCrearFacultad, "card2");

        PnlEliminarFacultad.setBackground(new java.awt.Color(255, 255, 255));
        PnlEliminarFacultad.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel164.setText("Facultad");
        PnlEliminarFacultad.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        cmbEliminarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEliminarFActionPerformed(evt);
            }
        });
        PnlEliminarFacultad.add(cmbEliminarF, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 180, -1));

        btnEliminarC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesDecano/eliminar.png"))); // NOI18N
        btnEliminarC1.setBorder(null);
        btnEliminarC1.setBorderPainted(false);
        btnEliminarC1.setContentAreaFilled(false);
        btnEliminarC1.setFocusable(false);
        btnEliminarC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarC1ActionPerformed(evt);
            }
        });
        PnlEliminarFacultad.add(btnEliminarC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel170.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesLogin/lg2.png"))); // NOI18N
        PnlEliminarFacultad.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));

        jtEliminarF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD_FACULTAD", "NOMBRE", "DECANA", "EDIFICIO"
            }
        ));
        jScrollPane7.setViewportView(jtEliminarF);

        PnlEliminarFacultad.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 380, 180));

        ParentPanelFacultad.add(PnlEliminarFacultad, "card3");

        javax.swing.GroupLayout PnlFacultadLayout = new javax.swing.GroupLayout(PnlFacultad);
        PnlFacultad.setLayout(PnlFacultadLayout);
        PnlFacultadLayout.setHorizontalGroup(
            PnlFacultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
            .addGroup(PnlFacultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlFacultadLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(PnlFacultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ParentPanelFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        PnlFacultadLayout.setVerticalGroup(
            PnlFacultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(PnlFacultadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PnlFacultadLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(ParentPanelFacultad, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        ParentPanel.add(PnlFacultad, "card6");

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

        jLabel24.setForeground(new java.awt.Color(106, 151, 197));
        jLabel24.setText("academicdesktopapplication@gmail.com");
        PnlAjustes.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 200, 20));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesEst/CuadroAjustes.png"))); // NOI18N
        PnlAjustes.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 420, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel26.setText("Ayuda y asistencia");
        PnlAjustes.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

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

    private void btnPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnPerfilMouseClicked

    private void btnPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseEntered
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-perfil.png")));
    }//GEN-LAST:event_btnPerfilMouseEntered

    private void btnPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPerfilMouseExited
        btnPerfil.setIcon(new ImageIcon(getClass().getResource("/imagesEst/perfil.png")));
        panelSelected();
    }//GEN-LAST:event_btnPerfilMouseExited

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAjustes);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnAjustesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseEntered
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-ajustes.png")));
    }//GEN-LAST:event_btnAjustesMouseEntered

    private void btnAjustesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseExited
        btnAjustes.setIcon(new ImageIcon(getClass().getResource("/imagesEst/ajustes.png")));
        panelSelected();
    }//GEN-LAST:event_btnAjustesMouseExited

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-salir.png")));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        btnSalir.setIcon(new ImageIcon(getClass().getResource("/imagesEst/salir.png")));
        panelSelected();
    }//GEN-LAST:event_btnSalirMouseExited

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
                Logger.getLogger(decanoPerfil.class.getName()).log(Level.SEVERE, null, ex);
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
        panelSelected();
    }//GEN-LAST:event_btnEditar1MouseExited

    private void btnEditar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlCambioFotoPerfil);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseClicked

    private void btnEditar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseEntered
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/Neg-editar.png")));
    }//GEN-LAST:event_btnEditar2MouseEntered

    private void btnEditar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditar2MouseExited
        btnEditar2.setIcon(new ImageIcon(getClass().getResource("/imagesEst/editar.png")));
        panelSelected();
    }//GEN-LAST:event_btnEditar2MouseExited

    private void btnCrearAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAdminActionPerformed
        double salario = Double.parseDouble(txtSalarioA.getText());
         java.util.Date nacimientoP = jdtNacimientoA.getDate();
        if((!txtNombreA.getText().equals("")) && (!txtApellidosA.getText().equals("")) && (!txtCedulaA.getText().equals("")) && (!txtDireccionA.getText().equals(""))&& (!txtCargoA.getText().equals("")) && (!txtSalarioA.getText().equals(""))&& (jdtNacimientoA!=null)&& (cmbFacultadA.getSelectedIndex()!=0)){
            long dnP = nacimientoP.getTime();
            //Aqui convertimos las Date de Java a Date de SQL
            java.sql.Date snacimientoP = new java.sql.Date(dnP);
            
            Administrador admin = new Administrador(id_max("CIF","PERSONAL"), txtNombreA.getText() + " " + txtApellidosA.getText(), txtCedulaA.getText(), txtDireccionA.getText(), txtCargoA.getText(), salario , cmbFacultadA.getSelectedItem().toString(), snacimientoP);
            Guardar ventana = new Guardar(admin);
            ventana.setVisible(true);
            exeLimpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_btnCrearAdminActionPerformed

    private void cmbFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadActionPerformed
        consultaTabla(cmbFacultad);
    }//GEN-LAST:event_cmbFacultadActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int row=jtEliminar.getSelectedRow();
        String cif = jtEliminar.getModel().getValueAt(row, 0).toString();

        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE PERSONAL WHERE CIF=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha eliminado correctamente");
            jtEliminar.removeAll();
            cmbFacultad.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlAdmin);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        panelSelected();
        admin();
    }//GEN-LAST:event_btnAdminMouseClicked

    private void btnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseEntered
        btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-admin.png")));
    }//GEN-LAST:event_btnAdminMouseEntered

    private void btnAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseExited
        btnAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/admin.png")));
        panelSelected();
    }//GEN-LAST:event_btnAdminMouseExited

    private void btnCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarreraMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlCarrera);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        carrera();
        panelSelected();
        cmbEliminarC.removeAllItems();
        cmbFacultadC.removeAllItems();
        agregarFacultades(cmbEliminarC);
        agregarFacultades(cmbFacultadC);
    }//GEN-LAST:event_btnCarreraMouseClicked

    private void btnCarreraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarreraMouseEntered
        btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-carrera.png")));
    }//GEN-LAST:event_btnCarreraMouseEntered

    private void btnCarreraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarreraMouseExited
        btnCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/carrera.png")));
        panelSelected();
    }//GEN-LAST:event_btnCarreraMouseExited

    private void btnFacultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultadMouseClicked
        ParentPanel.removeAll();
        ParentPanel.add(PnlFacultad);
        ParentPanel.revalidate();
        ParentPanel.repaint();
        facultad();
        panelSelected();
    }//GEN-LAST:event_btnFacultadMouseClicked

    private void btnFacultadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultadMouseEntered
        btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-facultad.png")));
    }//GEN-LAST:event_btnFacultadMouseEntered

    private void btnFacultadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacultadMouseExited
        btnFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/facultad.png")));
        panelSelected();
    }//GEN-LAST:event_btnFacultadMouseExited

    private void btnCrearAdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearAdMouseClicked
        ParentPanelAdmin.removeAll();
        ParentPanelAdmin.add(PnlCrearAdmin);
        ParentPanelAdmin.revalidate();
        ParentPanelAdmin.repaint();
        admin();
    }//GEN-LAST:event_btnCrearAdMouseClicked

    private void btnCrearAdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearAdMouseEntered
        btnCrearAd.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearAdmin.png")));

    }//GEN-LAST:event_btnCrearAdMouseEntered

    private void btnCrearAdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearAdMouseExited
        btnCrearAd.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearAdmin.png")));
        admin();
    }//GEN-LAST:event_btnCrearAdMouseExited

    private void btnModificacionAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionAdminMouseClicked
        ParentPanelAdmin.removeAll();
        ParentPanelAdmin.add(PnlModificarAdmin);
        ParentPanelAdmin.revalidate();
        ParentPanelAdmin.repaint();
        admin();
    }//GEN-LAST:event_btnModificacionAdminMouseClicked

    private void btnModificacionAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionAdminMouseEntered
        btnModificacionAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-ModificarAdmin.png")));
 
    }//GEN-LAST:event_btnModificacionAdminMouseEntered

    private void btnModificacionAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificacionAdminMouseExited
        btnModificacionAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/ModificarAdmin.png")));
        admin();
    }//GEN-LAST:event_btnModificacionAdminMouseExited

    private void btnEliminarAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarAdminMouseClicked
        ParentPanelAdmin.removeAll();
        ParentPanelAdmin.add(PnlEliminarAdmin);
        ParentPanelAdmin.revalidate();
        ParentPanelAdmin.repaint();
        admin();
    }//GEN-LAST:event_btnEliminarAdminMouseClicked

    private void btnEliminarAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarAdminMouseEntered
        btnEliminarAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarAdmin.png")));
    }//GEN-LAST:event_btnEliminarAdminMouseEntered

    private void btnEliminarAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarAdminMouseExited
        btnEliminarAdmin.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarAdmin.png")));
        admin();
    }//GEN-LAST:event_btnEliminarAdminMouseExited

    private void btnGuardarCambiosMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMPActionPerformed

        boolean personal=false, admin=false;

        try {
            java.util.Date df = jdtNacimientoMP.getDate();

            long b = df.getTime();

            java.sql.Date fecha = new java.sql.Date(b);

            String consulta = "UPDATE PERSONAL SET NOMBRE='" + txtNombreMP.getText() + "', COD_FACULTAD='" + cmbFacultadesMPN.getSelectedItem().toString() + "', CEDULA='" + txtCedulaMP.getText() + "', DIRECCION='" + txtDireccionMP.getText() +"', EMAIL_INSTITUCION='" + txtEmailMP.getText() + "', FECHA_NACIMIENTO='" + fecha + "' WHERE CIF=" + cif_mp;

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            personal = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        try {

            String consulta = "UPDATE PERSONAL_ADMINISTRATIVO SET CARGO ='" + txtCargoMP.getText() + "', SALARIO ='" + txtSalarioMP.getText() + "' WHERE CIF=" + cif_mp;

            PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

            sql.executeUpdate();
            admin = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

        if(admin && personal){
            JOptionPane.showMessageDialog(null, "Se han realizado los cambios correctamente");
            rellenarMP(1, cif_mp);
            exeLimpiar();
        }else{
            JOptionPane.showMessageDialog(null, "Error!!!");
        }
    }//GEN-LAST:event_btnGuardarCambiosMPActionPerformed

    private void cmbFacultadMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFacultadMPActionPerformed
        if(cmbFacultadMP.getSelectedIndex()!=0){
            try {
                DefaultTableModel model = new DefaultTableModel();
                jtAdminM.setModel(model);

                Statement sql = Conexion.getConnection().createStatement();

                String consulta = "SELECT P.CIF, P.NOMBRE FROM PERSONAL AS P INNER JOIN PERSONAL_ADMINISTRATIVO AS D ON P.CIF=D.CIF";
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
        if(jtAdminM.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
        }else{
            int row = jtAdminM.getSelectedRow();
            cif_mp = jtAdminM.getModel().getValueAt(row, 0).toString();

            rellenarMP(0,cif_mp);
            rellenarMP(1,cif_mp);
        }
    }//GEN-LAST:event_btnSeleccionarProfeActionPerformed

    private void btnCrearCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCarreraMouseClicked
        ParentPanelCarrera.removeAll();
        ParentPanelCarrera.add(PnlCrearCarrera);
        ParentPanelCarrera.revalidate();
        ParentPanelCarrera.repaint();
        carrera();
        panelSelected();
    }//GEN-LAST:event_btnCrearCarreraMouseClicked

    private void btnCrearCarreraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCarreraMouseEntered
        btnCrearCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearCarrera.png")));
    }//GEN-LAST:event_btnCrearCarreraMouseEntered

    private void btnCrearCarreraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearCarreraMouseExited
        btnCrearCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearCarrera.png")));
        carrera();
    }//GEN-LAST:event_btnCrearCarreraMouseExited

    private void btnEliminarCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCarreraMouseClicked
        ParentPanelCarrera.removeAll();
        ParentPanelCarrera.add(PnlEliminarCarrera);
        ParentPanelCarrera.revalidate();
        ParentPanelCarrera.repaint();
        carrera();
        panelSelected();
    }//GEN-LAST:event_btnEliminarCarreraMouseClicked

    private void btnEliminarCarreraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCarreraMouseEntered
        btnEliminarCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarCarrera.png")));
    }//GEN-LAST:event_btnEliminarCarreraMouseEntered

    private void btnEliminarCarreraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCarreraMouseExited
        btnEliminarCarrera.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarCarrera.png")));
        carrera();
    }//GEN-LAST:event_btnEliminarCarreraMouseExited

    private void CrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearCarreraActionPerformed
        if ((!txtNombreC.getText().equals("")) && (cmbFacultadC.getSelectedIndex() != 0)) {

            try {
                String consulta = "INSERT INTO CARRERA VALUES(" + id_max("ID_CARRERA","CARRERA") + ",'" + cmbFacultadC.getSelectedItem().toString() + "','" + txtNombreC.getText() + "')";

                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "La carrera se ha creado correctamente");
                cmbEliminarC.removeAllItems();
                agregarFacultades(cmbEliminarC);
                exeLimpiar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
    }//GEN-LAST:event_CrearCarreraActionPerformed

    private void cmbEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEliminarCActionPerformed

        if(cmbEliminarC.getSelectedIndex()!=0){
            consultaTabla(cmbEliminarC, 1);
        }else{
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarC.setModel(model);
        }
    }//GEN-LAST:event_cmbEliminarCActionPerformed

    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        int row=jtEliminarC.getSelectedRow();
        String cif = jtEliminarC.getModel().getValueAt(row, 0).toString();

        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE CARRERA WHERE ID_CARRERA=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha elminado correctamente");
            cmbEliminarC.removeAllItems();
            agregarFacultades(cmbEliminarC);
            cmbFacultadC.removeAllItems();
            agregarFacultades(cmbFacultadC);
            exeLimpiar();
            jtEliminarC.removeAll();
            cmbEliminarC.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarCActionPerformed

    private void btnCrearFacultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearFacultadMouseClicked
        ParentPanelFacultad.removeAll();
        ParentPanelFacultad.add(PnlCrearFacultad);
        ParentPanelFacultad.revalidate();
        ParentPanelFacultad.repaint();
        facultad();
        panelSelected();
    }//GEN-LAST:event_btnCrearFacultadMouseClicked

    private void btnCrearFacultadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearFacultadMouseEntered
        btnCrearFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-CrearFacultad.png")));
    }//GEN-LAST:event_btnCrearFacultadMouseEntered

    private void btnCrearFacultadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearFacultadMouseExited
        btnCrearFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/CrearFacultad.png")));
        facultad();
    }//GEN-LAST:event_btnCrearFacultadMouseExited

    private void btnEliminarFacultadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFacultadMouseClicked
        ParentPanelFacultad.removeAll();
        ParentPanelFacultad.add(PnlEliminarFacultad);
        ParentPanelFacultad.revalidate();
        ParentPanelFacultad.repaint();
        facultad();
        panelSelected();
    }//GEN-LAST:event_btnEliminarFacultadMouseClicked

    private void btnEliminarFacultadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFacultadMouseEntered
        btnEliminarFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/Neg-EliminarFacultad.png")));
    }//GEN-LAST:event_btnEliminarFacultadMouseEntered

    private void btnEliminarFacultadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarFacultadMouseExited
        btnEliminarFacultad.setIcon(new ImageIcon(getClass().getResource("/imagesDecano/EliminarFacultad.png")));
        facultad();
    }//GEN-LAST:event_btnEliminarFacultadMouseExited
 
    private void CrearFacultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearFacultadActionPerformed
        if ((!txtNombreF.getText().equals("")) && (!txtIDFacultad.getText().equals("")) && (!txtDecanaF.getText().equals("")) && (!txtEdificio.getText().equals("")) ) {
                try {
                String consulta = "INSERT INTO FACULTAD VALUES('" + txtIDFacultad.getText() + "','" + txtNombreF.getText() + "','" + txtDecanaF.getText() + "','" + txtEdificio.getText() +"')";

                PreparedStatement sql = Conexion.getConnection().prepareStatement(consulta);

                sql.executeUpdate();
                JOptionPane.showMessageDialog(null, "La facultad se ha creado correctamente");
                cmbEliminarF.removeAllItems();
                agregarFacultades(cmbEliminarF);
                exeLimpiar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
        }
            
    }//GEN-LAST:event_CrearFacultadActionPerformed

    private void cmbEliminarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEliminarFActionPerformed
        if(cmbEliminarF.getSelectedIndex()!=0){
            consultaTabla(cmbEliminarF, 3);
        }else{
            DefaultTableModel model = new DefaultTableModel();
            jtEliminarF.setModel(model);
        }
    }//GEN-LAST:event_cmbEliminarFActionPerformed

    private void btnEliminarC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarC1ActionPerformed
        int row=jtEliminarF.getSelectedRow();
        String cif = jtEliminarF.getModel().getValueAt(row, 0).toString();

        try {
            //Aqui se hace un update del registro
            PreparedStatement pps = Conexion.getConnection().prepareStatement("DELETE FACULTAD WHERE COD_FACULTAD=?");
            pps.setString(1, cif);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "El registro se ha eliminado correctamente");
            exeLimpiar();
            cmbEliminarF.removeAllItems();
            agregarFacultades(cmbEliminarF);
            jtEliminarF.removeAll();
            cmbEliminarF.setSelectedIndex(0);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarC1ActionPerformed

   
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new decanoPerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CrearCarrera;
    private javax.swing.JButton CrearFacultad;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JPanel ParentPanelAdmin;
    private javax.swing.JPanel ParentPanelCarrera;
    private javax.swing.JPanel ParentPanelFacultad;
    private javax.swing.JPanel PnlAdmin;
    private javax.swing.JPanel PnlAjustes;
    private javax.swing.JPanel PnlCambioFotoPerfil;
    private javax.swing.JPanel PnlCarrera;
    private javax.swing.JPanel PnlCrearAdmin;
    private javax.swing.JPanel PnlCrearCarrera;
    private javax.swing.JPanel PnlCrearFacultad;
    private javax.swing.JPanel PnlEliminarAdmin;
    private javax.swing.JPanel PnlEliminarCarrera;
    private javax.swing.JPanel PnlEliminarFacultad;
    private javax.swing.JPanel PnlFacultad;
    private javax.swing.JPanel PnlModificarAdmin;
    private javax.swing.JPanel PnlPerfil;
    private javax.swing.JLabel avatar;
    private javax.swing.JLabel avatar1;
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnCarrera;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrearAd;
    private javax.swing.JButton btnCrearAdmin;
    private javax.swing.JButton btnCrearCarrera;
    private javax.swing.JButton btnCrearFacultad;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarAdmin;
    private javax.swing.JButton btnEliminarC;
    private javax.swing.JButton btnEliminarC1;
    private javax.swing.JButton btnEliminarCarrera;
    private javax.swing.JButton btnEliminarFacultad;
    private javax.swing.JButton btnFacultad;
    private javax.swing.JButton btnGuardarCambiosMP;
    private javax.swing.JButton btnGuardarFoto;
    private javax.swing.JButton btnModificacionAdmin;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionarProfe;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cmbEliminarC;
    private javax.swing.JComboBox<String> cmbEliminarF;
    private javax.swing.JComboBox<String> cmbFacultad;
    private javax.swing.JComboBox<String> cmbFacultadA;
    private javax.swing.JComboBox<String> cmbFacultadC;
    private javax.swing.JComboBox<String> cmbFacultadMP;
    private javax.swing.JComboBox<String> cmbFacultadesMPN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel154;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator55;
    private javax.swing.JSeparator jSeparator56;
    private javax.swing.JSeparator jSeparator58;
    private javax.swing.JSeparator jSeparator60;
    private javax.swing.JSeparator jSeparator61;
    private javax.swing.JSeparator jSeparator62;
    private javax.swing.JSeparator jSeparator74;
    private javax.swing.JSeparator jSeparator75;
    private javax.swing.JSeparator jSeparator76;
    private javax.swing.JSeparator jSeparator77;
    private javax.swing.JSeparator jSeparator78;
    private javax.swing.JSeparator jSeparator79;
    private javax.swing.JSeparator jSeparator80;
    private javax.swing.JSeparator jSeparator81;
    private javax.swing.JSeparator jSeparator82;
    private javax.swing.JSeparator jSeparator83;
    private javax.swing.JSeparator jSeparator84;
    private javax.swing.JSeparator jSeparator86;
    private javax.swing.JSeparator jSeparator87;
    private javax.swing.JTextField jTextField13;
    private com.toedter.calendar.JDateChooser jdtNacimientoA;
    private com.toedter.calendar.JDateChooser jdtNacimientoMP;
    private javax.swing.JTable jtAdminM;
    private javax.swing.JTable jtEliminar;
    private javax.swing.JTable jtEliminarC;
    private javax.swing.JTable jtEliminarF;
    private javax.swing.JLabel lblCifA;
    private javax.swing.JLabel lblCifC;
    private javax.swing.JLabel marcoAvatar;
    private javax.swing.JTextField txtApellidosA;
    private javax.swing.JTextField txtCargoA;
    private javax.swing.JTextField txtCargoMP;
    private javax.swing.JTextField txtCedulaA;
    private javax.swing.JTextField txtCedulaMP;
    private javax.swing.JTextField txtDecanaF;
    private javax.swing.JTextField txtDireccionA;
    private javax.swing.JTextField txtDireccionA1;
    private javax.swing.JTextField txtDireccionMP;
    private javax.swing.JTextField txtEdificio;
    private javax.swing.JTextField txtEmailMP;
    private javax.swing.JTextField txtIDFacultad;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreF;
    private javax.swing.JTextField txtNombreMP;
    private javax.swing.JTextField txtSalarioA;
    private javax.swing.JTextField txtSalarioMP;
    // End of variables declaration//GEN-END:variables
}
