/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to store information about you
 * 
 */

package user;

// import methods
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
username,Password,rating,wins,losses,currentGame,gamesPlayed,dateJoined, email
*/

// User class: stores info about user
// The current logged user should be accessed through CurrentUser.getUser()
public class User {
    // class feilds, username, rating, pasword ...
    
    private String username;
    private double rating;
    private String password;
    private int wins; // int for wins
    private int losses; //
    private int gamesPlayed;
    private String dateJoined;
    private ArrayList<SavedGame> games; // array list of saved games    
    // email field
    private String email;
    
    // getters and setters for all attributes
    // get games
    public ArrayList<SavedGame> getGames() {
        // return games
        return games;
    }
    
    // set games
    public void setGames(ArrayList<SavedGame> games) {
        // set games
        this.games = games;
    }
    
    // clear games
    public void clearGames() {
        games.clear();
    }
    
    // getters and setters for each of the fields
    public String getEmail() {
        return email;
    }
    
    // set email
    public void setEmail(String email) {
        this.email = email;
        // save user database after field update
        UserDatabase.saveUsers();
    }
    
    // get username
    public String getUsername() {
        // return username
        return username;
    }
    
    // set username
    public void setUsername(String username) {
        // set username and savae database
        this.username = username;
        UserDatabase.saveUsers();
    }
    // getter for raing
    public double getRating() {
        // return rating
        return rating;
    }
    // set raing
    public void setRating(double rating) {
        // return rating and save dabatase
        this.rating = rating;
        UserDatabase.saveUsers();
    }
    // get the user ecyprted password
    public String getPassword() {
        return password;
    }
    
    // set the user password
    public void setPassword(String password) {
        this.password = password;
        UserDatabase.saveUsers();
    }
    
    // get wins
    public int getWins() {
        return wins;
    }
    
    // set wins
    public void setWins(int wins) {
        // set instance wins to wins
        this.wins = wins;
        // save databse
        UserDatabase.saveUsers();
    }
    // get losses
    public int getLosses() {
        // return loses
        return losses;
    }
    
    // set losses
    public void setLosses(int losses) {
        this.losses = losses;
        // save databse
        UserDatabase.saveUsers();
    }
    
    // get games played
    public int getGamesPlayed() {
        // return number of gagmes played
        return gamesPlayed;
    }
    
    // set games played
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
        // save database
        UserDatabase.saveUsers();
    }
    
    // get date joined
    public String getDateJoined() {
        return dateJoined;
    }
    // set date joined
    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
        // save users
        UserDatabase.saveUsers();
    }
    
    // increase and add inws/losses, ratings
    public void addWin() {
        this.wins += 1;
    }
    
    // decrease loss by 1
    public void addLoss() {
        this.losses += 1;
    }
    
    // increase rating by n points
    public void increaseRating(int points) {
        this.rating += points;
    }
    
    // Basic user when regristering.
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.wins = 0;
        this.losses = 0;
        this.gamesPlayed = 0;
        //defaut rating of 500, gamesPlayed =0, wins is 0, losses is 0
        this.rating = 500;
        this.email = email;
        // format the current date to string
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(config.USER_DATE_FORMAT);  
        // store this information
        String strDate = dateFormat.format(date);
        // in a dateJoined field
        this.dateJoined = strDate;
        // new array list of saved games
        this.games = new ArrayList<SavedGame>();
        
    }
    
    // User object constructor with all attributes
    public User(String username, double rating, String password, int wins, int losses, int gamesPlayed, String dateJoined, String email) {
        this.username = username;
        this.rating = rating;
        this.password = password;
        this.wins = wins;
        this.losses = losses;
        this.gamesPlayed = gamesPlayed;
        this.dateJoined = dateJoined;
        this.email = email;
    }
    
    // save game given game
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
        this.username = attributes[0];
        this.password = attributes[1];
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
            // loop through each game
            for (SavedGame game: games) {
                // add gameString to game string
                gameString += game.toString() + "|";
            }
        }
        
        // remove last | if it exists;
        if (!gameString.isEmpty()) {
            gameString = gameString.substring(0, gameString.length() - 1);
        }
        
        // base64 encode the games string to avoid conflicts with commas.
        String base64encodedGames = new String(Base64.getEncoder().encode(gameString.getBytes()));
        // return commas seperate attributess
        return username + "," + password + "," + rating + "," + wins + "," + losses + "," + gamesPlayed + "," + dateJoined + "," + email + "," + base64encodedGames;
    }

}
