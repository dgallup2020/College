/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import data.*;
import helpers.OutputHelpers;
import javax.swing.DefaultListModel;

public class ItemList {
    
    private ArrayList<Item> list;
    
    public ItemList() {
        list = new ArrayList<>();
    }
    public void add(Item aItem) {
        if (aItem != null) {
            list.add(aItem);
        }
    }
    public void remove(Item aItem) {
        if (aItem != null) {
            list.remove(aItem);
        }
    }
    public int saveList(Boolean asObjects) {
        int count;
        if(asObjects) {
            FileIO_Objects objectFile = new FileIO_Objects();
            count = objectFile.writeData(list);
        }
        else {
           FileIO_Streams streamFile = new FileIO_Streams();
           count = streamFile.writeData(list);
       }
       return count;
    }
    public int getList(DefaultListModel<Item> listModel, Boolean asObjects) {
        int count  = 0;
        
        if(asObjects) {
            FileIO_Objects objectFile = new FileIO_Objects();
            list = objectFile.getData();
        }
        else {
           FileIO_Streams streamFile = new FileIO_Streams();
           list = streamFile.getData();
        }
        if  (!list.isEmpty()) {
            listModel.clear();
            count = list.size();
            for(Item item:list) {
                listModel.addElement(item);
            }
        }
        return count;
    }
    public String getSummary() {
        double totalCost = 0;
        double averageCost = 0;
        int count = 0;
        if (!list.isEmpty()) {
            for(Item item:list) {
                totalCost += item.getCost();
                count++;
            }
            if (count > 0) {
                averageCost = totalCost/count;
            }
        }
        StringBuilder str = new StringBuilder();
        str.append("Item Checkout Summary");
        str.append("\nNumber of items checked out: ");
        str.append(count);
        str.append("\nTotal cost of items: ");
        str.append(OutputHelpers.formattedCurrency(totalCost));
        str.append("\nAverage cost of items: ");
        str.append(OutputHelpers.formattedCurrency(averageCost));
        
        return str.toString();
        
    }

}
