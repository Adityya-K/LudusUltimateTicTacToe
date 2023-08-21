
package user;

public class Validation {
    
    // ok means ok
    // errorMSG means error
    public static String validateUserName(String userName) {
        if (!userName.contains(",")) {
            return "ok";
        } else {
            return "Username contains commas. No commas allowed.";
        }
        
    }
}
