/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author kwongwenzhi
 */
public class attendence {
    
    private String ID;
    private String Name;
    private String ClockIn;
    private String ClockOut;
    private String Status;    
    
    
    public attendence(){
    }
    
    public attendence(String ID, String Name, String ClockIn, String ClockOut, String Status){
        this.ID = ID;
        this.Name = Name;
        this.ClockIn = ClockIn;
        this.ClockOut = ClockOut;
        this.Status = Status;  
    }

    public attendence(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public attendence(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
	
    public void setName(String Name){
        this.Name = Name;
    }
	
    public void setClockIn(String ClockIn){
        this.ClockIn = ClockIn;
    }
	
    public void setClockOut(String ClockOut){
        this.ClockOut = ClockOut;
    }
	
    public void setStatus(String Status){
        this.Status = Status;
    }  
    
    public String getID(){
        return ID;
    }
	
    public String getName(){
        return Name;
    }
	
    public String getClockIn(){
        return ClockIn;
    }
	
    public String getClockOut(){
        return ClockOut;
    }
	
    public String getStatus(){
        return Status;
    }	

}
