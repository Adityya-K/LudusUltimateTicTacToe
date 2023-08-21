package ludusultimatetictactoe;

import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

/**
 *
 * @author Ludus Team
 */

/*
username,encryptedPassword,rating,wins,losses,currentGame,gamesPlayed,dateJoined,email,games
*/

public class User {
    
    
    private String username;
    private double rating;
    private String encryptedPassword;
    private int wins;
    private int losses;
    private int gamesPlayed;
    private String dateJoined;
    private String email;
    //private ArrayList<Game> games; // TODO
    
    
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
    
    /*
    public void addGame(Game game) {
        games.add(game);
    }
    */
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    /*
    public ArrayList<Game> getGames() {
        return games;
    }
    
    public Game getLastGame() {
        return games.get(games.size() - 1);
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    */

    
    // Basic user when regristering.
    public User(String username, String password, String email) {
        this.username = username;
        // sha256 encrypt the passowrd
        this.encryptedPassword = SHAEncryption.getSHA256Hash(password);
        this.wins = 0;
        this.losses = 0;
        this.gamesPlayed = 0;
        this.email = email;
        
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
    // username,encryptedPassword,rating,wins,losses,gamesPlayed,dateJoined,email,games

    public User(String userString) {
        String [] attributes = userString.split(",");
        this.username = attributes[0];
        this.encryptedPassword = attributes[1];
        this.rating = Double.parseDouble(attributes[2]);
        this.wins = Integer.parseInt(attributes[3]);
        this.losses = Integer.parseInt(attributes[4]);
        this.gamesPlayed = Integer.parseInt(attributes[5]);
        this.dateJoined = attributes[6];
        this.email = attributes[7];
        
        
    }

    @Override
    public String toString() {
        // escape commas if user decides to enter commas as part of their username
        return username + "," + encryptedPassword + "," + rating + "," + wins + "," + losses + "," + gamesPlayed + "," + dateJoined + "," + email;
    }
    
    
}

