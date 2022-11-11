/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author alexm
 */
public class MediaStatusController implements Initializable {
    
  
    @FXML private ComboBox options;
    @FXML private ImageView ybox;
    @FXML private ImageView gamestation;
    @FXML private ImageView eternet;
    @FXML private Text yboxInfo;
    @FXML private Text gamestationInfo;
    @FXML private Text eternetInfo;
    
    @FXML private ProgressBar memoryUsageBar;
    
    @FXML private Text currentMbs;
    
    @FXML private Text helpline1;
    @FXML private Text helpline2;
    @FXML private Text helpline3;
    
    @FXML private SplitPane mySplitPane;
    
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
    
    /*
    handles the detect button press
    */
    public void detectMedia(ActionEvent event) throws IOException
    {
        ybox.setOpacity(1.00);
        gamestation.setOpacity(1.0);
        eternet.setOpacity(1.0);
        yboxInfo.setOpacity(1.00);
        gamestationInfo.setOpacity(1.0);
        eternetInfo.setOpacity(1.0);
        
        
        helpline1.setOpacity(0.0);
        helpline2.setOpacity(0.0);
        helpline3.setOpacity(0.0);
        
        memoryUsageBar.setProgress(0.4);
        
        currentMbs.setText("Current: 34.0 Mb/s");
    }     
    
    /*
    clear the media's renderer's
    */
    public void clearMedia(ActionEvent event) throws IOException
    {
        ybox.setOpacity(0.0);
        gamestation.setOpacity(0.0);
        eternet.setOpacity(0.0);
        yboxInfo.setOpacity(0.0);
        gamestationInfo.setOpacity(0.0);
        eternetInfo.setOpacity(0.0);
        
        helpline1.setOpacity(1.0);
        helpline2.setOpacity(1.0);
        helpline3.setOpacity(1.0);
        
        memoryUsageBar.setProgress(0.0);
        
        currentMbs.setText("Current: 0.0 Mb/s");
    }        
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {            
        //create object that handles screen changes
        screenChanger = new ScreenChanger();
        
        thisScreen = "Media Status";
        //set up expandable options menu
        optionSelector = new OptionSelector();
        optionSelector.setup(options);  
        
       
        
        
    }    
    
    public void doNothing()
    {
       
    }        
    
}
