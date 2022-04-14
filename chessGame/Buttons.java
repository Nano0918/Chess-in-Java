package chessproject;

import javax.swing.JButton;
        
public class Buttons extends JButton {
    private Piece p;
    private int xC;
    private int yC;
    
    public Buttons(Piece p, int xC, int yC){
        this.p = p;
        this.xC = xC;
        this.yC = yC;
    }
    
    public Piece getP(){
        return p;
    }
    
    /*
    public void getPieceType(Piece type){
        type = p.getPiece();
    }
    */
    public void move(Buttons[][] game, boolean[][] falseBoard, int row, int col){
        p.legalMoves(game, falseBoard, row, col);
    }
            
    public int getXC(){
        return xC;
    }
     
    
    public int getYC(){
        return yC;
    }
    
    public void setP(Piece p){
        this.p = p;
    }
    
    public void pawnPlayed(){
        p.ifPawnPlayed();
    }
    
}
