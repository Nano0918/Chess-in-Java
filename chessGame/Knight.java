package chessproject;

import java.awt.Color;
import javax.swing.Icon;

public class Knight extends Piece {
    public Knight(Icon image, boolean white){
        super(image, white);
    }
    
    @Override
    public boolean[][] legalMoves(Buttons[][] game, boolean[][] falseBoard, int row, int col){
        if(white)
        {
            if(row+2 < 8 && col+1 < 8 && (game[row+2][col+1].getP() == null || !game[row+2][col+1].getP().getSide()))
            {
                falseBoard[row+2][col+1] = true;
            }
            if(row+2 < 8 && col-1 >= 0 && (game[row+2][col-1].getP() == null || !game[row+2][col-1].getP().getSide()))
            {
                falseBoard[row+2][col-1] = true;
            }
            if(row+1 < 8 && col+2 < 8 && (game[row+1][col+2].getP() == null || !game[row+1][col+2].getP().getSide()))
            {
                falseBoard[row+1][col+2] = true;
            }
            if(row+1 < 8 && col-2 >= 0 && (game[row+1][col-2].getP() == null || !game[row+1][col-2].getP().getSide()))
            {
                falseBoard[row+1][col-2] = true;
            }
            if(row-2 >= 0 && col+1 < 8 && (game[row-2][col+1].getP() == null || !game[row-2][col+1].getP().getSide()))
            {
                falseBoard[row-2][col+1] = true;
            }
            if(row-2 >= 0 && col-1 >= 0 && (game[row-2][col-1].getP() == null || !game[row-2][col-1].getP().getSide()))
            {
                falseBoard[row-2][col-1] = true;
            }
            if(row-1 >= 0 && col+2 < 8 && (game[row-1][col+2].getP() == null || !game[row-1][col+2].getP().getSide()))
            {
                falseBoard[row-1][col+2] = true;
            }
            if(row-1 >= 0 && col-2 >= 0 && (game[row-1][col-2].getP() == null || !game[row-1][col-2].getP().getSide()))
            {
                falseBoard[row-1][col-2] = true;
            }
        }
        else
        {
            if(row+2 < 8 && col+1 < 8 && (game[row+2][col+1].getP() == null || game[row+2][col+1].getP().getSide()))
            {
                falseBoard[row+2][col+1] = true;
            }
            if(row+2 < 8 && col-1 >= 0 && (game[row+2][col-1].getP() == null || game[row+2][col-1].getP().getSide()))
            {
                falseBoard[row+2][col-1] = true;
            }
            if(row+1 < 8 && col+2 < 8 && (game[row+1][col+2].getP() == null || game[row+1][col+2].getP().getSide()))
            {
                falseBoard[row+1][col+2] = true;
            }
            if(row+1 < 8 && col-2 >= 0 && (game[row+1][col-2].getP() == null || game[row+1][col-2].getP().getSide()))
            {
                falseBoard[row+1][col-2] = true;
            }
            if(row-2 >= 0 && col+1 < 8 && (game[row-2][col+1].getP() == null || game[row-2][col+1].getP().getSide()))
            {
                falseBoard[row-2][col+1] = true;
            }
            if(row-2 >= 0 && col-1 >= 0 && (game[row-2][col-1].getP() == null || game[row-2][col-1].getP().getSide()))
            {
                falseBoard[row-2][col-1] = true;
            }
            if(row-1 >= 0 && col+2 < 8 && (game[row-1][col+2].getP() == null || game[row-1][col+2].getP().getSide()))
            {
                falseBoard[row-1][col+2] = true;
            }
            if(row-1 >= 0 && col-2 >= 0 && (game[row-1][col-2].getP() == null || game[row-1][col-2].getP().getSide()))
            {
                falseBoard[row-1][col-2] = true;
            }
        }
            
        
        for (int i = 0; i<8; i++) 
            for (int j = 0; j<8; j++) 
                if(falseBoard[i][j] == true)
                    game[i][j].setBackground(new Color(120, 190, 220));             
            
        return falseBoard;
    }

}

