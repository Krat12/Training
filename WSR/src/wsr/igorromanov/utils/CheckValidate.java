package wsr.igorromanov.utils;


public class CheckValidate {
    
       
    public static boolean isInteger (String data) throws NumberFormatException {
        try {
            Integer.parseInt(data);
            
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }
    
    public static boolean isFloat (String data) throws NumberFormatException {
        try {
            Float.parseFloat(data);
            
            return true;
        } catch (NumberFormatException e) {
            
            return false;
        }
    }
    
    public static boolean isString (String data) {
        if (!data.equals("")){
            return true;
        }else{
            return false;
        }
    }

}
