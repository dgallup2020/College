/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import helpers.*;

/**
 *
 * @author dgallup14
 */
public class Benefits {

    protected double cost;
    protected BenefitsTypes.BenefitPackages benefits;
    protected Boolean nonSmoker;
    protected Full_Benefits aFullBenefits;
    protected Standard_Benefits aStandardBenefits;

    
    public Benefits(BenefitsTypes.BenefitPackages benefitsType){
        this.benefits = benefitsType;
        if(benefits == BenefitsTypes.BenefitPackages.FULL){
             aFullBenefits = new Full_Benefits();
        }  
        if(benefits == BenefitsTypes.BenefitPackages.STANDARD){
             aStandardBenefits = new Standard_Benefits();
        }
        
    }
    
    /*
    public void setBenefitsType(BenefitsTypes.BenefitPackages benefits) {
        this.benefits = benefits;
    }
    */
    
    public String getBenefitsList() {
        return BenefitsTypes.getBenefitList(this.benefits);
        
    }
    
    public void setBenefitsTypes(BenefitsTypes.BenefitPackages bene){
            this.benefits = bene;
    }
    
    public BenefitsTypes.BenefitPackages getBenefitsType(){
        return this.benefits;
    }
    
    
    public void setCost(BenefitsTypes.BenefitPackages bene){
        double packagecost;
        packagecost = BenefitsTypes.getBenefitsCost(bene);
        if(nonSmoker)
            packagecost *= BenefitsTypes.getNonSmokerDiscount(bene);
        if(bene == BenefitsTypes.BenefitPackages.FULL)
            packagecost *= BenefitsTypes.getFullPackageDeduction();
        else
            packagecost *= BenefitsTypes.getstandardPackageDeduction();
        this.cost = packagecost;
    }
    
    
    public double getCost(){
        return cost;
    }
    
    
    
    public void setNonSmoker(Boolean nonSmoker) {
        this.nonSmoker = nonSmoker;
    }

    public Boolean getNonSmoker() {
        return nonSmoker;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Benefits:\n");
        //finish benefits type
        str.append("Type: ");
        str.append(getBenefitsType());
        str.append(getBenefitsList());
        str.append("Smoker: ");
        str.append(getNonSmoker());
        str.append("\n");
        str.append("Package Cost: $");
        str.append(getCost());
        return str.toString();
    }
   
}
