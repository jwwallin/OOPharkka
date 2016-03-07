/**
 * 
 */
package chess.pieces;

import chess.ChessBoard;
import chess.types.PieceColour;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Knight extends Piece {
	
	public static final int[][] siirrot = { //all possible move for knight
			{-1, -2},
			{-1, 2},
			{1, -2},
			{1, 2},
			{-2, -1},
			{-2, 1},
			{2, -1},
			{2, 1},
			
	};

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Knight(PieceColour player, int x, int y, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, x, y, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public Knight(PieceColour player, int x, int y) {
		super(player, x, y, false, false, false);
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#move(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		if (!isLegalMove(currentBoard, x, y)) return false;
		this.setX(x);
		this.setY(y);
		return true;
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#isLegalMove(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		for (int[] siirto: siirrot) { //loop through all possible moves for knight
			if (this.getX() + siirto[0] == x && this.getY() + siirto[1] == y) { //if target square is a legal square
				if (currentBoard.getPiece(x, y) == null) {
					return true;
				} else {
					if (currentBoard.getPiece(x, y).getPlayer() == this.getPlayer()) return false;
					return true;
				}
			}
		}
		return false;
	}

}
