/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author abc
 */
public class Connection {
     private static final String URL = "jdbc:mysql://localhost:3306/gms";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    
    private static java.sql.Connection connection = null;
    private static Statement statement = null;
    
    /* Creating Connection*/
    public static void connection(){
       try{
            Class.forName("com.mysql.jdbc.Driver");
           
           connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connection Opened");
        }catch(SQLException e){            
            JOptionPane.showMessageDialog(null, "Connection is not Opened ! " + e.getMessage());  } catch (ClassNotFoundException ex) {    
             Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
         }    
        }
       
    
}
