package business;

public class BenefitsTypes {
    
    public enum BenefitPackages{
        FULL,
        STANDARD
    }
    public static String getBenefitPackage(BenefitPackages type) {
        String str;
        switch (type) {
            case FULL:
                str = "Full Benefits";
                break;
            case STANDARD:
                str = "Standard Benefits";
                break;
            default:
                str = "Benefits";
                break;
        }
        return str;
    }
    public static double getDefaultCost() {
        return getStandardBenefitCost();
    }
    public static double getBenefitsCost(BenefitPackages type) {
        double cost;
        switch (type) {
            case FULL:
                cost = getFullBenefitCost();
                break;
            case STANDARD:
                cost = getStandardBenefitCost();
                break;
            default:
                cost = getDefaultCost();
                break;
        }
        return cost;
    }
    private static double fullBenefitsCost = 450;
    public static double getFullBenefitCost () {
        return fullBenefitsCost;
    }
    private static double standardBenefitsCost = 250;
    public static double getStandardBenefitCost () {
        return standardBenefitsCost;
    }
    private static BenefitPackages defaultBenefitPackage = BenefitPackages.STANDARD;
    public static BenefitPackages defaultBenefitPackage() {
        return defaultBenefitPackage;
    }
    public enum BenefitType {
        FULL_HEALTH,
        FULL_DENTAL,
        EYE,
        PRESCRIPTIONS,
        PARTIAL_DENTAL
    }
    public static String getBenefitList(BenefitPackages type) {
        String str;
        switch (type) {
            case FULL:
                str = getFullBenefitList();
                break;
            case STANDARD:
                str = getPartialBenefitList();
                break;
            default:
                str = getPartialBenefitList();
                break;
        }
        return str;
    }
    private static String getFullBenefitList() {
        StringBuilder str = new StringBuilder();
        str.append("Full Benefits");
        str.append("\n\t");
        str.append("FullHealth");
        str.append("\n\t");
        str.append("Full Dental");
        str.append("\n\t");
        str.append("Eye");
        str.append("\n\t");
        str.append("Prescriptions");
        
        return str.toString();
    }
    private static String getPartialBenefitList() {
        StringBuilder str = new StringBuilder();
        str.append("Standard Benefits");
        str.append("\n\t");
        str.append("FullHealth");
        str.append("\n\t");
        str.append("Parital Dental");
        
        return str.toString();
    }
    
    
    public static String getBenefitType(BenefitType type) {
        String str;
        switch(type) {
            case FULL_HEALTH: 
                str = "Full Health";
                break;
            case FULL_DENTAL:
                str = "Full Dental";
                break;
            case EYE:
                str = "Eye";
                break;
            case PRESCRIPTIONS:
                str = "Prescriptions";
                break;
            case PARTIAL_DENTAL:
                str = "Partial Dental";
                break;
            default:
                str = "Unknown Type";
                break; 
        }
         return str;
    }
    private static double fullPackageDeduction = .2;
    public static double getFullPackageDeduction() {
        return fullPackageDeduction;
    }   
    private static double standardPackageDeduction = .15;
    public static double getstandardPackageDeduction() {
        return standardPackageDeduction;
    }
    private static double nonSmokerDiscountFull = .20;
    public static double getNonSmokerDiscountFull() {
        return nonSmokerDiscountFull;
    }
    private static double nonSmokerDiscountStandard = .15;
    public static double getNonSmokerDiscountStandard() {
        return nonSmokerDiscountStandard;
    }
    public static double getNonSmokerDiscount(BenefitPackages type) {
        double discount;
        switch (type) {
            case FULL:
                discount = getNonSmokerDiscountFull();
                break;
            case STANDARD:
                discount = getNonSmokerDiscountStandard();
                break;
            default:
                discount = 0;
                break;
        }
       return discount;
    }
}