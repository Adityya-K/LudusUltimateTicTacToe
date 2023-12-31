/*
 * Group Name: Ludus 
 * Members: Adityya Kaushal, Alexander Tan, Eksjot Multani, Owen Yang
 * ICS4UE
 * August 20-22, 2023
 * Mr. Diakoloukas
 * Purpose: to allow the user to play normal Tic-Tac-Toe against the computer
 * 
 */

package normal_tic_tac_toe;

// Imports LoginFrame from the authentication_frames package
import authentication_frames.LoginFrame;

// Imports Color, Font, ActionEvent, ActionListener from java.awt
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Imports JButton and JOptionPane from javax.swing
import javax.swing.JButton;
import javax.swing.JOptionPane;

// Imports MainMenuFrame from the menu package and CurrentUser and SavedGame from the user package
import menu.MainMenuFrame;
import user.CurrentUser;
import user.SavedGame;


public class NormalTicTacToeAIFrame extends javax.swing.JFrame implements ActionListener{

    // Initializes the board, difficulty and player/computer letters
    String[] board = new String[9];
    String difficulty = "medium";
    String ai = "O";
    String player = "X";
    
    // Gives the correct value to the difficulty and player letters if the board is new
    public void setGameProperties (String difficulty, String ai, String player) {
        this.ai = ai;
        this.player = player;
        this.difficulty = difficulty;
        
        // Displays helpful hints about what letter represent what player
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        // Plays the first computer move if the computer is X
        if (ai.equals("X")) {
            if (difficulty.equals("easy")) {
                moveEasyComputer();
            } else if (difficulty.equals("medium")) {
                moveMediumComputer();
            } else if (difficulty.equals("hard")) {
                moveAI();
            }
        }
    }
    
