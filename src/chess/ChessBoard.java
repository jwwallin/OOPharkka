package chess;

import chess.pieces.*;

public class ChessBoard {
	private Piece[][] board;
	
	public Piece getPiece(int x, int y) {
		return board[x][y];
	}
	
	public void move(int[] posOrig, int[] posMoveTo) {
		//check if position data is valid
		if (posOrig.length != 2 || posOrig.length != 2) return;
		//move
		if (board[posMoveTo[0]][posMoveTo[1]] == null) {//check if MoveTo position is empty
			//if is
			board[posOrig[0]][posOrig[1]].move(this, posMoveTo[0], posMoveTo[1]); //call move for current piece to move
			board[posMoveTo[0]][posMoveTo[1]] = board[posOrig[0]][posOrig[1]];
			board[posOrig[0]][posOrig[1]] = null;
			
			
		} //TODO if MoveTo position is not empty
	}

}
