
package business;

import helpers.*;

public class Service implements java.io.Serializable {
    
    public static final double HARDWARE_MIN_COST = 0;
    public static final double HARDWARE_MAX_COST = 250000;
    public static final double SOFTWARE_MIN_COST = 0;
    public static final double SOFTWARE_MAX_COST = 100000;
    private static final String DEFAULT_SERVICE = "IT Service";
     private static final String DEFAULT_DESCRIPTION = "Not Provided";
    
    public ServiceManager person;
    private String itemName;
    private String description;
    
    private double servicecost;
    
    
    public HardwareCost HWcost;
    public SoftwareCost SWcost;
            
    //work on combining all the cost elements together still need to instanciate them
    
    public Service() {
        //make a condition to instanciate the right worker
        setItemName(DEFAULT_SERVICE);
        setDescription(DEFAULT_DESCRIPTION);
        //setCost(MIN_COST);
        HWcost = new HardwareCost(); // now i neet 
        SWcost = new SoftwareCost();
        person = new ServiceManager();
        
    }
    
    //constructor to distinguish workers (done)
    //to do list:
    /*
    ++1. finish up on declaration stuff with Person types and setting them up
    ++2. move on to the cost class and figure out how to spread that out. (hardware/software/personal
        2.5 make the conditions to check for the max cost for hardware and software. in here or in the GUI
    ++3. adjust the graphical interface
        3.5 change the conditions to check for my input
    4. refactor/rename
     
    5. test the data layer
    */
    
    
    
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = InputHelpers.setField(itemName, DEFAULT_SERVICE);
    }
    public Person getPerson() {
        return person;
    }
    public void setResponible(ServiceManager person) {
        this.person = person;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = InputHelpers.setField(description, DEFAULT_DESCRIPTION);
    }
    
    public double getServiceCost() {
        return this.servicecost;
    }
    /*
    public void setCost(double cost) {
        this.cost = InputHelpers.setField(cost, MIN_COST, MAX_COST);
    }
*/
    public void setServiceCost(){
        this.servicecost = person.aCost.getCharge() + HWcost.getTotalCost() + SWcost.getTotalCost();
        //this.servicecost = person.aCost.charge + hardwarecost + softwarecost;
    }
    
    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append("Service: ");
        str.append(getItemName());
        str.append("\n");
        str.append(person.toString());
        str.append("\nCost: ");
        str.append(OutputHelpers.formattedCurrency(HWcost.getTotalCost()+SWcost.getTotalCost()+person.aCost.getCharge()));
        str.append("\nDescription: ");
        str.append(description);
        
        return str.toString();
        
    }
    @Override
    public String toString() {
        return getItemName();
    }
    
    
    
    
    
}
