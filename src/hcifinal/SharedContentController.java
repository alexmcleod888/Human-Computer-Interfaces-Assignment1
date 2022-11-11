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
import javafx.scene.control.CheckBox;

import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 *
 * @author alexm
 */
public class SharedContentController implements Initializable {
    
    @FXML private ComboBox options;
    
    //define references to tables
    @FXML private TableView<SharedFolder> folderTable;
    @FXML private TableColumn<SharedFolder, String> folderNameColumn;
    @FXML private TableColumn<SharedFolder, CheckBox> monitorColumn;
    
    @FXML private TableView<WebContent> contentTable;
    @FXML private TableColumn<WebContent, String> typeColumn;
    @FXML private TableColumn<WebContent, String> webFolderNameColumn;
    @FXML private TableColumn<WebContent, String> sourceColumn;
    
    //set the current number of folder in the tables
    private int numNewFolders;
    private int numWebContent;
    
    private ScreenChanger screenChanger;//for changing scenes
    
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
   
    //purpose: for adding new folder to shared folders table
    public void addFolder()
    {
        SharedFolder newFolder = new SharedFolder("Folder " + numNewFolders);
        folderTable.getItems().add(newFolder);
        
        numNewFolders += 1;
    }        
    
    //purpose: for removing folders from shared folders table
    public void removeFolder()
    {
        int selectedRow;       
        
        selectedRow = folderTable.getSelectionModel().getSelectedIndex();
        
        if(folderTable.getItems().isEmpty() == false && selectedRow >= 0)
        {    
            folderTable.getItems().remove(selectedRow);
        }       
    } 
    
    //purpose: for adding web content to the web content table
    public void addWebContent()
    {
        WebContent newWebContent = new WebContent("newVideo Feed " + numWebContent, "Web, YouTube Channels", "https://www.youtube.com/random" + numWebContent);
        contentTable.getItems().add(newWebContent);
        
        numWebContent += 1;
    }        
    
    //purpose: for removing web content from the web content table
    public void removeWebContent()
    {
        int selectedRow;
        
        selectedRow = contentTable.getSelectionModel().getSelectedIndex();
        
        if(contentTable.getItems().isEmpty() == false && selectedRow >= 0)
        {   
            contentTable.getItems().remove(selectedRow);
        }    
       
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
        numNewFolders = 0;
        numWebContent = 0;
        
        //create object that handles screen changes
        screenChanger = new ScreenChanger();
        
        //set up expandable options menu
        optionSelector = new OptionSelector();
        optionSelector.setup(options);
        
        thisScreen = "Shared Content";
        
        //set columns of folderTable table view
        folderNameColumn.setCellValueFactory(new PropertyValueFactory<SharedFolder, String>("folderName"));
        monitorColumn.setCellValueFactory(new PropertyValueFactory<SharedFolder, CheckBox>("monitorPlayedStatus")); 
        
        //load some dummy data
        folderTable.setItems(getFolders());
        
        //allow a single row to be selected at a time
        folderTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        //set column of contentTable properties
        typeColumn.setCellValueFactory(new PropertyValueFactory<WebContent, String>("contentType"));
        webFolderNameColumn.setCellValueFactory(new PropertyValueFactory<WebContent, String>("folderName")); 
        sourceColumn.setCellValueFactory(new PropertyValueFactory<WebContent, String>("source")); 
        
        //load some dummy data
        contentTable.setItems(getWebContent());
        
        //allow a single row to be selected at a time
        contentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        
        
    }    
    
    /*
     * This method will return an Observable list of SharedFolder objects
    */
    public ObservableList<SharedFolder> getFolders()
    {
        ObservableList<SharedFolder> folders = FXCollections.observableArrayList();
        folders.add(new SharedFolder("myFolder"));
        folders.add(new SharedFolder("myCoolFolder"));
        folders.add(new SharedFolder("myGreatFolder"));
        folders.add(new SharedFolder("myCrazyFolder"));
        
        return folders;
    }
    
     /*
     * This method will return an Observable list of WebContent objects
    */
    public ObservableList<WebContent> getWebContent()
    {
        ObservableList<WebContent> webContent = FXCollections.observableArrayList();
        webContent.add(new WebContent("Video Feed", "Web, YouTube Channels", "http:://www.youtube.com/feeds/videos.xml/randomVideo1"));
        webContent.add(new WebContent("Image Feed", "Web, Pictures", "http:://api.flickr/feeds/photo/randomPhoto1"));
        webContent.add(new WebContent("Video Feed", "Web, YouTube Channels", "http:://facebook/feeds/videos.xml/randomVideo2"));
        webContent.add(new WebContent("Video Feed", "Web, YouTube Channels", "http:://InstagramTV/feeds/videos.xml/randomVideo3"));
        
        return webContent;
    }     
    
}
