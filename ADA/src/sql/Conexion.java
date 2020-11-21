package sql;

import java.sql.*;

public class Conexion {
    
    public static Connection getConnection(){
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=ADA;"
                + "user=sa;"
                + "password=123;"
                + "loginTimeout=30;";
        
        try {
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }       
    }
}
