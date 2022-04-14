package chessproject;

import javax.swing.Icon;

public class Piece {
    protected Icon image;
    protected boolean white;
    
    public Piece(Icon image, boolean white){
        this.image = image;
        this.white = white;
    }
    
    public Icon getImage(){
        return image;
    }
    
    /*
    public Piece getPiece(){
        System.out.println("THIS IS RETURN. Very Sad.");
        return this;
    }
    */
    
    public boolean getSide(){
        return white;
    }
    
    
    public boolean[][] legalMoves(Buttons[][] game, boolean[][] falseBoard, int row, int col){
         
        return falseBoard;
    }
    
    public void ifPawnPlayed(){
        
    }
    
}
