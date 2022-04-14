package chessproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* To create a chess app that has pieces captured on the left and game info on 
   the right I can make a 3 collumn JFrame with 1 row. The collumn in the middle 
   is the chess game and is bigger than the other 2. ( Put a border around the 
   middle collumn.) 

    FEATURES TO ADD:
    - Left and Right Hud areas
    - 
*/
public class ChessProject {
    // Creating a 8x8 array of buttons for our chessboard
    private final Buttons[][] buttons = new Buttons[8][8];
    private int prevx;
    private int prevy;
    private int turn;
    
    // This array will help in creating the starting board
    private final int pieces[][] = {
        {-2,-3,-4,-5,-6,-4,-3,-2},
        {-1,-1,-1,-1,-1,-1,-1,-1},
        { 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0, 0, 0, 0, 0},
        { 1, 1, 1, 1, 1, 1, 1, 1},
        { 2, 3, 4, 5, 6, 4, 3, 2}
        };
      
    // This 2D boolean Array will be used to check for legal moves for a piece
    private boolean falseBoard[][] = {
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false},
        {false,false,false,false,false,false,false,false}
        }; 
    
    // Images for black pieces
    private final Icon bPawn = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bPawn.png");
    private final Icon bKnight = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bKnight.png");
    private final Icon bRook = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bRook.png");
    private final Icon bBishop = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bBishop.png");
    private final Icon bQueen = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bQueen.png");
    private final Icon bKing = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\bKing.png");

    // Images for white pieces    
    private final Icon wPawn = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wPawn.png");
    private final Icon wKnight = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wKnight.png");
    private final Icon wRook = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wRook.png");
    private final Icon wBishop = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wBishop.png");
    private final Icon wQueen = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wQueen.png");
    private final Icon wKing = new ImageIcon("C:\\Users\\Orlando\\Desktop\\Desktop\\JavaProjects\\ChessProject\\src\\assets\\chessPieces\\wKing.png");
        
    // Creating two Linked Lists of Pieces. When 1 is empty game is over
    private final LinkedList<Piece> wPieces = new LinkedList<>();
    private final LinkedList<Piece> bPieces = new LinkedList<>();
    private final JFrame frame = new JFrame();
    private final JPanel leftHud = new JPanel();
    private final JPanel chessBoard = new JPanel();
    private final JPanel rightHud = new JPanel();
    
    // Constructor
    public ChessProject(){
        funv();
    }
    
    // Start of main
    public static void main(String[] args) {
        ChessProject p = new ChessProject();
        
    }
    
    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //Piece type = new Piece(null, true);
            Buttons tempButton = (Buttons)e.getSource();
            
            // If a piece was selected that also is not a legal move for a previous selected piece
            if(tempButton.getP() != null && falseBoard[tempButton.getXC()][tempButton.getYC()] == false) {
                if(!tempButton.getP().getSide() && turn == 1){
                    setBoardColors();
                    setFalseBoard();
                    prevx = tempButton.getXC();
                    prevy = tempButton.getYC();
                    tempButton.move(buttons, falseBoard, tempButton.getXC(), tempButton.getYC());
                }
                else if(tempButton.getP().getSide() && turn == -1)
                {
                    setBoardColors();
                    setFalseBoard();
                    prevx = tempButton.getXC();
                    prevy = tempButton.getYC();
                    tempButton.move(buttons, falseBoard, tempButton.getXC(), tempButton.getYC());
                }
                
            }  
            // If the button selected is a legal move then move the piece to the new button
            else if(falseBoard[tempButton.getXC()][tempButton.getYC()] == true){
                // For current turn. Can also add turn number and increment in the else
                if(turn == 1)
                    turn = -1;
                else
                    turn = 1;
                setBoardColors();
                setFalseBoard();
                buttons[prevx][prevy].pawnPlayed();
                tempButton.setP(buttons[prevx][prevy].getP());
                tempButton.setIcon(buttons[prevx][prevy].getP().getImage());
                buttons[prevx][prevy].setP(null);
                buttons[prevx][prevy].setIcon(null);
            }
            // If any button that is not a legal move for a previous piece
            // Then reset the board
            else
            {
                setBoardColors();
                setFalseBoard();
            }
                
        }
    }
    
    
    private void funv(){
        // Creating GUI Window
        frame.setTitle("Chess");
        frame.setBounds(310, 90, 1300, 900);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new BorderLayout());
        
        // The left hud area is to display the num of pieces captured 
        // and the images of the pieces
        JLabel left = new JLabel("Left Hud Area");
        leftHud.add(left);
        leftHud.setPreferredSize(new Dimension(200, 900));
        leftHud.setBackground(new Color(240, 216, 191));
        leftHud.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        // The right hud area is to display who's turn it is, turn #, 
        JLabel right = new JLabel("Right Hud Area");
        rightHud.add(right);
        rightHud.setPreferredSize(new Dimension(200, 900));
        rightHud.setBackground(new Color(240, 216, 191));
        rightHud.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        
        // Creating the grid for the chessboard
        chessBoard.setLayout(new GridLayout(8,8));
        chessBoard.setBackground(new Color(0));
        turn = 1;
        
        // Create 64 buttons and filling the two Piece LinkedLists
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                if(pieces[x][y] == 0){
                    buttons[x][y] = new Buttons(null, x, y);
                    buttons[x][y].setIcon(null);
                    buttons[x][y].addActionListener(new ButtonListener());
                }
                if((pieces[x][y] == -1) || (pieces[x][y] == 1)){
                    if(pieces[x][y] == -1) {
                        Pawn pTemp = new Pawn(bPawn, true);
                        bPieces.add(pTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                        
                    if(pieces[x][y] == 1){
                        Pawn pTemp = new Pawn(wPawn, false);
                        wPieces.add(pTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
                if((pieces[x][y] == -2) || (pieces[x][y] == 2)){
                    if(pieces[x][y] == -2){
                        Rook rTemp = new Rook(bRook, true);
                        bPieces.add(rTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                    if(pieces[x][y] == 2){
                        Rook rTemp = new Rook(wRook, false);
                        wPieces.add(rTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
                if((pieces[x][y] == -3) || (pieces[x][y] == 3)){
                    if(pieces[x][y] == -3){
                        Knight kTemp = new Knight(bKnight, true);
                        bPieces.add(kTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                    if(pieces[x][y] == 3){
                        Knight kTemp = new Knight(wKnight, false);
                        wPieces.add(kTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
                if((pieces[x][y] == -4) || (pieces[x][y] == 4)){
                    if(pieces[x][y] == -4){
                        Bishop bTemp = new Bishop(bBishop, true);
                        bPieces.add(bTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                    if(pieces[x][y] == 4){
                        Bishop bTemp = new Bishop(wBishop, false);
                        wPieces.add(bTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
                if((pieces[x][y] == -5) || (pieces[x][y] == 5)){
                    if(pieces[x][y] == -5){
                        Queen qTemp = new Queen(bQueen, true);
                        bPieces.add(qTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                    if(pieces[x][y] == 5){
                        Queen qTemp = new Queen(wQueen, false);
                        wPieces.add(qTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
                if((pieces[x][y] == -6 ) || (pieces[x][y] == 6 )){
                    if(pieces[x][y] == -6){
                        King kTemp = new King(bKing, true);
                        bPieces.add(kTemp);
                        buttons[x][y] = new Buttons(bPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                    if(pieces[x][y] == 6){
                        King kTemp = new King(wKing, false);
                        wPieces.add(kTemp);
                        buttons[x][y] = new Buttons(wPieces.getLast(), x, y);
                        buttons[x][y].setIcon(buttons[x][y].getP().getImage());
                        buttons[x][y].addActionListener(new ButtonListener());
                    }
                }
            }
        }
        
        // Sets the checkered color pattern of the board
        setBoardColors();
        
        // Add the buttons to the content pane.
        for(int x = 0; x < 8; x++)
            for(int y = 0; y < 8; y++)
                chessBoard.add(buttons[x][y]);
        
        // Adding all the panels to the frame to be displayed in the window
        frame.add(leftHud, BorderLayout.WEST);
        frame.add(chessBoard, BorderLayout.CENTER);
        frame.add(rightHud, BorderLayout.EAST);
        frame.setVisible(true);
        
    }
    
    // Resetting the falseBoard that is used to show valid moves, to all false
    public void setFalseBoard(){
        for(int i = 0; i < 8; i++)
                    for(int j = 0; j < 8; j++)
                        falseBoard[i][j] = false;
    }
    
    // 
    public void setBoardColors(){
        boolean white = true;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (white) {
                    buttons[x][y].setBackground(new Color(240, 216, 191));
                    
                } else {
                    buttons[x][y].setBackground(new Color(186, 85, 70));
                }
                buttons[x][y].setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
                buttons[x][y].setFocusPainted(false);
                white = !white;
            }
            white = !white;
        }
    }
}
