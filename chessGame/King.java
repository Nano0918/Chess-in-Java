package chessproject;

import java.awt.Color;
import javax.swing.Icon;

public class King extends Piece {
    public King(Icon image, boolean white){
        super(image, white);
    }
    
    @Override
    public boolean[][] legalMoves(Buttons[][] game, boolean[][] falseBoard, int row, int col){
        if(white)
        {
            if(row+1 < 8 && col+1 < 8 && (game[row+1][col+1].getP() == null || !game[row+1][col+1].getP().getSide()))
            {
                falseBoard[row+1][col+1] = true;
            }
            if(row+1 < 8 && col-1 >= 0 && (game[row+1][col-1].getP() == null || !game[row+1][col-1].getP().getSide()))
            {
                falseBoard[row+1][col-1] = true;
            }
            if(row+1 < 8 && (game[row+1][col].getP() == null || !game[row+1][col].getP().getSide()))
            {
                falseBoard[row+1][col] = true;
            }
            if(col-1 >= 0 && (game[row][col-1].getP() == null || !game[row][col-1].getP().getSide()))
            {
                falseBoard[row][col-1] = true;
            }
            if(row-1 >= 0 && col+1 < 8 && (game[row-1][col+1].getP() == null || !game[row-1][col+1].getP().getSide()))
            {
                falseBoard[row-1][col+1] = true;
            }
            if(row-1 >= 0 && (game[row-1][col].getP() == null || !game[row-1][col].getP().getSide()))
            {
                falseBoard[row-1][col] = true;
            }
            if(row-1 >= 0 && col+1 < 8 && (game[row-1][col+1].getP() == null || !game[row-1][col+1].getP().getSide()))
            {
                falseBoard[row-1][col+1] = true;
            }
            if(col+1 >= 0 && (game[row][col+1].getP() == null || !game[row][col+1].getP().getSide()))
            {
                falseBoard[row][col+1] = true;
            }
        }
        else
        {
            if(row+1 < 8 && col+1 < 8 && (game[row+1][col+1].getP() == null || game[row+1][col+1].getP().getSide()))
            {
                falseBoard[row+1][col+1] = true;
            }
            if(row+1 < 8 && col-1 >= 0 && (game[row+1][col-1].getP() == null || game[row+1][col-1].getP().getSide()))
            {
                falseBoard[row+1][col-1] = true;
            }
            if(row+1 < 8 && (game[row+1][col].getP() == null || game[row+1][col].getP().getSide()))
            {
                falseBoard[row+1][col] = true;
            }
            if(col-1 >= 0 && (game[row][col-1].getP() == null || game[row][col-1].getP().getSide()))
            {
                falseBoard[row][col-1] = true;
            }
            if(row-1 >= 0 && col+1 < 8 && (game[row-1][col+1].getP() == null || game[row-1][col+1].getP().getSide()))
            {
                falseBoard[row-1][col+1] = true;
            }
            if(row-1 >= 0 && (game[row-1][col].getP() == null || game[row-1][col].getP().getSide()))
            {
                falseBoard[row-1][col] = true;
            }
            if(row-1 >= 0 && col+1 < 8 && (game[row-1][col+1].getP() == null || game[row-1][col+1].getP().getSide()))
            {
                falseBoard[row-1][col+1] = true;
            }
            if(col+1 >= 0 && (game[row][col+1].getP() == null || game[row][col+1].getP().getSide()))
            {
                falseBoard[row][col+1] = true;
            }
        }
            
        
        for (int i = 0; i<8; i++) 
            for (int j = 0; j<8; j++) 
                if(falseBoard[i][j] == true)
                    game[i][j].setBackground(new Color(120, 190, 220));             
            
        return falseBoard;
    }

}
