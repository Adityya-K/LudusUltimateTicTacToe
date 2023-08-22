package user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import user.*;

// class for saved game
/*
    @author Ludus Team

*/
public class SavedGame {
    // declare vairables, player1, player1 piece, game_type, opponent_type, ai_difficulty, turn
    private String player1;
    // not multiplayer yet
    //private User player2; //
    private String player1Piece; // X, O
    private String game_type; // ULTIMATE, NORMAL
    private String opponent_type; // AI, HUMAN
    private String ai_difficulty; // EASY, MEDIUM, HARD
    private String turn; // ME, OPPONENT
    private String savedDate; // date in str 


    
    /*
    e --> empty
    x --> x
    
    For regular this is: xexxooxxx
    Ultimate is xeexxx,eee
                ... ... ...
                ... ... ...
    */
    private String position; 
    
    // constructo for saved game with ai opponent
    public SavedGame(String player1, String player1Piece, String game_type, String opponent_type, String ai_difficulty, String turn, String position) {
        this.player1 = player1;
        this.player1Piece = player1Piece;
        this.game_type = game_type;
        this.opponent_type = opponent_type;
        this.ai_difficulty = ai_difficulty;
        this.turn = turn;
        this.position = position;
    }

    // constructor for human opponent
    public SavedGame(String player1, String player1Piece, String game_type, String opponent_type, String turn, String position) {
        this.player1 = player1;
        //this.player2 = player2;
        this.player1Piece = player1Piece;
        this.game_type = game_type;
        this.opponent_type = opponent_type;
        this.turn = turn;
        this.position = position;
           // format the current date to string
           Date date = new Date();
           DateFormat dateFormat = new SimpleDateFormat(config.gameDateFormat);  
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
        this.game_type = attributes[2];
        this.opponent_type = attributes[3];
        this.ai_difficulty = attributes[4];
        this.turn = attributes[5];
        this.position = attributes[6];
        // case where the date isn't in database, save the string
        if (attributes.length <= 7) {
           // format the current date to string
           Date date = new Date();
           DateFormat dateFormat = new SimpleDateFormat(config.gameDateFormat);  
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
        return player1 + "," + player1Piece + "," + game_type + "," + opponent_type + "," + ai_difficulty + "," + turn + "," + position + "," + savedDate;
    }
    
    
}
