/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.Item;
import helpers.FileHelpers;
import helpers.OutputHelpers;
import helpers.StringHelpers;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dgallup14
 */
public class FileIO_Objects {
     public static final String DEFAULT_FILE_NAME = "itemStream.dat";
    public static final String DELIMTER = ",";
    
    private String fileName;
    
    public FileIO_Objects() {
        fileName = DEFAULT_FILE_NAME;
    }
    public FileIO_Objects(String fileName) {
        setFileName(fileName);
    }
    public final void setFileName(String fileName) {
        if (StringHelpers.IsNullOrEmpty(fileName)) {
            this.fileName = DEFAULT_FILE_NAME;
        }
        else {
            this.fileName = fileName;
        }
    }
    public String getFileName() {
        return fileName;
    }
    public int writeData(ArrayList<Item> list) throws FileNotFoundException, IOException {
        int numRecords = 0;
        if(!list.isEmpty() && !StringHelpers.IsNullOrEmpty(fileName)){
            try{
                FileOutputStream fileOut = new FileOutputStream(fileName);
                try (ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                    for(Item item:list){
                        out.writeObject(item);
                        numRecords++;
                    }
                    out.flush();
                    out.close();
                }    
            }
            catch(IOException ex){
                OutputHelpers.showExceptionDialog("writeData: " + ex.getMessage(), "File Write Exception");
            }
            catch(SecurityException ex){
                OutputHelpers.showExceptionDialog("writeData: " + ex.getMessage(), "File Security Exception");
            }
            
        }
        return numRecords;   
        
    }
    public ArrayList<Item> getData() throws IOException, ClassNotFoundException {
        ArrayList<Item> list = new ArrayList<>();
        ObjectInputStream in;
        Item aItem;
        try{
            if(!StringHelpers.IsNullOrEmpty(fileName)){
                fileName = FileHelpers.checkFile(fileName);
                FileInputStream fileIn = new FileInputStream(fileName);
                in = new ObjectInputStream(fileIn);
                Object obj;
                while((obj = in.readObject()) != null){
                    list.add((Item)obj);
                }
                in.close();
            }
        }
            catch(EOFException ex){
            //normal terminatoin of file input loop
                ex = null;
            }
            catch(IOException | ClassNotFoundException ex){
                OutputHelpers.showExceptionDialog("getData: " + ex.getMessage(), "File read Excpetion");
                list  = null;
            }
            catch(Exception ex){
                OutputHelpers.showExceptionDialog("getData: " + ex.getMessage(), "Unknown Exception");
            }
        //finally
        return null;
        }   
         
}
