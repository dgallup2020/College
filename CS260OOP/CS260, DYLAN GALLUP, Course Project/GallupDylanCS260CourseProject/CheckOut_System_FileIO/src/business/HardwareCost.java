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
public class HardwareCost extends Cost{
    
    private double installationCost = 0;
    private double HWinitCost = 0;
    private double HWtotalCost = 0;
    
    
    public HardwareCost(){
    }
    
    public HardwareCost(double initCost, double installationCost){
        setInitCost(initCost);
        setInstallationCost(installationCost);
        //setTotalCost();
    }

    //@Override
    //public void setInitCost(double ic){
    //   this.initCost = ic; 
    //}

    
    public double getHWinitCost() {
        return this.HWinitCost;
    }

    public void setHWinitCost(double SWinitCost) {
        this.HWinitCost = SWinitCost;
    }
    
    
    public double getInstallationCost() {
        return installationCost;
    }

    public void setInstallationCost(double installationCost) {
        this.installationCost = installationCost;
    }
    
    public void setTotalCost(double ic,double lc){
        this.HWtotalCost = ic+lc;
    }
    
    //another setter for the total cost
    public void setTotalCost(){
        this.HWtotalCost = this.HWinitCost+this.installationCost;
    }
    
    public double getTotalCost(){
        return this.HWtotalCost;
    }
}
