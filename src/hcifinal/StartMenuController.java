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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 *
 * @author alexm
 */
public class StartMenuController implements Initializable {
   
    private ScreenChanger screenChanger;
    /*
    When this method is called it will change the scene to the media status
    screen
    */
    public void changeScreenToMediaStatus(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenToMediaStatus(event);
    }
    
    /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenToHelp(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenToHelp(event);
    }
    
    /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenToAbout(ActionEvent event) throws IOException
    {
        screenChanger.changeScreenToAbout(event);
    }
    
    
    /*
    When this method is called it will close the app
    */
    public void closeMenu(ActionEvent event) throws IOException
    {
         //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        screenChanger = new ScreenChanger();
    }    
    
    
    
}
