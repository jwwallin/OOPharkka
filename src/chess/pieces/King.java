
package chess.pieces;

import chess.ChessBoard;
import chess.types.PieceColour;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class King extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public King(PieceColour player, int x, int y, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, x, y, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public King(PieceColour player, int x, int y) {
		super(player, x, y, false, false, false);
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#move(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#isLegalMove(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		if (currentBoard.getPiece(x, y) == null) { //if target square is empty
			if(Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1) { //if moving by one square in any direction
				for (Piece[] arr: currentBoard.getBoard()) { //loop through rows
					for (Piece p: arr) { //loop through columns
						if (p == null) continue; //if no piece in current square
						if (p.getPlayer() == this.getPlayer()) continue; //if piece is same colour do nothing
						if (p.isLegalMove(currentBoard, x, y)) return false; //if current piece can move to target square
					}
				}
				return true; //if this is reached no piece is threatening target square
			}
		} else {
			if (currentBoard.getPiece(x, y).getPlayer() == this.getPlayer()) return false; //if piece in target square is same colour
			if(Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1) { //if moving by one square in any direction
				for (Piece[] arr: currentBoard.getBoard()) { //loop through rows
					for (Piece p: arr) { //loop through columns
						if (p == null) continue; //if no piece in current square
						if (p.getPlayer() == this.getPlayer()) continue; //if piece is same colour do nothing
						if (p.isLegalMove(currentBoard, x, y)) return false; //if current piece can move to target square
					}
				}
				return true; //if this is reached no piece is threatening target square
			}
		}
		return false;
	}

}
