/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: 
 * 
 */

package user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import user.*;


public class SavedGame {
    // declare vairables, player1, player1 piece, game_type, opponent_type, ai_difficulty, turn
    private String player1;
    // not multiplayer yet
    //private User player2; //
    private String player1Piece; // X, O
    private String gameType; // ULTIMATE, NORMAL
    private String opponentType; // AI, HUMAN
    private String aiDifficulty; // EASY, MEDIUM, HARD
    private String turn; // ME, OPPONENT
    private String savedDate; // date in str 
    /*
    e --> empty
    x --> x
    o --> o
    
    For regular this is: xexxooxxx
    Ultimate is xeexxxea...
    */
    private String position; 
    // getters and setters for savedGame
    // getter for player1
    public String getPlayer1() {
        return player1;
    }
    // setter for player1
    public void setPlayer1(String player1) {
        // set player1 username
        this.player1 = player1;
    }
    // getter for player1 piece
    public String getPlayer1Piece() {
        return player1Piece;
    }
    // setter for player1piece
    public void setPlayer1Piece(String player1Piece) {
        this.player1Piece = player1Piece;
    }
    // getter for gametype
    public String getGameType() {
        return gameType;
    }
    // setter for gametype
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }
    // getter for opponent type
    public String getOpponentType() {
        return opponentType;
    }
    // setter for opponenttype
    public void setOpponentType(String opponentType) {
        this.opponentType = opponentType;
    }
    // getter for ai difficulty
    public String getAIDifficulty() {
        return aiDifficulty;
    }
    // setter for ai difficulty
    public void setAIDifficulty(String aiDifficulty) {
        this.aiDifficulty = aiDifficulty;
    }
    // getter for turn
    public String getTurn() {
        return turn;
    }
    // setter for turn
    public void setTurn(String turn) {
        this.turn = turn;
    }
    // getter for saved date
    public String getSavedDate() {
        return savedDate;
    }
    // sette for saved date
    public void setSavedDate(String savedDate) {
        this.savedDate = savedDate;
    }
    // getter for position
    public String getPosition() {
        return position;
    }
    // setter for position
    public void setPosition(String position) {
        this.position = position;
    }
    
    // constructo for saved game with ai opponent
    public SavedGame(String player1, String player1Piece, String game_type, String opponent_type, String ai_difficulty, String turn, String position) {
        // player
        this.player1 = player1;
        // piece
        this.player1Piece = player1Piece;
        // game_tpe
        this.gameType = game_type;
        // opponentType
        this.opponentType = opponent_type;
        // ai difficulty
        this.aiDifficulty = ai_difficulty;
        // variable for turn
        this.turn = turn;
        // variable for position
        this.position = position;
        // format the current date to string
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(config.GAME_DATE_FORMAT);  
        // store this information
        String strDate = dateFormat.format(date);
        // in a dateJoined field
        this.savedDate = strDate;
    }

    // constructor for human opponent
    public SavedGame(String player1, String player1Piece, String game_type, String opponent_type, String turn, String position) {
        // player1 username
        this.player1 = player1;
        //this.player2 = player2;
        // player1 piece
        this.player1Piece = player1Piece;
        // game ytpe
        this.gameType = game_type;
        // opponent type
        this.opponentType = opponent_type;
        // turn
        this.turn = turn;
        // position
        this.position = position;
        // format the current date to string
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(config.GAME_DATE_FORMAT);  
        // store this information
        String strDate = dateFormat.format(date);
        // in a dateJoined field
        this.savedDate = strDate;
    }
    
    
    // attributes = player1, player1piece, game_type, opponent_type, ai_difficulty, turn, position
    // load saved game from database string
    public SavedGame(String databaseString) {
        // split database by commas
        String[] attributes = databaseString.split(",", -1);
        System.out.println(attributes[0]);
        // get the user from database and set as player1
        this.player1 = attributes[0];
        /*
        if (!attributes[1].isEmpty()) {
            this.player2 = UserDatabase.getUser(attributes[1]);
        }
        else {
            this.player2 = null;
        }*/
        
        // set the rest of the class fields as the attributes
        this.player1Piece = attributes[1];
        this.gameType = attributes[2];
        this.opponentType = attributes[3];
        this.aiDifficulty = attributes[4];
        this.turn = attributes[5];
        this.position = attributes[6];
        // case where the date isn't in database, save the string
        if (attributes.length <= 7) {
           // format the current date to string
           Date date = new Date();
           DateFormat dateFormat = new SimpleDateFormat(config.GAME_DATE_FORMAT);  
           // store this information
           String strDate = dateFormat.format(date);
           // in a dateJoined field
           this.savedDate = strDate;
        } else {
            this.savedDate = attributes[7];
        }
    }

    // override to string
    @Override
    public String toString() {
        /*
        String player2Username = "";
        // case ai opponent
        
        if (player2 == null) {
            player2Username = "";
        } else {
            
            player2Username = player2.getUsername();
        }
        */
        // return a database formatted string, with each variable seperated by commas
        return player1 + "," + player1Piece + "," + gameType + "," + opponentType + "," + aiDifficulty + "," + turn + "," + position + "," + savedDate;
    }
    
    
}
