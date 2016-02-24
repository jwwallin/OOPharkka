/**
 * 
 */
package chess.pieces;

import chess.ChessBoard;
import chess.types.PieceColour;

/**
 * @author aku
 *
 */
public class Rook extends Piece {

	/**
	 * @param player
	 * @param position
	 * @param hasMoved
	 * @param isTaken
	 * @param canJump
	 */
	public Rook(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, position, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	public Rook(PieceColour player, int[] position) {
		super(player, position, false, false, false);
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#move(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		if (!this.isLegalMove(currentBoard, x, y)) return false;
		int[] pos = {x,y};
		this.setPosition(pos);
		return true;
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#isLegalMove(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		// TODO EVERYTHING
		return false;
	}

}
