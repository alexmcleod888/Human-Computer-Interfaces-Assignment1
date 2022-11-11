/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal.notifications;

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
 * purpose: controller for setting the Restart notification screen.
 */
public class RestartNotiController implements Initializable {

    
      
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
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
