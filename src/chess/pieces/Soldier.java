package chess.pieces;

import chess.ChessBoard;
import chess.types.*;

public class Soldier extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Soldier(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, position, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public Soldier(PieceColour player, int[] position) {
		super(player, position, false, false, false);
	}

	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		if (!isLegalMove(currentBoard, x, y)) return false;
		int[] pos = {x,y};
		this.setPosition(pos);
		return true;
	}

	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		if (currentBoard.getPiece(x, y) == null) { //if moveTo square is empty
			if (x-this.getPosition()[0] == 0) { //can only be moving straight ahead
				if (y-this.getPosition()[1] == 1) return true; //if moving 1 square forward
				if (!this.hasMoved() && y-this.getPosition()[1] == 2) return true; // if has not moved and is moving 2 squares forward
			}
		} else {
			if (Math.abs(x-this.getPosition()[0]) == 1) { // if moving 1 square to the side when moving to square
				if (currentBoard.getPiece(x, y).getPlayer() != this.getPlayer()) // if piece in moveTo square is different colour
					return true; 
			}
		}
		//TODO add all checks
		return false;
	}

}
