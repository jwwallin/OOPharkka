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
public class Rook extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Rook(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, position, hasMoved, isTaken, canJump);
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
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
		if (currentBoard.getPiece(x, y) == null) { //if target square is empty
			if (y == this.getPosition()[1] && x != this.getPosition()[0]) { //if only moving horizontally
				if (x < this.getPosition()[0]) { // check which direction move is
					for (int i = this.getPosition()[0] + 1; i < x; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
				} else {
					for (int i = this.getPosition()[0]; i > x; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
				}
			} else if (y != this.getPosition()[1] && x == this.getPosition()[0]) { // if only moving vertically
				if (y < this.getPosition()[1]) { // check which direction move is
					for (int i = this.getPosition()[1] + 1; i < y; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getPosition()[1]; i > y; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			}
		} else {
			if (currentBoard.getPiece(x, y).getPlayer() == this.getPlayer()) return false;
			if (y == this.getPosition()[1] && x != this.getPosition()[0]) { //if only moving horizontally
				if (x < this.getPosition()[0]) { // check which direction move is
					for (int i = this.getPosition()[0] + 1; i < x; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
				} else {
					for (int i = this.getPosition()[0]; i > x; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(i, y) != null) return false; // if there is a piece between current square and target square
					}
				}
			} else if (y != this.getPosition()[1] && x == this.getPosition()[0]) { // if only moving vertically
				if (y < this.getPosition()[1]) { // check which direction move is
					for (int i = this.getPosition()[1] + 1; i < y; i++) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				} else {
					for (int i = this.getPosition()[1]; i > y; i--) { // loop through all squares between current square and target square
						if (currentBoard.getPiece(x, i) != null) return false; // if there is a piece between current square and target square
					}
					return true;
				}
			}
		}
		return false;
	}

}
