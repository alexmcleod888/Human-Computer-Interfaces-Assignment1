/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hcifinal;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author alex mcleod
 * purpose: container class for holding the information for an element in the Web Content table
 */
public class WebContent 
{
    private SimpleStringProperty contentType;
    private SimpleStringProperty folderName;
    private SimpleStringProperty source;
    
    public WebContent(String newContentType, String newFolderName, String newSource)
    {
        this.contentType = new SimpleStringProperty(newContentType);
        this.folderName = new SimpleStringProperty(newFolderName);
        this.source = new SimpleStringProperty(newSource);
        
    }        

    public String getContentType() {
        return contentType.get();
    }

    public void setContentType(SimpleStringProperty contentType) {
        this.contentType = contentType;
    }

    public String getFolderName() {
        return folderName.get();
    }

    public void setFolderName(SimpleStringProperty folderName) {
        this.folderName = folderName;
    }

    public String getSource() {
        return source.get();
    }

    public void setSource(SimpleStringProperty Source) {
        this.source = Source;
    }
    
    
    
}
