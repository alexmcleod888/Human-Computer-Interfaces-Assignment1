/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author alexm
 */
public class LogController implements Initializable {
    
  
    @FXML private ComboBox options;
    
    //initialise screenChanger for changing scenes
    private ScreenChanger screenChanger;
    
    //initialise option selector to determine what to do when an option is selected
    private OptionSelector optionSelector;
    
    private String thisScreen;
    
    //table of logs 
    @FXML private TableView<LogClass> logTable;
    @FXML private TableColumn<LogClass, String> logColumn;
    
    //search Field
    @FXML private TextField searchField; 
    
    //this is the list of logs
    ObservableList<LogClass> logs;
    
    //this is the new list of logs after a search
    ObservableList<LogClass> newLogs;
    
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
    This is the method called when the search button is pressed
    */
    public void searchBtnPressed()
    {
        newLogs = FXCollections.observableArrayList();
        String searchString = searchField.getText();
        
        if(!searchString.equals(""))
        {    
            for (LogClass log : logs)
            {
                String logString = log.getLogName();           
                if(logString.contains(searchString))
                {
                    newLogs.add(new LogClass(logString));
                }    
            }
            logs.clear();
            logTable.setItems(newLogs);        
        }        
        else
        {
            logs.clear();
            logTable.setItems(getLogs());  
        }    
    }          
       
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //create object that handles screen changes
        screenChanger = new ScreenChanger();
        
        //set up expandable options menu
        optionSelector = new OptionSelector();
        optionSelector.setup(options);
        
        thisScreen = "Logs";
        
        logColumn.setCellValueFactory(new PropertyValueFactory<LogClass, String>("logName"));      
        logTable.setItems(getLogs());
        
                
        
    }    
    
    //set dummy log data
    public ObservableList<LogClass> getLogs()
    {
        logs = FXCollections.observableArrayList();
        logs.add(new LogClass("16:00:49 INFO  :   Yamaha RX-V500D"));
        logs.add(new LogClass("16:00:49 INFO  :   Yamaha RX-V671"));
        logs.add(new LogClass("16:00:49 INFO  Checking the fontconfig cache in the background, this can take two minutes or so."));
        logs.add(new LogClass("16:00:49 INFO  Configuration saved to \"C:\\ProgramData\\UMS\\UMS.conf\""));
        logs.add(new LogClass("16:00:49 INFO  VSFilter / DirectVobSub was not found. This can cause problems when trying to play"));
        logs.add(new LogClass("16:00:49 INFO  Transcoding engine \"AviSynth/FFmpeg\" is available"));
        logs.add(new LogClass("16:00:50 INFO  Transcoding engine \"FFmpeg Audio\" is available"));
        logs.add(new LogClass("16:00:50 INFO  Transcoding engine \"MEncoder Video\" is available"));
        logs.add(new LogClass("16:00:50 INFO  Transcoding engine \"FFmpeg Video\" is available"));
        logs.add(new LogClass("16:00:50 WARN  Transcoding engine \"VLC Video\" is not available"));
        logs.add(new LogClass("16:00:50 INFO  Transcoding engine \"FFmpeg Web Video\" is available"));
        
        
        
        return logs;
    }
    
    
    
    
}
