/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesor;

import java.sql.Date;

/**
 *
 * @author carto
 */
public class Profesor {
    private int CIF, ID_CARRERA;
    private String COD_FACULTAD, NOMBRE, CEDULA, DIRECCION, EMAIL_INSTITUCION, CONTRASENA_SISTEMA, ESPECIALIDAD, ESTADO;
    java.sql.Date FECHA_NACIMIENTO;
    
    public Profesor(int CIF, String COD_FACULTAD, String NOMBRE, String CEDULA, String DIRECCION, java.sql.Date FECHA_NACIMINETO, String EMAIL_INSTITUCION, String CONTRASENA_SISTEMA, String ESPECIALIDAD, String ESTADO){
        this.CIF=CIF;
        this.COD_FACULTAD=COD_FACULTAD;
        this.NOMBRE=NOMBRE;
        this.CEDULA=CEDULA;
        this.DIRECCION=DIRECCION;
        this.FECHA_NACIMIENTO=FECHA_NACIMINETO;
        this.EMAIL_INSTITUCION=EMAIL_INSTITUCION;
        this.CONTRASENA_SISTEMA=CONTRASENA_SISTEMA;
        this.ESPECIALIDAD=ESPECIALIDAD;
        this.ESTADO=ESTADO;
    }
    
    public Profesor(int CIF, String COD_FACULTAD, String NOMBRE, String CEDULA, String DIRECCION, java.sql.Date FECHA_NACIMINETO, String ESPECIALIDAD, String ESTADO){
        this.CIF=CIF;
        this.COD_FACULTAD=COD_FACULTAD;
        this.NOMBRE=NOMBRE;
        this.CEDULA=CEDULA;
        this.DIRECCION=DIRECCION;
        this.FECHA_NACIMIENTO=FECHA_NACIMINETO;
        this.ESPECIALIDAD=ESPECIALIDAD;
        this.ESTADO=ESTADO;
    }

    public int getCIF() {
        return CIF;
    }

    public void setCIF(int CIF) {
        this.CIF = CIF;
    }

    public int getID_CARRERA() {
        return ID_CARRERA;
    }

    public void setID_CARRERA(int ID_CARRERA) {
        this.ID_CARRERA = ID_CARRERA;
    }

    public String getCOD_FACULTAD() {
        return COD_FACULTAD;
    }

    public void setCOD_FACULTAD(String COD_FACULTAD) {
        this.COD_FACULTAD = COD_FACULTAD;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String CEDULA) {
        this.CEDULA = CEDULA;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getEMAIL_INSTITUCION() {
        return EMAIL_INSTITUCION;
    }

    public void setEMAIL_INSTITUCION(String EMAIL_INSTITUCION) {
        this.EMAIL_INSTITUCION = EMAIL_INSTITUCION;
    }

    public String getCONTRASENA_SISTEMA() {
        return CONTRASENA_SISTEMA;
    }

    public void setCONTRASENA_SISTEMA(String CONTRASENA_SISTEMA) {
        this.CONTRASENA_SISTEMA = CONTRASENA_SISTEMA;
    }

    public String getESPECIALIDAD() {
        return ESPECIALIDAD;
    }

    public void setESPECIALIDAD(String ESPECIALIDAD) {
        this.ESPECIALIDAD = ESPECIALIDAD;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }    
}
