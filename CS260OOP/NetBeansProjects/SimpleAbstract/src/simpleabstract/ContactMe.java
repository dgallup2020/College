/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleabstract;
import helpers.*;
/**
 *
 * @author dgallup14
 */
public abstract class ContactMe {
    protected abstract void callMe();
    
    protected void callYou(String name){
        OutputHelpers.showStandardDialog("I'am calling you " + name + "!!!", name);
        
    }        
}
