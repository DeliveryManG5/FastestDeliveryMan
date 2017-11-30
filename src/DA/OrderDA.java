/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kwongwenzhi
 */
public class OrderDA {
    private String host = "jdbc:derby://localhost:1527/FastestDeliveryMan";
    private String user = "Testing";
    private String password = "testing";
    private String tableName = "FOODORDER";
    private Connection conn;
    private PreparedStatement stmt;   
    
    public OrderDA(){
        createConnection();
    }
    
    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(host, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }  
    
    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
    
        public ResultSet selectRecord(){
        String queryStr = "SELECT * FROM " + tableName;
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }  
}
