package chessproject;

import java.awt.Color;
import javax.swing.Icon;

public class Rook extends Piece {
    
    public Rook(Icon image, boolean white){
        super(image, white);
    }
    
    
    @Override
    public boolean[][] legalMoves(Buttons[][] game, boolean[][] falseBoard, int row, int col){
        int x = row, y = col;
        
        if(white)
        {
            while(x+1 != 8 && game[++x][y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(!game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
                    
            x = row;
            while(x-1 != -1 && game[--x][y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(!game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
            x = row;
            while(y+1 != 8 && game[x][++y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(!game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
            y = col;
            while(y-1 != -1 && game[x][--y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(!game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
        }
        else
        {
            while(x+1 != 8 && game[++x][y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
                    
            x = row;
            while(x-1 != -1 && game[--x][y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
            x = row;
            while(y+1 != 8 && game[x][++y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
            y = col;
            while(y-1 != -1 && game[x][--y].getP() == null)
                falseBoard[x][y] = true;
            
            if(game[x][y].getP() != null)
                if(game[x][y].getP().getSide())
                    falseBoard[x][y] = true;
        }
            
        
        for (int i = 0; i<8; i++) 
            for (int j = 0; j<8; j++) 
                if(falseBoard[i][j] == true)
                    game[i][j].setBackground(new Color(120, 190, 220));             
            
        return falseBoard;
    }

}
