
package business;

import helpers.*;

public class Item implements java.io.Serializable {
    
    public static final double MIN_COST = 0;
    public static final double MAX_COST = 10000;
    private static final String DEFAULT_SERVICE = "IT Service";
     private static final String DEFAULT_DESCRIPTION = "Not Provided";
    
    Person person;
    String itemName;
    String description;
    double cost;
    
    public Item() {
        person = new Person();
        setItemName(DEFAULT_SERVICE);
        setDescription(DEFAULT_DESCRIPTION);
        setCost(MIN_COST);
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = InputHelpers.setField(itemName, DEFAULT_SERVICE);
    }
    public Person getPerson() {
        return person;
    }
    public void setResponible(Person person) {
        this.person = person;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = InputHelpers.setField(description, DEFAULT_DESCRIPTION);
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = InputHelpers.setField(cost, MIN_COST, MAX_COST);
    }
    public String getDetails() {
        StringBuilder str = new StringBuilder();
        str.append("Item name: ");
        str.append(getItemName());
        str.append("\n");
        str.append(person.toString());
        str.append("\nCost: ");
        str.append(OutputHelpers.formattedCurrency(cost));
        str.append("\nDescription: ");
        str.append(description);
        
        return str.toString();
        
    }
    @Override
    public String toString() {
        return getItemName();
    }
    
    
    
    
    
}
