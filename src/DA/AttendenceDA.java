/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DA;

import domain.attendence;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author kwongwenzhi
 */
public class AttendenceDA {
    private String host = "jdbc:derby://localhost:1527/FastestDeliveryMan";
    private String user = "Testing";
    private String password = "testing";
    private String tableName = "ATTENDENCESHEET";
    private Connection conn;
    private PreparedStatement stmt;

    public AttendenceDA(){
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
    
    public ArrayList<attendence> filterRecord(String Status){
        ResultSet rs = null;
        String queryStr = "SELECT * FROM " + tableName + "WHERE STATUS = Available";
        //attendence Attendence = null;
        ArrayList<attendence> Attendence = new ArrayList<attendence>();
        try{
           stmt = conn.prepareStatement(queryStr);
           stmt.setString(1, Status);
           
            rs = stmt.executeQuery();

            attendence attd;
            
            while (rs.next()) {
                attd = new attendence(
                        rs.getString("ID"),
                        rs.getString("NAME"),
                        rs.getString("CLOCKIN"),
                        rs.getString("CLOCKOUT"),
                        rs.getString("STATUS")
                );
                Attendence.add(attd);
                //Attendence = new attendence(rs.getString("ID"), rs.getString("NAME"), rs.getString("CLOCKIN"),rs.getString("CLOCKOUT"),rs.getString("STATUS"));
            }    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        return Attendence;
    }
    
        public ResultSet selectRecord(String id){
        String queryStr = "SELECT * FROM " + tableName + " WHERE STATUS = ?";
        ResultSet rs = null;
        try{
            stmt = conn.prepareStatement(queryStr);
            stmt.setString(1,id);
            
            rs = stmt.executeQuery();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}
