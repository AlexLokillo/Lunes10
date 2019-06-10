
package GestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AsistenteBD {
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    String driver ="org.sqlite.JDBC";
    String nombreBD ="empresa.sqlite";
    String url ="jdbc:sqlite:"+nombreBD;
    
    public void crearBD(){
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Base de datos creada con exito");
    }//.
    
    public void crearTabla(){
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = ("CREATE TABLE CLIENTE" + 
                "(ID        INT     PRIMARY KEY NOT NULL,"+
                "NOMBRE     TEXT    NOT NULL,"+
                "APELLIDO   TEXT    NOT NULL,"+
                "EDAD       INT)");
                sentencia.executeUpdate(sql);
                sentencia.close();
                conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Base de datos creada con exito");
    }
    
    public void IngresarDatos(){
        
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = "INSERT INTO CLIENTE"+
                "(ID, NOMBRE, APELLIDO, EDAD)"+
                "VALUES(1, 'AGUSTIN', 'ALVAREZ', 33)";
                sentencia.executeUpdate(sql);
                sentencia.close();
                conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Usuario agregado con exito");
    }
    
    public void mostrarDatos(){
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        String sql = "SELECT * FROM CLIENTE";
        resultado = sentencia.executeQuery(sql);
        while(resultado.next()){
            int id = resultado.getInt("ID");
            String nombre =resultado.getString("NOMBRE");
            String apellido =resultado.getString("APELLIDO");
            int edad = resultado.getInt("EDAD");
            
            System.out.println("\nID: " + id+ 
                    "\nNOMBRE: " + nombre+
                    "\nAPELLIDO: "+ apellido+
                    "\nEDAD: "+ edad);
            
        }
        
                resultado.close();
                sentencia.close();
                conexion.close();
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Usuario agregado con exito");
    
    }
    
    public void updateBD(){
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        sentencia.executeUpdate ("UPDATE CLIENTE "+
                "set NOMBRE = 'ALEX', APELLIDO = 'ORELLANA', EDAD = 19 WHERE ID = 1");
        
        
               
                sentencia.close();
                
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Actualizacion con exito");
    }
    
    public void eliminarBD(){
        try{
        Class.forName(driver);
        conexion = DriverManager.getConnection(url);
        sentencia = conexion.createStatement();
        sentencia.executeUpdate ("DELETE FROM CLIENTE WHERE ID = 1");
       
                sentencia.close();
                
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Eliminado con exito");
    }
}//fin clase.
