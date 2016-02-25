package chess.pieces;

import chess.ChessBoard;
import chess.types.PieceColour;

/**
 * @author Jussi Wallin, Tero Yrjölä, Niklas Niemelä
 *
 */
public class Bishop extends Piece {

	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 * @param hasMoved whether piece has moved yet
	 * @param isTaken whether piece has been taken
	 * @param canJump whether piece can jump over other pieces
	 */
	public Bishop(PieceColour player, int[] position, boolean hasMoved, boolean isTaken, boolean canJump) {
		super(player, position, hasMoved, isTaken, canJump);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param player the player colour
	 * @param position piece's initial position, max length 2
	 */
	public Bishop(PieceColour player, int[] position) {
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
		
		if (currentBoard.getPiece(x, y) == null) { //if target square is empty
			if (Math.abs(x) == Math.abs(y)) { //if moving diagonally
				if (x > this.getPosition()[0]) { //if moving diagonally to the right
					if (y < this.getPosition()[1]) { //if moving diagonally up
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y+i) != null) return false;
						}
						return true;
					} else {
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y-i) != null) return false;
						}
						return true;
					}
				} else { //moving diagonally to the left
					if (y < this.getPosition()[1]) { //if moving diagonally up
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y+i) != null) return false;
						}
						return true;
					} else {
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y-i) != null) return false;
						}
						return true;
					}
				}
			}
		} else {
			if (Math.abs(x) == Math.abs(y)) { //if moving diagonally
				if (x > this.getPosition()[0]) { //if moving diagonally to the right
					if (y < this.getPosition()[1]) { //if moving diagonally up
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y+i) != null) return false;
						}
						return true;
					} else {
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X+i, Y-i) != null) return false;
						}
						return true;
					}
				} else { //moving diagonally to the left
					if (y < this.getPosition()[1]) { //if moving diagonally up
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y+i) != null) return false;
						}
						return true;
					} else {
						int X = this.getPosition()[0];
						int Y = this.getPosition()[1];
						
						for (int i = 1; i < Math.abs(x - this.getPosition()[0]); i++) { //loop through all squares between current and target squares
							if (currentBoard.getPiece(X-i, Y-i) != null) return false;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
