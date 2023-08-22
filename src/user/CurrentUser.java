/*
Static Class for current user
Is set after logging in, stores the current user.
 */
package user;

/**
 *
 * @author Ludus Team
 */
public class CurrentUser {
    // static variable for current user
    private static User user;

    // gets the current user
    public static User getUser() {
        return user;
    }
    
    // sets the user.
    public static void setUser(User user) {
        CurrentUser.user = user;
    }
    
    
}
