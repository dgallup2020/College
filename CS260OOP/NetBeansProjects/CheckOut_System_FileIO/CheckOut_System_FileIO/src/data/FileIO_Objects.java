
package data;

import business.*;
import helpers.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO_Objects {
    public static final String DEFAULT_FILE_NAME = "itemObjects.dat";
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
    public int writeData(ArrayList<Item> list) {
        int numRecords = 0;
        if (!list.isEmpty() && !StringHelpers.IsNullOrEmpty(fileName)) {
            try {
                FileOutputStream fileOut = new FileOutputStream(fileName);
                try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    for(Item item:list) {
                        out.writeObject(item);
                        numRecords++;
                    }
                    out.flush();
                    out.close();
                }
            }
            catch (IOException ex) {
                OutputHelpers.showExceptionDialog("writeData: " + ex.getMessage(), "File Write Exception");
            }
            catch (SecurityException ex) {
                 OutputHelpers.showExceptionDialog("writeData: " + ex.getMessage(), "File Security Exception");
            }
            catch (Exception ex) {
                 OutputHelpers.showExceptionDialog("writeData: " + ex.getMessage(), "Unknown exception");
            }
        }
        return numRecords;
    }
    public ArrayList<Item> getData() {
        ArrayList<Item> list = new ArrayList<>();
        
        ObjectInputStream in;
        Item aItem;
        try {
            if (!StringHelpers.IsNullOrEmpty(fileName)) {
                fileName = FileHelpers.checkFile(fileName);
                FileInputStream fileIn = new FileInputStream(fileName);
                in = new ObjectInputStream(fileIn);
                Object obj;
                while ((obj = in.readObject()) != null) {
                    list.add((Item)obj);
                }
                in.close();
            }
        } 
        catch (EOFException ex) {
           //normal termination of file input loop
            ex = null;
        }
        catch (IOException | ClassNotFoundException ex) {
            OutputHelpers.showExceptionDialog("getData: " + ex.getMessage(), "File read Exception");
            list = null;
        }
        catch (Exception ex) {
            OutputHelpers.showExceptionDialog("getData: " + ex.getMessage(), "Unknown Exception");
            list = null;
        }
        finally {
            
        }
        return list;
    }

}
