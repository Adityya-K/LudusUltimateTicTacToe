
package user;

import user.SHAEncryption;
import user.config;
import java.util.*;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import menu.*;

/**
 *
 * @author Ludus Team
 */

/*
username,encryptedPassword,rating,wins,losses,currentGame,gamesPlayed,dateJoined, email
*/

// User class: stores
public class User {
    // class feilds, username, rating, encrypted pasword ...
    
    private String username;
    private double rating;
    private String encryptedPassword;
    private int wins; // int for wins
    private int losses; //
    private int gamesPlayed;
    private String dateJoined;
    private ArrayList<SavedGame> games; // array list of saved games    
    
    private String email;
    
    // getters and setters for each of the fields
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
        // save user database after field update
        UserDatabase.saveUsers();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        UserDatabase.saveUsers();
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
        UserDatabase.saveUsers();
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
        UserDatabase.saveUsers();
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
        UserDatabase.saveUsers();
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
        UserDatabase.saveUsers();
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        UserDatabase.saveUsers();
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
        UserDatabase.saveUsers();
    }
    
    // increase and add inws/losses, ratings
    public void addWin() {
        this.wins += 1;
    }
    
    public void addLoss() {
        this.losses += 1;
    }
    
    public void increaseRating(int points) {
        this.rating += points;
    }
    
    // Basic user when regristering.
    public User(String username, String password, String email) {
        this.username = username;
        // sha256 encrypt the passowrd
        this.encryptedPassword = SHAEncryption.getSHA256Hash(password);
        this.wins = 0;
        this.losses = 0;
        this.gamesPlayed = 0;
        //defaut rating of 500, gamesPlayed =0, wins is 0, losses is 0
        this.rating = 500;
        this.email = email;
        // format the current date to string
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(config.dateFormat);  
        // store this information
        String strDate = dateFormat.format(date);
        // in a dateJoined field
        this.dateJoined = strDate;
        this.games = new ArrayList<SavedGame>();
        
    }
    
    // User object constructor with all attributes

    public User(String username, double rating, String encryptedPassword, int wins, int losses, int gamesPlayed, String dateJoined, String email) {
        this.username = username;
        this.rating = rating;
        this.encryptedPassword = encryptedPassword;
        this.wins = wins;
        this.losses = losses;
        this.gamesPlayed = gamesPlayed;
        this.dateJoined = dateJoined;
        this.email = email;
    }
    
    public void saveGame(SavedGame game) {
        // add the game to the user
        this.games.add(game);
        // save the game to the user database
        UserDatabase.saveUsers();
    }
    
    // user object constructor when loaded from database
    // String user object to --> user object
    // username,encryptedPassword,rating,wins,losses,gamesPlayed,dateJoined,email,encoded games

    public User(String userString) {
        // split the userdatabase string into attrbutes. limit=-1 to allow for empyt attributes
        String [] attributes = userString.split(",", -1);
        System.out.println(userString);
        this.username = attributes[0];
        this.encryptedPassword = attributes[1];
        this.rating = Double.parseDouble(attributes[2]);
        this.wins = Integer.parseInt(attributes[3]);
        this.losses = Integer.parseInt(attributes[4]);
        this.gamesPlayed = Integer.parseInt(attributes[5]);
        this.dateJoined = attributes[6];
        this.email = attributes[7];
        this.games = parseGameString(attributes[8]);
        
    }
    
    // parses the list of games string fro mthe database
    private ArrayList<SavedGame> parseGameString(String base64encodedGameString) {
        // bsae64 decode the games string
        String decodedGameString = new String(Base64.getDecoder().decode(base64encodedGameString));
        // create a new arraylist to store these games
        ArrayList<SavedGame> savedGames = new ArrayList<>();
        
        // seperate the decoded game string with |
        // this returns an array of game objects in string format
        String[] gamesArr = decodedGameString.split("\\|");
        // each element is a game in string format, loop through eaco fthem
        for (String gameStr: gamesArr){
            // add the saved games, create a new saved game from the game string
            if (!gameStr.isEmpty()){
                savedGames.add(new SavedGame(gameStr));
            }
        }
        return savedGames;
        
    }

    @Override
    public String toString() {
        // escape commas if user decides to enter commas as part of their username
        // encode games to base64
        String gameString = "";
        // add the game to string and seperate with |
        if (games.size() != 0){
            for (SavedGame game: games) {
                gameString += game.toString() + "|";
            }
        }
        
        // remove last | if it exists;
        if (!gameString.isEmpty()) {
            gameString = gameString.substring(0, gameString.length() - 1);
        }
        
        
        // base64 encode the games string
        String base64encodedGames = new String(Base64.getEncoder().encode(gameString.getBytes()));
        return username + "," + encryptedPassword + "," + rating + "," + wins + "," + losses + "," + gamesPlayed + "," + dateJoined + "," + email + "," + base64encodedGames;
    }
    
    
    
    
}