    // Gives the correct value to the difficulty and player letters if the board is loaded
    public void setGameProperties (String difficulty, String ai, String player, String[] board) {
        this.ai = ai;
        this.player = player;
        this.difficulty = difficulty;
        this.board = board;
        
        // Iterates through all of the indices in the button array
        for (int i = 0; i < btnArray.length; i++) {
            
            // Sets the color of the squares to indicate they have been loaded
            btnArray[i].setForeground(new Color(0,102,255));
            
            // Adds " " to the board if it is empty (indicated by "e"), adds the player/computer if it isn't
            btnArray[i].setText(board[i].equals("e") ? " " : board[i]);
            this.board[i] = board[i].equals("e") ? null : board[i];
            
        }
        
        // Displays helpful hints about what letter represent what player
        lblComputerIs.setText("Computer is: " + ai + " ( " + difficulty.toUpperCase() + " difficulty )");
        lblPlayerIs.setText("You are: " + player);
        
        // Stores the game result
        String gameResult = getGameResult(getAllLines());
                
        // Checks if the game has been decided
        if (!gameResult.equals("undecided")) {

            // Displays the game result
            JOptionPane.showMessageDialog(this, gameResult.equals("draw") ? "It was a draw" : gameResult + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            
            // Disables all of the buttons
            for (int i = 0; i < btnArray.length; i++) {
                btnArray[i].setEnabled(false);
            }
            
        }
        
    }
    
    /**
     * Creates new form NormalTicTacToeFrame
     */
    public NormalTicTacToeAIFrame() {
        
        // Displays the JFrame at the center position of the screen
        setSize(940, 788);
        setLocationRelativeTo(null);
        initComponents();
        
        // Creates all the buttons
        for (int i = 0; i < btnArray.length; i++) {
            
            // Sets the text
            btnArray[i] = new JButton(" ");
            
            // Sets the background color
            btnArray[i].setBackground(new Color(128, 176, 247));
            
            // Sets the font
            btnArray[i].setFont(new Font("SansSerif", Font.BOLD, 50));
            
            // Sets the action command
            btnArray[i].setActionCommand("" + i);
            
            // Adds an action listener
            btnArray[i].addActionListener(this);
            
            // Adds the button to the panel
            panButtons.add(btnArray[i]);
            
        }
        
    }
    
    // Plays a random move
    private void moveEasyComputer() {
        
        // Initializes the move index
        int moveIndex;
        
        // Chooses a random square that is empty
        do {
            moveIndex = (int) (Math.random() * 9);
        } while (board[moveIndex] != null);
        
        // Sets the square at the index to the computer's letter
        board[moveIndex] = ai;
        
        // Sets the color according to the computer's letter
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
        
        // Sets the squares at the index to the computer's letter
        btnArray[moveIndex].setText(ai);
        
    }
    
    // Plays a random move, unless the computer can win in one move
    private void moveMediumComputer() {
        
        // Determines if there is a win in one move
        int moveIndex = findWin();
        
        // Plays a random move if there is no winning move
        if (moveIndex == -1) {
            do {
                moveIndex = (int) (Math.random() * 9);
            } while (board[moveIndex] != null);
        }
        
        // Sets the square at the index to the computer's letter
        board[moveIndex] = ai;
        
        // Sets the color according to the computer's letter
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
        
        // Sets the square at the index to the computer's letter
        btnArray[moveIndex].setText(ai);
        
    }
    
    // Returns the index indicating a win-in-one-move, returns -1 if such a move doesn't exist
    private int findWin() {
        
        // Initializes the move index
        int moveIndex = -1;
        
        // Stores all of the lines in an array
        String [] lines = getAllLines();
        
        // Initializes the index of the winning line
        int winningLineIndex = -1;
        
        // Initializes the winning line
        String winningLine = "";
        
        // Initializes an array containing the indices of all three squares in each line
        String [] indicesInLines = {"012", "345", "678", "036", "147", "258", "048", "246"};
        
        // (this is a linear search) Iterates through all the indices of the lines array
        for (int i = 0; i < lines.length; i++) {
            
            // Runs if the line has two Xs and one empty spot
            if (lines[i].equals("XXnull") || lines[i].equals("XnullX") || lines[i].equals("nullXX")) {
                
                // Sets the index of the winning line to the current index
                winningLineIndex = i;
                
                // Sets the winning line to the current line
                winningLine = lines[i];
                
                // Breaks out of the loop
                break;
                
            }
            
        }
        
        // Runs if a winning line was found
        if (winningLineIndex != -1) {
            
            // Sets the move index to the appropriate number
            if (winningLine.equals("XXnull")) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(2)));
            } else if (winningLine.equals("XnullX")) {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(1)));
            } else {
                moveIndex = Integer.parseInt(String.valueOf(indicesInLines[winningLineIndex].charAt(0)));
            }
            
        }
        
        // Returns the winning move index
        return moveIndex;
        
    }
    
    /**
     * A method that calls minimax on each of the available positions to find 
     * the best possible outcome and return the move to reach that outcome
     */
    private void moveAI() {
        // Set the most min value possible, negative inifinty
        Double bestMoveScore = Double.NEGATIVE_INFINITY;
        
        // Set the move index ot an impossible number to diagnose problems
        int moveIndex = -1;
        
        // Loop through the entire board
        for (int i = 0; i < board.length; i++) {
            
            // Check if the spot if null by passing in its respective parameters
            if (board[i] == null) {
                // Play the move at the avaliable spot
                board[i] = ai;
                
                // Call on minimax to evaluate the position with initial call 
                // parameters. In this case since we are maximzing in this
                // function we call minimax to minimize. The depth is zero
                // as this is the first call. Alpha and Beta are small values
                // so that they can be used to prune recursion branches
                double moveScore = minimax(board, 0, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, false);
                
                // After getting the evaluation reset the board
                board[i] = null;
                
                // Check if the evaluation returns a greater score than the besScore
                // that was found so far
                if (moveScore > bestMoveScore) {
                    // Set the best Score to the current evaluation as that is
                    // the new mark to beat
                    bestMoveScore = moveScore;
                    
                    // Set the current move index to the current value i as
                    // at this index is a higher evaluation than best socre
                    moveIndex = i;
                }
            }
        }
        
        // After the for loop has run, it will have found the move with the
        // highest evalulation
        
        // We move to the index with the highest score
        board[moveIndex] = ai;
        
        // We change color of the text of the button based on what the ai piece is
        btnArray[moveIndex].setForeground(ai.equals("X") ? Color.black : Color.white);
        
        // Set the text at the button to reflect the ai move
        btnArray[moveIndex].setText(ai);
        
    }
    
    /**
     * The minimax algorithm, using the idea that the opponent will minimize your
     * chances to win while you are trying to maximize your chances
     * @param board The current state of the borad
     * @param depth How many recursions the algorithm has done
     * @param alpha Used to prune by maximizing
     * @param beta Used to prune by minimizing
     * @param isMaximizing A boolean that stores whether the function is maximizing
     * @return The evaluation of the position at the initial call of the function
     */
    private double minimax(String[] board, int depth, double alpha, double beta, boolean isMaximizing) {
        // A string that stores the result of the game which will be used for
        // the base case of this recursion tree
        String gameResult = getGameResult(getAllLines());
        
        // Check if the AI won
        if (gameResult.equals(ai)) {
            // Return 10 minus the depth as we want to advantage positions
            // that give us a faster win
            return 10 - depth;
        }
        // If the player won
        if (gameResult.equals(player)) {
            // Return -10 plus the depth as we assume that opponent will play the
            // best move so we account for that during minimization
            return -10 + depth;
        }
        // If it is a draw
        if (gameResult.equals("draw")) {
            // We turn a neutral score of zero
            return 0;
        }
        
        // Check if the function is called to maximize
        if (isMaximizing) {
            // Set the maxEval to the smallest possible value to be changed
            // later, this also could have been -10000, but infinity is chosen
            // to keep in line with general implementation strategies.
            double maxEval = Double.NEGATIVE_INFINITY;
            
            // Loop through the entire position
            for (int i = 0; i < board.length; i++) {
                
                // Check if the position is avaliable
                if (board[i] == null) {
                    
                    // Make a move by the AI
                    board[i] = ai;
                    
                    // Recursively call minimax and see if the method returns
                    // a larger eval than current maxEval and set it
                    maxEval = Math.max(maxEval, minimax(board, depth + 1, alpha, beta, false));
                    
                    // Reset the board and undo the move
                    board[i] = null;
                    
                    // Check between alpha and maxEval to see which one is
                    // greater and set Alpha
                    alpha = Math.max(alpha, maxEval);
                    
                    // Check if alpha is larger than beta as if it is
                    // we already know the algorithm has found a better option
                    // so this entire branch can be pruned
                    if (beta <= alpha) {
                        // break out of the loop
                        break;
                    }
                }

            }
            // Return the maxEval that the function got if maximizing
            return maxEval;
        }
        // If it is not maximizing, it is minimizing.
        else  {
            // Set the maxEval to the largest possible value to be changed
            // later, this also could have been 10000, but infinity is chosen
            // to keep in line with general implementation strategies.
            double minEval = Double.POSITIVE_INFINITY;
            
            // Loop through the entire array
            for (int i = 0; i < board.length; i++) {
                
                // Check if the position is available
                if (board[i] == null) {
                    
                    // Make a move by the AI
                    board[i] = player;
                    
                    // Recursively call minimax and see if the method returns
                    // a smaller eval than current minEval and set it
                    minEval = Math.min(minEval, minimax(board, depth + 1, alpha, beta, true));
                    
                    // Reset the board and undo the move
                    board [i] = null;
                    
                    // Check between beta and minEval to see which one is
                    // lesser and set beta
                    beta = Math.min(beta, minEval);
                    
                    // Check if alpha is larger than beta as if it is
                    // we already know the algorithm has found a better option
                    // so this entire branch can be pruned
                    if (beta <= alpha) {
                        // break out of the loop
                        break;
                    }
                }

            }
            // Return the min that the function got if maximizing
            return minEval;
        }
    }

    /**
     * A method that saves the game
     */
    private void saveGame() {
        // Declare a variable that stores the moves that the user made
        int movesPresent = 0;
        
        // Loop through the entire board
        for (int i = 0; i < board.length; i++) {
            // Check of the current element if not null
            if (board[i] != null) {
                // Add one to the moves counter as a move was made on this square
                movesPresent++;
            }
        }
        
        // If the moves made was less than two
        if(movesPresent < 2) {
            // Return out of the function as the user just started the game, so
            // there is no point in asking them to save
            return;
        }
        
        // If more than 2 moves were made, ask the user if they want to save
        if (JOptionPane.showConfirmDialog(this, "Would you like to save your current game?", "Save Game?",JOptionPane.YES_NO_OPTION) == 0) {
            // Define a string that will store the board
            String boardString = "";
            
            // Loop through the board
            for (int i = 0; i < board.length; i++) {
                // Store null positions as "e" with colon as seperator
                boardString += (board[i] == null ? "e" : board[i]) + ":";
            }
            
            // Create a new savedGame object with the proper parameters
            SavedGame currentGame = new SavedGame(CurrentUser.getUser().getUsername(), player, "normal", "computer", difficulty, player, boardString);
            
            // Save the game
            CurrentUser.getUser().saveGame(currentGame);
        }
    }
    
    // Handles a button click
    public void actionPerformed(ActionEvent ae) {
        
        // (this is a linear search) Iterates through the array of buttons
        for (int i = 0; i < btnArray.length; i++) {
            
            // Runs if the button was clicked
            if (ae.getActionCommand().equals("" + i) && board[i] == null) {
                
                // Plays the move
                board[i] = player;
                
                // Sets the color accordingly
                btnArray[i].setForeground(player.equals("X") ? Color.black : Color.white);
                
                // Sets the button text to the correct player using the parity of the turn number
                btnArray[i].setText(player);
                
                // Stores the game result
                String gameResult = getGameResult(getAllLines());
                
                // Plays a computer move according to the difficulty
                if (gameResult.equals("undecided")) {
                    if (difficulty.equals("easy")) {
                        moveEasyComputer();
                    } else if (difficulty.equals("medium")) {
                        moveMediumComputer();
                    } else if (difficulty.equals("hard")) {
                        moveAI();
                    }
                }
                
                // Stores the game result
                gameResult = getGameResult(getAllLines());
                
                // Checks if the game has been decided
                if (!gameResult.equals("undecided")) {
                    
                    // Prints out the game result
                    JOptionPane.showMessageDialog(this, gameResult.equals("draw") ? "It was a draw" : gameResult + " won!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Adds a win to the player and adjusts their rating if they won
                    if (gameResult.equals(player)) {
                        CurrentUser.getUser().addWin();
                        switch (difficulty) {
                            case "easy":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 5);
                                break;
                            case "medium":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 10);
                                break;
                            case "hard":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() + 20);
                                break;
                        }
                    
                    // Adds a loss to the player and adjusts their rating if they lost
                    } else if (gameResult.equals(ai)) {
                        CurrentUser.getUser().addLoss();
                        switch (difficulty) {
                            case "easy":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 20 ? CurrentUser.getUser().getRating() - 20 : 0);
                                break;
                            case "medium":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 10 ? CurrentUser.getUser().getRating() - 10 : 0);
                                break;
                            case "hard":
                                CurrentUser.getUser().setRating(CurrentUser.getUser().getRating() >= 5 ? CurrentUser.getUser().getRating() - 5 : 0);
                                break;
                        }
                    }
                    
                    // Disables all of the buttons
                    for (int j = 0; j < btnArray.length; j++) {
                        btnArray[j].setEnabled(false);
                    }
                    
                }
                
                // Stops the search for a button click
                break;
                
            }
            
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panRootBackground = new javax.swing.JPanel();
        btnRestart = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblPlayerIs = new javax.swing.JLabel();
        panBackground = new javax.swing.JPanel();
        panButtons = new javax.swing.JPanel();
        btnToMainMenu = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblComputerIs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(940, 788));
        setMinimumSize(new java.awt.Dimension(940, 788));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panRootBackground.setBackground(new java.awt.Color(0, 35, 82));
        panRootBackground.setMinimumSize(new java.awt.Dimension(940, 788));
        panRootBackground.setPreferredSize(new java.awt.Dimension(940, 788));

        btnRestart.setBackground(new java.awt.Color(0, 102, 255));
        btnRestart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(255, 255, 255));
        btnRestart.setText("Restart");
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("NORMAL TIC TAC TOE (COMPUTER OPPONENT)");

        lblPlayerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblPlayerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerIs.setText("You are: O");

        panBackground.setBackground(new java.awt.Color(0, 35, 82));
        panBackground.setForeground(new java.awt.Color(0, 102, 255));

        panButtons.setBackground(new java.awt.Color(0, 102, 255));
        panButtons.setMinimumSize(new java.awt.Dimension(100, 100));
        panButtons.setPreferredSize(new java.awt.Dimension(500, 500));
        panButtons.setLayout(new java.awt.GridLayout(3, 3));
        panBackground.add(panButtons);

        btnToMainMenu.setBackground(new java.awt.Color(0, 102, 255));
        btnToMainMenu.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnToMainMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnToMainMenu.setText("To Main Menu");
        btnToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToMainMenuActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(0, 102, 255));
        btnHelp.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        lblComputerIs.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        lblComputerIs.setForeground(new java.awt.Color(255, 255, 255));
        lblComputerIs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComputerIs.setText("Computer is: X");

        javax.swing.GroupLayout panRootBackgroundLayout = new javax.swing.GroupLayout(panRootBackground);
        panRootBackground.setLayout(panRootBackgroundLayout);
        panRootBackgroundLayout.setHorizontalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRootBackgroundLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnToMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRootBackgroundLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblComputerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(lblPlayerIs, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panRootBackgroundLayout.setVerticalGroup(
            panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRootBackgroundLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlayerIs)
                    .addComponent(lblComputerIs))
                .addGap(18, 18, 18)
                .addComponent(panBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRootBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart)
                    .addComponent(btnToMainMenu)
                    .addComponent(btnHelp))
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panRootBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        
        // Resets the board to an empty one
        resetBoard();
        
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMainMenuActionPerformed
        // TODO add your handling code here:
        
        // Displays the main menu if the user confirms it
        if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?", "Confirmation",JOptionPane.YES_NO_OPTION) == 0) {    
            saveGame();
            MainMenuFrame frmMainMenu = new MainMenuFrame();
            frmMainMenu.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btnToMainMenuActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        // Displays the login page if the current user is null when the window is opened
        if(CurrentUser.getUser() == null) {
            LoginFrame frmLogin = new LoginFrame();
            frmLogin.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        // Saves the game when the window is closed
        saveGame();
        
    }//GEN-LAST:event_formWindowClosing

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        
        // Displays the help page
        NormalHelpFrame frmNormalHelp = new NormalHelpFrame();
        frmNormalHelp.setVisible(true);
        
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NormalTicTacToeAIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NormalTicTacToeAIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnToMainMenu;
    private javax.swing.JLabel lblComputerIs;
    private javax.swing.JLabel lblPlayerIs;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panBackground;
    private javax.swing.JPanel panButtons;
    private javax.swing.JPanel panRootBackground;
    // End of variables declaration//GEN-END:variables
    
    // Creates an array of 9 buttons
    private JButton[] btnArray = new JButton[9];

    // Resets the board
    private void resetBoard() {
        
        // Iterates through every index in the array and resets the text
        for (int i = 0; i < btnArray.length; i++) {
            btnArray[i].setText(" ");
            btnArray[i].setEnabled(true);
            board[i] = null;
        }
        
        // Plays a computer move according to the difficulty if the computer is X
        if (ai.equals("X")) {
            if (difficulty.equals("easy")) {
                moveEasyComputer();
            } else if (difficulty.equals("medium")) {
                moveMediumComputer();
            } else if (difficulty.equals("hard")) {
                moveAI();
            }
        }
        
    }

    // Returns a string with the winner, if there is a draw or if the game is undecided
    private String getGameResult(String[] lines) {
        
        // Initializes the game result string
        String gameResult = "undecided";
        
        // Initializes a boolean indicating if it's a draw
        Boolean draw = true;
        
        // Iterates through every line in the array passed into this method
        for (String line : lines) {
            
            // Runs if X won
            if (line.equals("XXX")) {
                
                // Sets the result string
                gameResult = "X";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
            
            // Runs if O won
            } else if (line.equals("OOO")) {
                
                
                // Sets the result string
                gameResult = "O";
                
                // Indicates there is not a draw
                draw = false;
                
                // Stops the search for a 3-in-a-row
                break;
                
            }
            
        }
        
        // Runs if the game is a draw
        if (draw == true) {
            
            // Sets the game result string to a draw
            gameResult = "draw";
            
            // (this is a linear search) If there are still empty squares, sets the game result to undecided
            for (int i = 0; i < board.length; i++) {
                if (board[i] == null) {
                    gameResult = "undecided";
                }
            }
            
        }
        
        // Returns the game result
        return gameResult;
        
    }

    // Returns an array of strings that represent all the lines on the board
    private String[] getAllLines() {
        
        // Initializes the array of lines (3 vertical, 3 horizontal, 2 diagonal)
        String[] lines = new String[8];
        
        // Setting the horizontal lines
        lines[0] = board[0] + board[1] + board[2];
        lines[1] = board[3] + board[4] + board[5];
        lines[2] = board[6] + board[7] + board[8];
        
        // Setting the vertical lines
        lines[3] = board[0] + board[3] + board[6];
        lines[4] = board[1] + board[4] + board[7];
        lines[5] = board[2] + board[5] + board[8];
        
        // Setting the diagonal lines
        lines[6] = board[0] + board[4] + board[8];
        lines[7] = board[2] + board[4] + board[6];
        
        // Returns the lines
        return lines;
        
    }
    
}
