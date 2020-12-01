package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Cuenta {
    public static int tipoCuenta(String CIF){
        int retorno = 0;  
        
        try {
            Statement sql = Conexion.getConnection().createStatement();
            
            String consulta = "SELECT * FROM ESTUDIANTE WHERE CIF='" + CIF + "'";
            ResultSet resultado = sql.executeQuery(consulta);
            
            while(resultado.next()){
                retorno=1;
            }
        } catch (SQLException ex) {
        }
        
        if(retorno==0){
            try {
                Statement sql = Conexion.getConnection().createStatement();

                String consulta = "SELECT * FROM DOCENTE WHERE ID_DOCENTE='" + CIF + "'";
                ResultSet resultado = sql.executeQuery(consulta);

                while (resultado.next()) {
                    retorno = 2;
                }
            } catch (SQLException ex) {
            }
        }
        
        if(retorno==0){
            try {
                Statement sql = Conexion.getConnection().createStatement();

                String consulta = "SELECT * FROM PERSONAL_ADMINISTRATIVO WHERE CIF='" + CIF + "'";
                ResultSet resultado = sql.executeQuery(consulta);

                while (resultado.next()) {
                    retorno = 3;
                }
            } catch (SQLException ex) {
            }
        }
        
        return retorno;
    }
}
