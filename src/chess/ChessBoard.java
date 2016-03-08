package chess;

import chess.pieces.*;
import chess.types.PieceColour;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class ChessBoard {
	private Piece[][] board = new Piece[8][8];
	

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	public void addPiece(Piece piece, int x, int y){
		board[x][y] = piece;
	}
	public String getId(Piece piece){
		if (piece instanceof Pawn){
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "P";
			} else {
				return "p";
			}
		}
		if (piece instanceof Rook){
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "R";
			} else {
				return "r";
			}
		}
		if (piece instanceof Bishop) {
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "B";
			} else {
				return "b";
			}
		}
		if (piece instanceof Knight) {
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "N";
			} else {
				return "n";
			}
		}
		if (piece instanceof King) {
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "K";
			} else {
				return "k";
			}
		}
		if (piece instanceof Queen) {
			if (piece.getPlayer() == PieceColour.BLACK) {
				return "Q";
			} else {
				return "q";
			}
		}
		return " ";
	}
	
	public Piece[][] getBoard(){
		return board;
	}
	
	public boolean move(int origX, int origY, int targetX, int targetY) {
		if (board[origX][origY] == null) return false; //if no piece to be moved
		//move
		if (board[targetX][targetY] == null) {//if target position is empty
			if (!board[origX][origY].move(this, targetX, targetY)) // if current piece not moved successfully
				return false; 
			board[targetX][targetY] = board[origX][origY];
			board[origX][origY] = null;
			return true;

		} else {
			if (!board[origX][origY].move(this, targetX, targetY)) // if current piece not moved successfully
				return false;
			board[targetX][targetY].setX(-1);
			board[targetX][targetY].setY(-1);
			board[targetX][targetY].setTaken(true);
			board[targetX][targetY] = board[origX][origY];
			board[origX][origY] = null;
			return true;
		}
	}

	/**
	 * @return (-1, 0, 1) being (black player is in check, no check, white player is in check)
	 */
	public int isCheck() {
		for (Piece[] arr: this.getBoard()) { //loop through rows
			for (Piece p: arr) { //loop through columns
				if (p instanceof King) { //if piece is a King

					for (Piece[] arr2: board) { //loop through rows
						for (Piece p2: arr2) { //loop through columns
							if (p2 == null) continue; //if no piece in current square
							if (p.getPlayer() == p2.getPlayer()) continue; //if piece is same colour do nothing
							if (p2.isLegalMove(this, p.getX(), p.getY())) { //if current piece can move to target square
								if (p.getPlayer() == PieceColour.WHITE)return 1;
								if (p.getPlayer() == PieceColour.BLACK) return -1;
							}
						}
					}
				}
			}
		}
		return 0;
	}

	/**
	 * Draws the board in terminal
	 */
	public void showBoard(){
		boolean white = false;
		System.out.println(ansi().reset() + "--------------------------"); 					//draw the top horizontal line

		for (int i = 0; i < 8; i++){
			white = !white;																			//after each row, change starting color

			if (i > 0){
				System.out.println(ansi().reset() + "--------------------------");			//draw horizontal lines in between
			}

			for (int j = 0; j < 8; j++){
				if (j==0){
					System.out.print(ansi().reset() + "|");												//draw a vertical line before each character
				}
				if (white){
					if (getPiece(j,i) != null && getPiece(j,i).getPlayer()==PieceColour.WHITE) {	//choose correct colors and print character's id
						System.out.print(ansi().bg(WHITE).fg(GREEN).a(" " + getId(getPiece(j,i))+ " "));
					} else {
						System.out.print(ansi().bg(WHITE).bold().fg(RED).bold().a(" " + getId(getPiece(j,i))+ " "));
					}
					white = !white;
					
				}else{
					if (getPiece(j,i) != null && getPiece(j,i).getPlayer()==PieceColour.WHITE) {
						System.out.print(ansi().bg(BLACK).fg(GREEN).a(" " + getId(getPiece(j,i))+ " "));
					} else {
						System.out.print(ansi().bg(BLACK).fg(RED).bold().a(" " + getId(getPiece(j,i))+ " "));
					}
				white = !white;
				}

				if (j==7){
					System.out.println(ansi().reset() + "| " + (ansi().fg(BLUE).bold().a(i+1)));	//after the 8th character, draw a vertical line
				
				}
			}
		}
		System.out.println(ansi().reset() + "--------------------------");					//draw the bottom horizontal line
		System.out.println(ansi().fg(BLUE).bold().a("  A  B  C  D  E  F  G  H"));
	}
}
