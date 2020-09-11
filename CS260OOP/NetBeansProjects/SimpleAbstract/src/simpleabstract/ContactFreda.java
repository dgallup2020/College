/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleabstract;

import helpers.OutputHelpers;

/**
 *
 * @author dgallup14
 */
public class ContactFreda extends ContactMe{
    @Override
    protected void callMe() {
        OutputHelpers.showStandardDialog("What's up", "Freda");
    }
    
    
}
