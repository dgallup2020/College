package business;
import helpers.*;
public class CarTypes {
    public enum Cars {
        STREET_TUNED,
        HOT_ROD,
        RACE_CAR,
        GENERIC
    }
    public static String CarType(Cars type) {
        String str;
        switch (type) {
            case STREET_TUNED:
                str = "Street Tuned";
                break;
            case HOT_ROD:
                str = "Hot Rod";
                break;
            case RACE_CAR:
                str = "Race Car";
                break;
            default:
                str = "Generic";
                break;
        }
        return str;
    }
    public static final double RACE_CAR_INCREASE = .5;
    public static final double HOT_ROD_INCREASE = .65;
    public static final double STREET_TUNE_INCREASE = .70;
    public static final double GENERIC_INCREASE = 0;
    
    public static final int MIN_SPEED = 0;
    public static final int MAX_SPEED = 350;
    
    public static int generateRandomSpeed() {
        return (int)(NumberHelpers.getRandomNumber(MAX_SPEED));
    }
    
    
}
