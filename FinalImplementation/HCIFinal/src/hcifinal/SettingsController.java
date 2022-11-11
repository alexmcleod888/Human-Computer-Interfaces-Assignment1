/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import javafx.stage.Stage;

/**
 *
 * @author alexm
 */
public class SettingsController implements Initializable {
   
    //reference to bottom left options combo box
    @FXML private ComboBox options;
   
    private ScreenChanger screenChanger;
    private OptionSelector optionSelector;
    private String thisScreen;
    /* 
        check the options chosen and switch menu's
    */
    public void optionChanged(ActionEvent event) throws IOException
    {
        String chosenOption;
        
        chosenOption = options.getValue().toString();
        
        optionSelector.getSelectedOption(thisScreen, chosenOption, event);
         
    }       
    
    /*
    When this method is called it will close the app
    */
    public void closeInterface(ActionEvent event) throws IOException
    {
         //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }    
    
    /*
    when this method is called the server is shutdown
    */
    public void shutDownServer(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenShutdownNoti(event);
    }
    
    /*
    when this method is called the server is shutdown
    */
    public void restartServer(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenRestartNoti(event);
    }
    
    /*
    when this method is called the server is shutdown
    */
    public void openWebInterface(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenWebInterfaceNoti(event);
    }   
            
              
       

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //create object that handles screen changes
        screenChanger = new ScreenChanger();
        
        //set up expandable options menu
        optionSelector = new OptionSelector();
        optionSelector.setup(options);
        
        thisScreen = "Settings";
    }    
    
}
