/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleabstract;

/**
 *
 * @author dgallup14
 */
public class SimpleAbstract {
    
    private static ContactJoe joe = new ContactJoe();
    private static ContactFreda freda = new ContactFreda();
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        joe.callMe();
        freda.callMe();
        joe.callYou("Freda");
        
    }
    
}
