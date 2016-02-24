package chess;

import chess.pieces.*;
import chess.types.PieceColour;

import org.fusesource.jansi.AnsiConsole;
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
		if (piece instanceof Soldier){
			return "S";
		}
		if (piece instanceof Rook){
			return "R";
		}
		return " ";
	}

	public boolean move(int[] posOrig, int[] posMoveTo) {
		//check if position data is valid
		if (posOrig.length != 2 || posMoveTo.length != 2) return false;
		//move
		if (board[posMoveTo[0]][posMoveTo[1]] == null) {//if target position is empty
			if (!board[posOrig[0]][posOrig[1]].move(this, posMoveTo[0], posMoveTo[1])) // if current piece not moved successfully
				return false; 
			board[posMoveTo[0]][posMoveTo[1]] = board[posOrig[0]][posOrig[1]];
			board[posOrig[0]][posOrig[1]] = null;
			return true;

		} else {
			//TODO if MoveTo position is not empty
			return false;
		}
	}

	/**
	 * @return if board drawing is successful
	 */
	public boolean drawBoard() {
		return false;
	}

	/**
	 * @return -1, 0, 1 being black player is in check, no check, white player is in check
	 */
	public int isCheck() {
		return 0;

	}

	public void showBoard(){
		boolean white = false;
		System.out.println(ansi().reset() + "---------------------------------"); 					//draw the top horizontal line

		for (int i = 0; i < 8; i++){
			white = !white;																			//after each row, change starting color

			if (i > 0){
				System.out.println(ansi().reset() + "---------------------------------");			//draw horizontal lines in between
			}

			for (int j = 0; j < 8; j++){

				System.out.print(ansi().reset() + "|");												//draw a vertical line before each character

				if (white){
					if (getPiece(j,i) != null && getPiece(j,i).getPlayer()==PieceColour.WHITE) {	//choose correct colors and print character's id
						System.out.print(ansi().bg(WHITE).fg(GREEN).a(" " + getId(getPiece(j,i))+ " "));
					} else {

						System.out.print(ansi().bg(WHITE).fg(RED).a(" " + getId(getPiece(j,i))+ " "));

					}
					white = !white;
					
				}else{
					if (getPiece(j,i) != null && getPiece(j,i).getPlayer()==PieceColour.WHITE) {
						System.out.print(ansi().bg(BLACK).fg(GREEN).a(" " + getId(getPiece(j,i))+ " "));
					} else {

						System.out.print(ansi().bg(BLACK).fg(RED).a(" " + getId(getPiece(j,i))+ " "));
					}
				white = !white;
				}


				if (j==7){
					System.out.println(ansi().reset() + "|");									//after the 8th character, draw a vertical line
					if(i==7){
						
					}
				}
			}
		}
		
		System.out.println(ansi().reset() + "---------------------------------");					//draw the bottom horizontal line

	}
}
