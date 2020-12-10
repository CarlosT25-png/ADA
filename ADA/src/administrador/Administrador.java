/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import java.sql.Date;

public class Administrador {
    private int ID_CARRERA, CIF;
    private double SALARIO;
    private String COD_FACULTAD, NOMBRE, CEDULA, DIRECCION, EMAIL_INSTITUCION, CONTRASENA_SISTEMA, CARGO;
    java.sql.Date FECHA_NACIMIENTO;
    
    public Administrador(int CIF, String NOMBRE, String CEDULA, String DIRECCION, String CARGO, Double SALARIO,String COD_FACULTAD,java.sql.Date FECHA_NACIMINETO){
        this.CIF=CIF;
        this.NOMBRE=NOMBRE;
        this.CEDULA=CEDULA;
        this.DIRECCION=DIRECCION;
        this.CARGO = CARGO;
        this.SALARIO = SALARIO;
        this.COD_FACULTAD = COD_FACULTAD;
        this.FECHA_NACIMIENTO=FECHA_NACIMINETO;
    }
    
    public Administrador(int CIF, String NOMBRE, String CEDULA, String DIRECCION, String CARGO, Double SALARIO, String COD_FACULTAD, java.sql.Date FECHA_NACIMINETO, String EMAIL_INSTITUCION, String CONTRASENA_SISTEMA){
        this.CIF=CIF;
        this.NOMBRE=NOMBRE;
        this.CEDULA=CEDULA;
        this.DIRECCION=DIRECCION;
        this.FECHA_NACIMIENTO=FECHA_NACIMINETO;
        this.EMAIL_INSTITUCION=EMAIL_INSTITUCION;
        this.CONTRASENA_SISTEMA=CONTRASENA_SISTEMA;
        this.CARGO = CARGO;
        this.SALARIO = SALARIO;
        this.COD_FACULTAD = COD_FACULTAD;
    }

    public double getSALARIO() {
        return SALARIO;
    }

    public void setSALARIO(double SALARIO) {
        this.SALARIO = SALARIO;
    }

    public String getCARGO() {
        return CARGO;
    }

    public void setCARGO(String CARGO) {
        this.CARGO = CARGO;
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

    public Date getFECHA_NACIMIENTO() {
        return FECHA_NACIMIENTO;
    }

    public void setFECHA_NACIMIENTO(Date FECHA_NACIMIENTO) {
        this.FECHA_NACIMIENTO = FECHA_NACIMIENTO;
    }    
}
