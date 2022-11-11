/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

/**
 *
 * @author alex mcleod
 * purpose: creates the contents of the ComboBox contain option information
 */
public class OptionSelector 
{
    private ComboBox options;  
    
    private Tooltip mediaStatusTooltip;
    private Tooltip logsTooltip;
    private Tooltip sharedContentTooltip;        
    private Tooltip settingsTooltip;        
    private Tooltip helpTooltip;        
    private Tooltip aboutTooltip;
    
    private Label mediaStatusLab;   
    private Label logsLab;
    private Label sharedContentLab;
    private Label settingsLab;
    private Label helpLab;
    private Label aboutLab;  
    
    private ScreenChanger screenChanger;
            
    public OptionSelector()
    {        
        screenChanger = new ScreenChanger();
    }       
    
    public void setup(ComboBox options)
    {                      
       
        //these are the different options 
        options.getItems().add("Media Status");
        options.getItems().add("Logs");
        options.getItems().add("Shared Content");
        options.getItems().add("Settings");
        options.getItems().add("Help");
        options.getItems().add("About");
        options.setValue("Options");  
    }      
    
    
    
    public void getSelectedOption(String thisScreen, String chosenOption, ActionEvent event) throws IOException
    {
        
        if(chosenOption.equals("Media Status") && !thisScreen.equals("Media Status"))
        {
            screenChanger.changeScreenToMediaStatus(event);
            
        }       
        else if(chosenOption.equals("Logs") && !thisScreen.equals("Logs"))
        {
            screenChanger.changeScreenToLogs(event);
            
        }  
        else if(chosenOption.equals("Shared Content") && !thisScreen.equals("Shared Content"))
        {
            screenChanger.changeScreenToSharedContent(event);
        }    
        else if(chosenOption.equals("Settings") && !thisScreen.equals("Settings"))
        {
            screenChanger.changeScreenToSettings(event);
            
        }   
        else if(chosenOption.equals("Help"))
        {
            screenChanger.changeScreenToHelp(event);
            
        }  
        else if(chosenOption.equals("About"))
        {
            screenChanger.changeScreenToAbout(event);
            
        }  
        
    }        
            
}
