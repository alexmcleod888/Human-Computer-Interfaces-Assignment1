/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author alex mcleod
 * purpose: container class for holding the information for each Shared Folder table element
 */
public class SharedFolder 
{
    private SimpleStringProperty folderName;
    private CheckBox monitorPlayedStatus;
    
    public SharedFolder(String folderName)
    {
        this.folderName = new SimpleStringProperty(folderName);
        this.monitorPlayedStatus = new CheckBox("monitor");

    }    

    
    public String getFolderName() {
        return folderName.get();
    }

    public void setFolderName(SimpleStringProperty folderName) {
        this.folderName = folderName;
    }

    public CheckBox getMonitorPlayedStatus() {
        return monitorPlayedStatus;
    }

    public void setMonitorPlayedStatus(CheckBox monitorPlayedStatus) {
        this.monitorPlayedStatus = monitorPlayedStatus;
    }

        
}
