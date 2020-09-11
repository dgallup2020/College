
package data;
import java.io.*;
import java.util.ArrayList;
import helpers.*;
import business.*;

public class FileIO_Streams {
    public static final String DEFAULT_FILE_NAME = "itemStream.dat";
    public static final String DELIMTER = ",";
    
    private String fileName;
    
    public FileIO_Streams() {
        fileName = DEFAULT_FILE_NAME;
    }
    public FileIO_Streams(String fileName) {
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
    public int writeData(ArrayList<Service> list) {
        StringBuilder recordList = new StringBuilder();
        int count = 0;
        
        if(!list.isEmpty()) {
            for(Service item:list) {
                count++;
                recordList.append(item.getPerson().getFirstName());
                recordList.append(DELIMTER);
                recordList.append(item.getPerson().getLastName());
                recordList.append(DELIMTER);
                recordList.append(item.getPerson().getEmail());
                recordList.append(DELIMTER);
                recordList.append(item.getPerson().getPhone());
                recordList.append(DELIMTER);
                recordList.append(item.getItemName());
                recordList.append(DELIMTER);
                recordList.append(item.getServiceCost());
                recordList.append(DELIMTER);
                recordList.append(item.getDescription());
                if (count < list.size())
                    recordList.append("\r\n");
            }
            FileHelpers.writeData(recordList.toString(), fileName);
        }
        return count;
    }
    public ArrayList<Service> getData() {
        Service aItem;
        ArrayList<String> recordList;
        ArrayList<Service> list = new ArrayList<>();
        String[] fields;
        
        recordList = FileHelpers.readList(fileName);
        if (!recordList.isEmpty()) {
            for(String record:recordList) {
                fields = record.split(DELIMTER);
                if (fields.length == 7) {
                    aItem = new Service();
                    aItem.getPerson().setFirstName(fields[0]);
                    aItem.getPerson().setLastName(fields[1]);
                    aItem.getPerson().setEmail(fields[2]);
                    aItem.getPerson().setPhone(fields[3]);
                    aItem.setItemName(fields[4]);
                    aItem.setServiceCost();//(Double.parseDouble(fields[5])); //overriden setter for the input
                    aItem.setDescription(fields[6]);
                    list.add(aItem);
                }
            }
        }
        return list;
    }
}
