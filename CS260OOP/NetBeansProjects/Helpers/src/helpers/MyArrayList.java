/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;
import java.util.ArrayList;

public class MyArrayList<T> extends ArrayList<T> {
    
    public String getListElements() {
        StringBuilder str = new StringBuilder();
        
        if (!this.isEmpty()) {
            for(T element : this) {
                str.append(element.toString());
                str.append("\n");
            }
        }
        return str.toString();
    }
    
}
