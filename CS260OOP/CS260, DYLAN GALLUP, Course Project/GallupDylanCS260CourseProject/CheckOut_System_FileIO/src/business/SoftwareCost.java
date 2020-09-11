/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author dgallup14
 */
public class SoftwareCost extends Cost{
    
    private double lincensingCost = 0;
    private double SWtotalCost = 0;
    private double SWinitCost = 0; 
    
    public SoftwareCost(){
    }
    
    public SoftwareCost(double initCost, double lincensingCost){
        setInitCost(initCost);
        setLincensingCost(lincensingCost);
        //setTotalCost();
    }

    
    //public void setSWInitCost(double ic){
    //   this.initCost = ic; 
    //}
    
    public double getSWinitCost() {
        return this.SWinitCost;
    }

    public void setSWinitCost(double SWinitCost) {
        this.SWinitCost = SWinitCost;
    }
    
    public double getLincensingCost() {
        return this.lincensingCost;
    }

    public void setLincensingCost(double lincensingCost) {
        this.lincensingCost = lincensingCost;
    }
    
    public void setTotalCost(double ic,double lc){
        this.SWtotalCost = ic+lc;
    }
    
    //another setter for the total cost
    public void setTotalCost(){
        this.SWtotalCost = this.SWinitCost+this.lincensingCost;
    }
    
    public double getTotalCost(){
        return this.totalCost;
    }
    
    
    
}
