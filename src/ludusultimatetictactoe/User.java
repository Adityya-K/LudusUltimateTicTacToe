
package ludusultimatetictactoe;

import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

/**
 *
 * @author Ludus Team
 */

/*
username,encryptedPassword,rating,wins,losses,currentGame,gamesPlayed,dateJoined
*/

public class User {
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Board getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Board currentGame) {
        this.currentGame = currentGame;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }
    
    private String username;
    private double rating;
    private String encryptedPassword;
    private int wins;
    private int losses;
    private int gamesPlayed;
    private String dateJoined;
    private Board currentGame; // TODO
    
    // Basic user when regristering.
    public User(String username, String password) {
        this.username = username;
        // sha256 encrypt the passowrd
        this.encryptedPassword = SHAEncryption.getSHA256Hash(password);
        this.wins = 0;
        this.losses = 0;
        this.gamesPlayed = 0;
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(config.dateFormat);  
        String strDate = dateFormat.format(date);  
        this.dateJoined = strDate;
        
    }
    
    // User object constructor with all attributes

    public User(String username, double rating, String encryptedPassword, int wins, int losses, int gamesPlayed, String dateJoined) {
        this.username = username;
        this.rating = rating;
        this.encryptedPassword = encryptedPassword;
        this.wins = wins;
        this.losses = losses;
        this.gamesPlayed = gamesPlayed;
        this.dateJoined = dateJoined;
    }
    
    // user object constructor when loaded from database
    // String user object to --> user object
    // username,encryptedPassword,rating,wins,losses,gamesPlayed,dateJoined

    public User(String userString) {
        String [] attributes = userString.split(",");
        this.username = attributes[0];
        this.encryptedPassword = attributes[1];
        this.rating = Double.parseDouble(attributes[2]);
        this.wins = Integer.parseInt(attributes[3]);
        this.losses = Integer.parseInt(attributes[4]);
        this.gamesPlayed = Integer.parseInt(attributes[5]);
        this.dateJoined = attributes[6];
    }

    @Override
    public String toString() {
        // escape commas if user decides to enter commas as part of their username
        return username + "," + encryptedPassword + "," + rating + "," + wins + "," + losses + "," + gamesPlayed + "," + dateJoined;
    }
    
}
