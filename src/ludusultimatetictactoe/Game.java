
package ludusultimatetictactoe;

/**
 *
 * @author Alexander Tan
 */
public class Game {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    private String player1;
    private String player2;
    private String turn; // x means x to play
    private String type; // ULTIMATE, REGULAR
    //private UltimateBoard ultimateBoardPosition; // current position

    public Game(String player1, String player2, String turn, String TYPE, String positionString, double player1Rating, double player2Rating, int winner, double player1time, double player2time) {
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
        this.type = type;
        /*
        if (type == "ULTIMATE"){
            this.ultimateBoardPosition = new UltimateBoard(positionString);
        } else {
            this.regularBoardPosition = new RegularBoard();
        }
        */
        this.player1Rating = player1Rating;
        this.player2Rating = player2Rating;
        this.winner = winner;
        this.player1time = player1time;
        this.player2time = player2time;
    }
    
    
    //private RegularBoard regularBoardPosition; // current position
    private double player1Rating; // player 1 rating
    private double player2Rating; // player 1 rating
    
    private int winner; // 0 undetremined, 1 x wins, 2: O wins, 3: draw
    
    private double player1time;
    private double player2time;

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
/*
    public UltimateBoard getUltimateBoardPosition() {
        return ultimateBoardPosition;
    }

    public void setUltimateBoardPosition(UltimateBoard ultimateBoardPosition) {
        this.ultimateBoardPosition = ultimateBoardPosition;
    }

    public RegularBoard getRegularBoardPosition() {
        return regularBoardPosition;
    }

    public void setRegularBoardPosition(RegularBoard regularBoardPosition) {
        this.regularBoardPosition = regularBoardPosition;
    }
*/
    public double getPlayer1Rating() {
        return player1Rating;
    }

    public void setPlayer1Rating(double player1Rating) {
        this.player1Rating = player1Rating;
    }

    public double getPlayer2Rating() {
        return player2Rating;
    }

    public void setPlayer2Rating(double player2Rating) {
        this.player2Rating = player2Rating;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public double getPlayer1time() {
        return player1time;
    }

    public void setPlayer1time(double player1time) {
        this.player1time = player1time;
    }

    public double getPlayer2time() {
        return player2time;
    }

    public void setPlayer2time(double player2time) {
        this.player2time = player2time;
    }
    
    

}
