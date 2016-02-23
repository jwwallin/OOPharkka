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
	public void move(ChessBoard currentBoard, int x, int y) {
		if (!isLegalMove(currentBoard, x, y)) return;
		int[] pos = {x,y};
		this.setPosition(pos);
	}

	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		if (y-this.getPosition()[1] == 1) return true;
		if (!this.hasMoved() && y-this.getPosition()[1] == 2) return true;
		if (currentBoard.getPiece(x, y) != null && currentBoard.getPiece(x, y).getPlayer() != this.getPlayer()) return true;
		//TODO add all checks
		return false;
	}

}
