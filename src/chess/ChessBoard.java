package chess;

import chess.pieces.*;

public class ChessBoard {
	private Piece[][] board;
	
	public Piece getPiece(int x, int y) {
		return board[x][y];
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

}
