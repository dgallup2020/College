package helpers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelpers {
	
    public static boolean IsNullOrEmpty(String theString) {
        boolean isEmpty;

        if(theString != null && !theString.trim().isEmpty()) {
                isEmpty = false;
        }
        else {
                isEmpty = true;
        }
        return isEmpty;
    }
    public static String setStringValue(String value, String defaultValue) {
        String theValue = defaultValue;
        if (!StringHelpers.IsNullOrEmpty(value)) {
            theValue = value;
        }
        return theValue;
    }
	
    private static final String phonePattern = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";  
    public static boolean validatePhoneNumber(String phoneNumber) {
        boolean valid = false;
        CharSequence inputStr = phoneNumber; 
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
                valid = true;
        }
        else {
                valid = false;
        }
        return valid;
    }
    @SuppressWarnings("static-access")
    public static String formattedPhone(String number) {
        return number.format("(%s) %s-%s", number.substring(0, 3), number.substring(3, 6), number.substring(6, 10));
    }

    private static final String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static boolean validateEmail(String email) {
        boolean valid = false;
        CharSequence inputStr = email; 
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
                valid = true;
        }
        else {
                valid = false;
        }
        return valid;

    }
   
}
