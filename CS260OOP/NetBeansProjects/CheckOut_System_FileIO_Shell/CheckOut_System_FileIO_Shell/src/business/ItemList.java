/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import data.*;
import helpers.OutputHelpers;
import java.io.IOException;
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
    public int saveList() throws IOException {
        int count;
        FileIO_Objects streamFile = new FileIO_Objects();
        count = streamFile.writeData(list);
       return count;
    }
    public int getList(DefaultListModel<Item> listModel) throws IOException, ClassNotFoundException {
        int count  = 0;
        
        FileIO_Objects streamFile = new FileIO_Objects();
        list = streamFile.getData();
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
