/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to allow the user to play the 2-player version of normal Tic-Tac-Toe
 * 
 */
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
