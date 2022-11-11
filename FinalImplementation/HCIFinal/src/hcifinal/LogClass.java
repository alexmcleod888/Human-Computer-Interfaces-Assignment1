/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Alex McLeod
 * purpose: class used to store each of the log lines in the log table
 */
public class LogClass 
{
    private SimpleStringProperty logName;
    
    public LogClass(String logName)
    {
        this.logName = new SimpleStringProperty(logName);
    }    

    
    public String getLogName() {
        return logName.get();
    }

    public void setLogName(SimpleStringProperty logName) {
        this.logName = logName;
    }
}
