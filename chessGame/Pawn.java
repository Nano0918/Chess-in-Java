package chessproject;

import java.awt.Color;
import javax.swing.Icon;

public class Pawn extends Piece {
    private int played;
    
    public Pawn(Icon image, boolean white){
        super(image, white);
        this.played = 0;
    }
    
    /*
    // Dynamnic Binding to access the following Pawn method
    @Override
    public Piece getPiece(){
        return this;
    }
    */
    
    // Dynamnic Binding to access the following Pawn method
    @Override
    public boolean[][] legalMoves(Buttons[][] game, boolean[][] falseBoard, int row, int col){
        if(row > 0 && row < 7)
        {
            if(white)
            {
                if(played == 0)
                {
                    if(game[row+1][col].getP() == null){
                        falseBoard[row+1][col] = true;
                        if(game[row+2][col].getP() == null){
                            falseBoard[row+2][col] = true;
                        }
                    }
                    
                }
                else
                {
                    if(game[row+1][col].getP() == null){
                        falseBoard[row+1][col] = true;
                    }
                }
            
            /* If the collumn is within the 0 and 7th indices
            Checks if the next row one collumn to the left contains a piece
            if it does then check if it is opposite color
            if it is then pawn can take the piece making it a legal move  */
            
                if(col > 0 && col < 7)
                {
                    if(game[row+1][col-1].getP() != null)
                        if(game[row+1][col-1].getP().getSide() != white)
                            falseBoard[row+1][col-1] = true;

                    if(game[row+1][col+1].getP() != null)
                        if(game[row+1][col+1].getP().getSide() != white)
                            falseBoard[row+1][col+1] = true;
                }

                if(col == 0)
                    if(game[row+1][col+1].getP() != null)
                        if(game[row+1][col+1].getP().getSide() != white)
                            falseBoard[row+1][col+1] = true;

                if(col == 7)
                    if(game[row+1][col-1].getP() != null)
                        if(game[row+1][col-1].getP().getSide() != white)
                            falseBoard[row+1][col-1] = true;
            }
            
                
        
            else
            {
                if(played == 0)
                {
                    if(game[row-1][col].getP() == null){
                        falseBoard[row-1][col] = true;
                        if(game[row-2][col].getP() == null){
                            falseBoard[row-2][col] = true;
                        }
                    }
                    
                }
                else
                {
                    if(game[row-1][col].getP() == null){
                        falseBoard[row-1][col] = true;
                    }
                }

                if(col > 0 && col < 7)
                {
                    if(game[row-1][col-1].getP() != null)
                        if(game[row-1][col-1].getP().getSide() != white)
                            falseBoard[row-1][col-1] = true;

                    if(game[row-1][col+1].getP() != null)
                        if(game[row-1][col+1].getP().getSide() != white)
                            falseBoard[row-1][col+1] = true;
                }

                if(col == 0)
                    if(game[row-1][col+1].getP() != null)
                        if(game[row-1][col+1].getP().getSide() != white)
                            falseBoard[row-1][col+1] = true;

                if(col == 7)
                    if(game[row-1][col-1].getP() != null)
                        if(game[row-1][col-1].getP().getSide() != white)
                            falseBoard[row-1][col-1] = true;
            }
        }
        
        for (int i = 0; i<8; i++) 
            for (int j = 0; j<8; j++) 
                if(falseBoard[i][j] == true)
                    game[i][j].setBackground(new Color(120, 190, 220));             
            
        return falseBoard;
    }
    
    @Override
    public void ifPawnPlayed(){
        played = 1;
    }
    
}
