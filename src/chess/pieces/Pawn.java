package chess.pieces;

import chess.ChessBoard;
import chess.types.*;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Pawn extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Pawn(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, position, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public Pawn(PieceColour player, int[] position) {
		super(player, position, false, false, false);
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#move(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean move(ChessBoard currentBoard, int x, int y) {
		if (!isLegalMove(currentBoard, x, y)) return false;
		int[] pos = {x,y};
		this.setPosition(pos);
		return true;
	}

	/* (non-Javadoc)
	 * @see chess.pieces.Piece#isLegalMove(chess.ChessBoard, int, int)
	 */
	@Override
	public boolean isLegalMove(ChessBoard currentBoard, int x, int y) {
		if (this.getPlayer() == PieceColour.WHITE) {
			if (y < this.getPosition()[1]) return false; // white moves up
		} else if (this.getPlayer() == PieceColour.BLACK) {
			if (y > this.getPosition()[1]) return false; // black moves down
		}
		if (currentBoard.getPiece(x, y) == null) { //if target square is empty
			if (x-this.getPosition()[0] == 0) { //if is moving straight ahead
				if (Math.abs(y-this.getPosition()[1]) == 1) return true; //if moving 1 square forward
				if (!this.hasMoved() && y-this.getPosition()[1] == 2 && currentBoard.getPiece(x, y-1) == null) return true; // if has not moved, is moving 2 squares forward and there is no piece in the way
			}
		} else {
			if (Math.abs(x-this.getPosition()[0]) == 1) { // if moving 1 square to the side when moving to target square
				if (currentBoard.getPiece(x, y).getPlayer() != this.getPlayer()) // if piece in target square is different colour
					return true; 
			}
		}
		return false;
	}

}
