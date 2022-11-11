/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 *
 * @author alexm
 */
public class HelpMenuController implements Initializable {
     
    //information panes for each topic
    @FXML private Pane introductionPane;
    @FXML private Pane networkPane;
    @FXML private Pane installPane;
    @FXML private Pane configPane;
    @FXML private Pane navigationPane;
    @FXML private Pane transcodePane;
    @FXML private Pane externalPane;
    
    //left topic toggle buttons
    @FXML private ToggleButton introductionBtn;
    @FXML private ToggleButton networkBtn;
    @FXML private ToggleButton installBtn;
    @FXML private ToggleButton configBtn;
    @FXML private ToggleButton navigationBtn;
    @FXML private ToggleButton transcodeBtn;
    @FXML private ToggleButton externalBtn;
    
    //topic button toggle group
    private ToggleGroup sideBarToggleGroup;
    
    private String currentPane;
    
    
    //events that occur when left toggle buttons are selected
    
    public void introductionBtnPressed()
    {
        introductionPane.toFront();
        currentPane = "introduction";
    }  
    
    public void networkBtnPressed()
    {
        networkPane.toFront();
        currentPane = "network";
    } 
    
    public void installBtnPressed()
    {
        installPane.toFront();
        currentPane = "install";
    } 
    
    public void configBtnPressed()
    {
        configPane.toFront();
        currentPane = "config";
    } 
    
    public void navigationBtnPressed()
    {
        navigationPane.toFront();
        currentPane = "navigation";
    } 
    
    public void transcodeBtnPressed()
    {
        transcodePane.toFront();
        currentPane = "transcode";
    } 
    
    public void externalBtnPressed()
    {
        externalPane.toFront();
        currentPane = "external";
    } 
   
    
    //purpose: handles the event when then next button is pressed
    public void nextBtnPressed()
    {
        if (currentPane.equals("introduction"))
        {
            networkPane.toFront();
            currentPane = "network";
            networkBtn.setSelected(true);
        }    
        else if (currentPane.equals("network"))
        {
            installPane.toFront();
            currentPane = "install";
            installBtn.setSelected(true);
        }    
        else if (currentPane.equals("install"))
        {
            configPane.toFront();
            currentPane = "config";
            configBtn.setSelected(true);
        }    
        else if (currentPane.equals("config"))
        {
            navigationPane.toFront();
            currentPane = "navigation";
            navigationBtn.setSelected(true);
        }    
        else if (currentPane.equals("navigation"))
        {    
            transcodePane.toFront();
            currentPane = "transcode";
            transcodeBtn.setSelected(true);
        }
        else if (currentPane.equals("transcode"))
        {
            externalPane.toFront();
            currentPane = "external";
            externalBtn.setSelected(true);
        }    
        else if (currentPane.equals("external"))
        {
            
        }                       
    } 
    
    //purpose: handles the event when the previous button is selected
    public void prevBtnPressed()
    {
        if (currentPane.equals("introduction"))
        {
            
        }    
        else if (currentPane.equals("network"))
        {
            introductionPane.toFront();
            currentPane = "introduction";
            introductionBtn.setSelected(true);
        }    
        else if (currentPane.equals("install"))
        {
            networkPane.toFront();
            currentPane = "network";
            networkBtn.setSelected(true);
        }    
        else if (currentPane.equals("config"))
        {
            installPane.toFront();
            currentPane = "install";
            installBtn.setSelected(true);
        }    
        else if (currentPane.equals("navigation"))
        {    
            configPane.toFront();
            currentPane = "config";
            configBtn.setSelected(true);
        }
        else if (currentPane.equals("transcode"))
        {
            navigationPane.toFront();
            currentPane = "navigation";
            navigationBtn.setSelected(true);
        }    
        else if (currentPane.equals("external"))
        {
            transcodePane.toFront();
            currentPane = "transcode";
            transcodeBtn.setSelected(true);
        }                    
    }
    
    //purpose: initialises different elements
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //set the starting pane
        currentPane = "introduction";
        
        //set toggle pane
        sideBarToggleGroup = new ToggleGroup();
        this.introductionBtn.setToggleGroup(sideBarToggleGroup);
        this.networkBtn.setToggleGroup(sideBarToggleGroup);
        this.installBtn.setToggleGroup(sideBarToggleGroup);
        this.configBtn.setToggleGroup(sideBarToggleGroup);
        this.navigationBtn.setToggleGroup(sideBarToggleGroup);
        this.transcodeBtn.setToggleGroup(sideBarToggleGroup);
        this.externalBtn.setToggleGroup(sideBarToggleGroup);
        
        //put starting pane to the front
        introductionPane.toFront();
        introductionBtn.setSelected(true);
    }    
    
}
