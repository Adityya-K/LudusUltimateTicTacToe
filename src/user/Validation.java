
package user;

// validation class for validating user input
/*
@author Ludus Team
*/
public class Validation {
    
    // ok means ok
    // errorMSG means error
    public static String validateUserName(String userName) {
        // no commas allowed
        if (!userName.contains(",")) {
            return "ok";
        } else {
            // return error msg
            return "Username contains commas. No commas allowed.";
        }
        
    }
    
    // validate email
    public static String validateEmail(String email) {
        // no commas allowed
        if (!email.contains(",")) {
            return "ok";
        } else {
            // return error msg
            return "Email contains commas. No commas allowed.";
        }
        
    }    
}
