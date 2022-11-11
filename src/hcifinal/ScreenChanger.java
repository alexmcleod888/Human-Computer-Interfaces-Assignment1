/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author student
 */
public class ScreenChanger 
{
     /*
    When this method is called it will change the scene to the Media Status
    screen
    */
    public void changeScreenToMediaStatus(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MediaStatus.fxml"));
        Scene mediaScene = new Scene(tableViewParent);
        
        //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(mediaScene);
        window.show();     
    }
    
    
     /*
    When this method is called it will change the scene to the logs
    screen
    */
    public void changeScreenToLogs(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Log.fxml"));
        Scene logsScene = new Scene(tableViewParent);
        
        //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(logsScene);
        window.show();     
    }
    
    /*
    When this method is called it will change the scene to the shared content
    screen
    */
    public void changeScreenToSharedContent(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SharedContent.fxml"));
        Scene sharedContentScene = new Scene(tableViewParent);
        
        //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(sharedContentScene);
        window.show();     
    }
    
    /*
    When this method is called it will change the scene to the shared content
    screen
    */
    public void changeScreenToSettings(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene settingsScene = new Scene(tableViewParent);
        
        //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(settingsScene);
        window.show();     
    }
    /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenToHelp(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("HelpMenu.fxml"));
        
        Stage stage = new Stage();
        
        stage.setTitle("Help Menu");
        stage.setResizable(false);
        stage.setScene(new Scene(tableViewParent));
        stage.show();  
    }
    
     /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenToAbout(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("About.fxml"));
        
        Stage stage = new Stage();
        
        stage.setTitle("About Screen");
        stage.setResizable(false);
        stage.setScene(new Scene(tableViewParent));
        stage.show();  
    }   
    
     /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenShutdownNoti(ActionEvent event) throws IOException
    {
       
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("notifications/ShutdownNoti.fxml"));
        Scene settingsScene = new Scene(tableViewParent);
        
        //this line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(settingsScene);
        window.show();   
    }  
    
     /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenRestartNoti(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("notifications/RestartNoti.fxml"));
        
        Stage stage = new Stage();
        
        stage.setTitle("Restart Notification");
        stage.setScene(new Scene(tableViewParent));
        stage.show();  
    }  
    
     /*
    When this method is called it will change the scene to the help menu
    screen
    */
    public void changeScreenWebInterfaceNoti(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("notifications/WebInterfaceNoti.fxml"));
        
        Stage stage = new Stage();
        
        stage.setTitle("Web Interface Notification");
        stage.setScene(new Scene(tableViewParent));
        stage.show();  
    }  
    
    
}
